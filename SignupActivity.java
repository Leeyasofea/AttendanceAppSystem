package com.example.attendanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.attendancesystem.R;

public class SignupActivity extends AppCompatActivity {

    private EditText etFullName, etEmail, etPassword, etConfirmPassword;
    private RadioGroup radioGroupRole;
    private Button btnSignUp;
    private TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        radioGroupRole = findViewById(R.id.radioGroupRole);
        btnSignUp = findViewById(R.id.btnSignUp);
        tvLogin = findViewById(R.id.tvLogin);

        btnSignUp.setOnClickListener(v -> registerUser());
        tvLogin.setOnClickListener(v -> startActivity(new Intent(SignupActivity.this, LoginActivity.class)));
    }

    private void registerUser() {
        String fullName = etFullName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();
        int selectedRoleId = radioGroupRole.getCheckedRadioButtonId();

        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selectedRole = findViewById(selectedRoleId);
        String role = selectedRole.getText().toString();

        Toast.makeText(this, "User registered as " + role, Toast.LENGTH_SHORT).show();
    }
}

