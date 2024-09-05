package com.example.stratagempicker.Model;

import com.example.stratagempicker.Activities.MainActivity;

import java.util.ArrayList;

/**
 * Represents selection of 4 stratagems and checks for validity of selection
 */
public class Batch {

    // Attributes
    private ArrayList<Stratagem> contents = new ArrayList<Stratagem>();
    private boolean hasMech;
    private boolean hasWeapon;
    private boolean hasBackpack;
    private boolean hasEagle;

    // Constructor
    public Batch() {
        hasMech = false;
        hasWeapon = false;
        hasBackpack = false;
        hasEagle = false;
    }

    // Functions
    public boolean tryToAdd(Stratagem stratagem) {
        if (!contents.isEmpty()) {

            // Check if already in batch
            if (contents.contains(stratagem)) {
                return false;
            }

            // Check if is mech and batch already has mech
            if (stratagem.getType() == StratagemType.MECH && hasMech) {
                return false;
            }

            // Check if violation of user-disabled multiple weapons
            if (!MainActivity.user.isAllowMultipleWeapons() && stratagem.getType() == StratagemType.WEAPON && hasWeapon) {
                return false;
            }

            // Check if violation of user-disabled multiple backpacks
            if (!MainActivity.user.isAllowMultipleBackpacks() && stratagem.isHasBackpack() && hasBackpack) {
                return false;
            }

            // Check if violation of user-disabled multiple eagles
            if (!MainActivity.user.isAllowMultipleEagles() && stratagem.getType() == StratagemType.EAGLE && hasEagle) {
                return false;
            }
        }

        // Otherwise, addition is possible and executed
        this.addStratagem(stratagem);
        return true;
    }

    private void addStratagem(Stratagem stratagem) {

        // Add stratagems to contents
        contents.add(stratagem);

        // Update attributes
        if (stratagem.getType() == StratagemType.MECH) {
            hasMech = true;
        }
        if (stratagem.isHasBackpack()) {
            hasBackpack = true;
        }
        if (stratagem.getType() == StratagemType.WEAPON) {
            hasWeapon = true;
        }
        if (stratagem.getType() == StratagemType.EAGLE) {
            hasEagle = true;
        }
    }

    public Stratagem get(int i) {
        return contents.get(i);
    }

    public int size() {
        return contents.size();
    }
}
