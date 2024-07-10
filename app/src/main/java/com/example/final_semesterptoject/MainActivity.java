package com.example.final_semesterptoject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;

    Button AU , GS , Appointment ,drs;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Set up the toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);


            // video
            VideoView videoView1 = findViewById(R.id.videoView);
            Uri uri1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video2);
            videoView1.setVideoURI(uri1);

            MediaController mediaController1 = new MediaController(this);
            mediaController1.setAnchorView(videoView1);
            videoView1.setMediaController(mediaController1);
            videoView1.start();


            //aboutus button
            AU=(Button) findViewById(R.id.button1);
            //getstarted button
            GS=(Button) findViewById(R.id.button2);
            //Appointment button
            Appointment=(Button) findViewById(R.id.button3);
            //Doctors button
            drs=(Button) findViewById(R.id.button4);
            return insets;
        });

        drawerLayout = findViewById(R.id.main);
        navigationView = findViewById(R.id.nav);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();
            if (id == R.id.home1) {
                Toast.makeText(MainActivity.this, "Home Selected", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.how) {
                Toast.makeText(MainActivity.this, "How it works", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.dr) {
                Toast.makeText(MainActivity.this, "Doctors", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.reg) {
                Toast.makeText(MainActivity.this, "Registration", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.appointment) {
                Toast.makeText(MainActivity.this, "Appointment", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.evaluation) {
                Toast.makeText(MainActivity.this, "Evaluation of Doctors", Toast.LENGTH_SHORT).show();
            }
            return false;
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    //Aboutus function intent
    public void aboutus(View v)
    {
        Intent intent=new Intent(MainActivity.this, Aboutus.class);
        startActivity(intent);
    }
    //getstarted intent
    public void getstarted(View v)
    {
        Intent intent=new Intent(MainActivity.this, GetStarted.class);
        startActivity(intent);
    }
    public void Appointment(View v)
    {
        Intent intent=new Intent(MainActivity.this, Appointmentform.class);
        startActivity(intent);
    }
    public void doctors(View v)
    {
        Intent intent=new Intent(MainActivity.this, Doctorlist.class);
        startActivity(intent);
    }
}
