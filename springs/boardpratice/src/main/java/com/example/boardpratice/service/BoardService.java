package com.example.boardpratice.service;

import com.example.boardpratice.domain.Board;
import com.example.boardpratice.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public Iterable<Board> showList() {
        return boardRepository.findAll();
    }

    public Page<Board> showListByPage(Pageable pageable) {
        Pageable page = PageRequest.of(pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by(Sort.Direction.DESC, "id"));

        return boardRepository.findAll(page);

    }

    public Board addBoard(Board board) {
        board.setCreatedAt(LocalDateTime.now());
        board.setUpdatedAt(board.getCreatedAt());
       return boardRepository.save(board);
    }

    public Board updateBoard(Long id, Board board) {

        board.setCreatedAt(findBoardById(id).getCreatedAt());
        board.setUpdatedAt(LocalDateTime.now());
        return boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Board findBoardById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    public void deleteBoard(Long id, Board board) {
        //if (findBoardById(id).getPassword().equals(board.getPassword()))
            boardRepository.deleteById(id);
    }
}
