/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
@Entity
public class Hour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String name;

    @OneToMany
    List<Lesson> lessons;

    @OneToMany
    List<Teacher> teachers;

    @OneToMany
    List<ClassRoom> classRooms;

    @ManyToOne
    School school;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ":" + super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<ClassRoom> getClassRooms() {
        return classRooms;
    }

    public void setClassRooms(List<ClassRoom> classRooms) {
        this.classRooms = classRooms;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            throw new RuntimeException("Hour olmayan nesne eşleşemez!");
        }
        Hour hour = (Hour) o;
        return hour.getSchool().getId() == school.getId()
                && hour.getName().equals(getName()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return 12424244; //To change body of generated methods, choose Tools | Templates.
    }

}
