package com.ewoo.luck8estjh.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ewoo.luck8estjh.R;
import com.ewoo.luck8estjh.db.MainDB;

public class CountActivity extends AppCompatActivity {

    private EditText etCount;
    private Button btnStart;

    private int exCount;

    private String gymName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        gymName = getIntent().getStringExtra("gym");

        MainDB mainDB = MainDB.getInstance(this);
        exCount = mainDB.exerciseDao().selectExerciseCount(gymName);

        etCount = findViewById(R.id.a_count_et_count);
        etCount.setText(Integer.toString(exCount));

        btnStart = findViewById(R.id.a_count_btn_start);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etCount.getText().toString().isEmpty()) {
                    Toast.makeText(CountActivity.this, "운동 개수를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(etCount.getText().toString()) > exCount ) {
                    Toast.makeText(CountActivity.this, "최대 운동 개수를 초과했습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), ExerciseActivity.class);
                    intent.putExtra("gym", gymName);
                    intent.putExtra("idx", Integer.parseInt(etCount.getText().toString()));
                    startActivity(intent);
                }


            }
        });
    }
}