package com.example.aspire4739.quizunyil_pa;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aspire4739.quizunyil_pa.kuliner.Soal1Kuliner;
import com.example.aspire4739.quizunyil_pa.pakaian.Soal1Pakaian;
import com.example.aspire4739.quizunyil_pa.rumah.Soal1Rumah;
import com.example.aspire4739.quizunyil_pa.sejarah.Soal1Sejarah;
import com.example.aspire4739.quizunyil_pa.tarian.Soal1Tarian;
import com.example.aspire4739.quizunyil_pa.tempat.Soal1Tempat;

public class SoalActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    String halaman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        if (getIntent().getStringExtra("gambar") != null){
            halaman = getIntent().getStringExtra("gambar");
            cariSoal(halaman);
        }

    }

    void cariSoal(String tujuan){

        if (tujuan.equals( String.valueOf(R.drawable.pakaian_adat))){
            Soal1Pakaian newfragment = new Soal1Pakaian();
            fragmentTransaction.add(R.id.uc, newfragment);
        }else if (tujuan.equals( String.valueOf(R.drawable.rumah_adat))){
            Soal1Rumah newfragment = new Soal1Rumah();
            fragmentTransaction.add(R.id.uc, newfragment);
        }else if (tujuan.equals(String.valueOf(R.drawable.tarian))){
            Soal1Tarian newfragment = new Soal1Tarian();
            fragmentTransaction.add(R.id.uc, newfragment);
        }else if (tujuan.equals(String.valueOf(R.drawable.kuliner))){
            Soal1Kuliner newfragment = new Soal1Kuliner();
            fragmentTransaction.add(R.id.uc, newfragment);
        }else if (tujuan.equals(String.valueOf(R.drawable.button_sejarah))){
            Soal1Sejarah newfragment = new Soal1Sejarah();
            fragmentTransaction.add(R.id.uc, newfragment);
        }else if (tujuan.equals(String.valueOf(R.drawable.button_tempat))){
            Soal1Tempat newfragment = new Soal1Tempat();
            fragmentTransaction.add(R.id.uc, newfragment);
        }


        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
