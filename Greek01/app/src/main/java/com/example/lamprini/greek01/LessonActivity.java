package com.example.lamprini.greek01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lamprini.greek01.db.Lesson;

public class LessonActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        Intent intent = getIntent();
        Lesson lesson = (Lesson) intent.getSerializableExtra("lesson");

        TextView titleView = findViewById(R.id.lesson_title);
        titleView.setText(lesson.getTitle());

        TextView textView = findViewById(R.id.lesson_text);
        textView.setText(lesson.getText());

    }



}
