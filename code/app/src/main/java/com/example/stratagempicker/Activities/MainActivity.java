package com.example.stratagempicker.Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

import com.example.stratagempicker.Fragments.CategoryListFragment;
import com.example.stratagempicker.Fragments.GenerateLoadoutFragment;
import com.example.stratagempicker.Fragments.UserPreferencesFragment;
import com.example.stratagempicker.Model.Batch;
import com.example.stratagempicker.Model.Database;
import com.example.stratagempicker.Model.User;
import com.example.stratagempicker.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

/**
 * Main activity of application
 */

public class MainActivity extends AppCompatActivity {

    // Attributes
    String dbName = "database.db";
    public static User user;
    public static Database database;
    private BottomNavigationView navBar;
    private FragmentContainerView fragmentContainerView;
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private final CategoryListFragment categoryListFragment = new CategoryListFragment();
    private final GenerateLoadoutFragment generateLoadoutFragment = new GenerateLoadoutFragment();
    private final UserPreferencesFragment userPreferencesFragment = new UserPreferencesFragment();
    private Fragment activeFragment;
    public static final int NAV_CATEGORY_LIST = R.id.navbar_category_list;
    public static final int NAV_GENERATE_LOADOUT = R.id.navbar_generate_loadout;
    public static final int NAV_USER_PREFERENCES = R.id.navbar_user_preferences;

    // Functions
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create user object
        user = new User();

        // Create database instance
        database = new Database(getBaseContext(), dbName);

        // Find views
        navBar = findViewById(R.id.main_activity_bottom_nav);
        fragmentContainerView = findViewById(R.id.main_activity_frag_contain);

        // Set up nav bar
        navBar.setSelectedItemId(NAV_GENERATE_LOADOUT);
        activeFragment = generateLoadoutFragment;
        fragmentManager.beginTransaction()
                .add(R.id.main_activity_frag_contain, categoryListFragment, "categoryList")
                .hide(categoryListFragment)
                .commit();
        fragmentManager.beginTransaction()
                .add(R.id.main_activity_frag_contain, generateLoadoutFragment, "generateLoadout")
                .commit();
        fragmentManager.beginTransaction()
                .add(R.id.main_activity_frag_contain, userPreferencesFragment, "userPreferences")
                .hide(userPreferencesFragment)
                .commit();

        // Set up fragment transitioning
        navBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment;

                // Find corresponding selected fragment
                int itemID = item.getItemId();
                Log.d("bagel", Integer.toString(itemID));
                if (itemID == NAV_CATEGORY_LIST) {
                    selectedFragment = categoryListFragment;
                } else if (itemID == NAV_GENERATE_LOADOUT) {
                    selectedFragment = generateLoadoutFragment;
                } else if (itemID == NAV_USER_PREFERENCES) {
                    selectedFragment = userPreferencesFragment;
                }
                else {
                    return false;
                }
                Log.d("bagel", Integer.toString(itemID % 3));

                // Update container to show new fragment
                fragmentManager.beginTransaction()
                        .hide(activeFragment)
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .show(selectedFragment)
                        .commitNow();
                activeFragment = selectedFragment;
                return true;
            }
        });



    }
}