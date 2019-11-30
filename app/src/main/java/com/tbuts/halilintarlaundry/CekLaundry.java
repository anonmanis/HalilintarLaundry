package com.tbuts.halilintarlaundry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class CekLaundry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_laundry);
        SharedPreferences mSettings = getSharedPreferences("HasilDaftar", Context.MODE_PRIVATE);

        String id = mSettings.getString("iddaftar", "missing");
        TextView TextViewID = findViewById(R.id.tvIDHasil2);
        TextViewID.setText(id);

        String nama = mSettings.getString("nama", "missing");
        TextView TextViewNama = findViewById(R.id.tvNamaHasil2);
        TextViewNama.setText(nama);

        String alamat = mSettings.getString("alamat", "missing");
        TextView TextViewAlamat = findViewById(R.id.tvAlamatHasil2);
        TextViewAlamat.setText(alamat);

        String jns = mSettings.getString("jnslaundry", "missing");
        TextView TextViewJenis = findViewById(R.id.tvJenisHasil2);
        TextViewJenis.setText(jns);

        String berat = mSettings.getString("berat", "missing");
        TextView TextViewBerat = findViewById(R.id.tviBeratHasil2);
        TextViewBerat.setText(berat);

        String deliv = mSettings.getString("deliv", "missing");
        TextView TextViewDeliv = findViewById(R.id.tvDelivHasil2);
        TextViewDeliv.setText(deliv);

        String harga = mSettings.getString("harga", "missing");
        TextView TextViewHarga = findViewById(R.id.tvHargaHasil2);
        TextViewHarga.setText(harga);
    }
}
