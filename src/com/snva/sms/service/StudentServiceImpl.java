package com.snva.sms.service;

import com.snva.sms.bean.Student;
import com.snva.sms.service.exception.StudentServiceException;
import com.snva.sms.utils.ReadUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentServiceImpl implements IStudentService {

    private List<Student> studentList;
    private ReadUtil m_readUtil;
    private String directoryPath;

    public StudentServiceImpl() {
        studentList = new ArrayList<>();
        m_readUtil = new ReadUtil();
        directoryPath = "/Users/jackfeng/Desktop/example";
        studentList = loadAllStudent(directoryPath);
    }

    private List<Student> loadAllStudent(String directoryPath) {

        List<Student> studentsList = new ArrayList<>();

        File file = new File(directoryPath);
        String[] fileNames = file.list();
        for (String fileName: fileNames) {
            try {
                FileInputStream fileInputStream = new FileInputStream(directoryPath + "/" + fileName);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Student student = (Student)objectInputStream.readObject();
                studentsList.add(student);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return studentsList;
    }

    @Override
    public void addNewStudent(Student student) {

        try {
//            String fileName = student.getId() + student.hashCode();
//            String fileName = student.getId() + "";
//            studentList.add(student);
            // file path output
            File file = new File(directoryPath);
            // covert file to String array
            String[] allFiles = file.list();
            assert allFiles != null;
            Arrays.sort(allFiles);
            // get last file
            String lastFile = allFiles[allFiles.length - 1];
            // get curIdx by split lastFile with "."[0] and then plus 1 to become next index of new file
            int curIdx =  Integer.parseInt(lastFile.split("\\.")[0]) + 1;
            // set current id with curIdx
            student.setId(curIdx);
            String fileName = student.getId() + "";
            FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath() + "/" + fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.println("File was write and saved at " + file.getAbsolutePath());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> showAllStudentsInformation() throws StudentServiceException {

        studentList = loadAllStudent(directoryPath);
        if (studentList.size() == 0) {
            throw new StudentServiceException(StudentServiceException.NO_STUDENT_FOUND);
        }
        return studentList;
    }
}
