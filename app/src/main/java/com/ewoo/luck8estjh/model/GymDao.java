package com.ewoo.luck8estjh.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GymDao {

    @Insert
    void insertGym(Gym gym);

    @Query("SELECT * FROM Gym ORDER BY seq DESC")
    List<Gym> selectGym();

    @Query("DELETE FROM Gym WHERE gymName = :gymName")
    void deleteGym(String gymName);

}
