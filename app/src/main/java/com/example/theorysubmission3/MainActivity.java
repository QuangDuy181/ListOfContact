package com.example.theorysubmission3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv;
    ContactAdapter contactAdapter;
    int img[] ={R.drawable.ada_thorne,R.drawable.arthur_shelby,R.drawable.billy_kimber,R.drawable.freddie_gray,
            R.drawable.grace_shelby,R.drawable.john_shelby,R.drawable.lizzy_stark,R.drawable.luca_changretta,
            R.drawable.polly_gray,R.drawable.tommy_shelby};
    String phone[],name[],description[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = getResources().getStringArray(R.array.contact_name);
        phone = getResources().getStringArray(R.array.contact_number);
        description = getResources().getStringArray(R.array.contact_description);

        rcv = findViewById(R.id.rcv);
        contactAdapter = new ContactAdapter(this,img,name,phone,description);
        rcv.setAdapter(contactAdapter);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 0);
            }
        }


}