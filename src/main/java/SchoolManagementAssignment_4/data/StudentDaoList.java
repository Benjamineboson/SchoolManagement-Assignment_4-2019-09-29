package SchoolManagementAssignment_4.data;

import SchoolManagementAssignment_4.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoList implements StudentDao {

    private static List<Student> studentList = new ArrayList<>();

    // TESTED
    @Override
    public Student saveStudent(Student student) {
    if (!studentList.contains(student)){
        studentList.add(student);
        System.out.println(student.getName()+" added");
        return student;
    }
    return null;
    }


    // TESTED
    @Override
    public Student findByEmail(String email) {
        for (Student student : studentList) {
            if (student.getEmail().equalsIgnoreCase(email)) {
                return student;
            }
        }
        return null;
    }


    // TESTED
    @Override
    public Student findById(int id) {
        for (Student student:studentList) {
            if(student.getStudentId() == id){
                return student;
            }
        }
        return null;
    }


    // TESTED
    @Override
    public List<Student> findByName(String name) {
        List<Student> tempList = new ArrayList<>();
        for (Student student:studentList) {
            if (student.getName().equalsIgnoreCase(name)){
                tempList.add(student);
            }
        }
        return tempList;
    }


    // TESTED
    @Override
    public List<Student> findAll() {
        return studentList;
    }


    // TESTED
    @Override
    public boolean removeStudent(Student student) {
    if(studentList.contains(student)){
        System.out.println(student.getName()+" removed");
        studentList.remove(student);
        return true;
    }
    return false;
    }
}
