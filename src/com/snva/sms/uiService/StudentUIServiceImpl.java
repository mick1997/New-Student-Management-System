package com.snva.sms.uiService;

import com.snva.sms.bean.Student;
import com.snva.sms.service.IStudentService;
import com.snva.sms.service.StudentServiceImpl;
import com.snva.sms.service.exception.StudentServiceException;
import com.snva.sms.utils.ReadUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentUIServiceImpl implements IStudentUIService {

    private ReadUtil m_readUtil;
    private IStudentService m_studentService;

    public StudentUIServiceImpl() {
        m_readUtil = new ReadUtil();
        m_studentService = new StudentServiceImpl();
    }

    @Override
    public void addNewStudent() {
        Student student = new Student();
//        student.setId(m_readUtil.readInt("Please enter your id", "Input can not be empty!"));
        student.setfName(m_readUtil.readString("Please enter your First name", "Input can not be empty!"));
        student.setlName(m_readUtil.readString("Please enter your Last name", "Input can not be empty!"));
        student.setDate(m_readUtil.readDate("Please enter your Birth date", "Input can not be empty!"));
        student.setPhoneNumber(m_readUtil.readDouble("Please enter your phone number", "Input can not be empty!"));
        student.setEmail(m_readUtil.readString("Please enter your email address", "Input can not be empty!"));
        student.setAddress(m_readUtil.readString("Please enter your address", "Input can not be empty!"));
        student.setSex(m_readUtil.readString("Please enter your Gender", "Input can not be empty!"));
        m_studentService.addNewStudent(student);
    }

    @Override
    public void showAllStudents() {

        try {
            List<Student> studentList = m_studentService.showAllStudentsInformation();
            System.out.println("All Student Information: \n");
            printList(studentList);
        }
        catch (StudentServiceException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> searchStudentById(int id) {
        List<Student> studentList = null;

        try {
            List<Student> allStudentList = m_studentService.showAllStudentsInformation();
            studentList = new ArrayList<>();
            Iterator<Student> studentIterator = allStudentList.listIterator();
            while (studentIterator.hasNext()) {
                Student student = studentIterator.next();
                if (student.getId().equals(id)) {
                    studentList.add(student);
                }
            }
            printList(studentList);
        }
        catch (StudentServiceException e) {
            System.out.println(e.getMessage());
        }
        if (studentList == null || studentList.size() == 0) {
            throw new NullPointerException();
        }
        return studentList;
    }

    @Override
    public List<Student> searchStudentByName(String name) throws NullPointerException {
        List<Student> studentList = null;

        try {
            name = name.toLowerCase();
            List<Student> allStudentList = m_studentService.showAllStudentsInformation();
            studentList = new ArrayList<>();
            Iterator<Student> studentIterator = allStudentList.listIterator();
            while (studentIterator.hasNext()) {
                Student student = studentIterator.next();
                String fullName = (student.getfName() + " " + student.getlName()).toLowerCase();
                if (fullName.contains(name)) {
                    studentList.add(student);
                }
            }
            printList(studentList);
        }
        catch (StudentServiceException e) {
            System.out.println(e.getMessage());
        }
        if (studentList == null || studentList.size() == 0) {
            throw new NullPointerException();
        }
        return studentList;
    }

    private void printList(List<Student> studentList) {

        for (Student student : studentList) {
            System.out.println("=========================================");
            System.out.println("Student ID: " + student.getId());
            System.out.println("Student First Name: " + student.getfName());
            System.out.println("Student Last Name: " + student.getlName());
            System.out.println("Student Date of Birth: " + student.getDate());
            System.out.println("Student Gender: " + student.getSex());
            System.out.println("Student Phone Number: " + student.getPhoneNumber());
            System.out.println("Student Email: " + student.getEmail());
            System.out.println("Student Address: " + student.getAddress());
            System.out.println("=========================================");
            System.out.println();
        }
    }
}
