package com.a710company.bateryindicador;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

     private AdView mAdView;

    TextView bateria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        bateria = (TextView) (findViewById(R.id.txtbateria));


        cargaBateria();

    }

    public int cargaBateria ()
    {
        try
        {
            IntentFilter batIntentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
            Intent battery = this.registerReceiver(null, batIntentFilter);
            int nivelBateria = battery.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);

            bateria.setText(String.valueOf(nivelBateria)+"%");


            return nivelBateria;

        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),
                    "Error al obtener estado de la batería",
                    Toast.LENGTH_SHORT).show();
            return 0;
        }


    }
}