package com.snva.sms.service;

import com.snva.sms.bean.Student;
import com.snva.sms.service.exception.StudentServiceException;
import com.snva.sms.utils.ReadUtil;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements IStudentService {

    private List<Student> studentList;
    private ReadUtil m_readUtil;

    public StudentServiceImpl() {
        studentList = new ArrayList<>();
        m_readUtil = new ReadUtil();
    }

    @Override
    public void addNewStudent(Student student) {

        try {
            studentList.add(student);
        }
        catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
        catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> showAllStudentsInformation() throws StudentServiceException {

        if (studentList.size() == 0) {
            throw new StudentServiceException(StudentServiceException.NO_STUDENT_FOUND);
        }
        return studentList;
    }
}
