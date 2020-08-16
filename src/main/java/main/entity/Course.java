package main.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.enums.CourseType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "courses")
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"students", "subscriptions"})
public class Course implements Serializable {
    private int id;
    private String name;
    private int duration;
    private CourseType type;
    private String description;
    private Teacher teacher;
    private Integer studentsCount;
    private int price;
    private float pricePerHour;
    private List<Student> students;
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

    @Column(name = "duration")
    public int getDuration() {
        return duration;
    }

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type", columnDefinition = "enum")
    public CourseType getType() {
        return type;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Teacher getTeacher() {
        return teacher;
    }

    @Column(name = "students_count")
    public Integer getStudentsCount() {
        return studentsCount;
    }

    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    @Column(name = "price_per_hour")
    public float getPricePerHour() {
        return pricePerHour;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "subscriptions",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    public List<Student> getStudents() {
        return students;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    @Override
    public String toString() {
        return "Курс:\n\tID: " + id +
                ", название: " + name +
                ", длительность: " + duration +
                ", тип: " + type +
                ", преподаватель: " + teacher.getName() +
                ", цена: " + price;
    }
}
