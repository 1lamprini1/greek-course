package com.example.lamprini.greek01;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.lamprini.greek01.db.DatabaseAccessor;
import com.example.lamprini.greek01.db.Lesson;
import com.example.lamprini.greek01.db.LessonDatabase;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private static DatabaseAccessor db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Test.
        db = new DatabaseAccessor(this);

        try {

            db.clear();
            db.createLessons("Lesson 1", "Lesson2");

        }
        catch (Exception e) { e.printStackTrace(); }

    }

    public void toLessons(View view) {

        Intent intent = new Intent(this, LessonsActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onDestroy() {

        LessonDatabase.destroyDbInstance();
        super.onDestroy();

    }

}
