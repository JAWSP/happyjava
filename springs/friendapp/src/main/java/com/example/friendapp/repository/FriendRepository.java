package com.example.friendapp.repository;

import com.example.friendapp.domain.Friend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

//Friend엔티티에 대한 CRUD를 간-단히 해주는거 추가
//패이징과 정렬도 해주는 인터페이스도 추가
public interface FriendRepository
        extends CrudRepository<Friend, Long>,
        PagingAndSortingRepository<Friend, Long> {

}
