package Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Major {
    @Id
    @GeneratedValue
    @Column(name = "major_id")
    private int id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String majorCode;

    @ManyToMany
    @JoinTable(
            name = "major_lesson",
            joinColumns = {@JoinColumn(name = "major_id")},
            inverseJoinColumns = {@JoinColumn(name = "lesson_id")})
    private Set<Lesson> lessonSet = new HashSet<>();

    @OneToMany
    private Set<Student> studentSet = new HashSet<>();

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

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }
}
