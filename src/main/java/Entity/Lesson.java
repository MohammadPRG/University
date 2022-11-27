package Entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private int numberOfCourse;

    @ManyToMany(mappedBy = "lessonSet")
    private Set<Major> majorSet=new HashSet<>();

    @ManyToMany
    private Set<Student> students = new HashSet<>();

    @ManyToOne
    private Master master;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfCourse() {
        return numberOfCourse;
    }

    public void setNumberOfCourse(int numberOfCourse) {
        this.numberOfCourse = numberOfCourse;
    }
}
