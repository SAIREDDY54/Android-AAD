package com.thkrue.cert.room;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {MyEntity.class}, version = 1)
public abstract class MyRoomDb extends RoomDatabase {

    public abstract MyEntityDao entityDao();

    private static MyRoomDb INSTANCE;

    static MyRoomDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyRoomDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MyRoomDb.class, "Entity.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}