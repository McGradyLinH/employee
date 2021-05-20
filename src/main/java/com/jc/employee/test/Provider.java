package com.jc.employee.test;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author LX
 * @date 2021/4/25
 */

public class Provider implements InvocationHandler {
    private Object target;

    public Object getProxyObject(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method before");
        return method.invoke(target, args);
    }

    public static void main(String[] args) {
        ProviderInterface provider = new ProviderImpl();
        Provider provider1 = new Provider();
        ProviderInterface proxyObject = (ProviderInterface) provider1.getProxyObject(provider);
        System.out.println(proxyObject);
//        provider.sayHello("lx");
    }
}

class ProviderImpl implements ProviderInterface{

    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}
