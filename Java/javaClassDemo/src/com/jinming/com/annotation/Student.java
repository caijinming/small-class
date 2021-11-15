package com.jinming.com.annotation;

@CustomDescription(description = "学生")
public class Student extends Person {
    private String studentId;

    public Student() {

    }
    public Student(String name) {
        super(name);
        studentId = "123";
    }

    public Student(String name, String studentId) {
        super(name);
        studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String StudentPublicMethod(String str) {
        return str;
    }

    private String StudentPrivateMethod(String str) {
        return str;
    }
}
