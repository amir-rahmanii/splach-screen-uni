package com.example.splashactivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
// MainActivity.java
import android.app.Dialog;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private TextView profileTextView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileTextView = findViewById(R.id.profileTextView);

        Button showDialogButton = findViewById(R.id.showDialogButton);
        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }

    private void showCustomDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_profile);

        EditText firstNameEditText = dialog.findViewById(R.id.editTextFirstName);
        EditText lastNameEditText = dialog.findViewById(R.id.editTextLastName);
        EditText jobEditText = dialog.findViewById(R.id.editTextJob);
        TimePicker timePicker = dialog.findViewById(R.id.timePicker);
        Button saveButton = dialog.findViewById(R.id.buttonSave);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String job = jobEditText.getText().toString();

                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();
                String time = String.format("%02d:%02d", hour, minute);

                String profileInfo = "نام: " + firstName + "\n" +
                        "نام خانوادگی: " + lastName + "\n" +
                        "شغل: " + job + "\n" +
                        "ساعت: " + time;

                profileTextView.setText(profileInfo);

                dialog.dismiss();
            }
        });

        dialog.show();
    }

}
