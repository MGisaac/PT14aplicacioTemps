package com.isaac.pt14_maldonadoisaac.ui.activities;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.isaac.pt14_maldonadoisaac.R;

public class PrincipalActivity extends AppCompatActivity {


    TextInputEditText ciutat_et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        initViews();
    }

    private void initViews() {
        ciutat_et=findViewById(R.id.ciutat_et);
    }

    public void onMostraClick(View view) {
        String ciutat = ciutat_et.getText().toString();
        startActivity(TemperaturesHoresActivity.buildIntent(this,ciutat));
    }

}
