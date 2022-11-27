package ServiceTest;

import Entity.Student;
import Service.StudentService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentServiceTest {
    private static final StudentService ss = new StudentService();
    @Test
    public void create(){
        Student student = new Student("reza","dfg","09116876584","dhfggnrth");
        assertTrue(ss.studentCreate(student));
    }
    @Test
    public void showStudent(){
        ss.showStudent();
    }
//    @Test
//    public void delete(){
//        ss.delete();
//    }
    @Test
    public void update(){
        assertTrue(ss.updateStudent());
    }
}
