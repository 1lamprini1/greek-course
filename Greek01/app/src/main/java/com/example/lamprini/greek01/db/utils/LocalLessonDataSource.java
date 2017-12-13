package com.example.lamprini.greek01.db.utils;

import android.support.annotation.VisibleForTesting;

import java.util.List;

import com.example.lamprini.greek01.db.DictEntry;
import com.example.lamprini.greek01.db.DictEntryDao;
import com.example.lamprini.greek01.db.Lesson;
import com.example.lamprini.greek01.db.LessonDao;

/**
 * @author Lamprini Georgatsou
 */

public class LocalLessonDataSource {

    private final LessonDao lessonDao;

    private final DictEntryDao dictDao;

    @VisibleForTesting
    public LocalLessonDataSource(LessonDao lessonDao, DictEntryDao dictDao) {

        this.lessonDao = lessonDao;
        this.dictDao = dictDao;

    }

    public List<Lesson> getLessons() { return lessonDao.getAll(); }

    public List<DictEntry> getEntries() { return dictDao.getEntries(); }

}
