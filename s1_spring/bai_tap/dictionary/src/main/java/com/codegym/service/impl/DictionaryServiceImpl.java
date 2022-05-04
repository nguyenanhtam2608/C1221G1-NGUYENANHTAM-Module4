package com.codegym.service.impl;

import com.codegym.repository.DictionaryRepository;
import com.codegym.repository.impl.DictionaryRepositoryIpml;
import com.codegym.service.DictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    DictionaryRepository dictionaryRepository = new DictionaryRepositoryIpml();

    public String stringMap(String dich) {
        return dictionaryRepository.stringMap(dich);
    }


}


