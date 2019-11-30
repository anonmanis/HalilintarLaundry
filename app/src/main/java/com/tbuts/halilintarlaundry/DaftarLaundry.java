package com.tbuts.halilintarlaundry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class DaftarLaundry extends AppCompatActivity {
EditText editTextNama, editTextAlamat, editTextBerat;
TextView textViewID, textViewHarga;
Button buttonDaftar;
Spinner spinJenis;
RadioButton radYa, radNo, rdButton;
RadioGroup rdGroup;
private String[] list={"Baju (5000/KG)", "Selimut (6000/KG)", "Jaket (7000/KG)", "Handuk (6000/kg)"};
ArrayAdapter<String> adapter;
int hasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_laundry);
        editTextNama = findViewById(R.id.etNama);
        editTextAlamat = findViewById(R.id.etAlamat);
        editTextBerat = findViewById(R.id.etBerat);
        textViewID = findViewById(R.id.tvID2);
        spinJenis = findViewById(R.id.spJenis);
        rdGroup = findViewById(R.id.rgDeliv);
        radYa = findViewById(R.id.rbYa);
        radNo = findViewById(R.id.rbTidak);
        buttonDaftar = findViewById(R.id.btnDaftarSekarang);
        textViewHarga = findViewById(R.id.tvTotal);

        textViewID.setText(generateString(10));

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinJenis.setAdapter(adapter);

        sendData();
    }

    private String generateString(int length){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < length; i++){
            char c = chars[random.nextInt(chars.length)];
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public void hitungHarga(View v){
        String satuan = String.valueOf(spinJenis.getSelectedItemPosition());
        int berat = Integer.parseInt(editTextBerat.getText().toString());

        if(satuan.equals("0")){
            hasil = 5000 * berat;
            textViewHarga.setText(String.valueOf(hasil));
        } else if(satuan.equals("0") && radYa.isChecked()){
            hasil = 5000 * berat + 5000;
            textViewHarga.setText(String.valueOf(hasil));
        } else if(satuan.equals("1")){
            hasil = 6000 * berat;
            textViewHarga.setText(String.valueOf(hasil));
        } else if(satuan.equals("1") && radYa.isChecked()) {
            hasil = 6000 * berat + 5000;
            textViewHarga.setText(String.valueOf(hasil));
        } else if(satuan.equals("2")){
            hasil = 7000 * berat;
            textViewHarga.setText(String.valueOf(hasil));
        } else if(satuan.equals("2") && radYa.isChecked()){
            hasil = 7000 * berat + 5000;
            textViewHarga.setText(String.valueOf(hasil));
        } else if(satuan.equals("3")){
            hasil = 6000 * berat;
            textViewHarga.setText(String.valueOf(hasil));
        } else if(satuan.equals("3") && radYa.isChecked()){
            hasil = 6000 * berat + 5000;
            textViewHarga.setText(String.valueOf(hasil));
        }
    }

    public void sendData(){
        buttonDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), HasilDaftar.class);
                SharedPreferences mSettings = getSharedPreferences("HasilDaftar", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = mSettings.edit();

                int selectedId = rdGroup.getCheckedRadioButtonId();
                rdButton = findViewById(selectedId);


                editor.putString("nama", editTextNama.getText().toString());
                editor.putString("alamat", editTextAlamat.getText().toString());
                editor.putString("jnsLaundry", spinJenis.getSelectedItem().toString());
                editor.putString("berat", editTextBerat.getText().toString());
                editor.putString("deliv", rdButton.getText().toString());
                editor.putString("iddaftar", textViewID.getText().toString());
                editor.putString("harga", textViewHarga.getText().toString());

                editor.apply();
                startActivity(intent);
                finish();
            }
        });
    }
}
