package com.example.aspire4739.quizunyil_pa;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import java.util.ArrayList;

public class FragmentKategori extends Fragment {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    public static final Integer[] gambar_os = {R.drawable.kuliner, R.drawable.tarian,
            R.drawable.pakaian_adat, R.drawable.rumah_adat, R.drawable.button_sejarah,
            R.drawable.button_tempat};

    ArrayList<Sisop> listOs = new ArrayList<Sisop>();

    public FragmentKategori() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kategori, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
        fragmentManager = getActivity().getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        for (int i = 0; i < gambar_os.length; i++) {
            Sisop item = new Sisop(gambar_os[i]);
            listOs.add(item);
        }

        RecyclerView mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.recyclerview);
        CustomAdapter mAdapter = new CustomAdapter(getActivity(), listOs);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
