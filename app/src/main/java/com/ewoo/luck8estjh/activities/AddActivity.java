package com.ewoo.luck8estjh.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ewoo.luck8estjh.R;
import com.ewoo.luck8estjh.db.MainDB;
import com.ewoo.luck8estjh.model.Exercise;

public class AddActivity extends AppCompatActivity {

    private ImageView ivBack;
    private EditText etExName, etMinCount, etMaxCount, etMinSet, etMaxSet;
    private Button btnFinish;

    private String gymName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        gymName = getIntent().getStringExtra("gym");

        init();

        InputMethodManager manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                etExName.requestFocus();
                manager.showSoftInput(etExName, InputMethodManager.SHOW_IMPLICIT);
            }
        }, 300);


    }

    private void init() {
        ivBack = findViewById(R.id.a_add_iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        etExName = findViewById(R.id.a_add_et_name);
        etMinCount = findViewById(R.id.a_add_et_min_count);
        etMaxCount = findViewById(R.id.a_add_et_max_count);
        etMinSet = findViewById(R.id.a_add_et_min_set);
        etMaxSet = findViewById(R.id.a_add_et_max_set);

        btnFinish = findViewById(R.id.a_add_btn_finish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strExName = etExName.getText().toString();
                String strMinCount = etMinCount.getText().toString();
                String strMaxCount = etMaxCount.getText().toString();
                String strMinSet = etMinSet.getText().toString();
                String strMaxSet = etMaxSet.getText().toString();

                if (strExName.isEmpty() ||
                        strMinCount.isEmpty() ||
                        strMaxCount.isEmpty() ||
                        strMinSet.isEmpty() ||
                        strMaxSet.isEmpty()) {
                    Toast.makeText(AddActivity.this, "값을 전부 입력하여 주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    Exercise exercise = new Exercise();
                    exercise.setGymName(gymName);
                    exercise.setExName(strExName);
                    exercise.setMinCount(Integer.parseInt(strMinCount));
                    exercise.setMaxCount(Integer.parseInt(strMaxCount));
                    exercise.setMinSet(Integer.parseInt(strMinSet));
                    exercise.setMaxSet(Integer.parseInt(strMaxSet));

                    MainDB mainDB = MainDB.getInstance(AddActivity.this);
                    mainDB.exerciseDao().insertExercise(exercise);

                    setResult(1000);
                    finish();
                }


            }
        });
    }
}