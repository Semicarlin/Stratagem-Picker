package com.example.stratagempicker;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton generateButton;
    private TextView stratagem1Text;
    private TextView stratagem2Text;
    private TextView stratagem3Text;
    private TextView stratagem4Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views
        generateButton = findViewById(R.id.generate_button);
        stratagem1Text = findViewById(R.id.stratagem_1_text);
        stratagem2Text = findViewById(R.id.stratagem_2_text);
        stratagem3Text = findViewById(R.id.stratagem_3_text);
        stratagem4Text = findViewById(R.id.stratagem_4_text);

        DatabaseHelper dbh = new DatabaseHelper(MainActivity.this);
    }
}