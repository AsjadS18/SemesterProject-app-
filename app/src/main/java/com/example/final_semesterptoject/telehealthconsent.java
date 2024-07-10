package com.example.final_semesterptoject;


import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class telehealthconsent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView heading = findViewById(R.id.heading);
        TextView point1 = findViewById(R.id.point1);
        TextView point2 = findViewById(R.id.point2);
        TextView point3 = findViewById(R.id.point3);
        TextView point4 = findViewById(R.id.point4);
        TextView point5 = findViewById(R.id.point5);

        heading.setText("Telehealth Consent");

        point1.setText("1. I hereby authorize Health Care Services to use the telehealth practice platform for telecommunication for evaluating, testing and diagnosing my medical condition.");
        point2.setText("2. I understand that technical difficulties may occur before or during the telehealth sessions and my appointment cannot be started or ended as intended.");
        point3.setText("3. I accept that the professionals can contact interactive sessions with video call; however, I am informed that the sessions can be conducted via regular voice communication if the technical requirements such as internet speed cannot be met.");
        point4.setText("4. I understand that my current insurance may not cover the additional fees of the telehealth practices and I may be responsible for any fee that my insurance company does not cover.");
        point5.setText("5. I agree that my medical records on telehealth can be kept for further evaluation, analysis and documentation, and in all of these, my information will be kept private.");
    }
}
