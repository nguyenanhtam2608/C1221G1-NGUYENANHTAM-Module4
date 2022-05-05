package com.codegym.repository.impl;

import com.codegym.model.YTe;
import com.codegym.repository.YTeRepository;

import java.util.ArrayList;
import java.util.List;

public class YTeRepositoryImpl implements YTeRepository {
    static List<YTe> yTeList = new ArrayList<>();

    static {
        yTeList.add(new YTe("Tâm", "26/08/2002", "Nam", "Việt Nam", "206406031", "Máy bay", "123456", "12", "05/05/2022", "06/05/2022", "ĐÀ nẵng "));
    }

    @Override
    public List<YTe> listYTe() {

        return yTeList;
    }

    @Override
    public void save(YTe yTe) {
        yTeList.add(yTe);
    }
}
