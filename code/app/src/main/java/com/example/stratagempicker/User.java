package com.example.stratagempicker;

/**
 * Stores user-specified preferences
 */

public class User {

    // Attributes
    private boolean allowMultipleWeapons;
    private boolean allowMultipleBackpacks;
    private boolean allowMultipleEagles;

    // Constructors
    public User() {
        this.allowMultipleWeapons = false;
        this.allowMultipleBackpacks = false;
        this.allowMultipleEagles = true;
    }

    // Functions
    public void updateUser(boolean allowMultipleWeapons, boolean allowMultipleBackpacks, boolean allowMultipleEagles) {
        this.allowMultipleWeapons = allowMultipleWeapons;
        this.allowMultipleBackpacks = allowMultipleBackpacks;
        this.allowMultipleEagles = allowMultipleEagles;
    }
    public boolean isAllowMultipleWeapons() {
        return allowMultipleWeapons;
    }
    public boolean isAllowMultipleBackpacks() {
        return allowMultipleBackpacks;
    }
    public boolean isAllowMultipleEagles() {
        return allowMultipleEagles;
    }

    @Override
    public String toString() {
        return "User{" +
                "allowMultipleWeapons=" + allowMultipleWeapons +
                ", allowMultipleBackpacks=" + allowMultipleBackpacks +
                ", allowMultipleEagles=" + allowMultipleEagles +
                '}';
    }
}
