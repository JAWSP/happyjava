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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

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
        //model.addAttribute("comments")
        return "detail";
    }


    @GetMapping("deleteform/{id}")
    public String showDeleteForm(@PathVariable(name="id")Long id, Model model) {
        model.addAttribute("board", boardService.findBoardById(id));
        return "deleteform";
    }

    @PostMapping("delete/{id}")
    public String deleteBoard(@PathVariable(name = "id")Long id,
                              @ModelAttribute Board board,
                              RedirectAttributes redirectAttributes) {
        if (boardService.findBoardById(id).getPassword().equals(board.getPassword())) {
            redirectAttributes.addFlashAttribute("ds", "삭제 완료");
            boardService.deleteBoard(id, board);
            return "redirect:/boards/list";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "비밀번호가 틀린댑쇼");
            return  "redirect:/boards/deleteform/" + id.toString();
        }
    }

    @GetMapping("updateform/{id}")
    public String showUpdateForm(@PathVariable(name="id")Long id, Model model) {
        System.out.println("start : " + boardService.findBoardById(id));
        model.addAttribute("board", boardService.findBoardById(id));
        return "updateForm";
    }

    @PostMapping("update/{id}")
    public String updateBoard(@PathVariable(name="id")Long id, @ModelAttribute Board board,
                              RedirectAttributes redirectAttributes) {
        if (boardService.findBoardById(id).getPassword().equals(board.getPassword())) {
            redirectAttributes.addFlashAttribute("us", "업데이트 완료");
            boardService.updateBoard(id, board);
            return "redirect:/boards/view/{id}";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "비밀번호가 틀린댑쇼");
            return "redirect:/boards/view/" +id.toString();
        }
    }


}
