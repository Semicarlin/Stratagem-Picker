package com.example.stratagempicker.Model;

import androidx.annotation.Nullable;

public class Stratagem {

    // Attributes
    private int id;
    private String name;
    private String input;
    private double uses;
    private StratagemType type;
    private boolean hasBackpack;
    private boolean isOwned;

    // Constructors
    public Stratagem() {}

    public Stratagem(int id, String name, String input, int uses, StratagemType type, int hasBackpack, int isOwned)
    {
        this.id = id;
        this.name = name;
        this.input = input;
        this.uses = uses;
        this.type = type;
        this.hasBackpack = (hasBackpack == 1);
        this.isOwned = (isOwned == 1);
    }

    public Stratagem(int id, String name, String input, double uses, StratagemType type, boolean hasBackpack, boolean isOwned) {
        this.id = id;
        this.name = name;
        this.input = input;
        this.uses = uses;
        this.type = type;
        this.hasBackpack = hasBackpack;
        this.isOwned = isOwned;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInput() {
        return input;
    }

    public double getUses() {
        return uses;
    }

    public StratagemType getType() {
        return type;
    }

    public boolean isHasBackpack() {
        return hasBackpack;
    }

    public boolean isOwned() {
        return isOwned;
    }

    // Functions
    @Override
    public String toString() {
        return "Stratagem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", input='" + input + '\'' +
                ", uses=" + uses +
                ", type=" + type +
                ", hasBackpack=" + hasBackpack +
                '}';
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        else {
            return this.getId() == ((Stratagem) obj).getId();
        }
    }
}
