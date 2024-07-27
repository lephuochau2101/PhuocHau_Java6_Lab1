package com.example.java6_lab1.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JackSon {
    public static void main(String[] args) throws Exception {
//        Jackson_1();
        Jackson_2();
    }

    private static void Jackson_1() throws Exception {
        String path = "D:\\FPT Polytechnic\\JAVA6\\Test_Java6\\Java6_Lab1\\src\\main\\resources\\Student.json";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode student = mapper.readTree(new File(path));

        System.out.println(">> Name: " + student.get("name").asText());
        System.out.println(">> Marks: " + student.get("marks").asDouble());
        System.out.println(">> Gender: " + student.get("gender").asBoolean());

        JsonNode contact = student.get("contact");
        if (contact != null) {
            System.out.println(">> Email: " + contact.get("email").asText());
            System.out.println(">> Phone: " + contact.get("phone").asText());
        }

        JsonNode subjects = student.get("subjects");
        if (subjects != null && subjects.isArray()) {
            subjects.forEach(subject -> {
                System.out.println(">> Subject: " + subject.asText());
            });
        }
    }

    private static void Jackson_2() throws Exception{
        String path = "D:\\FPT Polytechnic\\JAVA6\\Test_Java6\\Java6_Lab1\\src\\main\\resources\\Students.json";
        ObjectMapper mapper = new ObjectMapper();

        JsonNode students = mapper.readTree(new File(path));
        students.iterator().forEachRemaining(student -> {
            System.out.println(">> Name: " + student.get("name").asText());
        });
    }
}
