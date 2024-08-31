package com.example.stratagempicker;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.List;

/**
 * Main activity of application
 */

public class MainActivity extends AppCompatActivity {

    String dbName = "database.db";
    public static User user;
    private Database database;
    private AppCompatButton generateButton;
    private TextView stratagem1Text;
    private TextView stratagem2Text;
    private TextView stratagem3Text;
    private TextView stratagem4Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create user object
        user = new User();

        // Create database instance
        database = new Database(this, dbName);

        // Find views
        generateButton = findViewById(R.id.generate_button);
        stratagem1Text = findViewById(R.id.stratagem_1_text);
        stratagem2Text = findViewById(R.id.stratagem_2_text);
        stratagem3Text = findViewById(R.id.stratagem_3_text);
        stratagem4Text = findViewById(R.id.stratagem_4_text);
        List<TextView> textViews = List.of(stratagem1Text, stratagem2Text, stratagem3Text, stratagem4Text);

        // Set on-click listeners
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Batch batch = database.makeBatch();
                Log.d("bagel", user.toString());
                for (int i = 0; i < 4; ++i) {
                    textViews.get(i).setText(batch.get(i).getName());
                    Log.d("bagel", batch.get(i).toString());
                }
//                stratagem1Text.setText(database.getRandomStratagem().getName());
//                stratagem2Text.setText(database.getRandomStratagem().getName());
//                stratagem3Text.setText(database.getRandomStratagem().getName());
//                stratagem4Text.setText(database.getRandomStratagem().getName());
            }
        });

    }
}