package com.example.boardpratice.repository;

import com.example.boardpratice.domain.Comment;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    @Query("SELECT * FROM comment WHERE board_id = :boardId ORDER BY created_at DESC")
    List<Comment> findByBoardId(@Param("boardId") Long boardId);
}
