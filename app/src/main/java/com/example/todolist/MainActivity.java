package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

//        getSupportActionBar().setTitle(R.string.app_name);

        EditText edtnamapel = findViewById(R.id.namapelanggan);
        EditText edtnamabar = findViewById(R.id.namabarang);
        EditText edtjumlahbel = findViewById(R.id.jumlahbeli);
        EditText edtharga = findViewById(R.id.harga);
        EditText edtuangbay = findViewById(R.id.uangbayar);
        Button btnproses = findViewById(R.id.tombol1);
        Button btnhapus = findViewById(R.id.tombol2);
        Button btnexit = findViewById(R.id.tombol3);
        TextView txtnamapel = findViewById(R.id.namapelanggan);
        TextView txtnamabar = findViewById(R.id.namabarang);
        TextView txtjumlahbel = findViewById(R.id.jumlahbeli);
        TextView txtharga = findViewById(R.id.harga);
        TextView txtuangbay = findViewById(R.id.uangbayar);
        TextView txtbonus = findViewById(R.id.bonus);
        TextView txttotalbelanja = findViewById(R.id.totalbelanja);
        TextView txtuangkembali = findViewById(R.id.uangkembali);
        TextView txtketerangan = findViewById(R.id.keterangan);

        //memberikan action pada tombol proses

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namapelanggan = edtnamapel.getText().toString().trim();
                String namabarang = edtnamabar.getText().toString().trim();
                String jumlahbeli = edtjumlahbel.getText().toString().trim();
                String harga = edtharga.getText().toString().trim();
                String uangbayar = edtuangbay.getText().toString().trim();

                if (!jumlahbeli.matches("[0-9]+") || !harga.matches("[0-9]+")) {
                    return;
                }

                double jb = Double.parseDouble(jumlahbeli);
                double h = Double.parseDouble(harga);
                double ub = Double.parseDouble(uangbayar);
                double total = (jb * h);
                txttotalbelanja.setText("Total Belanja : " + total);

                if (total >=200000){
                    txtbonus.setText("Bonus : Mouse");
                } else if (total >=50000){
                    txtbonus.setText("Bonus : Keyboard");
                } else  if (total >=40000){
                    txtbonus.setText("Bonus : Harddisk");
                } else {
                    txtbonus.setText("Bonus : Tidak Ada Bonus");
                }
                double uangkembalian = (ub - total);

                if (ub < total){
                    txtketerangan.setText("Keterangan : uang bayar kurang Rp " + (-uangkembalian));
                    txtuangkembali.setText("Uang Kembali : Rp 0" );
                }else{
                    txtketerangan.setText("Keterangan : Tunggu Kembalian");
                    txtuangkembali.setText("Uang Kembali : " + uangkembalian);
                }
            }
        });

        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtnamapel.setText(" ");
                txtnamabar.setText(" ");
                txttotalbelanja.setText(" Total Belanja : Rp 0");
                txtharga.setText(" ");
                txtuangbay.setText(" ");
                txtuangkembali.setText("Uang Kembali : Rp 0");
                txtbonus.setText("Bonus : - ");
                txtjumlahbel.setText(" ");
                txtketerangan.setText("Keterangan : - ");

                Toast.makeText(getApplicationContext(),"Data sudah direset", Toast.LENGTH_LONG).show();
            }
        });

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
            }
        });

//        btnhapus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                txtnamapel.setText(" ");
//                txtnamabar.setText(" ");
//                txttotalbelanja.setText(" Total Belanja : Rp 0");
//                txtharga.setText(" ");
//                txtuangbay.setText(" ");
//                txtuangkembali.setText("Uang Kembali : Rp 0");
//                txtbonus.setText("Bonus : - ");
//                txtjumlahbel.setText(" ");
//                txtketerangan.setText("Keterangan : - ");
//
//                Toast.makeText(getApplicationContext(),"Data sudah direset", Toast.LENGTH_LONG).show();
//
//                // memberikan action pada tombol keluar
//            }
//        });
//        btnexit.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//
//                moveTaskToBack(true);
//            }
//        });
    }
}