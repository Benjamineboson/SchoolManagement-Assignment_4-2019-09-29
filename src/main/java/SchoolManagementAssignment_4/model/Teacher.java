package SchoolManagementAssignment_4.model;

public class Teacher {
    private static int teacherCounter;
    private int teacherId;
    private String teacherName;

    public Teacher(int teacherId, String teacherName) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }

    public Teacher(String teacherName) {
        this(++teacherCounter,teacherName);
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
