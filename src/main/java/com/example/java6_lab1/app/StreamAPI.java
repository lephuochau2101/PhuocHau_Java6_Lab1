package com.example.java6_lab1.app;



import com.example.java6_lab1.bean.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

    static List<Student> list = Arrays.asList(
            new Student("Lê Phước Hậu",true,9.5),
            new Student("Đinh Trọng Trường",true,8.0),
            new Student("Nguyễn Văn Chuyển",true,7.5),
            new Student("Nguyễn Ngọc Duyên",false,9.0),
            new Student("Phạm Ngọc Hà",true,10.0)
    );
    public static void main(String[] args) {
//        StreamAPI_1();
//        StreamAPI_2();
//        StreamAPI_3();
        StreamAPI_4();
    }
    private static void StreamAPI_1(){
        Stream<Integer> stream_1 = Stream.of(1,3,5,6,7);
        stream_1.forEach(n ->{
            System.out.println(n);
        });

        List<Integer> list = Arrays.asList(1,3,5,6,7);
        list.stream().forEach(n-> {
            System.out.println(n);

        });
    }
    private static void StreamAPI_2(){
        List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
        List<Double> result  = list.stream()
                .filter(n-> n%2 ==0)
                .map(n -> Math.sqrt(n))
                .peek(d -> System.out.println(d))
                .collect(Collectors.toList());
    }
    private static void StreamAPI_3(){
        List<Student> result = list.stream()
                .filter(sv -> sv.getMarks() >= 7)
                .peek(sv -> sv.setName(sv.getName().toUpperCase()))
                .collect(Collectors.toList());
        result.forEach(sv -> {
            System.out.println(">> Name: " + sv.getName());
            System.out.println(">> Marks: " + sv.getMarks()); System.out.println();
        });
    }
    private static void StreamAPI_4(){
        double average = list.stream()
                .mapToDouble(sv -> sv.getMarks())
                .average().getAsDouble();
        System.out.println("average: " + average);
        double sum = list.stream()
                .mapToDouble(sv -> sv.getMarks())
                .sum();
        System.out.println("sum: " + sum);

        double min_marks = list.stream() .mapToDouble(sv -> sv.getMarks()) .min().getAsDouble();
        System.out.println("min_marks: " + min_marks);
        boolean all_passed = list.stream()
                .allMatch (sv -> sv.getMarks() >= 5);
        System.out.println("all_passed: " + all_passed);
        Student min_sv = list.stream() .reduce(list.get(0),
                (min, sv) -> sv.getMarks() < min.getMarks() ? sv: min);
        System.out.println("min_sv: " + min_sv.getName());
    }
}
