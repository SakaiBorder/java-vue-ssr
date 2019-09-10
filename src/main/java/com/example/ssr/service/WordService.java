package com.example.ssr.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class WordService {

    public Map<String, String> getWord() {
        Map<String, String> map = new HashMap<String, String>();
        
        map.put("word", "hello, world");

        return map;
    }
}
