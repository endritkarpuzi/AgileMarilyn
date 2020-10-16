package com.example.greentipsalpha1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.greentipsalpha1.R;

public class DatabaseActivity extends AppCompatActivity{

    DatabaseHelper myDb;
    EditText editTip;
    Button btnAddData;
    Button btnViewAll;
    Button btnViewUpdate;

    String text_category;
    String text_id;
    ArrayAdapter<CharSequence> adapter_id;

    String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        Spinner spinner_category = findViewById(R.id.spinner_category);
        final Spinner spinner_id = findViewById(R.id.spinner_id);

        final Spinner spinner_language = findViewById(R.id.spinner_lan);

        ArrayAdapter<CharSequence> adapter_lan = ArrayAdapter.createFromResource(this, R.array.lan_spinner, android.R.layout.simple_spinner_item);
        adapter_lan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_language.setAdapter(adapter_lan);

        ArrayAdapter<CharSequence> adapter_category = ArrayAdapter.createFromResource(this, R.array.categories_spinner, android.R.layout.simple_spinner_item);
        adapter_category.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_category.setAdapter(adapter_category);

        spinner_language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    language = "Engelska";
                }
                if(position == 1){
                    language = "Svenska";
                }
                if(position == 2){
                    language = "Spanska";
                }
                if(position == 3){
                    language = "Franska";
                }
                if(position == 4){
                    language = "Arabiska";
                }
                if(position == 5){
                    language = "Syrianska";
                }
                if(position == 6){
                    language = "Polska";
                }
                if(position == 7){
                    language = "Albanska";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                language = null;
            }
        });

        spinner_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    adapter_id = ArrayAdapter.createFromResource (getApplicationContext(), R.array.id_transport, android.R.layout.simple_spinner_item);
                }
                if(position == 1){
                    adapter_id = ArrayAdapter.createFromResource (getApplicationContext(), R.array.id_outdoors, android.R.layout.simple_spinner_item);
                }
                if(position == 2){
                    adapter_id = ArrayAdapter.createFromResource (getApplicationContext(), R.array.id_social_life, android.R.layout.simple_spinner_item);
                }
                if(position == 3){
                    adapter_id = ArrayAdapter.createFromResource (getApplicationContext(), R.array.id_work_life, android.R.layout.simple_spinner_item);
                }
                if(position == 4){
                    adapter_id = ArrayAdapter.createFromResource (getApplicationContext(), R.array.id_household, android.R.layout.simple_spinner_item);
                }

                spinner_id.setAdapter(adapter_id);

                text_category = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                adapter_id = null;
            }
        });

        spinner_id.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text_id = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        myDb = new DatabaseHelper(this);


        editTip = findViewById(R.id.textInput_Tip);

        btnAddData = findViewById(R.id.button_add);
        btnViewAll = findViewById(R.id.button_database);
        btnViewUpdate = findViewById(R.id.button_update);

        addData();
        viewAll();
        updateData();
    }

    public void updateData(){
        btnViewUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = myDb.updateData(
                        text_id,
                        text_category,
                        editTip.getText().toString(),
                        language);

                if(isUpdate == true){
                    Toast.makeText(DatabaseActivity.this, "Data updated", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(DatabaseActivity.this, "Data NOT updated", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void addData(){
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(
                        text_id,
                        text_category,
                        editTip.getText().toString(),
                        language);

                if(isInserted == true){
                    Toast.makeText(DatabaseActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(DatabaseActivity.this, "Data NOT inserted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void viewAll(){
        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();

                if(res.getCount() == 0){
                    //show message
                    showMessage("Error","Nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();

                while(res.moveToNext()){
                    buffer.append("Id :" +  res.getString(0) + "\n");
                    buffer.append("Category :" +  res.getString(1) + "\n");
                    buffer.append("Tip (English):" +  res.getString(2) + "\n");
                    buffer.append("Tip (Swedish):" +  res.getString(3) + "\n");
                    buffer.append("Tip (Spanish):" +  res.getString(4) + "\n");
                    buffer.append("Tip (French):" +  res.getString(5) + "\n");
                    buffer.append("Tip (Arabic):" +  res.getString(6) + "\n");
                    buffer.append("Tip (Syriac):" +  res.getString(7) + "\n");
                    buffer.append("Tip (Polish):" +  res.getString(8) + "\n");
                    buffer.append("Tip (Albanian):" +  res.getString(9) + "\n\n");
                }

                //Show all data
                showMessage("Data", buffer.toString());
            }
        });
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}