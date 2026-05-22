package state;

import java.util.Objects;

/**
 * Représente un produit pouvant être ajouté à une commande.
 */
public class Produit {

    private final String nom;

    public Produit(String nom) {
        this.nom = Objects.requireNonNull(nom, "Le nom du produit ne peut pas être null");
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Produit{nom='" + nom + "'}";
    }
}
