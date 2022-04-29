package com.example.service;

import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService{

    @Override
    public String searchWork(String word) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");

        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            if (entry.getKey().equals(word)) {
                return entry.getValue();
            }
        }
        return "Không tìm thấy gì!!!";
    }
}
