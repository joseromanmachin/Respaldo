package com.keepsystems.conversordeunidades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.temperatura:
                Toast.makeText(this, "temperatura", Toast.LENGTH_SHORT).show();
            break;
            case R.id.masa:
                Toast.makeText(this, "masa", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
