package Classes;

import ui.Student;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MyClass {
    public String groupName;
    List<Student> studentList;
    int maxStudent;

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public MyClass(String groupName, int maxStudent) {
        this.groupName = groupName;
        this.studentList = new ArrayList<>();
        this.maxStudent = maxStudent;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(Student student) {
        for (Student s : studentList) {
            if (s.name.contains(student.name)) {
                JOptionPane.showMessageDialog(null,
                        "ten student juz istnieje",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if(studentList.size() < maxStudent){
            System.out.println("");
            studentList.add(student);
        }else {
            JOptionPane.showMessageDialog(null,
                    "Osiągnięto limit stanu osobowego klasy",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void removeStudent(String name, String lastname){
        for (Student s: studentList) {
            if(s.name == name && s.lastName==lastname){
                studentList.remove(s);
            }
        }
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "groupName='" + groupName + '\'' +
                ", studentList=" + studentList +
                ", maxStudent=" + maxStudent +
                '}';
    }

    public void changeCondition(Student student, String studentCondition) {
        for (Student s : studentList) {
            if (s.name.equals(student.name)) {
                student.studentCondition= studentCondition;
            }
        }
    }

    public void print(Student student) {
        for (Student s : studentList) {
            student.print();
            return;
        }
    }

    public  String[][] getClassStudents() {
        String[][] stringList = {};
        for (Student s : studentList) {
            int n = stringList.length;
            String[] tempList = {s.name, s.lastName, s.studentCondition, String.valueOf(s.birthAt), String.valueOf(s.points)};
            stringList = addArrayElement(n, stringList, tempList);
        }
        return stringList;
    }

    public static String[][] addArrayElement(int n, String[][] myArray, String[] ele) {
        String newArray[][] = new String[n + 1][];
        //copy original array into new array
        for (int i = 0; i < n; i++) {
            newArray[i] = myArray[i];
        }
        newArray[n] = ele;
        return newArray;
    }

    public static void main(String[] args) {
        Student student = new Student("Piotr", "Nowak","najebany",2001, 0.1);
        student.print();

        MyClass klasa1 = new MyClass("Pedały", 4);
        klasa1.addStudent(student);
        student.print();
    }


}
