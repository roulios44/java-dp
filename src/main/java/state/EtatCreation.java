package state;

/**
 * État CREATION de la commande.
 */
public class EtatCreation implements EtatCommande {

    @Override
    public void ajouterProduit(Commande commande, Produit produit) {
        commande.ajouterProduitInterne(produit);
    }

    @Override
    public double payer(Commande commande) {
        double total = commande.calculerPrixTotal();
        commande.setEtat(new EtatPaiement());
        return total;
    }

    @Override
    public void livrer(Commande commande, String adresse) {
        throw new IllegalStateException("La commande doit être en statut PAIEMENT pour être livrée.");
    }

    @Override
    public void annuler(Commande commande) {
        commande.setEtat(new EtatAnnulee());
    }

    @Override
    public StatutCommande getStatut() {
        return StatutCommande.CREATION;
    }
}
