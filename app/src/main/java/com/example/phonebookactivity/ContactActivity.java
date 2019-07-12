package com.example.phonebookactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.Serializable;
import com.bumptech.glide.Glide;


public class ContactActivity extends AppCompatActivity {
    TextView tvName, tvSDT;
    ImageView imgIcon;
    Contact contact= new Contact();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        tvName = findViewById(R.id.tvName);
        tvSDT = findViewById(R.id.tvSDT);
        imgIcon = findViewById(R.id.imgIcon);
        Intent intent = getIntent();
        contact= (Contact) intent.getSerializableExtra("contact");
        String name = intent.getStringExtra("name");
        String sdt = intent.getStringExtra("sdt");
        String img = intent.getStringExtra("img");
        if (contact.getImg().equals("1")) {
            Glide.with(this).load(R.mipmap.home).centerCrop().into(imgIcon);
        } else if (contact.getImg().equals("2")) {
            Glide.with(this).load(R.mipmap.friendship).centerCrop().into(imgIcon);
        } else if (contact.getImg().equals("3")) {
            Glide.with(this).load(R.mipmap.work).centerCrop().into(imgIcon);
        } else {
            Glide.with(this).load(R.mipmap.ic_launcher).centerCrop().into(imgIcon);
        }
        tvName.setText(contact.getName());
        tvSDT.setText(contact.getSdt());
    }
}
