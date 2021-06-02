package com.example.royallifeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class choosingPlace extends AppCompatActivity {
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing_place);
        txt = (TextView) findViewById(R.id.txtChoosingNo);
        txt = (TextView) findViewById(R.id.txtChoosingNo);
        draw();
    }

    private void draw() {
        switch (mmeennuu.choosingNo) {
            case 1:
                txt.setText("1");
                break;
            case 2:
                txt.setText("2");
                break;
            case 3:
                txt.setText("3");
                break;
            case 4:
                txt.setText("4");
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mmeennuu.choosingNo = 0;
    }
}
