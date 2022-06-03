package com.thkrue.cert.room;

import androidx.paging.DataSource;
import androidx.room.Insert;
import androidx.room.Query;

@androidx.room.Dao
public interface MyEntityDao {

    @Insert()
    void insert(MyEntity... entities);

//    @Query("Select * FROM alphabet")
//    MyEntity[] getEntities();

//    @Query("Select * FROM alphabet where alphabetindex = :alphabetindex LIMIT :limit")
//    MyEntity[] getEntities(int alphabetindex, int limit);

    @Query("SELECT * FROM alphabet")
    DataSource.Factory<Integer, MyEntity> getEntities();
//    LiveData<PagedList<MyEntity>> getEntities();

}
