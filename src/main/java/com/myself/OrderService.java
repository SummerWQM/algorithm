//package com.myself;
//
//
//import com.myself.service.SmsInterface;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.PostConstruct;
//
//@Component
//public class OrderService implements InitializingBean {
//
//    @Autowired
//    public OrderService(SmsInterface smsImpl1) {
//        System.out.println("...");
//    }
//
//    public OrderService(SmsInterface SmsImpl1, SmsInterface SmsImpl2) {
//        System.out.println(3);
//    }
//
//    public void init() {
//        System.out.println(123);
//    }
//
//    @Autowired
//    public void abc() {
//        System.out.println(456);
//    }
//
//    @PostConstruct
//    public void post() {
//        System.out.println(12222);
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//
//    }
//
//
//    @Transactional(propagation = Propagation.NEVER)
//    public void doQuery(){
//
//    }
//
//}
