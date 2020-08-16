package main.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "teachers")
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"courses"})
public class Teacher implements Serializable {
    private int id;
    private String name;
    private int salary;
    private int age;
    private List<Course> courses;

    //==================================================================================================================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "salary")
    public int getSalary() {
        return salary;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Учитель:\n\tимя: " + name +
                ", возраст: " + age +
                ", зарплата: " + salary +
                ", курсов ведёт: " + courses.size();
    }
}
