import Entity.Student;
import Service.StudentService;

public class Main {
    public static void main(String[] args) {
//        Student student = new Student("ali","kkljvl","0911236584","alikfl");
       StudentService ss = new StudentService();
//        ss.studentCreate(student);
        ss.showStudent();

    }
}
