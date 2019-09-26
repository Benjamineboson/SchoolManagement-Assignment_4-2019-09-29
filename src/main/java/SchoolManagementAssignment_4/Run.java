package SchoolManagementAssignment_4;

import SchoolManagementAssignment_4.data.CourseDaoList;
import SchoolManagementAssignment_4.data.LectureDaoList;
import SchoolManagementAssignment_4.data.StudentDaoList;
import SchoolManagementAssignment_4.data.TeacherDaoList;
import SchoolManagementAssignment_4.model.Course;
import SchoolManagementAssignment_4.model.Lecture;
import SchoolManagementAssignment_4.model.Student;
import SchoolManagementAssignment_4.model.Teacher;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Run {
    private CourseDaoList courseList = new CourseDaoList();
    private StudentDaoList studentList = new StudentDaoList();
    private TeacherDaoList teacherList = new TeacherDaoList();
    private LectureDaoList lectureList = new LectureDaoList();

    public void run (){
        Scanner scan = new Scanner (System.in);
        boolean isInUse = true;
        while (isInUse){
            boolean isChoosing = true;
            while (isChoosing) {
                System.out.println("(1) Create new student/teacher/course/lecture\n" +
                        "(2) Register/Remove student from course\n" +
                        "(3) Register/Remove teacher from lecture\n" +
                        "(4) Register/Remove lecture from course\n" +
                        "(5) Find specific student/course\n" +
                        "(6) Edit student/course\n" +
                        "(7) Quit");
                String choice = scan.nextLine();
                if (choice.equalsIgnoreCase("1")){
                    Scanner choice1Scanner = new Scanner(System.in);
                    System.out.println("(1) Create new student\n(2) Create new teacher\n(3) Create new course\n(4) Create new lecture");
                    String choice1secondChoice = choice1Scanner.nextLine();
                    if (choice1secondChoice.equalsIgnoreCase("1")) {
                        Scanner studentScanner = new Scanner(System.in);
                        System.out.println("Enter full name, email and address - In that order.");
                        Student newStudent = new Student(studentScanner.nextLine(), studentScanner.nextLine(), studentScanner.nextLine());
                        studentList.saveStudent(newStudent);
                    }else if (choice1secondChoice.equalsIgnoreCase("2")){
                        Scanner teacherScanner = new Scanner (System.in);
                        System.out.println("Enter name");
                        Teacher newTeacher = new Teacher(teacherScanner.nextLine());
                        teacherList.saveTeacher(newTeacher);
                    } else if (choice1secondChoice.equalsIgnoreCase("3")) {
                        Scanner courseScanner = new Scanner (System.in);
                        System.out.println("Enter course name");
                       try {
                           String tempName = courseScanner.nextLine();
                           System.out.println("Enter start date (YYYY-MM-DD)");
                           String tempDate = courseScanner.nextLine();
                           System.out.println("Enter duration of course (number of weeks)");
                           int tempDuration = courseScanner.nextInt();
                           for (Teacher teacher:teacherList.findAll()){
                               System.out.println("Name: "+teacher.getTeacherName()+"\t|\tId: "+teacher.getTeacherId());
                           }
                           System.out.println("Enter the ID of the teacher supervising the course");
                           Course newCourse = new Course(tempName, LocalDate.parse(tempDate), tempDuration,teacherList.findById(courseScanner.nextInt()));
                           courseList.saveCourse(newCourse);
                       }catch (InputMismatchException|DateTimeParseException e){
                           System.out.println("Enter valid date (YYYY-MM-DD) / Enter valid course duration (0-9)");
                       }
                    }else if (choice1secondChoice.equalsIgnoreCase("4")){
                        Scanner lectureScanner = new Scanner (System.in);
                        System.out.println("Enter lecture name");
                        String tempName = lectureScanner.nextLine();
                        System.out.println("Enter time of lecture");
                        String tempTime = lectureScanner.nextLine();
                        Lecture tempLecture = new Lecture (tempName,LocalTime.parse(tempTime));
                        lectureList.saveLecture(tempLecture);
                    } else {
                        System.out.println("Make a choice between 1 - 4");
                    }
                } else if (choice.equalsIgnoreCase("2")) {
                    Scanner choice2Scanner = new Scanner(System.in);
                    System.out.println("(1) Register student to course\n(2) Remove student from course");
                    String choice2secondChoice = choice2Scanner.nextLine();
                    if (choice2secondChoice.equalsIgnoreCase("1")){
                        for (Course course:courseList.findAll()){
                            System.out.println(course.getCourseName()+" ID: "+course.getCourseId());
                        }
                        System.out.println("Enter the email address of the student and the ID of the desired course");
                        Student tempStudent = studentList.findByEmail(choice2Scanner.nextLine());
                        try{
                            courseList.findById(choice2Scanner.nextInt()).addStudent(tempStudent);
                        }catch (InputMismatchException|NullPointerException e){
                            System.out.println("Email or ID non existent");
                        }
                    }else if (choice2secondChoice.equalsIgnoreCase("2")){
                        for (Course course:courseList.findAll()){
                            System.out.println(course.getCourseName()+" ID: "+course.getCourseId());
                        }
                        System.out.println("Enter the email address of the student and the ID of the desired course");
                        Student tempStudent = studentList.findByEmail(choice2Scanner.nextLine());
                        try{
                            courseList.findById(choice2Scanner.nextInt()).removeStudent(tempStudent);
                        }catch (InputMismatchException|NullPointerException e){
                            System.out.println("Email or ID non existent");
                        }
                    }else{
                        System.out.println("Make a choice between 1 - 2");
                    }
                }else if(choice.equalsIgnoreCase("3")){

                }else if(choice.equalsIgnoreCase("4")){

                }else  if (choice.equalsIgnoreCase("5")) {
                    Scanner choice3Scanner = new Scanner(System.in);
                    System.out.println("(1) Find student\n(2) Find course");
                    String choice3secondChoice = choice3Scanner.nextLine();
                    if (choice3secondChoice.equalsIgnoreCase("1")){
                        System.out.println("(1) Find student by name\n" +
                                           "(2) Find student by ID\n" +
                                           "(3) Find student by email\n" +
                                           "(4) Get a list of all students");
                        String choice3thirdChoice = choice3Scanner.nextLine();
                        if (choice3thirdChoice.equalsIgnoreCase("1")){
                            System.out.println("Enter student name");
                            List<Student> tempStudentList = studentList.findByName(choice3Scanner.nextLine());
                            for (Student student : tempStudentList) {
                                student.getInfo();
                            }
                        }

                        else if(choice3thirdChoice.equalsIgnoreCase("2")){
                            System.out.println("Enter student ID");
                            try{
                                Student tempStudent = studentList.findById(choice3Scanner.nextInt());
                                tempStudent.getInfo();
                            }catch (NullPointerException|InputMismatchException e){
                                System.out.println("Enter valid ID");
                            }

                        }

                        else if(choice3thirdChoice.equalsIgnoreCase("3")){
                            System.out.println("Enter student Email");
                            try {
                                Student tempStudent = studentList.findByEmail(choice3Scanner.nextLine());
                                tempStudent.getInfo();
                            }catch (NullPointerException e){
                                System.out.println("Enter valid Email");
                            }
                        }
                        else if(choice3thirdChoice.equalsIgnoreCase("4")){
                            List<Student> tempStudentList = studentList.findAll();
                            for (Student student : tempStudentList) {
                               student.getInfo();
                            }
                        }else{
                            System.out.println("Make a choice between 1 - 4");
                        }
                    }else if(choice3secondChoice.equalsIgnoreCase("2")){
                        System.out.println("(1) Find course by ID\n" +
                                "(2) Find course by name\n" +
                                "(3) Find course by start date\n" +
                                "(4) Get a list of all courses");
                        String choice3thirdChoice = choice3Scanner.nextLine();
                        if (choice3thirdChoice.equalsIgnoreCase("1")){
                            System.out.println("Enter course ID");
                            try {
                                Course tempCourse = courseList.findById(choice3Scanner.nextInt());
                                tempCourse.getInfo();
                            }catch (InputMismatchException|NullPointerException e){
                                System.out.println("Enter valid ID");
                            }
                        }else if (choice3thirdChoice.equalsIgnoreCase("2")){
                            System.out.println("Enter course name");
                            List<Course> tempList = courseList.findByName(choice3Scanner.nextLine());
                            for (Course course:tempList) {
                                course.getInfo();
                            }
                        }else if (choice3thirdChoice.equalsIgnoreCase("3")){
                            System.out.println("Enter course start date");
                            try{
                            List<Course> tempList = courseList.findByDate(LocalDate.parse(choice3Scanner.nextLine()));
                            for (Course course:tempList) {
                                course.getInfo();
                            }
                            }catch (NullPointerException|DateTimeParseException e){
                                System.out.println("Enter valid date (YYYY-MM-DD)");
                            }
                        }else if (choice3thirdChoice.equalsIgnoreCase("4")){
                            List<Course> tempList = courseList.findAll();
                            for (Course course:tempList) {
                                course.getInfo();
                            }
                        }else{
                            System.out.println("Make a choice between 1 - 4");
                        }
                    }else{
                        System.out.println("Make a choice between 1 - 2");
                    }
                } else if (choice.equalsIgnoreCase("6")) {
                    Scanner choice4Scanner = new Scanner (System.in);
                    System.out.println("(1) Edit student\n(2) Edit course");
                    String choice4secondChoice = choice4Scanner.nextLine();
                    if (choice4secondChoice.equalsIgnoreCase("1")){
                        System.out.println("Enter email of student you wish to edit");
                        try {
                            Student tempStudent = studentList.findByEmail(choice4Scanner.nextLine());
                            System.out.println(tempStudent.getName() + "\n(1) Edit name: \n(2) Edit email: \n(3) Edit address");

                            String choice4thirdChoice = choice4Scanner.nextLine();
                            if (choice4thirdChoice.equalsIgnoreCase("1")) {
                                System.out.println("Enter new name");
                                tempStudent.setName(choice4Scanner.nextLine());
                            } else if (choice4thirdChoice.equalsIgnoreCase("2")) {
                                System.out.println("Enter new email");
                                tempStudent.setEmail(choice4Scanner.nextLine());
                            } else if (choice4thirdChoice.equalsIgnoreCase("3")) {
                                System.out.println("Enter new address");
                                tempStudent.setAddress(choice4Scanner.nextLine());
                            } else {
                                System.out.println("Make a choice between 1 - 3");
                            }
                        }catch (NullPointerException e){
                            System.out.println("Enter valid Email");
                        }
                    }else if (choice4secondChoice.equalsIgnoreCase("2")){
                        Scanner choice4Scanner2 = new Scanner (System.in);
                        System.out.println("Enter ID of course you wish to edit");
                       try {
                           int tempId = choice4Scanner2.nextInt();
                           Course tempCourse = courseList.findById(tempId);
                           System.out.println(tempCourse.getCourseName() + "\n(1) Edit name: \n(2) Edit start date: \n(3) Edit course duration:");
                           String choice4thirdChoice = choice4Scanner.nextLine();
                           if (choice4thirdChoice.equalsIgnoreCase("1")) {
                               System.out.println("Enter new name");
                               tempCourse.setCourseName(choice4Scanner.nextLine());
                           } else if (choice4thirdChoice.equalsIgnoreCase("2")) {
                               System.out.println("Enter new start date");
                               tempCourse.setStartDate(LocalDate.parse(choice4Scanner.nextLine()));
                           } else if (choice4thirdChoice.equalsIgnoreCase("3")) {
                               System.out.println("Enter new course duration in weeks");
                               tempCourse.setCourseDuration(choice4Scanner.nextInt());
                           } else {
                               System.out.println("Make a choice between 1 - 3");
                           }
                       }catch (InputMismatchException|NullPointerException|DateTimeParseException e){
                           System.out.println("Enter valid ID (0-9) / Enter valid start date (YYYY-MM-DD) / Enter valid course duration (0-9)");
                       }
                    }else{
                        System.out.println("Make a choice between 1 - 2");
                    }
                }else if (choice.equalsIgnoreCase("7")){
                    isChoosing = false;
                }else{
                    System.out.println("Make a choice between 1 - 5");
                }
            }
            System.out.println("(1) To exit program\nTo continue press any key...");
            String killSwitch = scan.nextLine();
            if (killSwitch.equalsIgnoreCase("1")){
                isInUse = false;
            }

        }
    }

}
