package state;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import lombok.Data;

/**
 * Représente une commande utilisant le pattern State.
 */

public class Commande {

    private EtatCommande etat;
    private final List<Produit> produits;
    private String adresse;

    public Commande() {
        this.produits = new ArrayList<>();
        this.etat = new EtatCreation();
    }

    public void ajouterProduit(Produit produit) {
        Objects.requireNonNull(produit, "Le produit ne peut pas être null");
        etat.ajouterProduit(this, produit);
    }

    public double payer() {
        return etat.payer(this);
    }

    public void livrer(String adresse) {
        Objects.requireNonNull(adresse, "L'adresse de livraison ne peut pas être null");
        etat.livrer(this, adresse);
    }

    public void annuler() {
        etat.annuler(this);
    }

    public StatutCommande getStatut() {
        return etat.getStatut();
    }

    public List<Produit> getProduits() {
        return Collections.unmodifiableList(produits);
    }

    void ajouterProduitInterne(Produit produit) {
        produits.add(produit);
    }

    double calculerPrixTotal() {
        return produits.size() * 0.5;
    }

    void setEtat(EtatCommande etat) {
        this.etat = etat;
    }

    void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }
}
