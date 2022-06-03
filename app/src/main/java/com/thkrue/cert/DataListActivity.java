package com.thkrue.cert;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.thkrue.cert.room.MyEntity;
import com.thkrue.cert.room.MyEntityViewModel;

import java.util.UUID;

public class DataListActivity extends AppCompatActivity {

    private MyEntityViewModel myEntityVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);

        myEntityVM = ViewModelProviders.of(this).get(MyEntityViewModel.class);

        RecyclerView recycler = findViewById(R.id.rv_list);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setHasFixedSize(true);
        final MyListAdapter adapter = new MyListAdapter(new DiffUtil.ItemCallback<MyEntity>() {
            @Override
            public boolean areItemsTheSame(@NonNull MyEntity entity, @NonNull MyEntity t1) {
                return entity.equals(t1);
            }

            @Override
            public boolean areContentsTheSame(@NonNull MyEntity entity, @NonNull MyEntity t1) {
                return entity.equals(t1);
            }
        });
        recycler.setAdapter(adapter);
        setupViewModel(adapter);
        initFab();
    }

    private void initFab() {
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myEntityVM.insert(new MyEntity(UUID.randomUUID().toString().substring(0, 8)));
            }
        });
    }

    private void setupViewModel(final MyListAdapter adapter) {
        myEntityVM.getAllEntities().observe(this, new Observer<PagedList<MyEntity>>() {
            @Override
            public void onChanged(@Nullable final PagedList<MyEntity> entities) {
                adapter.submitList(entities);
//                adapter.setData(entities);
            }
        });
    }
}