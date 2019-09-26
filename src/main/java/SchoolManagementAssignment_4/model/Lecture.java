package SchoolManagementAssignment_4.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Lecture {
    private static int lectureCounter;
    private int lectureId;
    private String lectureName;
    private List<Teacher> teacherList;
    private LocalTime lectureTime;

    public Lecture(int lectureId, String lectureName, LocalTime lectureTime) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.lectureTime = lectureTime;
        this.teacherList = new ArrayList<>();
    }

    public Lecture(String lectureName, LocalTime lectureTime) {
        this(++lectureCounter,lectureName, lectureTime);
    }

    public int getLectureId() {
        return lectureId;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public LocalTime getLectureTime() {
        return lectureTime;
    }

    public void setLectureTime(LocalTime lectureTime) {
        this.lectureTime = lectureTime;
    }

    public void addTeacher (Teacher teacher){
        if (!teacherList.contains(teacher)) {
            teacherList.add(teacher);
            System.out.println(teacher.getTeacherName()+" added to "+getLectureName());
        }
    }

    public void removeTeacher (int id){
        removeTeacher(findById(id));
    }

    public void removeTeacher (Teacher teacher){
        System.out.println(teacher.getTeacherName()+" removed from "+getLectureName());
        teacherList.remove(teacher);
    }

    public Teacher findById (int id){
        for (Teacher teacher:teacherList) {
            if (teacher.getTeacherId() == id){
                return teacher;
            }
        }
        return null;
    }

}
