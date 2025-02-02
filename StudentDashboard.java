package com.example.attendancesystem;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class StudentDashboard extends AppCompatActivity {
    private Spinner spinnerClass, spinnerSubject;
    private CheckBox cbPresent, cbAbsent;
    private EditText etReason;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        spinnerClass = findViewById(R.id.spinnerClass);
        spinnerSubject = findViewById(R.id.spinnerSubject);
        cbPresent = findViewById(R.id.cbPresent);
        cbAbsent = findViewById(R.id.cbAbsent);
        etReason = findViewById(R.id.etReason);
        Button btnSubmit;
        btnSubmit = findViewById(R.id.btnSubmit);

        setupSpinners();
        setupCheckBoxListeners();
        btnSubmit.setOnClickListener(v -> submitAttendance());
    }

    private void setupSpinners() {
        ArrayAdapter<CharSequence> classAdapter = ArrayAdapter.createFromResource(this,
                R.array.classes_array, android.R.layout.simple_spinner_item);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerClass.setAdapter(classAdapter);

        ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this,
                R.array.subjects_array, android.R.layout.simple_spinner_item);
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSubject.setAdapter(subjectAdapter);
    }

    private void setupCheckBoxListeners() {
        cbPresent.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) cbAbsent.setChecked(false);
            etReason.setVisibility(View.GONE);
        });

        cbAbsent.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                cbPresent.setChecked(false);
                etReason.setVisibility(View.VISIBLE);
            } else {
                etReason.setVisibility(View.GONE);
            }
        });
    }

    private void submitAttendance() {
        String selectedClass = spinnerClass.getSelectedItem().toString();
        String selectedSubject = spinnerSubject.getSelectedItem().toString();
        boolean isPresent = cbPresent.isChecked();
        String reason = etReason.getText().toString().trim();

        if (cbAbsent.isChecked() && reason.isEmpty()) {
            Toast.makeText(this, "Please provide a reason for absence.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save to database (Placeholder Toast for now)
        Toast.makeText(this, "Attendance submitted!", Toast.LENGTH_SHORT).show();
    }
}
