package fr.sdv.builder;

import fr.sdv.factory.Unite;

/**
 * Représente un produit construit par ProduitBuilder.
 */
public class Produit {

    private final int id;
    private final String nom;
    private final int quantite;
    private final double prix;
    private final ProduitType type;
    private final Unite unite;

    public Produit(int id, String nom, int quantite, double prix, ProduitType type, Unite unite) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
        this.type = type;
        this.unite = unite;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getPrix() {
        return prix;
    }

    public ProduitType getType() {
        return type;
    }

    public Unite getUnite() {
        return unite;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", quantite=" + quantite +
                ", prix=" + prix +
                ", type=" + type +
                ", unite=" + unite +
                '}';
    }
}
