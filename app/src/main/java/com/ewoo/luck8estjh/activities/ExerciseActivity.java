package com.ewoo.luck8estjh.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ewoo.luck8estjh.R;
import com.ewoo.luck8estjh.adapter.ExerciseAdapter;
import com.ewoo.luck8estjh.db.MainDB;
import com.ewoo.luck8estjh.model.Exercise;

import java.util.List;

public class ExerciseActivity extends AppCompatActivity {

    private ImageView ivBack;
    private RecyclerView rvList;
    private Button btnFinish;

    private ExerciseAdapter adapter;
    private List<Exercise> exerciseList;

    private String gymName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        int idx = getIntent().getIntExtra("idx", 0);
        gymName = getIntent().getStringExtra("gym");

        MainDB mainDB = MainDB.getInstance(this);

        ivBack = findViewById(R.id.a_exercise_iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        rvList = findViewById(R.id.a_exercise_rv_list);
        btnFinish = findViewById(R.id.a_exercise_btn_finish);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        exerciseList = mainDB.exerciseDao().selectRandomExercise(gymName, idx);
        adapter = new ExerciseAdapter(this, exerciseList);
        rvList.setAdapter(adapter);
    }
}