package com.thkrue.cert.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "alphabet")
public class MyEntity {

    @PrimaryKey
    @ColumnInfo(name = "character")
    @NonNull
    private String character;


    public MyEntity(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return character;
    }
}
