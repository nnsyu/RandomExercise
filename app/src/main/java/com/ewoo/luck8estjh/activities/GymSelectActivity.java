package com.ewoo.luck8estjh.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.ewoo.luck8estjh.R;
import com.ewoo.luck8estjh.adapter.GymSelectAdapter;
import com.ewoo.luck8estjh.adapter.ListGymAdapter;
import com.ewoo.luck8estjh.db.MainDB;
import com.ewoo.luck8estjh.model.Gym;

import java.util.List;

public class GymSelectActivity extends Activity {

    private ImageView ivBack;
    private Button btnAdd;
    private RecyclerView rvList;

    private List<Gym> gymList;

    private GymSelectAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_list);

        init();

        MainDB mainDB = MainDB.getInstance(this);
        gymList = mainDB.gymDao().selectGym();
        adapter = new GymSelectAdapter(this, gymList);
        rvList.setAdapter(adapter);
    }

    private void init() {
        ivBack = findViewById(R.id.a_gym_list_iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnAdd = findViewById(R.id.a_gym_list_btn_add);
        btnAdd.setVisibility(View.GONE);

        rvList = findViewById(R.id.a_gym_list_rv_list);
    }
}