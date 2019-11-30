package com.tbuts.halilintarlaundry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void daftar(View view) {
        Intent intent = new Intent(MainActivity.this, DaftarLaundry.class);
        startActivity(intent);
    }

    public void cekLaundry(View view) {
        Intent intent = new Intent(MainActivity.this, CekLaundry.class);
        startActivity(intent);
    }
}
