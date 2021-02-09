package com.mp;

import example.simple.EnumMessage.Person;

public class EnumMain {
    public static void main(String[] args) {
        Person.Builder builder = Person.newBuilder();
        builder.setAge(30);

        builder.setEyeColor(Person.EyeColor.EYE_BLACK);

        Person person = builder.build();
        System.out.println(person);

    }
}
