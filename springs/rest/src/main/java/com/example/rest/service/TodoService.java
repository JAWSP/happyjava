package com.example.rest.service;

import com.example.rest.domain.Todo;
import com.example.rest.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional
    public Todo CreateTodoListService(Todo todo) {
        try {
            return todoRepository.save(todo);
        } catch (Exception e) {
            throw new RuntimeException("너 이상한거 추가함?" + e.getMessage(), e);
        }
    }

    @Transactional(readOnly = true)
    public List<Todo> getTodoListsService() {
        return todoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Todo getTodoByIdService(Long id) {
        if (!todoRepository.existsById(id))
            throw new IllegalArgumentException("없는댑쇼");
        Todo target = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("그 아이디 못찾겠는뎁쇼" + id));
        return target;
    }

    @Transactional
    public Todo updateTodoService(Long id) {
        if (id == null)
            throw new IllegalArgumentException("id넣으셈");
        Todo target = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("없는뎁쇼" + id));
//        target.setTodo(todo.getTodo());
//        target.setDone(todo.isDone());

        //save를 굳이 안넣어도 jpa의 영속성 컨택스트가 그걸 감지해서 알아서 바꿔줌
        //그리고 그게 더 안전하다고 한다
        //트랜잭션?그거했잔아
        target.setDone(!target.isDone());
//        if (!target.isDone())
//            target.setDone(true);
//        else
//            target.setDone(false);

        return target;
    }

    @Transactional
    public void deleteTodoService(Long id) {
        if (!todoRepository.existsById(id))
            throw new IllegalArgumentException("없는댑쇼");
        todoRepository.deleteById(id);
        log.info("삭제 완료 : {}", id);
    }

}
