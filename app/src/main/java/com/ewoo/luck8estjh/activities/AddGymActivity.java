package com.ewoo.luck8estjh.activities;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ewoo.luck8estjh.R;
import com.ewoo.luck8estjh.db.MainDB;
import com.ewoo.luck8estjh.model.Gym;

public class AddGymActivity extends AppCompatActivity {

    private ImageView ivBack;
    private EditText etGymName;
    private Button btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gym);

        init();

        InputMethodManager manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                etGymName.requestFocus();
                manager.showSoftInput(etGymName, InputMethodManager.SHOW_IMPLICIT);
            }
        }, 300);


    }

    private void init() {
        ivBack = findViewById(R.id.a_add_gym_iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        etGymName = findViewById(R.id.a_add_gym_et_name);

        btnFinish = findViewById(R.id.a_add_gym_btn_finish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strExName = etGymName.getText().toString();

                if (strExName.isEmpty()) {
                    Toast.makeText(AddGymActivity.this, "헬스장 이름을 입력해 주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    Gym gym = new Gym();
                    gym.setGymName(strExName);

                    MainDB mainDB = MainDB.getInstance(AddGymActivity.this);
                    mainDB.gymDao().insertGym(gym);

                    setResult(2000);
                    finish();
                }


            }
        });
    }
}