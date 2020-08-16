package main.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "students")
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"courses", "subscriptions"})
public class Student implements Serializable {
    private int id;
    private String name;
    private int age;
    private LocalDateTime regDate;
    private List<Course> courses;
    private List<Subscription> subscriptions;

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

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    @Column(name = "registration_date")
    public LocalDateTime getRegDate() {
        return regDate;
    }

    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
    public List<Course> getCourses() {
        return courses;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    @Override
    public String toString() {
        return "Студент:\n\tимя: " + name +
                ", возраст: " + age +
                ", дата регистрации: " + regDate +
                ", куплено курсов: " + courses.size();
    }
}
