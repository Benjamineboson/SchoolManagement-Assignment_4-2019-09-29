package SchoolManagementAssignment_4;

import static org.junit.Assert.assertEquals;
import SchoolManagementAssignment_4.data.StudentDaoList;
import SchoolManagementAssignment_4.model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;


public class StudentDaoListTest
{

    private Student testStudent;
    private StudentDaoList testStudentList;

    @Before
    public void init (){
        testStudent = new Student (1,"Test Student","test@email.com","Test Address");
        testStudentList = new StudentDaoList();
    }

    @After
    public void clearLists(){
        testStudentList.findAll().clear();
    }


    @Test
    public void test_FindByEmail(){
        testStudentList.saveStudent(testStudent);
        Student expected = testStudent;
        Student actual = testStudentList.findByEmail("test@email.com");
        assertEquals(expected,actual);
        assertEquals(null,testStudentList.findByEmail("Going to return null"));
    }


    @Test
    public void test_SaveStudent(){
        Student expected = testStudent;
        Student actual = testStudentList.saveStudent(testStudent);
        assertEquals(expected,actual);
        actual = testStudentList.saveStudent(testStudent);
        assertEquals(null,actual);
    }


    @Test
    public void test_FindById(){
        testStudentList.saveStudent(testStudent);
        Student expected = testStudent;
        Student actual = testStudentList.findById(1);
        assertEquals(expected,actual);
        actual = testStudentList.findById(5);
        assertEquals(null,actual);
    }


    @Test
    public void test_FindByName(){
        List<Student> expected = new ArrayList<>();
        expected.add(testStudent);
        testStudentList.saveStudent(testStudent);
        List<Student> actual = testStudentList.findByName("Test Student");
        assertEquals(expected,actual);
        actual.remove(testStudent);
        expected.remove(testStudent);
        assertEquals(expected,actual);
    }

    @Test
    public void test_findAll(){
        List<Student> expected = new ArrayList<>();
        expected.add(testStudent);
        testStudentList.saveStudent(testStudent);
        assertEquals(expected,testStudentList.findAll());
    }

    @Test
    public void test_deleteStudent(){
        testStudentList.saveStudent(testStudent);
        assertEquals(true,testStudentList.removeStudent(testStudent));
        assertEquals(false,testStudentList.removeStudent(testStudent));
    }
}
