package com.codegym.repository.impl;

import com.codegym.repository.DictionaryRepository;

import java.util.HashMap;
import java.util.Map;

public class DictionaryRepositoryIpml implements DictionaryRepository {

    @Override
    public String stringMap(String dich) {
                Map<String, String> map = new HashMap<>();
        map.put("hello", "xin chào");
        map.put("goodbye", "Tạm biệt");
        map.put("display", "hiển thị");
        map.put("giang", " giảng đầu bò ");

        if (map.get(dich) != null) {
            return map.get(dich);
        }else {  return "khong tim thay";}

    }
}
