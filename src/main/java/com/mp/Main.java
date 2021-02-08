package com.mp;

import example.simple.BasicMessage.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Protobuf");
        Person.Builder person = Person.newBuilder();

        // Simple fields
        person.setAge(30)
                .setFirstName("Muthiah")
                .setLastName("Prabhakaran")
                .setHeight(162.5f)
                .setProfileVerified(true);

        // Repeated fields
        person.addPhoneNumber("1")
                .addPhoneNumber("2");

        person.addAllPhoneNumber(Arrays.asList("3","4","5"));

        // person.clearPhoneNumber(); //To clear

        System.out.println(person);

        Person p1 = person.build();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(p1.getFirstName());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("simple-message.bin");
            p1.writeTo(fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Converting to byte array to send over network
        // byte[] bytes = p1.toByteArray();

        System.out.println("Reading from the file...");

        try {
            FileInputStream fileInputStream = new FileInputStream("simple-message.bin");
            Person p2 = Person.parseFrom(fileInputStream);
            System.out.println(p2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
