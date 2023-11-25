package com.elpros.autoskola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.maintxt);

        Button nxt = findViewById(R.id.next);
        CheckBox a = findViewById(R.id.A);
        CheckBox b = findViewById(R.id.B);
        CheckBox c = findViewById(R.id.C);
        CheckBox d = findViewById(R.id.D);
        TextView qtxt = findViewById(R.id.qTxt);
        ImageView img = findViewById(R.id.qImg);
        TextView qpr = findViewById(R.id.prgInd);
        ProgressBar prg = findViewById(R.id.progressBar);

        final int[] q = {1}; //pitanje na kojem se nalazi polagac
        final int[] cpts = {0}; //broj bodova
        final int[] sq = {0}; //izabrano pitanje
        final boolean[] fi = {false}; //je li polagac pogrjesio pitanje raskrizja

        String[] qR = {"0", "1", "2", "3", "4"}; //tekst obicnog pitanja
        String[] qI = {"0I", "1I", "2I", "3I", "4I"}; //tekst pitanja raskrizja
        String[][] qRAt = {{"a", "b", "c",}, {"a", "b"}, {"a", "b", "c", "d",}, {"a", "b", "c", "d",}, {"a", "b", "c", "d",}}; //ponudjeni odgovori obicnog pitanja
        String[][] qIAt = {{"a", "b", "c",}, {"a", "b"}, {"a", "b", "c", "d",}, {"a", "b", "c", "d",}, {"a", "b", "c", "d",}}; //ponudjeni odgovori pitanja raskrizja
        boolean[][] qRA = {{false, false, false}, {false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false},}; //tocni odgovori obicnog pitanja
        boolean[][] qIA = {{false, false, false}, {false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false},}; //tocni odgovori pitanja raskrizja

        final int minq = 0;
        final int maxq = 4; //broj obicnih pitanja -1
        final int maxqi = 4; //broj pitanja raskrizja -1

        sq[0] = new Random().nextInt((maxq - minq) + 1) + minq;
        qtxt.setText(qR[sq[0]]);
        qpr.setText(q[0] + "/38");
        prg.setProgress(q[0] * 100 / 38);
        a.setChecked(false);
        b.setChecked(false);
        c.setChecked(false);
        d.setChecked(false);
        switch (qRA[sq[0]].length) {
            case 2:
                d.setVisibility(View.INVISIBLE);
                c.setVisibility(View.INVISIBLE);
                a.setText(qRAt[sq[0]][0]);
                b.setText(qRAt[sq[0]][1]);
                break;
            case 3:
                d.setVisibility(View.INVISIBLE);
                c.setVisibility(View.VISIBLE);
                a.setText(qRAt[sq[0]][0]);
                b.setText(qRAt[sq[0]][1]);
                c.setText(qRAt[sq[0]][2]);
                break;
            case 4:
                d.setVisibility(View.VISIBLE);
                c.setVisibility(View.VISIBLE);
                a.setText(qRAt[sq[0]][0]);
                b.setText(qRAt[sq[0]][1]);
                c.setText(qRAt[sq[0]][2]);
                d.setText(qRAt[sq[0]][3]);
                break;
        }

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (q[0]==23){
                    switch (qRA[sq[0]].length) {
                        case 2:
                            if (a.isChecked() == qRA[sq[0]][0] && b.isChecked() == qRA[sq[0]][1]) {
                                cpts[0]++;
                            }
                            break;
                        case 3:
                            if (a.isChecked() == qRA[sq[0]][0] && b.isChecked() == qRA[sq[0]][1] && c.isChecked() == qRA[sq[0]][2]) {
                                cpts[0]++;
                            }
                            break;
                        case 4:
                            if (a.isChecked() == qRA[sq[0]][0] && b.isChecked() == qRA[sq[0]][1] && c.isChecked() == qRA[sq[0]][2] && d.isChecked() == qRA[sq[0]][3]) {
                                cpts[0]++;
                            }
                            break;
                    }
                    q[0]++;
                    sq[0] = new Random().nextInt((maxqi - minq) + 1) + minq;
                    qtxt.setText(qI[sq[0]]);
                    qpr.setText(q[0] + "/38");
                    prg.setProgress(q[0] * 100 / 38);
                    a.setChecked(false);
                    b.setChecked(false);
                    c.setChecked(false);
                    d.setChecked(false);
                    switch (qIA[sq[0]].length) {
                        case 2:
                            d.setVisibility(View.INVISIBLE);
                            c.setVisibility(View.INVISIBLE);
                            a.setText(qIAt[sq[0]][0]);
                            b.setText(qIAt[sq[0]][1]);
                            break;
                        case 3:
                            d.setVisibility(View.INVISIBLE);
                            c.setVisibility(View.VISIBLE);
                            a.setText(qIAt[sq[0]][0]);
                            b.setText(qIAt[sq[0]][1]);
                            c.setText(qIAt[sq[0]][2]);
                            break;
                        case 4:
                            d.setVisibility(View.VISIBLE);
                            c.setVisibility(View.VISIBLE);
                            a.setText(qIAt[sq[0]][0]);
                            b.setText(qIAt[sq[0]][1]);
                            c.setText(qIAt[sq[0]][2]);
                            d.setText(qIAt[sq[0]][3]);
                            break;
                    }
                }
                else if (q[0]>=24 && q[0]<27){
                    switch (qIA[sq[0]].length) {
                        case 2:
                            if (a.isChecked() == qIA[sq[0]][0] && b.isChecked() == qIA[sq[0]][1]) {
                                cpts[0]++;
                            }
                            else{
                                fi[0]=true;
                            }
                            break;
                        case 3:
                            if (a.isChecked() == qIA[sq[0]][0] && b.isChecked() == qIA[sq[0]][1] && c.isChecked() == qIA[sq[0]][2]) {
                                cpts[0]++;
                            }
                            else{
                                fi[0]=true;
                            }
                            break;
                        case 4:
                            if (a.isChecked() == qIA[sq[0]][0] && b.isChecked() == qIA[sq[0]][1] && c.isChecked() == qIA[sq[0]][2] && d.isChecked() == qIA[sq[0]][3]) {
                                cpts[0]++;
                            }
                            else{
                                fi[0]=true;
                            }
                            break;
                    }
                    q[0]++;
                    sq[0] = new Random().nextInt((maxqi - minq) + 1) + minq;
                    qtxt.setText(qI[sq[0]]);
                    qpr.setText(q[0] + "/38");
                    prg.setProgress(q[0] * 100 / 38);
                    a.setChecked(false);
                    b.setChecked(false);
                    c.setChecked(false);
                    d.setChecked(false);
                    switch (qIA[sq[0]].length) {
                        case 2:
                            d.setVisibility(View.INVISIBLE);
                            c.setVisibility(View.INVISIBLE);
                            a.setText(qIAt[sq[0]][0]);
                            b.setText(qIAt[sq[0]][1]);
                            break;
                        case 3:
                            d.setVisibility(View.INVISIBLE);
                            c.setVisibility(View.VISIBLE);
                            a.setText(qIAt[sq[0]][0]);
                            b.setText(qIAt[sq[0]][1]);
                            c.setText(qIAt[sq[0]][2]);
                            break;
                        case 4:
                            d.setVisibility(View.VISIBLE);
                            c.setVisibility(View.VISIBLE);
                            a.setText(qIAt[sq[0]][0]);
                            b.setText(qIAt[sq[0]][1]);
                            c.setText(qIAt[sq[0]][2]);
                            d.setText(qIAt[sq[0]][3]);
                            break;
                    }
                }
                else if (q[0]==27){
                    switch (qIA[sq[0]].length) {
                        case 2:
                            if (a.isChecked() == qIA[sq[0]][0] && b.isChecked() == qIA[sq[0]][1]) {
                                cpts[0]++;
                            }
                            else{
                                fi[0]=true;
                            }
                            break;
                        case 3:
                            if (a.isChecked() == qIA[sq[0]][0] && b.isChecked() == qIA[sq[0]][1] && c.isChecked() == qIA[sq[0]][2]) {
                                cpts[0]++;
                            }
                            else{
                                fi[0]=true;
                            }
                            break;
                        case 4:
                            if (a.isChecked() == qIA[sq[0]][0] && b.isChecked() == qIA[sq[0]][1] && c.isChecked() == qIA[sq[0]][2] && d.isChecked() == qIA[sq[0]][3]) {
                                cpts[0]++;
                            }
                            else{
                                fi[0]=true;
                            }
                            break;
                    }
                    q[0]++;
                    sq[0] = new Random().nextInt((maxq - minq) + 1) + minq;
                    qtxt.setText(qR[sq[0]]);
                    qpr.setText(q[0] + "/38");
                    prg.setProgress(q[0] * 100 / 38);
                    a.setChecked(false);
                    b.setChecked(false);
                    c.setChecked(false);
                    d.setChecked(false);
                    switch (qRA[sq[0]].length) {
                        case 2:
                            d.setVisibility(View.INVISIBLE);
                            c.setVisibility(View.INVISIBLE);
                            a.setText(qRAt[sq[0]][0]);
                            b.setText(qRAt[sq[0]][1]);
                            break;
                        case 3:
                            d.setVisibility(View.INVISIBLE);
                            c.setVisibility(View.VISIBLE);
                            a.setText(qRAt[sq[0]][0]);
                            b.setText(qRAt[sq[0]][1]);
                            c.setText(qRAt[sq[0]][2]);
                            break;
                        case 4:
                            d.setVisibility(View.VISIBLE);
                            c.setVisibility(View.VISIBLE);
                            a.setText(qRAt[sq[0]][0]);
                            b.setText(qRAt[sq[0]][1]);
                            c.setText(qRAt[sq[0]][2]);
                            d.setText(qRAt[sq[0]][3]);
                            break;
                    }
                }
                else if (q[0] < 38) {
                    switch (qRA[sq[0]].length) {
                        case 2:
                            if (a.isChecked() == qRA[sq[0]][0] && b.isChecked() == qRA[sq[0]][1]) {
                                cpts[0]++;
                            }
                            break;
                        case 3:
                            if (a.isChecked() == qRA[sq[0]][0] && b.isChecked() == qRA[sq[0]][1] && c.isChecked() == qRA[sq[0]][2]) {
                                cpts[0]++;
                            }
                            break;
                        case 4:
                            if (a.isChecked() == qRA[sq[0]][0] && b.isChecked() == qRA[sq[0]][1] && c.isChecked() == qRA[sq[0]][2] && d.isChecked() == qRA[sq[0]][3]) {
                                cpts[0]++;
                            }
                            break;
                    }
                    q[0]++;
                    sq[0] = new Random().nextInt((maxq - minq) + 1) + minq;
                    qtxt.setText(qR[sq[0]]);
                    qpr.setText(q[0] + "/38");
                    prg.setProgress(q[0] * 100 / 38);
                    a.setChecked(false);
                    b.setChecked(false);
                    c.setChecked(false);
                    d.setChecked(false);
                    switch (qRA[sq[0]].length) {
                        case 2:
                            d.setVisibility(View.INVISIBLE);
                            c.setVisibility(View.INVISIBLE);
                            a.setText(qRAt[sq[0]][0]);
                            b.setText(qRAt[sq[0]][1]);
                            break;
                        case 3:
                            d.setVisibility(View.INVISIBLE);
                            c.setVisibility(View.VISIBLE);
                            a.setText(qRAt[sq[0]][0]);
                            b.setText(qRAt[sq[0]][1]);
                            c.setText(qRAt[sq[0]][2]);
                            break;
                        case 4:
                            d.setVisibility(View.VISIBLE);
                            c.setVisibility(View.VISIBLE);
                            a.setText(qRAt[sq[0]][0]);
                            b.setText(qRAt[sq[0]][1]);
                            c.setText(qRAt[sq[0]][2]);
                            d.setText(qRAt[sq[0]][3]);
                            break;
                    }
                }
                else if (q[0] == 38) {
                    switch (qRA[sq[0]].length) {
                        case 2:
                            if (a.isChecked() == qRA[sq[0]][0] && b.isChecked() == qRA[sq[0]][1]) {
                                cpts[0]++;
                            }
                            break;
                        case 3:
                            if (a.isChecked() == qRA[sq[0]][0] && b.isChecked() == qRA[sq[0]][1] && c.isChecked() == qRA[sq[0]][2]) {
                                cpts[0]++;
                            }
                            break;
                        case 4:
                            if (a.isChecked() == qRA[sq[0]][0] && b.isChecked() == qRA[sq[0]][1] && c.isChecked() == qRA[sq[0]][2] && d.isChecked() == qRA[sq[0]][3]) {
                                cpts[0]++;
                            }
                            break;
                    }
                    d.setVisibility(View.INVISIBLE);
                    c.setVisibility(View.INVISIBLE);
                    b.setVisibility(View.INVISIBLE);
                    a.setVisibility(View.INVISIBLE);
                    if (cpts[0] * 100 / 38 > 90 && !fi[0]) {
                        qtxt.setText("Položili ste! - " + cpts[0] * 100 / 38 + "%");
                    } else if(fi[0]) {
                        qtxt.setText("Pali ste! - Raskrižja krivo rješena - " + cpts[0] * 100 / 38 + "%");
                    } else {
                        qtxt.setText("Pali ste! - " + cpts[0] * 100 / 38 + "%");
                    }
                    q[0]++;
                }
            }

        });
    }
}