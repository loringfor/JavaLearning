package com.loring.rpc.servicebean;

public class CalculateImpl implements Calculate{
    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
