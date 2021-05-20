package com.jc.employee.test;

/**
 * @author LX
 * @date 2021/4/25
 */
public class SingletonObject {
    private SingletonObject(){}

    private static class SingletonObjectCreator{
        private static final SingletonObject singletonObject = new SingletonObject();
    }

    public static SingletonObject getInstance(){
        return SingletonObjectCreator.singletonObject;
    }

}
