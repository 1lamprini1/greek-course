package com.example.lamprini.greek01.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * @author Lamprini Georgatsou
 */


@Dao
public interface DictEntryDao {

    // Select all entries.
    @Query("SELECT * FROM Entry")
    List<DictEntry> getEntries();

    // TODO: Test this.
    // Select all entries starting with letter.
    @Query("SELECT * FROM Entry WHERE word LIKE :letter + '%'")
    List<DictEntry> getEntries(String letter);

    // Select one entry.
    @Query("SELECT * FROM Entry WHERE word LIKE :word")
    DictEntry getEntry(String word);

    @Insert
    void insertEntry(DictEntry entry);

    @Insert
    void insertEntries(DictEntry... entries);

    @Delete
    void deleteEntry(DictEntry entry);

    @Delete
    void deleteEntries(DictEntry... entries);

}
