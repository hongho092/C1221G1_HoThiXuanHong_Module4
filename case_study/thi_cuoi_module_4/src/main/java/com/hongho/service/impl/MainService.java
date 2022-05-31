package com.hongho.service.impl;

import com.hongho.repository.IMainRepository;
import com.hongho.service.IMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService implements IMainService {

    @Autowired
    private IMainRepository mainRepository;
}
