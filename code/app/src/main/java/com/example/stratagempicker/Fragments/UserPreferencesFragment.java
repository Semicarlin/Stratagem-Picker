package com.example.stratagempicker.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import com.example.stratagempicker.Activities.MainActivity;
import com.example.stratagempicker.R;

public class UserPreferencesFragment extends Fragment {

    // Attributes
    private SwitchCompat allowMultipleWeaponsSwitch;
    private SwitchCompat allowMultipleBackpacksSwitch;
    private SwitchCompat allowMultipleEaglesSwitch;
    private Button cancelButton;
    private Button saveButton;

    // Constructor
    public UserPreferencesFragment() {}

    // Functions
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_preferences, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Find switches
        allowMultipleWeaponsSwitch = view.findViewById(R.id.multiple_weapons_switch);
        allowMultipleBackpacksSwitch = view.findViewById(R.id.multiple_backpacks_switch);
        allowMultipleEaglesSwitch = view.findViewById(R.id.multiple_eagles_switch);

        // Set switches to match user object
        setSwitches();

        // Find buttons
        cancelButton = view.findViewById(R.id.cancel_button);
        saveButton = view.findViewById(R.id.save_button);

        // Set behaviour of buttons
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSwitches();
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private void setSwitches() {
        allowMultipleWeaponsSwitch.setChecked(MainActivity.database.user.isAllowMultipleWeapons());
        allowMultipleBackpacksSwitch.setChecked(MainActivity.database.user.isAllowMultipleBackpacks());
        allowMultipleEaglesSwitch.setChecked(MainActivity.database.user.isAllowMultipleEagles());
    }
}
