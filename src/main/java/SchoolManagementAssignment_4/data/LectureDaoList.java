package SchoolManagementAssignment_4.data;

import SchoolManagementAssignment_4.model.Lecture;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class LectureDaoList implements LectureDao {

   private static List<Lecture> lectureList = new ArrayList<>();

    @Override
    public Lecture saveLecture(Lecture lecture) {
        if(!lectureList.contains(lecture)){
            lectureList.add(lecture);
            System.out.println(lecture.getLectureName()+" added");
            return lecture;
        }
        return null;
    }

    @Override
    public List<Lecture> findByTime(LocalTime time) {
        List<Lecture> tempList = new ArrayList<>();
        for (Lecture lecture:lectureList) {
            if(lecture.getLectureTime().equals(time)){
                tempList.add(lecture);
                System.out.println(lecture+" added");
            }
        }
        return tempList;
    }

    @Override
    public Lecture findById(int id) {
        for (Lecture lecture:lectureList) {
            if (lecture.getLectureId() == id){
                return lecture;
            }
        }
        return null;
    }

    @Override
    public List<Lecture> findByName(String name) {
        return null;
    }

    @Override
    public List<Lecture> findAll() {
        return null;
    }

    @Override
    public boolean removeLecture(Lecture lecture) {
        return false;
    }
}
