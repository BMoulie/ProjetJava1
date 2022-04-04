package org.humanbooster.project1cgi.model;

import java.util.Objects;

public class CarOld {

    private String couleur;
    private String marque;
    private String modele;

    public CarOld(String couleur, String marque, String modele) {
        this.couleur = couleur;
        this.marque = marque;
        this.modele = modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarOld car = (CarOld) o;
        return marque.equals(car.marque) && modele.equals(car.modele);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marque, modele);
    }

    @Override
    public String toString() {
        return "Car{" +
                "couleur='" + couleur + '\'' +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                '}';
    }
}
