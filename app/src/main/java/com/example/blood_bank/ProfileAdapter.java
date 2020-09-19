package com.example.blood_bank;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {

    private Context mCtx;
    private List<Profile> profileList;

    public ProfileAdapter(Context mCtx, List<Profile> profileList) {
        this.mCtx = mCtx;
        this.profileList = profileList;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProfileViewHolder(
                LayoutInflater.from(mCtx).inflate(R.layout.activity_profile_adapter, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull final ProfileViewHolder holder, final int position) {
        Profile profile = profileList.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                Toast.makeText(holder.itemView.getContext(),""+position,Toast.LENGTH_SHORT).show();
            }


        });

        holder.text_name.setText(profile.getName());
        holder.text_blood.setText(profile.getBlood());
        holder.text_phone.setText(profile.getPhone());
        holder.text_district.setText(profile.getDistrict());
        holder.text_division.setText(profile.getDivision());
        holder.text_address.setText(profile.getFull_address());



    }


    @Override
    public int getItemCount() {
        return profileList.size();
    }

    class ProfileViewHolder extends RecyclerView.ViewHolder {

        TextView text_name, text_blood, text_phone, text_district, text_division,text_address;

        public ProfileViewHolder(View itemView) {
            super(itemView);


            text_name = itemView.findViewById(R.id.text_name);
            text_blood = itemView.findViewById(R.id.text_blood);
            text_phone = itemView.findViewById(R.id.text_phone);
            text_district = itemView.findViewById(R.id.text_district);
            text_division = itemView.findViewById(R.id.text_division);
            text_address = itemView.findViewById(R.id.text_address);

        }
    }



}