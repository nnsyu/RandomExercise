package com.ewoo.luck8estjh.activities;

import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ewoo.luck8estjh.R;
import com.ewoo.luck8estjh.adapter.ListExerciseAdapter;
import com.ewoo.luck8estjh.db.MainDB;
import com.ewoo.luck8estjh.model.Exercise;

import java.util.List;

public class ExerciseListActivity extends Activity {

    private ImageView ivBack;
    private Button btnAdd;
    private RecyclerView rvList;

    private List<Exercise> exerciseList;

    private ListExerciseAdapter adapter;

    private String gymName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        init();

        gymName = getIntent().getStringExtra("gym");

        MainDB mainDB = MainDB.getInstance(this);
        exerciseList = mainDB.exerciseDao().selectExercise(gymName);
        adapter = new ListExerciseAdapter(this, exerciseList);
        rvList.setAdapter(adapter);
    }

    private void init() {
        ivBack = findViewById(R.id.a_list_iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnAdd = findViewById(R.id.a_list_btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                intent.putExtra("gym", gymName);
                startActivityForResult(intent, 1000);
            }
        });

        rvList = findViewById(R.id.a_list_rv_list);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000) {
            if (adapter != null) {
                MainDB mainDB = MainDB.getInstance(this);
                adapter.setList(mainDB.exerciseDao().selectExercise(gymName));
            }
        }
    }
}