package com.codegym.service.impl;

import com.codegym.service.DictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    public String stringMap(String dich) {

        Map<String, String> map = new HashMap<>();
        map.put("hello", "xin chào");
        map.put("goodbye", "Tạm biệt");
        map.put("display", "hiển thị");
         return  map.get(dich);

    }

}
