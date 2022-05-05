package com.codegym.repository;

import com.codegym.model.YTe;

import java.util.List;

public interface YTeRepository {
    public List<YTe> listYTe();
    void save(YTe yTe);
}
