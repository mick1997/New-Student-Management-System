package com.snva.sms.uiService;

import com.snva.sms.bean.Student;

import java.util.List;

public interface IStudentUIService {

    void addNewStudent();
    void showAllStudents();
    List<Student> searchStudentById(String id);
    List<Student> searchStudentByName(String name);
}
