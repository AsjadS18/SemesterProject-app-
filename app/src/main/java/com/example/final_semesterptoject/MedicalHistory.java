package com.example.final_semesterptoject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MedicalHistory extends AppCompatActivity {

    private EditText fullNameEditText, phoneNumberEditText;
    private CheckBox asthmaCheckBox, cancerCheckBox, cardiacDiseaseCheckBox, diabetesCheckBox,
            hypertensionCheckBox, psychiatricDisorderCheckBox, epilepsyCheckBox,
            chestPainCheckBox, respiratoryCheckBox, cardiacDiseaseSymptomCheckBox,
            cardiovascularCheckBox, hematologicalCheckBox, lymphaticCheckBox,
            neurologicalCheckBox, psychiatricSymptomCheckBox, gastrointestinalCheckBox,
            genitourinaryCheckBox, weightGainCheckBox, weightLossCheckBox,
            musculoskeletalCheckBox;
    private RadioGroup medicationRadioGroup, genderRadioGroup, tobaccoUseRadioGroup, illegalDrugUseRadioGroup, alcoholFrequencyRadioGroup;
    private RadioButton medicationYesRadioButton, medicationNoRadioButton,
            genderMaleRadioButton, genderFemaleRadioButton, tobaccoUseYesRadioButton, tobaccoUseNoRadioButton,
            illegalDrugUseYesRadioButton, illegalDrugUseNoRadioButton, dailyRadioButton, weeklyRadioButton, monthlyRadioButton, occasionallyRadioButton, neverRadioButton;
    private Spinner tobaccoUseSpinner, illegalDrugUseSpinner;
    private Button submit;
    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference reference=db.getReference().child("Medicalform");
    int i=0;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullNameEditText = findViewById(R.id.full_name);
        phoneNumberEditText = findViewById(R.id.phone_number);
        submit=findViewById(R.id.submit_button);
        asthmaCheckBox = findViewById(R.id.asthma);
        cancerCheckBox = findViewById(R.id.cancer);
        cardiacDiseaseCheckBox = findViewById(R.id.cardiac_disease);
        diabetesCheckBox = findViewById(R.id.diabetes);
        hypertensionCheckBox = findViewById(R.id.hypertension);
        psychiatricDisorderCheckBox = findViewById(R.id.psychiatric_disorder);
        epilepsyCheckBox = findViewById(R.id.epilepsy);

        chestPainCheckBox = findViewById(R.id.chest_pain);
        respiratoryCheckBox = findViewById(R.id.respiratory);
        cardiacDiseaseSymptomCheckBox = findViewById(R.id.cardiac_disease_symptom);
        cardiovascularCheckBox = findViewById(R.id.cardiovascular);
        hematologicalCheckBox = findViewById(R.id.hematological);
        lymphaticCheckBox = findViewById(R.id.lymphatic);
        neurologicalCheckBox = findViewById(R.id.neurological);
        psychiatricSymptomCheckBox = findViewById(R.id.psychiatric_symptom);
        gastrointestinalCheckBox = findViewById(R.id.gastrointestinal);
        genitourinaryCheckBox = findViewById(R.id.genitourinary);
        weightGainCheckBox = findViewById(R.id.weight_gain);
        weightLossCheckBox = findViewById(R.id.weight_loss);
        musculoskeletalCheckBox = findViewById(R.id.musculoskeletal);

        medicationRadioGroup = findViewById(R.id.medication);
        medicationYesRadioButton = findViewById(R.id.medication_yes);
        medicationNoRadioButton = findViewById(R.id.medication_no);

        genderRadioGroup = findViewById(R.id.gender);
        genderMaleRadioButton = findViewById(R.id.gender_male);
        genderFemaleRadioButton = findViewById(R.id.gender_female);

        tobaccoUseSpinner = findViewById(R.id.tobacco_use_spinner);
        illegalDrugUseSpinner = findViewById(R.id.illegal_drug_use_spinner);

        alcoholFrequencyRadioGroup = findViewById(R.id.alcohol_frequency_radio_group);
        dailyRadioButton = findViewById(R.id.daily_radio_button);
        weeklyRadioButton = findViewById(R.id.weekly_radio_button);
        monthlyRadioButton = findViewById(R.id.monthly_radio_button);
        occasionallyRadioButton = findViewById(R.id.occasionally_radio_button);
        neverRadioButton = findViewById(R.id.never_radio_button);

        // Create an array of options for tobacco use
        String[] tobaccoUseOptions = {"Yes", "No"};

        // Create an ArrayAdapter for tobacco use
        ArrayAdapter<String> tobaccoUseAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tobaccoUseOptions);

        // Set the adapter to the tobacco use Spinner
        tobaccoUseSpinner.setAdapter(tobaccoUseAdapter);

        // Create an array of options for illegal drug use
        String[] illegalDrugUseOptions = {"Yes", "No"};

        // Create an ArrayAdapter for illegal drug use
        ArrayAdapter<String> illegalDrugUseAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, illegalDrugUseOptions);

        // Set the adapter to the illegal drug use Spinner
        illegalDrugUseSpinner.setAdapter(illegalDrugUseAdapter);

    }
    public void process(View v) {
        //Strings for saving data in firebase
       //conditions
        String Conditions="";
        String d1 = "Asthma";
        String d2 = "Cancer";
        String d3 = "Cardiac Disease";
        String d4 = "Chest pain";
        String d5 = "Hyper Tension";
        String d6 = " psychiatric Disorder";
        String d7 = "Epilepsy";
        //symptoms
        String Symptoms="";
        String d8 = "Respiratory";
        String d9 = "Cardiac disease";
        String d10 = "Cardiovascular";
        String d11 = "Hematological";
        String d12 = "Lymphatic";
        String d13 = "Neurological";
        String d14 = "Psychiatric";
        String d15 = "Gastrointestinal";
        String d16 = "Genitourinary";
        String d17 = "Weight gain";
        String d18 = "Weight loss";
        String d19 = "musculoskeletal";
       String Gender="";
        String d20 = "Male";
        String d21 = "Female";
       String Illegaldrug="";

        String d22 = "Yes";
        String d23 = "No";
        String d24 = "Not Sure";
        String Alcohaluse="";
        String d25 = "Daily";
        String d26 = "Weekly";
        String d27 = "Monthly";
        String d28 = "Occasionally";
        String d29 = "Never";


        String fullName=fullNameEditText.getText().toString();
        String phoneNumber= phoneNumberEditText.getText().toString();

        medicalformdataholder dataholder= new medicalformdataholder();
        reference.child(fullName).setValue(dataholder);

        medicalformdataholder obj1= new medicalformdataholder();
        reference.child(Conditions).setValue(obj1);

        medicalformdataholder obj2= new medicalformdataholder();
        reference.child(Symptoms).setValue(obj2);

        medicalformdataholder obj3= new medicalformdataholder();
        reference.child(Gender).setValue(obj3);

        medicalformdataholder obj4= new medicalformdataholder();
        reference.child(Illegaldrug).setValue(obj4);

        medicalformdataholder obj5= new medicalformdataholder();
        reference.child(Alcohaluse).setValue(obj5);
        if(asthmaCheckBox.isChecked()) {
          obj1.setAsthmaCheckBox(d1);
          reference.child(String.valueOf(i+1)).setValue(obj1);
        }
        if(cancerCheckBox.isChecked()) {
            obj1.setCancerCheckBox(d2);
            reference.child(String.valueOf(i+1)).setValue(obj1);
        }
        if(cardiacDiseaseCheckBox.isChecked()) {
            obj1.setCardiacDiseaseCheckBox(d3);
            reference.child(String.valueOf(i+1)).setValue(obj1);
        }
        if(hypertensionCheckBox.isChecked()) {
            obj1.setHypertensionCheckBox(d5);
            reference.child(String.valueOf(i+1)).setValue(obj1);
        }
        if(psychiatricDisorderCheckBox.isChecked()) {
            obj1.setPsychiatricDisorderCheckBox(d6);
            reference.child(String.valueOf(i+1)).setValue(obj1);
        }
        if(epilepsyCheckBox.isChecked()) {
            obj1.setEpilepsyCheckBox(d7);
            reference.child(String.valueOf(i+1)).setValue(obj1);
        }
        if(chestPainCheckBox.isChecked()) {
            obj1.setChestPainCheckBox(d4);
            reference.child(String.valueOf(i+1)).setValue(obj1);
        }
        if(respiratoryCheckBox.isChecked()) {
            obj2.setRespiratoryCheckBox(d8);
            reference.child(String.valueOf(i+1)).setValue(obj2);
        }
        if(cardiacDiseaseSymptomCheckBox.isChecked()) {
            obj2.setCardiacDiseaseSymptomCheckBox(d9);
            reference.child(String.valueOf(i+1)).setValue(obj2);
        }
        if(cardiovascularCheckBox.isChecked()) {
            obj2.setCardiovascularCheckBox(d10);
            reference.child(String.valueOf(i+1)).setValue(obj2);
        }
        if(hematologicalCheckBox.isChecked()) {
            obj2.setHematologicalCheckBox(d11);
            reference.child(String.valueOf(i+1)).setValue(obj2);
        }
        if(lymphaticCheckBox.isChecked()) {
            obj2.setLymphaticCheckBox(d12);
            reference.child(String.valueOf(i+1)).setValue(obj2);
        }
        if(neurologicalCheckBox.isChecked()) {
            obj2.setNeurologicalCheckBox(d13);
            reference.child(String.valueOf(i+1)).setValue(obj2);
        }
        if(psychiatricSymptomCheckBox.isChecked()) {
            obj2.setPsychiatricSymptomCheckBox(d14);
            reference.child(String.valueOf(i+1)).setValue(obj2);
        }
        if(gastrointestinalCheckBox.isChecked()) {
            obj2.setGastrointestinalCheckBox(d15);
            reference.child(String.valueOf(i+1)).setValue(obj2);
        }
        if(genitourinaryCheckBox.isChecked()) {
            obj2.setGenitourinaryCheckBox(d16);
            reference.child(String.valueOf(i+1)).setValue(obj2);
        }
        if(weightGainCheckBox.isChecked()) {
            obj2.setWeightGainCheckBox(d17);
            reference.child(String.valueOf(i+1)).setValue(obj2);
        }
        if(weightLossCheckBox.isChecked()) {
            obj2.setWeightLossCheckBox(d18);
            reference.child(String.valueOf(i+1)).setValue(obj2);
        }
        if(musculoskeletalCheckBox.isChecked()) {
            obj2.setMusculoskeletalCheckBox(d19);
            reference.child(String.valueOf(i+1)).setValue(obj2);
        }
        if(genderMaleRadioButton.isChecked()) {
            obj3.setGenderMaleRadioButton(d20);
            reference.child(String.valueOf(i+1)).setValue(obj3);
        }
        if(genderFemaleRadioButton.isChecked()) {
            obj3.setGenderFemaleRadioButton(d21);
            reference.child(String.valueOf(i+1)).setValue(obj3);
        }
        if(illegalDrugUseYesRadioButton.isChecked()) {
            obj4.setIllegalDrugUseYesRadioButton(d22);
            reference.child(String.valueOf(i+1)).setValue(obj4);
        }
        if(illegalDrugUseNoRadioButton.isChecked()) {
            obj4.setIllegalDrugUseYesRadioButton(d23);
            reference.child(String.valueOf(i+1)).setValue(obj4);
        }
       // if(illegalDrugUseNotsureRadioButton.isChecked()) {
       //     dataholder.setCardiacDiseaseCheckBox(d24);
         //   reference.child(String.valueOf(i+1)).setValue(obj1);
       // }
        if(dailyRadioButton.isChecked()) {
            obj5. setDailyRadioButton(d25);
            reference.child(String.valueOf(i+1)).setValue(obj5);
        }
        if(weeklyRadioButton.isChecked()) {
            obj5. setWeeklyRadioButton(d26);
            reference.child(String.valueOf(i+1)).setValue(obj5);
        }
        if(monthlyRadioButton.isChecked()) {
            obj4.setMonthlyRadioButton(d27);
            reference.child(String.valueOf(i+1)).setValue(obj5);
        }
        if(occasionallyRadioButton.isChecked()) {
            obj5.setOccasionallyRadioButton(d28);
            reference.child(String.valueOf(i+1)).setValue(obj5);
        }
        if(neverRadioButton.isChecked()) {
            obj5.setNeverRadioButton(d29);
            reference.child(String.valueOf(i+1)).setValue(obj5);
        }

    }



}