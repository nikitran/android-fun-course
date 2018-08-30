package com.example.okidoki.keyboardsamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView phoneNumberView;
    TextView nothingEnteredView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumberView = findViewById(R.id.phone_with_type);
        nothingEnteredView = findViewById(R.id.nothing_enter);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.label_array, android.R.layout.simple_list_item_1);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = findViewById(R.id.label_spinner);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                showText(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void showText(String spinnerLabel) {
        EditText phoneNumber = findViewById(R.id.editText_main);
        String number = phoneNumber.getText().toString();

        if(number.isEmpty()) {
            phoneNumberView.setVisibility(View.GONE);
            nothingEnteredView.setVisibility(View.VISIBLE);
        } else {
            nothingEnteredView.setVisibility(View.GONE);
            findViewById(R.id.nothing_enter).setVisibility(View.GONE);
            phoneNumberView.setVisibility(View.VISIBLE);
            phoneNumberView.setText(number + " - " +spinnerLabel);
        }
    }
}
