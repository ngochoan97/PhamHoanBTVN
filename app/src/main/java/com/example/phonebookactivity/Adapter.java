package com.example.phonebookactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    ArrayList<Contact> mlistContacts;
    Context mContext;
    LayoutInflater layoutInflater;

    public Adapter(ArrayList<Contact> mlistContacts, Context context) {
        this.mlistContacts = mlistContacts;
        this.mContext = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public Adapter(ArrayList<Contact> mlistContacts) {

        this.mlistContacts = mlistContacts;
    }

    @Override
    public int getCount() {
        return mlistContacts.size();
    }

    @Override
    public Object getItem(int i) {
        return mlistContacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {

        }
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        mContext = viewGroup.getContext();
        view = inflater.inflate(R.layout.item, viewGroup, false);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvSDT = view.findViewById(R.id.tvSDT);
        ImageView img = view.findViewById(R.id.imgIcon);
        Contact contact = new Contact();
        contact = mlistContacts.get(i);
        tvName.setText(contact.getName());
        tvSDT.setText(contact.getSdt());
        if (contact.getImg() == "1"){
            Glide.with(mContext).load(R.mipmap.home).centerCrop().into(img);
        }else if (contact.getImg() == "2"){
            Glide.with(mContext).load(R.mipmap.friendship).centerCrop().into(img);
        }
        else if(contact.getImg()=="3")
            {
            Glide.with(mContext).load(R.mipmap.work).centerCrop().into(img);
        }else
            {
            Glide.with(mContext).load(R.mipmap.ic_launcher).centerCrop().into(img);
        }

        return view;
    }
}
