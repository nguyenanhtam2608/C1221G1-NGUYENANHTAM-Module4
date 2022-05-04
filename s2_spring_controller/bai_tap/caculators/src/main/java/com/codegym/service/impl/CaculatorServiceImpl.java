package com.codegym.service.impl;

import com.codegym.service.CaculatorService;
import org.springframework.stereotype.Service;

@Service
public class CaculatorServiceImpl implements CaculatorService {


    @Override
    public Double caculatorService(double first, double second, String operator) {

        double result = 0;

        switch (operator) {

            case "+":
                result = first + second;
                break;

            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                result = first / second;
                break;

        }
        return result;


    }
}

