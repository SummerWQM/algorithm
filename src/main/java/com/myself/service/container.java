package com.myself.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class container {

    @Autowired
    private SmsInterface smsInterface;
}
