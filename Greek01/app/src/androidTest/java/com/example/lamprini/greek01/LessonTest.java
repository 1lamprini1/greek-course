package com.example.lamprini.greek01;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.util.Log;

import com.example.lamprini.greek01.db.Lesson;
import com.example.lamprini.greek01.db.LessonDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Lamprini Georgatsou
 */

public class LessonTest {

    private static final String TAG = "LessonDbTest";

    private LessonDatabase db;

    @Before
    public void initDb() {

        db = Room
                .inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), LessonDatabase.class)
                .build();

    }

    @After
    public void closeDb() { db.close(); }

    @Test
    public void insertAndGetLesson() {

        // Create a lesson.
        Lesson l1 = new Lesson("Lesson 1", "Lesson 1\n-Good morning!\n-Good morning!");

        // Insert it.
        db.lessonDao().insert(l1);

        // Retrieve it.
        Lesson lesson = db.lessonDao().getLesson(1);
        assertEquals(l1.getLessonId(), lesson.getLessonId());
        assertEquals(l1.getText(), lesson.getText());
        Log.d(TAG, "insertAndGetLesson: OK");

    }

    @Test
    public void insertAndDeleteLesson() {

        // Create a lesson.
        Lesson l1 = new Lesson("Lesson 1", "Lesson 1\nDatabases, databases, databases.");

        // Insert.
        db.lessonDao().insert(l1);

        // Delete.
        db.lessonDao().delete(l1);

        Lesson l2 = db.lessonDao().getLesson(1);
        assertNull(l2);
        Log.d(TAG, "insertAndDeleteLesson: OK");

    }

}
