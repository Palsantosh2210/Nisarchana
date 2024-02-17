package com.example.nisar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class hiringlist extends AppCompatActivity {
TextView textView;
    ImageView Setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiringlist);

        Setting = findViewById(R.id.imageButton2);
        Setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
        textView =findViewById(R.id.engineer);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openActivity1();

            }
        });
        textView =findViewById(R.id.labour);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openActivity3();

            }
        });
    }

    private void openActivity3() {
        Intent intent = new Intent(hiringlist.this, Labour.class);
        startActivity(intent);
    }

    private void openActivity1() {
        Intent intent = new Intent(hiringlist.this, CivilEngineer.class);
        startActivity(intent);
    }

    private void openActivity2() {
        Intent intent = new Intent(hiringlist.this, SettingsActivity.class);
        startActivity(intent);

    }
}