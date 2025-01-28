package com.edupoly.practice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String fullName;
    public String email;
    public String mobile;
    public String password;
    public String role;
    public int age;
    public String gender;
    public float height;
    public float weight;
    public boolean looseWeight;
    public boolean gainWeight;
    public boolean gainMuscle;
    public boolean calorieBurning;
    public boolean tonedBody;
    public boolean dietControl;


}
