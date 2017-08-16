package com.example.lab1orig;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.x;
import static android.R.id.list;
import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity {

    ArrayList<Orders> order = new ArrayList<Orders>();

    private Button submit;
    private EditText first;
    private EditText last;
    private Spinner ChocolateType;
    private RadioGroup shippingGroup;
    private RadioButton normal;
    private RadioButton expedited;
    private RadioButton shipMethod;
    private EditText numberofBars;
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
        first = (EditText) findViewById(R.id.editFirst);
        last = (EditText) findViewById(R.id.editLast);
        ChocolateType = (Spinner) findViewById(R.id.spinner);
        shippingGroup = (RadioGroup) findViewById(R.id.rgShipping);
        normal = (RadioButton) findViewById(R.id.radioNormal);
        expedited = (RadioButton) findViewById(R.id.radioExpedited);
        numberofBars = (EditText) findViewById(R.id.editNumberofbars);
        result = (TextView) findViewById(R.id.txtResult);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Orders newOrder = new Orders();

                newOrder.setFirst(first.getText().toString());
                newOrder.setLast(last.getText().toString());
                newOrder.setTypeofChocolate(ChocolateType.getSelectedItem().toString());
                newOrder.setNumberofBars(Integer.parseInt(numberofBars.getText().toString()));

                int shippingType = shippingGroup.getCheckedRadioButtonId();
                shipMethod = (RadioButton)findViewById(shippingType);
                if(shipMethod.getText().equals("Normal Shipment")){
                    newOrder.setShippingType(true);
                }
                else{
                    newOrder.setShippingType(false);
                }

                order.add(newOrder);
                result.setText("Order added, there are now " + order.size() + " orders.");
            }
        });
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

        if (id == R.id.action_new){
            first.setText("");
            last.setText("");
            ChocolateType.setSelection(0, true);
            numberofBars.setText("");
            shippingGroup.clearCheck();
        }

        if (id == R.id.doubleOrder){
            int doubleValue = Integer.parseInt(numberofBars.getText().toString());
            doubleValue = doubleValue * 2;
            numberofBars.setText(Integer.toString(doubleValue));
        }

        if(id == R.id.firstOrder){
            Orders firstOrder = order.get(0);
            first.setText(order.get(0).getFirst());
            last.setText(order.get(0).getLast());
            ArrayAdapter<String> adapter = (ArrayAdapter<String>)ChocolateType.getAdapter();
            int selectedChocolate = adapter.getPosition(firstOrder.getTypeofChocolate());
            ChocolateType.setSelection(selectedChocolate);
            int position = adapter.getPosition(order.get(0).getTypeofChocolate());
            ChocolateType.setSelection(position);
            //ChocolateType.set order.get(0).getTypeofChocolate();
            numberofBars.setText(Integer.toString(order.get(0).getNumberofBars()));
            Boolean type = order.get(0).getShippingType();
            if(type){
                expedited.setChecked(false);
                normal.setChecked(true);
            }
            else {
                normal.setChecked(false);
                expedited.setChecked(true);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
