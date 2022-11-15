package com.example.theorysubmission3;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    String name[],phone[],description[];
    int img[];
    Context context;

    public ContactAdapter(Context ct,int[] dataImg, String[] dataName, String[] dataPhone, String[] dataDescription) {
        context = ct;
        img = dataImg;
        name = dataName;
        phone = dataPhone;
        description = dataDescription;
    }

    @NonNull
    @Override
    public ContactAdapter.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.contact_item,parent,false);

        return new ContactViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactViewHolder holder, int position) {
        holder.tvName.setText(name[position]);
        holder.tvPhone.setText(phone[position]);
        holder.imgView.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        TextView tvName, tvPhone;
        ImageView imgView;
        ContactAdapter contactAdapter;

        public ContactViewHolder(@NonNull View itemView, ContactAdapter contactAdapter) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_contact_name);
            tvPhone = itemView.findViewById(R.id.tv_contact_number);
            imgView = itemView.findViewById(R.id.img_contact_picture);
            //contactLayout = itemView.findViewById(R.id.contact_layout);
            this.contactAdapter = contactAdapter;
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            Intent intent = new Intent(context,ContactActivity.class);
            intent.putExtra("Name",name[mPosition]);
            intent.putExtra("Phone",phone[mPosition]);
            intent.putExtra("Description",description[mPosition]);
            intent.putExtra("Image",img[mPosition]);
            context.startActivity(intent);
        }

        @Override
        public boolean onLongClick(View v) {
            int mPosition = getLayoutPosition();
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" +phone[mPosition]));
            context.startActivity(callIntent);
            Toast.makeText(context, "Calling", Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}
