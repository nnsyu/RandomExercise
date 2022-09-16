package com.ewoo.luck8estjh.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Gym {
    @PrimaryKey(autoGenerate = true)
    private int seq;
    private String gymName;

    public Gym() {
    }

    public Gym(int seq, String gymName) {
        this.seq = seq;
        this.gymName = gymName;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }
}
