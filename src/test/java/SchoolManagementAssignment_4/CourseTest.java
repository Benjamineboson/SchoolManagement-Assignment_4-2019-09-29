package SchoolManagementAssignment_4;
import static org.junit.Assert.assertEquals;
import SchoolManagementAssignment_4.model.Course;
import SchoolManagementAssignment_4.model.Student;
import SchoolManagementAssignment_4.model.Teacher;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class CourseTest {

    private Teacher testTeacher;
    private Course testCourse;
    private Student testStudent;

    @Before
    public void init(){
        testTeacher= new Teacher("Test Teacher");
        testCourse = new Course(1,"Test Course", LocalDate.parse("2020-01-01"),5,testTeacher);
        testStudent= new Student(1,"Test Student","test@email.com","Test Address");
    }

    @Test
    public void test_FindByEmail(){
        testCourse.addStudent(testStudent);
        Student expected = testStudent;
        Student actual = testCourse.findByEmail("test@email.com");
        assertEquals(expected,actual);
        assertEquals(null,testCourse.findByEmail("Going to return null"));
    }

    @Test
    public void test_FindById(){
        testCourse.addStudent(testStudent);
        Student expected = testStudent;
        Student actual = testCourse.findById(1);
        assertEquals(expected,actual);
        assertEquals(null,testCourse.findById(5));

    }
}
