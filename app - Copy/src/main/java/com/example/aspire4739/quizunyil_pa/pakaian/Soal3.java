package com.example.aspire4739.quizunyil_pa.pakaian;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.aspire4739.quizunyil_pa.FragmentScore;
import com.example.aspire4739.quizunyil_pa.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by administrator on 13/12/17.
 */

public class Soal3 extends Fragment {
    private View.OnClickListener click;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Button a;
    private Button b;
    private Button c;
    private Button d;
    private TextView soal;
    private TextView waktu;

    int hitungTimer=5;
    boolean habis = false, klik=false;
    View answer;
    Timer timer=new Timer();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_soal, container, false);
        a = rootView.findViewById(R.id.pic_btna);
        b = rootView.findViewById(R.id.pic_btnb);
        c = rootView.findViewById(R.id.pic_btnc);
        d = rootView.findViewById(R.id.pic_btnd);
        waktu = rootView.findViewById(R.id.waktu);
        soal = rootView.findViewById(R.id.soal);
        //edit soal
        soal.setText("Pakaian Adat Baju Cele berasal dari daerah …");
        a.setText("a. Kalimantan Barat");
        b.setText("b. Gorontalo");
        c.setText("c. Papua Barat");
        d.setText("d. Maluku");
        fragmentManager = getActivity().getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable(){
                    @Override
                    public void run(){
                        hitungTimer--;
                        waktu.setText("Sisa Waktu :"+hitungTimer);
                        if(hitungTimer==0)
                        {
                            habis = true;
                            timer.cancel();
                            pindah();
                        }
                    }
                });
            }
        }, 0, 1000);
        click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                klik = true;
                timer.cancel();
                answer = v;
                pindah();
            }
        };
        a.setOnClickListener(click);
        b.setOnClickListener(click);
        c.setOnClickListener(click);
        d.setOnClickListener(click);
        return rootView;
    }

    public void pindah() {
        if (habis == true || klik == true) {
            Soal4 nextFragment = new Soal4();
            Bundle bundle = new Bundle();

            //pilihan bnr
            if (answer == d) {
                String strtext = getArguments().getString("score");
                int scorenya = Integer.parseInt(strtext) + 20;
                bundle.putString("score", String.valueOf(scorenya));
            } else {
                String strtext = getArguments().getString("score");
                int scorenya = Integer.parseInt(strtext) ;
                bundle.putString("score", String.valueOf(scorenya));
            }
            nextFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.uc, nextFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}