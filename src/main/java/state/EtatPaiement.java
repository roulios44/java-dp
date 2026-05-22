package state;

/**
 * État PAIEMENT de la commande.
 */
public class EtatPaiement implements EtatCommande {

    @Override
    public void ajouterProduit(Commande commande, Produit produit) {
        throw new IllegalStateException("Impossible d'ajouter un produit lorsque la commande est en paiement.");
    }

    @Override
    public double payer(Commande commande) {
        throw new IllegalStateException("La commande a déjà été payée et est en attente de livraison.");
    }

    @Override
    public void livrer(Commande commande, String adresse) {
        commande.setAdresse(adresse);
        commande.setEtat(new EtatEnLivraison());
    }

    @Override
    public void annuler(Commande commande) {
        commande.setEtat(new EtatAnnulee());
    }

    @Override
    public StatutCommande getStatut() {
        return StatutCommande.PAIEMENT;
    }
}
