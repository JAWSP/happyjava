package com.example.friendapp.controller;

import com.example.friendapp.domain.Friend;
import com.example.friendapp.service.FriendService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//restapi는 url에 복수형을 낸다고 한다
@Controller
@RequestMapping("/friends")
@RequiredArgsConstructor
public class FriendController {
    private final FriendService friendService;

//    @GetMapping("/list")
//    public String list(Model model) {
//        //대충 서비스를 통하여 데이터를 얻어서 모델이 넣어준다
//       // Iterable<Friend> res = friendService.findAllfriend();
//        model.addAttribute("friends", friendService.findAllfriend());
//
//        //페이지가 굉장히 많아지면 디렉토리별로 나누는게 좋다고
//        //그래서 frinedlist가 아닌 friends/list가 된다
//        return "friends/list";
//    }


    //페이징을 통한 리스트 보이기, 페이지는 요청객체 안에 있다고 한다
    //페이지는 현재 페이지
    //사이즈는 한 페이지 당 사이즈
    @GetMapping("/list")
    public String list(Model model,
                       @RequestParam(name = "page", required = false, defaultValue = "1") int page,
                       @RequestParam(name = "size", required = false, defaultValue = "5") int size) {
        //페이지는 0번부터 있다고 한다, 그러니 디폴트가 1이니 0부터
        Pageable pageable = PageRequest.of(page -1, size);
        //페이지에 담을 얘들
        model.addAttribute("friends", friendService.findAllFriends(pageable));
        //현재 페이지
        model.addAttribute("currentPage", page);

        return "friends/list";
    }

    //폼 보여주기
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("friend", new Friend());
        return "friends/form";
    }


    //수정 처리하기
    //@modelattribute는 요청받은 모델에서 저 friend를 따로 쓰겠단 소리
    @PostMapping("/add")
    public String addFriend(@ModelAttribute Friend friend) {
        //서비스에게 저장해달라고 하기
        friendService.saveFriend(friend);
        return "redirect:/friends/list";
    }

    @GetMapping("/{id}")
    //id로 넘온 id를 받을거임
    //정보를 넘길 모델을 받을거임
    public String detailFriend(@PathVariable(name = "id")Long id, Model model) {
       model.addAttribute("friend", friendService.findFriendById(id));
        return "friends/detail";
    }


    @GetMapping("delete/{id}")
    public String deleteFriend(@PathVariable(name = "id") Long id) {
        friendService.deleteFriend(id);
        return "redirect:/friends/list";
    }

    @GetMapping("/update{id}")
    public String updateForm(@ModelAttribute Friend friend, Model model) {
        model.addAttribute("Friend", friend);
        return "friends/updateform";
    }

    @PostMapping("/update")
    public String updateFriend(@ModelAttribute Friend friend) {
        friendService.updateFriend(friend);
        return "redirect:/friends/list";
    }
}
