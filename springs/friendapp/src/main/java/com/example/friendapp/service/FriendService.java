package com.example.friendapp.service;

import com.example.friendapp.domain.Friend;
import com.example.friendapp.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FriendService {
    //friend에 대한 db를 연결시키기 위한놈
    private final FriendRepository friendRepository;

    //findall는 Iterable<T>리턴타입이다
    //저 뒤의 괄호는 생략되긴 한데 그래도 넣으면 좋음
    //나는 읽기전용이라고 알려준다고 한다
//    @Transactional(readOnly = true)
//    public Iterable<Friend> findAllfriend() {
//        //System.out.println(friendRepository.findAll());
//        return friendRepository.findAll();
//    }

    //친구를 찾는데 페이징(나눠서)알려주는거
    public Page<Friend> findAllFriends(Pageable pageable) {
        //page쪽 객체라고
        //불러올 페이지 번호랑, 페이지 사이즈를 보여주는거, 그리고 정렬 기준
        //정렬기준은 내림차순 할려면 Sort.Direction.DESC, Direction는 Enum
            //2번째는 비교할 부분
        Pageable page = PageRequest.of(pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by(Sort.Direction.ASC, "id"));

        //리턴부는 리포지토리에서 인용했던 그 부분을 이용
        return friendRepository.findAll(page);
    }

    //friend를 추가
    //매개변수는 추가시킬 친구
    //또한 id가 같다면 그냥 저장 아니면 수정
    public Friend saveFriend(Friend friend) {
        // spring data jdbc는 save(반드시 insert는 아님)
        // 검색해서 id값이 이미 존재한다면 -> 수정해줌(업데이트를)
        // id값이 없다면 -> 새로 만든다

        // 즉 입력 뿐만 아니라 수정도 가능하다 <- 얘가 핵심임


        //근데 애초에 저기 안에 insert가 안보이네
        return friendRepository.save(friend);
    }

    //결국은 같긴 한데 구별을 위하여...
    public Friend updateFriend(Friend friend) {
        return friendRepository.save(friend);
    }

    //select 쿼리 이니까 저런걸 쓴다고 한다
    @Transactional(readOnly = true)
    public Friend findFriendById(Long id) {
        //orElse로 optional을 friend로 쓸 수 있음
        return friendRepository.findById(id).orElse(null);
    }

    public void deleteFriend(Long id) {
        friendRepository.deleteById(id);
    }

}
