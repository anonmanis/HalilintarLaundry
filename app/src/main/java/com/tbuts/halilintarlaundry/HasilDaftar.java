package com.tbuts.halilintarlaundry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HasilDaftar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_daftar);
        SharedPreferences mSettings = getSharedPreferences("HasilDaftar", Context.MODE_PRIVATE);

        String id = mSettings.getString("iddaftar", "missing");
        TextView TextViewID = findViewById(R.id.tvIDHasil);
        TextViewID.setText(id);

        String nama = mSettings.getString("nama", "missing");
        TextView TextViewNama = findViewById(R.id.tvNamaHasil);
        TextViewNama.setText(nama);

        String alamat = mSettings.getString("alamat", "missing");
        TextView TextViewAlamat = findViewById(R.id.tvAlamatHasil);
        TextViewAlamat.setText(alamat);

        String jns = mSettings.getString("jnslaundry", "missing");
        TextView TextViewJenis = findViewById(R.id.tvJenisHasil);
        TextViewJenis.setText(jns);

        String berat = mSettings.getString("berat", "missing");
        TextView TextViewBerat = findViewById(R.id.tviBeratHasil);
        TextViewBerat.setText(berat);

        String deliv = mSettings.getString("deliv", "missing");
        TextView TextViewDeliv = findViewById(R.id.tvDelivHasil);
        TextViewDeliv.setText(deliv);

        String harga = mSettings.getString("harga", "missing");
        TextView TextViewHarga = findViewById(R.id.tvHargaHasil);
        TextViewHarga.setText(harga);

    }
    public void backHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
