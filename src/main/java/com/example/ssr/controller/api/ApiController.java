package com.example.ssr.controller.api;

import java.util.Map;

import com.example.ssr.service.WordService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class ApiController {

    private final WordService wordService;

    @GetMapping("/get-word/{pageId}")
    public Map<String, String> getWord(@PathVariable("pageId") String pageId) {

        return wordService.getWord(pageId);
    }
}
