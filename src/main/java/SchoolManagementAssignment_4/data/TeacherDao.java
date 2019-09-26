package SchoolManagementAssignment_4.data;

import SchoolManagementAssignment_4.model.Teacher;

import java.util.List;

public interface TeacherDao {
    Teacher saveTeacher(Teacher teacher);
    Teacher findById(int id);
    List<Teacher> findByName(String name);
    List<Teacher> findAll();
    boolean removeTeacher(Teacher teacher);
}
