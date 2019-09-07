package com.example.aspire4739.quizunyil_pa;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aspire4739.quizunyil_pa.rumah.Soal2;


public class FragmentScore extends Fragment {

    private View.OnClickListener click;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private ImageView backHome;
    private ImageView backMain;
    private TextView scoreTxt;
    public FragmentScore() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_score, container, false);
        fragmentManager = getActivity().getFragmentManager();
        fragmentTransaction= fragmentManager.beginTransaction();
        backHome = rootView.findViewById(R.id.pic_btnbacktohome);
        backMain = rootView.findViewById(R.id.pic_btnmain_lagi);
        scoreTxt = rootView.findViewById(R.id.scoreTxt);
        String strtext = getArguments().getString("score");
        scoreTxt.setText(strtext);
        click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pilihan bnr
                if (v == v.findViewById(R.id.pic_btnbacktohome)){
                    startActivity(new Intent(getActivity(),MainActivity.class));
                }else {
                    FragmentKategori nextFragment = new FragmentKategori();
                    fragmentTransaction.replace(R.id.uc, nextFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        };
        backMain.setOnClickListener(click);
        backHome.setOnClickListener(click);
        return rootView;
    }

}
