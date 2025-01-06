package com.example.stratagempicker.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.example.stratagempicker.Activities.MainActivity;
import com.example.stratagempicker.Model.Batch;
import com.example.stratagempicker.Model.StratagemType;
import com.example.stratagempicker.R;

import java.util.List;

public class GenerateLoadoutFragment extends Fragment {

    // Attributes
    private AppCompatButton generateButton;
    private TextView stratagem1Text;
    private TextView stratagem2Text;
    private TextView stratagem3Text;
    private TextView stratagem4Text;

    // Constructor
    public GenerateLoadoutFragment() {}

    // Functions
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_generate_loadout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Find views
        generateButton = view.findViewById(R.id.generate_button);
        stratagem1Text = view.findViewById(R.id.stratagem_1_text);
        stratagem2Text = view.findViewById(R.id.stratagem_2_text);
        stratagem3Text = view.findViewById(R.id.stratagem_3_text);
        stratagem4Text = view.findViewById(R.id.stratagem_4_text);
        List<TextView> textViews = List.of(stratagem1Text, stratagem2Text, stratagem3Text, stratagem4Text);

        // Set on-click listeners
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Batch batch = MainActivity.database.makeBatch();
                for (int i = 0; i < 4; ++i) {
                    textViews.get(i).setText(batch.get(i).getName());
                }
//                stratagem1Text.setText(database.getRandomStratagem().getName());
//                stratagem2Text.setText(database.getRandomStratagem().getName());
//                stratagem3Text.setText(database.getRandomStratagem().getName());
//                stratagem4Text.setText(database.getRandomStratagem().getName());
            }
        });
    }
}
