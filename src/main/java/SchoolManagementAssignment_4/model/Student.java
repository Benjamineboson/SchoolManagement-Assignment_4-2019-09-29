package SchoolManagementAssignment_4.model;

public class Student {

    private static int studentCounter;
    private int studentId;
    private String studentName;
    private String email;
    private String address;

    public Student(int studentId, String studentName, String email, String address) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.address = address;
    }

    public Student(String name, String email, String address) {
        this (++studentCounter,name,email,address);
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return studentName;
    }

    public void setName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void getInfo(){
        System.out.println("\n-----------STUDENT-INFO-----------"+
                "\nName: "+this.getName()+
                "\nID: "+getStudentId()+
                "\nEmail: "+getEmail()+
                "\nAddress: "+getAddress()+"\n"+
                "-----------STUDENT-INFO-----------\n");
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + studentName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
