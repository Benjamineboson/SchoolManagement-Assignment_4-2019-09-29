package SchoolManagementAssignment_4;

import SchoolManagementAssignment_4.data.CourseDaoList;
import SchoolManagementAssignment_4.model.Course;
import SchoolManagementAssignment_4.model.Teacher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CourseDaoListTest {

    private Course testCourse;
    private CourseDaoList testCourseList;
    private Teacher testTeacher;

    @Before
    public void init (){
        testTeacher = new Teacher("Test Teacher");
        testCourse = new Course(1,"Test Course", LocalDate.parse("2020-01-01"),5,testTeacher);
        testCourseList = new CourseDaoList();
    }

    @After
    public void clearList(){
        testCourseList.findAll().clear();
    }


    @Test
    public void test_FindByDate(){
        List<Course> expected = new ArrayList<>();
        expected.add(testCourse);
        testCourseList.saveCourse(testCourse);
        List<Course> actual = testCourseList.findByDate(LocalDate.parse("2020-01-01"));
        assertEquals(expected,actual);
        expected.remove(testCourse);
        actual.remove(testCourse);
        assertEquals(expected,actual);
    }

    @Test
    public void test_SaveCourse(){
        Course expected = testCourse;
        Course actual = testCourseList.saveCourse(testCourse);
        assertEquals(expected,actual);
        actual = testCourseList.saveCourse(testCourse);
        assertEquals(null,actual);
    }

//
    @Test
    public void test_FindById(){
        testCourseList.saveCourse(testCourse);
        Course expected = testCourse;
        Course actual = testCourseList.findById(1);
        assertEquals(expected,actual);
        actual = testCourseList.findById(5);
        assertEquals(null,actual);
    }


    @Test
    public void test_FindByName(){
        List<Course> expected = new ArrayList<>();
        expected.add(testCourse);
        testCourseList.saveCourse(testCourse);
        List<Course> actual = testCourseList.findByName("Test Course");
        assertEquals(expected,actual);
        actual.remove(testCourse);
        expected.remove(testCourse);
        assertEquals(expected,actual);
    }

    @Test
    public void test_findAll(){
        List<Course> expected = new ArrayList<>();
        expected.add(testCourse);
        testCourseList.saveCourse(testCourse);
        assertEquals(expected,testCourseList.findAll());
    }

    @Test
    public void test_RemoveCourse(){
        testCourseList.saveCourse(testCourse);
        assertEquals(true,testCourseList.removeCourse(testCourse));
        assertEquals(false,testCourseList.removeCourse(testCourse));
    }
}
