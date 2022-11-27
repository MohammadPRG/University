package Service;

import Entity.Student;
import Repository.Repository;

import java.util.List;

public class StudentService {
    private static final Repository<Student> repository = new Repository<Student>();
    private static final Student student = new Student();

    public boolean studentCreate(Student student) {
        repository.create(student);
        return true;
    }

    public List<Student> showStudent() {
        List<Student> list = repository.loadAll("student");
        return list;
    }

    public boolean delete() {
        repository.delete(Student.class, 3);
        return true;
    }

    public boolean updateStudent() {
        Student student1 = new Student();
        student1.setFirstName("ramin");
        repository.update(Student.class, 4);
        return true;
    }
}
