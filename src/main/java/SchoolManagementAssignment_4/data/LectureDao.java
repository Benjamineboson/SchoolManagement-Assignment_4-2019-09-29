package SchoolManagementAssignment_4.data;


import SchoolManagementAssignment_4.model.Lecture;
import SchoolManagementAssignment_4.model.Teacher;

import java.time.LocalTime;
import java.util.List;

public interface LectureDao {
    Lecture saveLecture(Lecture lecture);
    List<Lecture> findByTime(LocalTime time);
    Lecture findById(int id);
    List<Lecture> findByName(String name);
    List<Lecture> findAll();
    boolean removeLecture(Lecture lecture);
}
