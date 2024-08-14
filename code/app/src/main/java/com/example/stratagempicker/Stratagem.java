package com.example.stratagempicker;

public class Stratagem {

    // Attributes
    private int id;
    private String name;
    private String input;
    private int callInTime;
    private double uses;
    private int cooldown;
    private boolean owned;

    // Constructors
    public Stratagem() {}

    public Stratagem(int id, String name, String input, int callInTime, double uses, int cooldown) {
        this.id = id;
        this.name = name;
        this.input = input;
        this.callInTime = callInTime;
        this.uses = uses;
        this.cooldown = cooldown;
        this.owned = true;
    }

    public Stratagem(int id, String name, String input, int callInTime, double uses, int cooldown, boolean owned) {
        this.id = id;
        this.name = name;
        this.input = input;
        this.callInTime = callInTime;
        this.uses = uses;
        this.cooldown = cooldown;
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

    public boolean isOwned() {
        return owned;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setCallInTime(int callInTime) {
        this.callInTime = callInTime;
    }

    public void setUses(double uses) {
        this.uses = uses;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
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
                '}';
    }
}
