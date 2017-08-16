package com.example.anton.lab1f;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.data;
import static android.R.attr.order;
import static android.R.id.list;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 10;
    ArrayList<Orders> order = new ArrayList<Orders>();

    private Button submit;
    private Button getResults;
    private EditText first;
    private EditText last;
    private Spinner ChocolateType;
    private RadioGroup shippingGroup;
    private RadioButton normal;
    private RadioButton expedited;
    private RadioButton shipMethod;
    private EditText numberOfBars;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        Button submit = (Button) findViewById(R.id.btnSubmit);
        Button getResults = (Button) findViewById(R.id.btnResults);
        final EditText first = (EditText) findViewById(R.id.editFirst);
        final EditText last = (EditText) findViewById(R.id.editLast);
        final Spinner ChocolateType = (Spinner) findViewById(R.id.spinner);
        final RadioGroup shippingGroup = (RadioGroup) findViewById(R.id.rgShipping);
        RadioButton normal = (RadioButton) findViewById(R.id.radioNormal);
        RadioButton expedited = (RadioButton) findViewById(R.id.radioExpedited);
        final EditText numberOfBars = (EditText) findViewById(R.id.editNumberofbars);
        result = (TextView) findViewById(R.id.txtResult);


        getResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Orders newOrder = new Orders();

                newOrder.setFirst(first.getText().toString());
                newOrder.setLast(last.getText().toString());
                newOrder.setTypeofChocolate(ChocolateType.getSelectedItem().toString());
                newOrder.setNumberofBars(Integer.parseInt(numberOfBars.getText().toString()));

                int shippingType = shippingGroup.getCheckedRadioButtonId();
                shipMethod = (RadioButton)findViewById(shippingType);
                if(shipMethod.getText().equals("Normal")){
                    newOrder.setShippingType(true);
                }
                else{
                    newOrder.setShippingType(false);
                }

                Intent i = new Intent(v.getContext(), com.example.anton.lab1f.ResultActivity.class);
                i.putExtra("chocolateOrder", newOrder);
                startActivityForResult(i, REQUEST_CODE);
            }
        });
    }
//    public void GoToResults(View view){
//        Orders newOrder = new Orders();
//
//        newOrder.setFirst(first.getText().toString());
//        newOrder.setLast(last.getText().toString());
//        newOrder.setTypeofChocolate(ChocolateType.getSelectedItem().toString());
//        newOrder.setNumberofBars(Integer.parseInt(numberOfBars.getText().toString()));
//
//        int shippingType = shippingGroup.getCheckedRadioButtonId();
//        shipMethod = (RadioButton)findViewById(shippingType);
//        if(shipMethod.getText().equals("Normal")){
//            newOrder.setShippingType(true);
//        }
//        else{
//            newOrder.setShippingType(false);
//        }
//
//        Intent i = new Intent(this, com.example.anton.lab1f.ResultActivity.class);
//        i.putExtra("chocolateOrder", newOrder);
//        startActivityForResult(i, REQUEST_CODE);
//    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        //get data from result activity
       if(resultCode == RESULT_OK && requestCode == REQUEST_CODE){
            if(data.hasExtra("numberOfOrders")){
                String numberOfOrders = data.getExtras().getString("numberOfOrders");
                result.setText(("Number of orders = " + numberOfOrders));
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
