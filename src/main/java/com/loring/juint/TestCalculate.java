package com.loring.juint;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class TestCalculate {
    private Calculate calculate = new Calculate();

    @Before
    public void beforeTest(){
        System.out.println("before...");
    }

    @After
    public void afterTest(){
        System.out.println("after...");
    }

    @BeforeClass
    public static void beforeClassTest(){
        System.out.println("before class...");
    }

    @AfterClass
    public static void afterClassTest(){
        System.out.println("after class...");
    }

    @Test
    public void testAdd(){
        assertEquals(2,calculate.add(1,1));
        System.out.println("test...");
    }

    @Test
    public void testAdd1(){
        assertEquals(4, calculate.add(1,3));
    }
}
