package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class blocking extends AppCompatActivity {
    EditText panj_rec,jum_rec,ibg,block_fac,data_den,laju_p;
    TextView lama_a, transfer,panjang_p;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocking);


        UIelement();
        UIint();


    }
    private void UIelement() {
        panj_rec=(EditText)findViewById(R.id.panj_rec);
        jum_rec=(EditText)findViewById(R.id.jum_rec);
        ibg=(EditText)findViewById(R.id.ibg);
        block_fac=(EditText)findViewById(R.id.bloc_fac);
        data_den=(EditText)findViewById(R.id.data_den);
        laju_p=(EditText)findViewById(R.id.laju_p);
        lama_a=(TextView)findViewById(R.id.lma);
        transfer=(TextView)findViewById(R.id.trans);
        panjang_p=(TextView)findViewById(R.id.pjg);
        button=(Button)findViewById(R.id.button);


    }
    private void UIint() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            hitungBlock();
            }
        });
    }

    private void hitungBlock() {
        //jika tidak mengisi panjang dan lebar sekaligus maka akan tampil notifikasi
        if(panj_rec.length()==0 && jum_rec.length()==0 && ibg.length()==0 && block_fac.length()==0 && data_den.length()==0 && laju_p.length()==0) {
            Toast.makeText(getApplication(), "Data tidak boleh ada yang Kosong", Toast.LENGTH_LONG).show();
        }else if (panj_rec.length()==0) {
            Toast.makeText(getApplication(), "Panjang Record tidak boleh kosong ", Toast.LENGTH_LONG).show();
        }else if (jum_rec.length()==0) {
            Toast.makeText(getApplication(), "Jumlah Record tidak boleh kososng", Toast.LENGTH_LONG).show();
        }
        else if (ibg.length()==0) {
            Toast.makeText(getApplication(), "IBG tidak boleh kososng", Toast.LENGTH_LONG).show();
        }
        else if (block_fac.length()==0){
            Toast.makeText(getApplication(),"Faktor Block tidak boleh kososng", Toast.LENGTH_LONG).show();}
        else if (data_den.length()==0){
            Toast.makeText(getApplication(),"Data Dencity tidak boleh kososng", Toast.LENGTH_LONG).show();}
        else if (laju_p.length()==0){
            Toast.makeText(getApplication(),"Laju Pita tidak boleh kososng", Toast.LENGTH_LONG).show();}
            else{
            double panjang_rec = Double.parseDouble(panj_rec.getText().toString());
            double jumlah_rec = Double.parseDouble(jum_rec.getText().toString());
            double ibgg = Double.parseDouble(ibg.getText().toString());
            double block_fact = Double.parseDouble(block_fac.getText().toString());
            double data_dentt = Double.parseDouble(data_den.getText().toString());
            double laju_pi = Double.parseDouble(laju_p.getText().toString());

            double panjang = (jumlah_rec / block_fact) * ((block_fact * panjang_rec / data_dentt) + ibgg);
            double lama = panjang / laju_pi;
            double tranferi = (jumlah_rec * panjang_rec) / lama;


            panjang_p.setText("Panjang Pita :" + panjang + "");
            lama_a.setText("Lama Akses :" + lama + "");
            transfer.setText("Transfer rate :" + tranferi + "");
        }
        }

}
