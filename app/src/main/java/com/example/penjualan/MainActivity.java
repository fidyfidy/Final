package com.example.penjualan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText edtnamapel, edtid, edtnamabar, edtjumlahbel, edtharga, edtuangbay;
private Button btnproses;
private Button btnhapus;
private Button btnexit;
private TextView txtnamabar;
private TextView txtjumlahbel;
private TextView txtharga;
private TextView txtuangbay;
private TextView txttotalbelanja;
private TextView txtuangkembali;
private TextView txtketerangan;

       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);

           getSupportActionBar().setTitle("PENJUALAN");

           edtnamabar = (EditText) findViewById(R.id.namabarang);
           edtjumlahbel = (EditText) findViewById(R.id.jumlahbeli);
           edtharga = (EditText) findViewById(R.id.harga);
           edtuangbay = (EditText) findViewById(R.id.uangbayar);
           btnproses = (Button) findViewById(R.id.tombol1);
           btnhapus = (Button) findViewById(R.id.tombol2);
           btnexit = (Button) findViewById(R.id.tombol3);
           txtnamabar = (TextView) findViewById(R.id.namabarang);
           txtjumlahbel = (TextView) findViewById(R.id.jumlahbeli);
           txtharga = (TextView) findViewById(R.id.harga);
           txtuangbay = (TextView) findViewById(R.id.uangbayar);
           txttotalbelanja = (TextView) findViewById(R.id.totalbelanja);
           txtuangkembali = (TextView) findViewById(R.id.uangkembali);
           txtketerangan = (TextView) findViewById(R.id.keterangan);

           btnproses.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   String jumlahbeli = edtjumlahbel.getText().toString().trim();
                   String harga = edtharga.getText().toString().trim();
                   String uangbayar = edtuangbay.getText().toString().trim();

                   double jb = Double.parseDouble(jumlahbeli);
                   double h = Double.parseDouble(harga);
                   double ub = Double.parseDouble(uangbayar);
                   double total = (jb * h);
                   txttotalbelanja.setText("Total Belanja : " + total);



                   double uangkembalian = (ub - total);

                   if (ub < total){
                       txtketerangan.setText("Keterangan : uang bayar kurang Rp " + (-uangkembalian));
                       txtuangkembali.setText("Uang Kembali : Rp 0" );
                   }else{
                       txtketerangan.setText("Keterangan : TUNGGU KEMBALIANNYA");
                       txtuangkembali.setText("Uang Kembali : " + uangkembalian);
                   }


               }
           });
           btnhapus.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                  txtnamabar.setText(" ");
                  txttotalbelanja.setText(" Total Belanja : Rp 0");
                  txtharga.setText(" ");
                  txtuangbay.setText(" ");
                  txtuangkembali.setText("Uang Kembali : Rp 0");
                  txtjumlahbel.setText(" ");
                  txtketerangan.setText("Keterangan : - ");

                  Toast.makeText(getApplicationContext(),"data sudah direset", Toast.LENGTH_LONG).show();

              }
          });
          btnexit.setOnClickListener(new View.OnClickListener() {
              public void onClick(View view) {

                  moveTaskToBack(true);
              }
          });
      }
  }