package com.test.practice;


import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StudentDto {
    private String a = "김이박최조정우지장신명";
    private String b = "이신명재도하민정국훈치";
    private String c = "이신명재도하민정국훈치";
    private String name;
    private int hak;
    private int ban;
    private int age;
    private int kor;
    private int math;
    private int eng;

    public StudentDto() {
        Random random = new Random();
        this.name = a.split("")[random.nextInt(a.length())]+b.split("")[random.nextInt(b.length())]+c.split("")[random.nextInt(c.length())];
        this.age = random.nextInt(20)+10;
        this.kor = random.nextInt(100)+1;
        this.math = random.nextInt(100)+1;
        this.eng = random.nextInt(100)+1;
        this.hak = random.nextInt(3)+1;
        this.ban = random.nextInt(4)+1;
    }

    public static List<StudentDto> studentDtoList(int size){
        List<StudentDto> studentDtos = new ArrayList<>();
        for(int i=0;i<size;i++){
            studentDtos.add(new StudentDto());
        }
        return studentDtos;
    }
    public String getName() { return name; }public void setName(String name) { this.name = name; }public int getAge() { return age; }public void setAge(int age) { this.age = age; }public int getKor() { return kor; }public void setKor(int kor) { this.kor = kor; }public int getMath() { return math; }public void setMath(int math) { this.math = math; }public int getEng() { return eng; }public void setEng(int eng) { this.eng = eng; }

    public int getHak() { return hak; }public void setHak(int hak) { this.hak = hak; }public int getBan() { return ban; }public void setBan(int ban) { this.ban = ban; }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", hak=" + hak +
                ", ban=" + ban +
                ", age=" + age +
                ", kor=" + kor +
                ", math=" + math +
                ", eng=" + eng +
                '}';
    }
}
