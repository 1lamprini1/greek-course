package com.example.lamprini.greek01.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;
/**
 * @author Lamprini Georgatsou
 */

@Dao
public interface LessonDao {

    @Query("SELECT * FROM Lesson")
    List<Lesson> getAll();

    @Query("SELECT * FROM Lesson WHERE lessonId LIKE :lessonId")
    Lesson getLesson(int lessonId);

    @Query("SELECT * FROM Lesson WHERE title LIKE :title")
    Lesson getLesson(String title);

    @Query("SELECT COUNT(*) FROM Lesson")
    int getNoOfLessons();

    @Insert(onConflict = OnConflictStrategy.ROLLBACK)
    void insert(Lesson lesson);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Lesson... lessons);

    @Delete
    void delete(Lesson lesson);

    @Delete
    void deleteLessons(List<Lesson> lessons);

}
