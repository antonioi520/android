package com.example.anton.lab1f;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;

import static android.R.attr.data;


import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    static ArrayList<Orders> CandyOrder = new ArrayList<Orders>();
    private Button back;
    private ListView lvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button back = (Button) findViewById(R.id.btnBack);
        ListView lvResults = (ListView) findViewById(R.id.lvResults);

        Bundle extras = getIntent().getExtras();

        Orders order = extras.getParcelable("chocolateOrder");
        CandyOrder.add(order);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        for(int x = 0; x < CandyOrder.size(); x++){
            adapter.add(CandyOrder.get(x).getFirst() + " " + CandyOrder.get(x).getLast() + ": " + CandyOrder.get(x).getTypeofChocolate());
        }
        lvResults.setAdapter(adapter);


        back.setOnClickListener(backOnClickListener);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
    }
    private View.OnClickListener backOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };


    @Override
    public void finish(){
        Intent intent = new Intent();
        int data = CandyOrder.size();
        String dataString = Integer.toString(data);
        intent.putExtra("numberOfOrders", dataString);
        setResult(RESULT_OK,intent);
        super.finish();
    }





}
