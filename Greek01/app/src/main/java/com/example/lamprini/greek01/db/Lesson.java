package com.example.lamprini.greek01.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 @author Lamprini Georgatsou
 */

@Entity
public class Lesson implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Integer lessonId;

    private String title;

    private String text;

    // Tell Room not to use this constructor.
    @Ignore
    public Lesson(String title) { this(title, null); }

    public Lesson(String title, String text) {

        this.title = title;
        this.text = text;

    }

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

}
