package com.firstapp.secondpractical_viestursk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        Button goToSecondButton = findViewById(R.id.btnGoToSecondActivity);
        Button showDialogButton = findViewById(R.id.btnShowDialog);

        // Set click listeners
        goToSecondButton.setOnClickListener(this::goToSecondActivity);
        showDialogButton.setOnClickListener(this::showDialog);
    }

    private void goToSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    private void showDialog(View view) {
        String[] members = getResources().getStringArray(R.array.members_array);
        boolean[] checkedItems = new boolean[members.length];

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.group_dialog_title))
                .setMultiChoiceItems(members, checkedItems, (dialog, which, isChecked) -> {
                    String toastText = isChecked ? members[which] + " checked" : members[which] + " unchecked";
                    Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
                })
                .setPositiveButton(getString(R.string.dialog_positive_button), (dialog, which) -> {
                    // Show a Toast when "OK" is clicked
                    Toast.makeText(this, getString(R.string.dialog_ok_message), Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton(getString(R.string.dialog_negative_button), (dialog, which) -> {
                    // Show a Toast when "Close" is clicked and dismiss the dialog
                    Toast.makeText(this, getString(R.string.dialog_closed_message), Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
