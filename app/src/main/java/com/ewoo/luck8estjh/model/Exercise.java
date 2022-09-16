package com.ewoo.luck8estjh.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Exercise {
    @PrimaryKey(autoGenerate = true)
    private int seq;
    private String gymName;
    private String exName;
    private int minCount;
    private int maxCount;
    private int minSet;
    private int maxSet;

    public Exercise() {
    }

    public Exercise(int seq, String gymName, String exName, int minCount, int maxCount, int minSet, int maxSet) {
        this.seq = seq;
        this.gymName = gymName;
        this.exName = exName;
        this.minCount = minCount;
        this.maxCount = maxCount;
        this.minSet = minSet;
        this.maxSet = maxSet;
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

    public String getExName() {
        return exName;
    }

    public void setExName(String exName) {
        this.exName = exName;
    }

    public int getMinCount() {
        return minCount;
    }

    public void setMinCount(int minCount) {
        this.minCount = minCount;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getMinSet() {
        return minSet;
    }

    public void setMinSet(int minSet) {
        this.minSet = minSet;
    }

    public int getMaxSet() {
        return maxSet;
    }

    public void setMaxSet(int maxSet) {
        this.maxSet = maxSet;
    }
}
