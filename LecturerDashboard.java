package com.example.attendanceapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.attendancesystem.R;

public class LecturerDashboardActivity extends AppCompatActivity {

    private Spinner spinnerClass, spinnerSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_dashboard);

        spinnerClass = findViewById(R.id.spinnerClass);
        spinnerSubject = findViewById(R.id.spinnerSubject);
        Button btnViewAttendance = findViewById(R.id.btnViewAttendance);

        // Sample data
        String[] classes = {"CDCS240 5A", "CDCS240 5B", "CDCS240 5C"};
        String[] subjects = {"ICT602 - IT Project", "ICT603 - Database Management"};

        ArrayAdapter<String> classAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, classes);
        spinnerClass.setAdapter(classAdapter);

        ArrayAdapter<String> subjectAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, subjects);
        spinnerSubject.setAdapter(subjectAdapter);

        btnViewAttendance.setOnClickListener(v -> {
            String selectedClass = spinnerClass.getSelectedItem().toString();
            String selectedSubject = spinnerSubject.getSelectedItem().toString();
            Toast.makeText(this, "Viewing attendance for " + selectedClass + " - " + selectedSubject, Toast.LENGTH_SHORT).show();
        });
    }
}


