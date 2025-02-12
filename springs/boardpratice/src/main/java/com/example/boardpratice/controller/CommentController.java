package com.example.boardpratice.controller;

import com.example.boardpratice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private CommentService commentService;

    @PostMapping("add/{id}")
    public String addComment(@PathVariable(name="id")Long id, Model model) {

        return "redirect:/boards/view/{id}";
    }
}
