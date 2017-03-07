package com.example.afpa.ecfregate.model;

import java.util.Date;

/**
 * Created by Afpa on 28/02/2017.
 */

public class Regate {

    int id_regate;
    String nom_regate;
    int num_regate;
    Date date_regate;
    int distance;
    String nom_personne;
    String prenom_personne;
    int point;
    String nom_voilier;
    int temps_reel;


    public Regate(int id_regate, String nom_regate, int num_regate, Date date_regate, int distance, String nom_personne, String prenom_personne) {
        this.id_regate = id_regate;
        this.nom_regate = nom_regate;
        this.num_regate = num_regate;
        this.date_regate = date_regate;
        this.distance = distance;
        this.nom_personne = nom_personne;
        this.prenom_personne = prenom_personne;

    }

    public Regate(int id_regate, int point, String nom_voilier, int temps_reel, String nom_personne) {
        this.id_regate = id_regate;
        this.point = point;
        this.nom_voilier = nom_voilier;
        this.temps_reel = temps_reel;
        this.nom_personne = nom_personne;
    }

    public Regate(int id_regate, String nom_regate, int num_regate, Date date_regate, int distance) {
        this.id_regate = id_regate;
        this.nom_regate = nom_regate;
        this.num_regate = num_regate;
        this.date_regate = date_regate;
        this.distance = distance;


    }

    public Regate(String nom_regate) {
        this.nom_regate = nom_regate;
    }

    public Regate(String nom_regate, Date date_regate, int distance) {
        this.nom_regate = nom_regate;
        this.date_regate = date_regate;
        this.distance = distance;
    }

    public Regate(int id_regate, String nom_regate) {
        this.id_regate = id_regate;
        this.nom_regate = nom_regate;
    }

    public int getId_regate() {
        return id_regate;
    }

    public void setId_regate(int id_regate) {
        this.id_regate = id_regate;
    }

    public String getNom_regate() {
        return nom_regate;
    }

    public void setNom_regate(String nom_regate) {
        this.nom_regate = nom_regate;
    }

    public int getNum_regate() {
        return num_regate;
    }

    public void setNum_regate(int num_regate) {
        this.num_regate = num_regate;
    }

    public Date getDate_regate() {
        return date_regate;
    }

    public void setDate_regate(Date date_regate) {
        this.date_regate = date_regate;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getNom_personne() {
        return nom_personne;
    }

    public void setNom_personne(String nom_personne) {
        this.nom_personne = nom_personne;
    }

    public String getPrenom_personne() {
        return prenom_personne;
    }

    public void setPrenom_personne(String prenom_personne) {
        this.prenom_personne = prenom_personne;
    }

    public int getTemps_reel() {
        return temps_reel;
    }

    public void setTemps_reel(int temps_reel) {
        this.temps_reel = temps_reel;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getNom_voilier() {
        return nom_voilier;
    }

    public void setNom_voilier(String nom_voilier) {
        this.nom_voilier = nom_voilier;
    }

    @Override
    public String toString() {
        return "Regate{" +
                "id_regate=" + id_regate +
                ", nom_regate='" + nom_regate + '\'' +
                ", num_regate=" + num_regate +
                ", date_regate=" + date_regate +
                ", distance=" + distance +
                '}';
    }
}
