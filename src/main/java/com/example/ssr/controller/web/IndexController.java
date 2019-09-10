package com.example.ssr.controller.web;

import com.example.ssr.service.RenderService;
import com.example.ssr.service.WordService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final RenderService renderService;

    private final WordService wordService;

    @GetMapping("/")
    public String index(Model model) {

        String html = renderService.renderPage("/");

        model.addAttribute("rendered", html);
        model.addAttribute("state", wordService.getWord("firstPage"));

        return "index";
    }

    @GetMapping("/second")
    public String second(Model model) {
        String html = renderService.renderPage("/second");

        model.addAttribute("rendered", html);
        model.addAttribute("state", wordService.getWord("secondPage"));

        return "index";
    }
}