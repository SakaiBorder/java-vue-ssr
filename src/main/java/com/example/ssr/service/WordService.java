package com.example.ssr.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class WordService {

    public Map<String, String> getWord(String pageId) {

        Map<String, String> map = new HashMap<String, String>();

        if (pageId.equals("firstPage")) {
            map.put("word", "first page data");
        } else {
            map.put("word", "second page data");
        }

        return map;
    }
}
