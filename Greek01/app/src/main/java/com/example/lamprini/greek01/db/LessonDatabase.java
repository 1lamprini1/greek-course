package com.example.lamprini.greek01.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
/**
 * @author Lamprini Georgatsou
 */

// Increment version number every time this changes, to migrate the data.
@Database(entities = {Lesson.class, DictEntry.class}, exportSchema = false, version = 1)
public abstract class LessonDatabase extends RoomDatabase {

    private static LessonDatabase instance;

    public abstract LessonDao lessonDao();

    public abstract DictEntryDao dictDao();

    public static LessonDatabase getDbInstance(Context context) {

        if (instance == null)
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    LessonDatabase.class, "Lessons.db")
                    .build();

        return instance;

    }

    public static void destroyDbInstance() { instance = null; }

}
