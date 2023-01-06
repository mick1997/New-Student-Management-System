package com.snva.sms.service;

import com.snva.sms.bean.Student;
import com.snva.sms.service.exception.StudentServiceException;

import java.util.List;

public interface IStudentService {

    void addNewStudent(Student student);
    List<Student> showAllStudentsInformation() throws StudentServiceException;
}
