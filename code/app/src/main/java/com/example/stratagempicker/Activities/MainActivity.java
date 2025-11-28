package com.example.stratagempicker.Activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.stratagempicker.Fragments.CategoryListFragment;
import com.example.stratagempicker.Fragments.GenerateLoadoutFragment;
import com.example.stratagempicker.Fragments.UserPreferencesFragment;
import com.example.stratagempicker.Model.Database;
import com.example.stratagempicker.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

/**
 * Main activity of application
 */

public class MainActivity extends AppCompatActivity {

    // Database attributes
    String dbName = "database.db";
    public static Database database;

    // Navbar attributes
    private BottomNavigationView navBar;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private CategoryListFragment categoryListFragment = new CategoryListFragment();
    private GenerateLoadoutFragment generateLoadoutFragment = new GenerateLoadoutFragment();
    private UserPreferencesFragment userPreferencesFragment = new UserPreferencesFragment();
    private Fragment activeFragment;
    public static final int NAV_CATEGORY_LIST = R.id.navbar_category_list;
    public static final int NAV_GENERATE_LOADOUT = R.id.navbar_generate_loadout;
    public static final int NAV_USER_PREFERENCES = R.id.navbar_user_preferences;

    // Functions
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create database instance
        database = new Database(getBaseContext(), dbName);

        // Find views
        navBar = findViewById(R.id.main_activity_bottom_nav);

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

                // Update container to show new fragment
                fragmentManager.beginTransaction()
                        .hide(activeFragment)
                        .show(selectedFragment)
                        .commitNow();
                activeFragment = selectedFragment;
                return true;
            }
        });
    }
}