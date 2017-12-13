package com.example.lamprini.greek01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.lamprini.greek01.db.DatabaseAccessor;
import com.example.lamprini.greek01.db.Lesson;
import com.example.lamprini.greek01.db.LessonDatabase;

import java.util.concurrent.ExecutionException;

public class LessonsActivity extends AppCompatActivity {

    private DatabaseAccessor db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        db = new DatabaseAccessor(this);

    }

    public void toLesson(View view) throws ExecutionException, InterruptedException {

        Intent intent = new Intent(this, LessonActivity.class);
        Lesson lesson;

        switch (view.getId()) {

            case R.id.lesson_1:

                lesson = db.getLesson("Lesson 1");
                break;

            case R.id.lesson_2:

                lesson = db.getLesson("Lesson 2");
                break;

            default: throw new RuntimeException("???");

        }

        intent.putExtra("lesson", lesson);
        startActivity(intent);

    }

    @Override
    protected void onDestroy() {

        LessonDatabase.destroyDbInstance();
        super.onDestroy();

    }

}
