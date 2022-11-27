package Entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Master {
    @Id
    @GeneratedValue
    @Column(name = "master_id")
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Lesson> lesson = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
