package com.example.phonebookactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Add_contact extends AppCompatActivity {
    Button btnCancel;
    Button btnSave;
    Spinner spPhoneType;
    ArrayList<String> phoneType;
    EditText etName, etPhone;
    public static final String NEW_CONTACT = "new_contact";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        btnCancel = findViewById(R.id.btnCancel);
        btnSave = findViewById(R.id.btnSave);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        spPhoneType = findViewById(R.id.spPhoneType);
        phoneType = new ArrayList<>();
        phoneType.add("Home");
        phoneType.add("Friend");
        phoneType.add("Partner");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getBaseContext(),
                android.R.layout.simple_list_item_1, phoneType);
        spPhoneType.setAdapter(arrayAdapter);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                Contact contact = new Contact();
                contact.setName(etName.getText().toString());
                contact.setImg((spPhoneType.getSelectedItemId() + 1) + "");
                contact.setSdt(etPhone.getText().toString());
                intent.putExtra("contact",contact);
                startActivity(intent);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void addListenerOnSpinerItemSelection() {
        spPhoneType = findViewById(R.id.spPhoneType);
        spPhoneType.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

}
