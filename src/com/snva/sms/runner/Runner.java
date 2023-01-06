package com.snva.sms.runner;

import com.snva.sms.bean.Student;
import com.snva.sms.uiService.IStudentUIService;
import com.snva.sms.uiService.IStudentUIServiceImpl;
import com.snva.sms.utils.ReadUtil;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    private ReadUtil m_readUtil;
    private IStudentUIService m_StudentUIService;

    public Runner() {
        m_readUtil = new ReadUtil();
        m_StudentUIService = new IStudentUIServiceImpl();
        checkUserOptions();
    }

    private void checkUserOptions() {

        int choice = 0;
        List<Student> studentList = new ArrayList<>();

        do {
            displayMainMenu();
            choice = m_readUtil.readInt("Please input your choice", "Please input valid choice");
            switch (choice) {
                case 1:
                    m_StudentUIService.addNewStudent();
                    break;
                case 2:
                    m_StudentUIService.showAllStudents();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Thank you for using Student Management System!");
                    break;
                default:
                    System.out.println("Wrong choice, please enter a correct choice");
                    break;
            }
        }
        while (choice != 5);
    }

    private void displayMainMenu()
    {
        System.out.println("==========Main Menu==========");
        System.out.println("1. Add New Student ");
        System.out.println("2. View all Students ");
        System.out.println("3. View Student by ID ");
        System.out.println("4. View student by Name");
        System.out.println("5. Exit ");
        System.out.println("===========End Menu===========");
    }

    public static void main(String[] args) {
        new Runner();
    }
}
