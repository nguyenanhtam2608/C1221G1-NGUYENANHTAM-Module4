package com.codegym.service.Impl;

import com.codegym.service.CurrencyService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Override
    public Double currency(double vnd) {
        double usd = 0;
        usd = 23000 * vnd;
        return usd;
    }
}
