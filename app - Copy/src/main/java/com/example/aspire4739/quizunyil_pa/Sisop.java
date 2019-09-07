package com.example.aspire4739.quizunyil_pa;

import static android.R.attr.type;

/**
 * Created by Aspire 4739 on 07/11/2017.
 */

public class Sisop {
    public int gambar;

    public Sisop(int gambar)
    {
        this.gambar= gambar;
    }

    public String toString()
    {
        return type + " " + String.valueOf(gambar);
    }
}


