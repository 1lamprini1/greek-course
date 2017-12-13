package com.example.lamprini.greek01.db;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author Lamprini Georgatsou
 */

public class DatabaseAccessor {

    private final LessonDatabase db;

    public DatabaseAccessor(Context context) { db = LessonDatabase.getDbInstance(context); }

    public void createLessons(String... strings) throws ExecutionException, InterruptedException {

        CreateLessonsTask create = new CreateLessonsTask(db);
        create.execute(strings).get();

    }

    public Lesson getLesson(String... strings) throws ExecutionException, InterruptedException {

        GetLessonsTask get = new GetLessonsTask(db);
        return get.execute(strings).get()[0];

    }

    public void clear() throws ExecutionException, InterruptedException {

        ClearLessonsTask clear = new ClearLessonsTask(db);
        clear.execute().get();

    }

    public void close() {

        db.close();
        LessonDatabase.destroyDbInstance();

    }

    private static class CreateLessonsTask extends AsyncTask<String, Void, Void> {

        private final LessonDatabase db;

        private CreateLessonsTask(LessonDatabase db) { this.db = db; }

        @Override
        protected Void doInBackground(String... strings) {

            int count = strings.length;
            for (int i = 0; i < count; i++)
                db.lessonDao().insert(new Lesson(strings[i], "ένα τεστ."));

            return null;

        }

    }

    private class GetLessonsTask extends AsyncTask<String, Void, Lesson[]> {

        private final LessonDatabase db;

        private GetLessonsTask(LessonDatabase db) { this.db = db; }

        @Override
        protected Lesson[] doInBackground(String... strings) {

            int count = strings.length;
            Lesson[] result = new Lesson[count];
            for (int i = 0; i < count; i++)
                result[i] = db.lessonDao().getLesson(strings[i]);

            return result;

        }

    }

    private class ClearLessonsTask extends AsyncTask<Void, Void, Void> {

        private final LessonDatabase db;

        private ClearLessonsTask(LessonDatabase db) { this.db = db; }

        @Override
        protected Void doInBackground(Void... voids) {

            List<Lesson> lessons = db.lessonDao().getAll();
            db.lessonDao().deleteLessons(lessons);

            return null;
        }
    }

}
