package SchoolManagementAssignment_4.data;

import SchoolManagementAssignment_4.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoList implements CourseDao {

    private static List<Course> courseList = new ArrayList<>();

    // TESTED
    @Override
    public Course saveCourse(Course course) {
        if(!courseList.contains(course)){
            courseList.add(course);
            System.out.println(course.getCourseName()+" added");
            return course;
        }
        return null;
    }

    // TESTED
    @Override
    public Course findById(int id) {
        for (Course course:courseList) {
            if (course.getCourseId() == id){
                return course;
            }
        }
        return null;
    }

    // TESTED
    @Override
    public List<Course> findByName(String name) {
       List<Course> tempList = new ArrayList<>();
        for (Course course:courseList) {
            if(course.getCourseName().equalsIgnoreCase(name)){
                tempList.add(course);
            }
        }
        return tempList;
    }

    // TESTED
    @Override
    public List<Course> findByDate(LocalDate date) {
       List<Course> tempList = new ArrayList<>();
        for (Course course:courseList) {
            if (course.getStartDate().isEqual(date)){
                tempList.add(course);
            }
        }
        return tempList;
    }

    // TESTED
    @Override
    public List<Course> findAll() {
        return courseList;
    }

    // TESTED
    @Override
    public boolean removeCourse(Course course) {
        if (courseList.contains(course)){
            courseList.remove(course);
            return true;
        }
        return false;
    }
}
