package com.example.phonebookactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnAdd;
    EditText edFind;
    StringBuilder textFind = new StringBuilder();
    ListView lvContact, lvFind;
    static ArrayList<Contact> mlistContacts = new ArrayList<>();
    Adapter adapter;

    private static final String TAG = "MainActivity";

    public final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setData();
        btnAdd = findViewById(R.id.btnAdd);
        edFind = findViewById(R.id.edTimkiem);
        lvContact = findViewById(R.id.lvDanhba);
        lvFind = findViewById(R.id.lvFind);
        lvFind.setVisibility(View.GONE);
        adapter = new Adapter(mlistContacts, this);
        lvContact.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        lvContact.setVisibility(View.VISIBLE);
        Log.d(TAG, "onCreate: " + mlistContacts.size());
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getBaseContext(), ContactActivity.class);
                Contact contact = mlistContacts.get(i);
                intent.putExtra("contact",contact);
                intent.putExtra("name", contact.getName());
                intent.putExtra("sdt", contact.getSdt());
                intent.putExtra("img", contact.getImg());
                startActivity(intent);


            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Add_contact.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        edFind.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);

            }


            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(getBaseContext(), "" + edFind.getText().toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        ActionBar sc = getSupportActionBar();
        sc.hide();

    }


    public void setData() {
        for (int i = 1; i < 20; i++) {
            Contact contact = new Contact();
            contact.setName("LOL" + i);
            contact.setSdt("1232211");
            if (i % 3 == 0) {
                contact.setImg("1");
            } else {
                contact.setImg("2");
            }
            mlistContacts.add(contact);
        }
    }

    Contact newContact = new Contact();

    public void addNewContact() {
        Intent intent = getIntent();
        newContact = (Contact) intent.getSerializableExtra("contact");
        mlistContacts.add(newContact);
//        adapter = new Adapter(mlistContacts, this);
//        lvContact.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: " + mlistContacts.size());
        super.onResume();
        if (getIntent().getExtras() != null) {
            addNewContact();
        }

    }
    //    @Override
//    protected void onResume() {
//        super.onResume();
//        Intent intent;
//        adapter.notifyDataSetChanged();
//        if ((intent = getIntent()) != null) {
//            newContact = (Contact) intent.getSerializableExtra("contact");
//            mlistContacts.add(newContact);
//
//        }
//        if (edFind.getText().toString() == null || "".equalsIgnoreCase(edFind.getText().toString())) {
//
//        } else {
//            adapter = new Adapter(mlistTimKiem, this);
//            adapter.notifyDataSetChanged();
//            lvContact.setAdapter(adapter);
//        }
//
//    }

    static ArrayList<Contact> mlistTimKiem = new ArrayList<>();

//    public void findName(String name) {
//        for (int i = 0; i < mlistTimKiem.size(); i++) {
//            mlistTimKiem.remove(i);
//        }
//        for (Contact contact : mlistContacts) {
//            if (contact.getName().contains(name)) {
//                mlistTimKiem.add(contact);
//            }
//        }
//    }
}
