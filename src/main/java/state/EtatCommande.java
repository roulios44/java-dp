package state;

/**
 * Interface d'état pour la commande.
 */
public interface EtatCommande {

    void ajouterProduit(Commande commande, Produit produit);

    double payer(Commande commande);

    void livrer(Commande commande, String adresse);

    void annuler(Commande commande);

    StatutCommande getStatut();
}
