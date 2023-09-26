package com.myself.service.impl;

import com.myself.service.SmsInterface;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

@Service
public class SmsImpl2 implements BeanFactoryAware {

    @Jack
    SmsInterface smsInterface;


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(smsInterface.hello());
        System.out.println(smsInterface.hell2());

        System.out.println(smsInterface.hashCode());

    }
}
