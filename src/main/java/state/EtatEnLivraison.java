package state;

/**
 * État EN_LIVRAISON de la commande.
 */
public class EtatEnLivraison implements EtatCommande {

    @Override
    public void ajouterProduit(Commande commande, Produit produit) {
        throw new IllegalStateException("Impossible d'ajouter un produit lorsque la commande est en cours de livraison.");
    }

    @Override
    public double payer(Commande commande) {
        throw new IllegalStateException("La commande est déjà en cours de livraison et ne peut plus être payée.");
    }

    @Override
    public void livrer(Commande commande, String adresse) {
        throw new IllegalStateException("La commande est déjà en cours de livraison.");
    }

    @Override
    public void annuler(Commande commande) {
        throw new IllegalStateException("La commande est déjà en cours de livraison et l'annulation est impossible.");
    }

    @Override
    public StatutCommande getStatut() {
        return StatutCommande.EN_LIVRAISON;
    }
}
