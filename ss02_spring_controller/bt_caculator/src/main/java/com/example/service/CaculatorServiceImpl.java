package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CaculatorServiceImpl implements CaculatorService{

    @Override
    public int getResult(int number1, int number2, String calculator) {
        if (calculator.equals("Addition")) {
            return number1 + number2;
        } else if (calculator.equals("Subtraction")) {
            return number1 - number2;
        } else if (calculator.equals("Multiplication")) {
            return number1 * number2;
        } else if (calculator.equals("Division")) {
            return number1 / number2;
        }
        return -0;
    }
}
