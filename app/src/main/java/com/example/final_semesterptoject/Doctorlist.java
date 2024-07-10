package com.example.final_semesterptoject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Doctorlist extends AppCompatActivity {

    private RecyclerView doctorRecyclerView;
    private DoctorAdapter doctorAdapter;
    private List<Doctor> doctorList;
    Button z, m;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorlist);

        doctorRecyclerView = findViewById(R.id.doctorRecyclerView);
        doctorRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        doctorList = new ArrayList<>();
        // Dummy data
        doctorList.add(new Doctor("William J Nugent, MD", "Family Medicine", "I love helping people and I love working with families.", R.drawable.doctor1));
        doctorList.add(new Doctor("Erika M Ellis, MD", "Psychiatry", "This allows me to give people peace in mind.", R.drawable.doctor2));
        doctorList.add(new Doctor("Saleem Chouhan, MD", "Cardiology", "This allows me to give people peace in mind.", R.drawable.doctor1));
        doctorList.add(new Doctor("Irfan, MD", "General Physician", "This allows me to give people peace in mind.", R.drawable.doctor2));
        doctorList.add(new Doctor("Ahmed, MD", "E.N.T", "This allows me to give people peace in mind.", R.drawable.doctor1));
        doctorList.add(new Doctor("Imran, MD", "Psychiatry", "This allows me to give people peace in mind.", R.drawable.doctor2));
        // Add more dummy data as needed

        doctorAdapter = new DoctorAdapter(doctorList);
        doctorRecyclerView.setAdapter(doctorAdapter);

        z = findViewById(R.id.zoomLinkButton);
        m = findViewById(R.id.messageButton);

        z.setOnClickListener(this::zoom);
        m.setOnClickListener(this::message);
    }

    // Function to open the Zoom website using an implicit intent
    public void zoom(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://zoom.us"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    // Function to open Gmail using an implicit intent
    public void message(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("https://mail.google.com/mail"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private class Doctor {
        String name, specialty, quote;
        int imageResId;

        Doctor(String name, String specialty, String quote, int imageResId) {
            this.name = name;
            this.specialty = specialty;
            this.quote = quote;
            this.imageResId = imageResId;
        }
    }

    private class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder> {
        List<Doctor> doctorList;

        DoctorAdapter(List<Doctor> doctorList) {
            this.doctorList = doctorList;
        }

        @Override
        public DoctorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctor, parent, false);
            return new DoctorViewHolder(view);
        }

        @Override
        public void onBindViewHolder(DoctorViewHolder holder, int position) {
            Doctor doctor = doctorList.get(position);
            holder.doctorName.setText(doctor.name);
            holder.doctorSpecialty.setText(doctor.specialty);
            holder.doctorQuote.setText(doctor.quote);
            holder.doctorImage.setImageResource(doctor.imageResId);

            holder.zoomLinkButton.setOnClickListener(Doctorlist.this::zoom);
            holder.messageButton.setOnClickListener(Doctorlist.this::message);
        }

        @Override
        public int getItemCount() {
            return doctorList.size();
        }

        class DoctorViewHolder extends RecyclerView.ViewHolder {
            TextView doctorName, doctorSpecialty, doctorQuote;
            ImageView doctorImage;
            Button zoomLinkButton, messageButton;

            DoctorViewHolder(View itemView) {
                super(itemView);
                doctorName = itemView.findViewById(R.id.doctorName);
                doctorSpecialty = itemView.findViewById(R.id.doctorSpecialty);
                doctorQuote = itemView.findViewById(R.id.doctorQuote);
                doctorImage = itemView.findViewById(R.id.doctorImage);
                zoomLinkButton = itemView.findViewById(R.id.zoomLinkButton);
                messageButton = itemView.findViewById(R.id.messageButton);
            }
        }
    }
}
