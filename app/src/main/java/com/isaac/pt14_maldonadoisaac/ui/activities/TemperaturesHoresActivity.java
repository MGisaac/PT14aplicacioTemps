package com.isaac.pt14_maldonadoisaac.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.isaac.pt14_maldonadoisaac.R;
import com.isaac.pt14_maldonadoisaac.model.Bloc;
import com.isaac.pt14_maldonadoisaac.ui.adapters.CiutatAdapter;

import java.util.ArrayList;
import java.util.List;


public class TemperaturesHoresActivity extends AppCompatActivity {

    private static final String EXTRA_CIUTAT = "ciutat";

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CiutatAdapter ciutatAdapter;


    public static Intent buildIntent(Context context, String ciutat) {
        Intent intent = new Intent(context, TemperaturesHoresActivity.class);
        intent.putExtra(EXTRA_CIUTAT, ciutat);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatures_hores);

        initRecyclerView();
        peticioTemperatura();
    }

    private void peticioTemperatura() {
        String ciutat = getIntent().getStringExtra(EXTRA_CIUTAT);

        List<Bloc> blocList = new ArrayList<>();
        Bloc bloc;
        for (int i = 0; i < 4; i++) {
            bloc = new Bloc();
            bloc.setFredcalor(true);
            bloc.setHora("hora:" + i);
            bloc.setTemperatura(i + "");
            blocList.add(bloc);
        }

        for (Bloc b : blocList) {
            Log.e("ass", "b: " + b.getHora());
        }

        ciutatAdapter = new CiutatAdapter(blocList);
        recyclerView.setAdapter(ciutatAdapter);
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                this, layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }


}
