package com.example.boardpratice.service;

import com.example.boardpratice.domain.Comment;
import com.example.boardpratice.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public Iterable<Comment> showComments() {
        return commentRepository.findAll();
    }
}
