package org.humanbooster.project1cgi.model;

public class Orc {

    private String name = "NameLess";
    private int health;
    private int force;

    public Orc(int health, int force) {
        if (health > 100) {
            this.health = 100;
        } else {
            this.health = health;
        }
        this.force = force;
    }

    public Orc(String name, int health, int force) {
        this(health, force);
        this.name = name;
    }

    public void attack(Orc o) {
        o.health -= this.force;
        if (o.health < 0) {
            o.health = 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    @Override
    public String toString() {
        return name + " a " + health + " points de vie et une force de " + force + ".";
    }

}
