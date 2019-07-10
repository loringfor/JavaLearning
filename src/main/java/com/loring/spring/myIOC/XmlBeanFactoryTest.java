package com.loring.spring.myIOC;

import com.loring.spring.myIOC.simple.Car;
import com.loring.spring.myIOC.simple.SimpleIOC;
import com.loring.spring.myIOC.simple.Wheel;
import com.loring.spring.myIOC.xml.XmlBeanFactory;

public class XmlBeanFactoryTest {

    public static void main(String[] args) throws Exception {
        String location = SimpleIOC.class.getClassLoader().getResource("myIOC.xml").getFile();
        System.out.println(location);
        XmlBeanFactory factory = new XmlBeanFactory(location);
        Wheel wheel = (Wheel)factory.getBean("wheel");
        System.out.println(wheel.getBrand());
        Car car = (Car) factory.getBean("car");
        System.out.println(car.getName());
    }
}
