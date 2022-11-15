package com.example.theorysubmission3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {

    ImageView imgContact;
    TextView tvName,tvPhone,tvDescription;

    private String name,phone,description;
    private int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        imgContact = findViewById(R.id.detail_img_contact);
        tvName = findViewById(R.id.detail_tv_contact);
        tvPhone = findViewById(R.id.detail_tv_number);
        tvDescription = findViewById(R.id.detail_tv_description);

        if (getData()) {
            setData();
        }
    }



    private boolean getData() {
        if (getIntent().hasExtra("Name") && getIntent().hasExtra("Phone") && getIntent().hasExtra("Description")) {
            name = getIntent().getStringExtra("Name");
            phone = getIntent().getStringExtra("Phone");
            description = getIntent().getStringExtra("Description");
            img = getIntent().getIntExtra("Image", 1);
            return true;
        }
        Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        return false;

    }

    private void setData() {
        imgContact.setImageResource(img);
        tvName.setText(name);
        tvPhone.setText(phone);
        tvDescription.setText(description);
    }

}