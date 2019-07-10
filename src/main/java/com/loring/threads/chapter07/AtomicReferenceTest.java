package com.loring.threads.chapter07;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
    public static AtomicReference<User> atomicReference = new AtomicReference<User>();

    public static void main(String[] args) {
        User user = new User("Loring",24);
        atomicReference.set(user);
        User updateUser = new User("HHHHH",12);
        atomicReference.compareAndSet(user,updateUser);
        System.out.println(atomicReference.get().getName());
        System.out.println(atomicReference.get().getOld());
    }

    public static class User{
        private String name;
        private int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }
    }
}
