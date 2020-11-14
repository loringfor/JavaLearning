package com.loring.annotation;

@PersonAnnotation
public class TestAnnotation {
    public static void print(Class c){
        System.out.println(c.getName());
        // java.lang.Class的getAnnotation方法，如果有注解，则返回注解。否则返回null
        PersonAnnotation person = (PersonAnnotation) c.getAnnotation(PersonAnnotation.class);
        if (person != null) {
            System.out.println("name:" + person.name() + " age:" + person.age());
        }
        else {
            System.out.println("person unknown!");
        }
    }

    @SuppressWarnings("all")
    public static void main(String[] args){
        TestAnnotation.print(TestAnnotation.class);
    }
}
