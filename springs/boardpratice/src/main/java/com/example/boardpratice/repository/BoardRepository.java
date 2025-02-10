package com.example.boardpratice.repository;

import com.example.boardpratice.domain.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BoardRepository
    extends CrudRepository<Board, Long>,
        PagingAndSortingRepository<Board, Long> {
}
