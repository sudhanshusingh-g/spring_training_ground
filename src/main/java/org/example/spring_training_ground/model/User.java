package org.example.spring_training_ground.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "user_name")
   private String name;
    @Column(name = "user_job_role")
   private String jobRole;
    @Column(name = "user_age")
   private int age;

    public User() {
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jobRole='" + jobRole + '\'' +
                ", age=" + age +
                '}';
    }

    public User(int id, String name, String jobRole, int age) {
        this.id=id;
        this.name = name;
        this.jobRole = jobRole;
        this.age = age;
    }
}
