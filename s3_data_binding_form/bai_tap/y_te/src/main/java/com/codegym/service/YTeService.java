package com.codegym.service;

import com.codegym.model.YTe;

import java.util.List;

public interface YTeService {
    public List<YTe> listYTe();
    void save(YTe yTe);
}
