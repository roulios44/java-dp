package fr.sdv.builder;

import fr.sdv.factory.Unite;

/**
 * Builder fluent pour construire une instance de Produit.
 */
public class ProduitBuilder {

    private int id;
    private String nom;
    private int quantite;
    private double prix;
    private ProduitType type;
    private Unite unite = Unite.MILLI_GRAMMES;

    public ProduitBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public ProduitBuilder withNom(String nom) {
        this.nom = nom;
        return this;
    }

    public ProduitBuilder withQuantite(int quantite) {
        this.quantite = quantite;
        return this;
    }

    public ProduitBuilder withPrix(double prix) {
        this.prix = prix;
        return this;
    }

    public ProduitBuilder withType(ProduitType type) {
        this.type = type;
        return this;
    }

    public ProduitBuilder withUnite(Unite unite) {
        this.unite = unite;
        return this;
    }

    public Produit build() {
        validate();
        return new Produit(id, nom, quantite, prix, type, unite);
    }

    private void validate() {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalStateException("Le nom du produit est obligatoire.");
        }
        if (type == null) {
            throw new IllegalStateException("Le type de produit est obligatoire.");
        }
        if (quantite < 0) {
            throw new IllegalStateException("La quantité ne peut pas être négative.");
        }
        if (prix < 0) {
            throw new IllegalStateException("Le prix ne peut pas être négatif.");
        }
    }
}
