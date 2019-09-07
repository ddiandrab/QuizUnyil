package com.example.aspire4739.quizunyil_pa;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.Button;
import android.widget.ImageView;


public class FragmentMenu extends Fragment {

    private View.OnClickListener click;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    public FragmentMenu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedState){
        super.onActivityCreated(savedState);

        ImageView iv_main = (ImageView) getActivity().findViewById(R.id.main);

        fragmentManager = getActivity().getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        click = new View.OnClickListener(){
            @Override
            public void onClick(View v){

                FragmentKategori fk = new FragmentKategori();

                fragmentTransaction.replace(R.id.layout_frag, fk);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        };

        iv_main.setOnClickListener(click);
    }
}
