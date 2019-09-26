package SchoolManagementAssignment_4.data;

import SchoolManagementAssignment_4.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherDaoList implements TeacherDao{

    private static List<Teacher> teacherList = new ArrayList<>();

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        if(!teacherList.contains(teacher)){
            teacherList.add(teacher);
            System.out.println(teacher.getTeacherName()+" added");
            return teacher;
        }
        return null;
    }

    @Override
    public Teacher findById(int id) {
        for (Teacher teacher:teacherList) {
            if (teacher.getTeacherId() == id){
                return teacher;
            }
        }
        return null;
    }

    @Override
    public List<Teacher> findByName(String name) {
        List<Teacher> tempList = new ArrayList<>();
        for (Teacher teacher:teacherList) {
            if(teacher.getTeacherName().equalsIgnoreCase(name)){
                tempList.add(teacher);
            }
        }
        return tempList;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherList;
    }

    @Override
    public boolean removeTeacher(Teacher teacher) {
        if(teacherList.contains(teacher)){
            teacherList.remove(teacher);
            System.out.println(teacher.getTeacherName()+" removed");
            return true;
        }
        return false;
    }
}
