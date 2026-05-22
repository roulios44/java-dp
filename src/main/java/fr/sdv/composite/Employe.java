package fr.sdv.composite;

import java.util.Objects;

/**
 * Représente un employé avec un salaire fixe.
 */
public class Employe implements IElement {

    private final String nom;
    private final double salaire;

    public Employe(String nom, double salaire) {
        this.nom = Objects.requireNonNull(nom, "Le nom ne peut pas être null");
        if (salaire < 0) {
            throw new IllegalArgumentException("Le salaire ne peut pas être négatif");
        }
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public double getSalaire() {
        return salaire;
    }

    @Override
    public double calculerSalaire() {
        return salaire;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' +
                ", salaire=" + salaire +
                '}';
    }
}
