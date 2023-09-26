package com.myself.service.impl;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class JackProxy implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        Class<?> clazz = method.getDeclaringClass();
        // 代理类拦截了所有方法，这里如果调用类原生方法，就不拦截。
        if (Object.class.equals(clazz)) {
            return method.invoke(this, objects);
        }

        return "cglib  invoker hello";
    }
}
