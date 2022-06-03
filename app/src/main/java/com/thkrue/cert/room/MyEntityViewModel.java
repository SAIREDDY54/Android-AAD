package com.thkrue.cert.room;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

public class MyEntityViewModel extends AndroidViewModel {

    private MyEntityRepository mRepo;

    public MyEntityViewModel(Application a) {
        super(a);
        mRepo = new MyEntityRepository(a.getApplicationContext());
    }

    public LiveData<PagedList<MyEntity>> getAllEntities() {
        return mRepo.getData();
    }

    public void insert(MyEntity entity) {
        mRepo.insert(entity);
    }
}