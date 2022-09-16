package com.ewoo.luck8estjh.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ExerciseDao {

    @Insert
    void insertExercise(Exercise exercise);

    @Query("SELECT * FROM Exercise WHERE gymName = :gymName ORDER BY seq DESC")
    List<Exercise> selectExercise(String gymName);

    @Query("SELECT * FROM Exercise WHERE gymName = :gymName ORDER BY RANDOM() LIMIT :idx")
    List<Exercise> selectRandomExercise(String gymName, int idx);

    @Query("SELECT COUNT(seq) FROM Exercise WHERE gymName = :gymName")
    int selectExerciseCount(String gymName);

    @Query("DELETE FROM Exercise WHERE exName = :exName")
    void deleteExercise(String exName);

    @Query("DELETE FROM Exercise WHERE gymName = :gymName")
    void deleteExerciseByGym(String gymName);
}
