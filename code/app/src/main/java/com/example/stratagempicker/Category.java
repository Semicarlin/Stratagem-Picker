package com.example.stratagempicker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Represents group of stratagems
 */
public class Category {

    // Attributes
    private int id;
    private String name;
    private ArrayList<Stratagem> stratagems;
    private final Random random = new Random();

    // Constructor
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Functions
    public void addStratagem(Stratagem stratagem) {
        if (stratagems.contains(stratagem)) {
            stratagems.add(stratagem);
        }
    }

    public Stratagem getRandomStratagem() {
        return stratagems.get(random.nextInt(stratagems.size()));
    }

}
