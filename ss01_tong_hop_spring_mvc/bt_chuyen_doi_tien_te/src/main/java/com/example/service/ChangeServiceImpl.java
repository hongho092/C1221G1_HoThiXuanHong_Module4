package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class ChangeServiceImpl implements ChangeService{
    @Override
    public int changeVND(Integer dollar) {
        return dollar * 22000;
    }
}
