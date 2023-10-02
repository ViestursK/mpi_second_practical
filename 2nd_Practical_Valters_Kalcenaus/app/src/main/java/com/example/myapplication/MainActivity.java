package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] members = {"Valters Kalcenaus", "Viesturs Kalcenaus"};
        boolean[] checkedItems = new boolean[members.length];
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("<No. 1> Group’s Dialog")
                .setMultiChoiceItems(members, checkedItems, (dialog, which, isChecked) -> {
                    String toastText = isChecked ? members[which] + " checked" : members[which] + " unchecked";
                    Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
                })
                .setPositiveButton("OK", null)
                .setNegativeButton("Close", (dialog, which) -> {
                    Toast.makeText(this, "You closed dialog", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                });

        AlertDialog dialog = builder.create();

        Button dialogButton = findViewById(R.id.dialog);
        dialogButton.setOnClickListener(v -> {
            dialog.show();
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(view -> {
                Toast.makeText(MainActivity.this, "You clicked OK", Toast.LENGTH_SHORT).show();
            });
        });

        Button goToSecondButton = findViewById(R.id.GoToSecond);
        goToSecondButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
    }
}
