package com.example.stratagempicker.Model;

import androidx.annotation.Nullable;

public class Stratagem {

    // Attributes
    private int id;
    private String name;
    private String input;
    private int callInTime;
    private double uses;
    private int cooldown;
    private StratagemType type;
    private boolean hasBackpack;
    private boolean owned;

    // Constructors
    public Stratagem() {}

    public Stratagem(int id, String name, String input, int callInTime, double uses, int cooldown, StratagemType type, boolean hasBackpack, boolean owned) {
        this.id = id;
        this.name = name;
        this.input = input;
        this.callInTime = callInTime;
        this.uses = uses;
        this.cooldown = cooldown;
        this.type = type;
        this.hasBackpack = hasBackpack;
        this.owned = owned;
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

    public int getCallInTime() {
        return callInTime;
    }

    public double getUses() {
        return uses;
    }

    public int getCooldown() {
        return cooldown;
    }

    public StratagemType getType() {
        return type;
    }

    public boolean isHasBackpack() {
        return hasBackpack;
    }

    public boolean isOwned() {
        return owned;
    }

    // Functions
    @Override
    public String toString() {
        return "Stratagem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", input='" + input + '\'' +
                ", callInTime=" + callInTime +
                ", uses=" + uses +
                ", cooldown=" + cooldown +
                ", type=" + type +
                ", hasBackpack=" + hasBackpack +
                ", owned=" + owned +
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
