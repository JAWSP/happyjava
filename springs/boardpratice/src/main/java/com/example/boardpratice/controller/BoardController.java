package com.example.boardpratice.controller;

import com.example.boardpratice.domain.Board;
import com.example.boardpratice.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/")
    public String test() {
        return "index";
    }

    @GetMapping("list")
    public String getList(Model model,
                          @RequestParam(name = "page", required = false, defaultValue = "1") int page,
                          @RequestParam(name = "size", required = false, defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        model.addAttribute("boards", boardService.showListByPage(pageable));
        model.addAttribute("currentPage", page);

        //model.addAttribute("boards", boardService.showList());
        //return "/boards/list"와 동일
        return "list";
    }

    @GetMapping("add")
    public String showAddForm(Model model) {
        model.addAttribute("board", new Board());
        return "addForm";
    }

    @PostMapping("add")
    public String addBoard(@ModelAttribute Board board) {
        boardService.addBoard(board);
        return "redirect:/boards/list";

    }

    @GetMapping("view/{id}")
    public String viewBoard(@PathVariable(name ="id")Long id, Model model) {
        model.addAttribute("board", boardService.findBoardById(id));
        return "detail";
    }


    @GetMapping("deleteform/{id}")
    public String showDeleteForm(@PathVariable(name="id")Long id, Model model) {
        model.addAttribute("board", boardService.findBoardById(id));
        return "deleteform";
    }

    @PostMapping("delete/{id}")
    public String deleteBoard(@PathVariable(name = "id")Long id, @ModelAttribute Board board) {
        boardService.deleteBoard(id, board);
        return "redirect:/boards/list";
    }

    @GetMapping("updateform/{id}")
    public String showUpdateForm(@PathVariable(name="id")Long id, Model model) {
        model.addAttribute("board", boardService.findBoardById(id));
        return "updateForm";
    }

    @PostMapping("update/{id}")
    public String updateBoard(@PathVariable(name="id")Long id, @ModelAttribute Board board) {
        boardService.updateBoard(id, board);
        //대충 비번 확인하고 업데이트 하는거
        return "redirect:/boards/view/{id}";
    }


}
