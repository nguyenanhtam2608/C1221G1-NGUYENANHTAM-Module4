package com.codegym.service.employee;

import com.codegym.model.employee.Position;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPositionService {


    List<Position> findAll();
}
