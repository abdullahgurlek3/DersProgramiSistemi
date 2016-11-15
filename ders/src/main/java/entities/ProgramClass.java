/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
@Entity
public class ProgramClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    ProgramClassRoom programClassRoom;

    @OneToOne
    Class class1;

    public void setClass1(Class class1) {
        this.class1 = class1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProgramClassRoom getProgramClassRoom() {
        return programClassRoom;
    }

    public void setProgramClassRoom(ProgramClassRoom programClassRoom) {
        this.programClassRoom = programClassRoom;
    }

}
