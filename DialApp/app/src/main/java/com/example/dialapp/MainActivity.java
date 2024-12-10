package com.example.dialapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind views
        EditText phoneNumberEditText = findViewById(R.id.phone_number);
        Button dialButton = findViewById(R.id.dial_button);

        // Set button click listener
        dialButton.setOnClickListener(v -> {
            String phoneNumber = phoneNumberEditText.getText().toString().trim();

            if (!phoneNumber.isEmpty()) {
                // Create an Intent to open the dialer
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(dialIntent);
            } else {
                // Show error message
                Toast.makeText(this, "Please enter a phone number", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
