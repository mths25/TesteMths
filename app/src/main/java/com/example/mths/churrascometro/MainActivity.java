package com.example.mths.churrascometro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar sbMan, sbWoman, sbKids;
    TextView tvMen, tvWoman, tvKid, outputMeat, outputSalsage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbMan = (SeekBar) findViewById(R.id.seekBarMen);
        sbWoman = (SeekBar) findViewById(R.id.seekBarWomen);
        sbKids = (SeekBar) findViewById(R.id.seekBarKid);
        tvMen = (TextView) findViewById(R.id.textViewMan);
        tvWoman = (TextView) findViewById(R.id.textViewWomen);
        tvKid = (TextView) findViewById(R.id.textViewKid);

        sbMan.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvMen.setText(String.valueOf(progress));
                calculate(progress, sbWoman.getProgress(), sbKids.getProgress());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        sbWoman.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvWoman.setText(String.valueOf(progress));
                calculate(progress, sbMan.getProgress(), sbKids.getProgress());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        sbKids.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvKid.setText(String.valueOf(progress));
                calculate(progress, sbMan.getProgress(), sbWoman.getProgress());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
        public void calculate(int men , int womem, int kid){
            int sausage, meat;
            float resultSalsage,resultMeat;

            outputMeat=(TextView)findViewById(R.id.Meat);
            outputSalsage=(TextView)findViewById(R.id.Salsage);

            sausage= men*450 + womem*250 + kid*200;
            resultSalsage=(float) sausage/1000;

            meat= men*500 + womem*300 + kid*200;
            resultMeat=(float) meat/1000;

            outputSalsage.setText(String.valueOf(resultSalsage));
            outputMeat.setText(String.valueOf(resultMeat));
        }
    }

