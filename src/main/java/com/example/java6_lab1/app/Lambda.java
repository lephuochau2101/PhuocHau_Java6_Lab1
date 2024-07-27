package com.example.java6_lab1.app;



import com.example.java6_lab1.bean.Student;

import java.util.Arrays;
import java.util.List;

public class Lambda {

    static List<Student> list = Arrays.asList();
    public  static void main(String[] args) {

//        student();
//        student1();
        demo2();
    }
    private static void studen(){
        List<Student> list = Arrays.asList(
                new Student("Lê Phước Hậu",true,9.5),
                new Student("Đinh Trọng Trường",true,8.0),
                new Student("Nguyễn Văn Chuyển",true,7.5),
                new Student("Nguyễn Ngọc Duyên",false,9.0),
                new Student("Phạm Ngọc Hà",true,10.0)
        );

        list.forEach(sv-> {
            System.out.println(">> Name "+sv.getName());
            System.out.println(">> Name "+sv.getMarks());
            System.out.println();
        });
    }
//    private static void student1() {
//        Collections.sort(list, (sv1, sv2) -> sv1.getMarks().compareTo(sv2.getMarks()));
//        list.forEach(sv -> {
//            System.out.println(">> Name: " + sv.getName());
//            System.out.println(">> Marks: " + sv.getMarks());
//            System.out.println();
//        });
//    }

    private static void demo2(){
    Demo2Inter o = x -> System.out.println(x);
       o.m1(2022);
    }
 @FunctionalInterface
    interface Demo2Inter {
        void m1 (int x);
        default void m2(){}
     public static void m3(){}
 }
}
