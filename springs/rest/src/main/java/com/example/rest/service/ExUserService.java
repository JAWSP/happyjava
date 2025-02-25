package com.example.rest.service;

import com.example.rest.domain.ExUser;
import com.example.rest.repository.ExUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class ExUserService {
    private final ExUserRepository exUserRepository;
    private final AtomicLong counter = new AtomicLong();


    @Transactional
    public Long createUserService(ExUser user) {
        ExUser exUser= new ExUser();
        exUser.setName(user.getName());
        exUser.setName(user.getEmail());
        exUserRepository.save(user);
        return exUser.getId();
    }

    @Transactional
    public List<ExUser> getUsersService() {
       return exUserRepository.findAll();
        //return ResponseEntity.ok(exUserRepository.findAll());
    }

    @Transactional
    public ExUser getUSerByIdService(Long id) {
        if(!exUserRepository.existsById(id))
           // return ResponseEntity.status(404).body("없는댑쇼"); ->얜 스트링에만
            throw new IllegalArgumentException("없는댑쇼");
        ExUser user = exUserRepository.findById(id).get();
        return user;
    }

    @Transactional
    public ExUser updateUserService(Long id, ExUser user) {
        //대충 이렇게 가능하다
        user.setId(id);
        if (user.getId() == null) {
            throw new IllegalArgumentException("id넣으셈");
        }
        //만약에 있다면 찾고 못찾았으면 던지고
        ExUser target = exUserRepository.findById(user.getId()).orElseThrow(()-> new RuntimeException("걔가 없는뎁쇼"+user.getId()));
        target.setName(user.getName());
        target.setEmail(user.getEmail());
        //그외 이름,이메일 널체크도 가능함
        //save()로 직접 박는 것 보다 변경감지로 수정이 더 낫다고 한다
        return target;
    }

    @Transactional
    public void deleteUserService(Long id) {
        if (!exUserRepository.existsById(id)) {
            throw new IllegalArgumentException("없는데?");
        }
        exUserRepository.deleteById(id);
    }

}
