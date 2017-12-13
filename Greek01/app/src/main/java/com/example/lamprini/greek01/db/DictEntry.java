package com.example.lamprini.greek01.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * @author Lamprini Georgatsou
 */

@Entity(tableName = "Entry")
public class DictEntry {

    @PrimaryKey
    @NonNull
    private String word;

    private String definition;

    public DictEntry(String word) { this.word = word; }

    public String getWord() { return word; }

    public void setWord(String word) { this.word = word; }

    public String getDefinition() { return definition; }

    public void setDefinition(String definition) { this.definition = definition; }

}
