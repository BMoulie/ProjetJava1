package org.humanbooster.project1cgi.model;

public class Person {

    public String name;
    public int age = 18;
    private Horse ownedHorse;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this(name);
        this.age = age;
    }

    @Override
    public String toString() {
        return  name + " a " + age + " ans.";
    }

    public void afficheDetails() {
        System.out.println("Nom de la personne : " + this.name  + " d'âge " + this.age + " ans.");
    }

    public void addToAge(int annees) {
        this.age += annees;
    }

    public String getStatus() {
        return this.age >= 18 ? "Majeur" : "Mineur";
    }

}
