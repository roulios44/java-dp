package state;

/**
 * État ANNULEE de la commande.
 */
public class EtatAnnulee implements EtatCommande {

    private static final String ERREUR = "La commande a déjà été annulée.";

    @Override
    public void ajouterProduit(Commande commande, Produit produit) {
        throw new IllegalStateException(ERREUR);
    }

    @Override
    public double payer(Commande commande) {
        throw new IllegalStateException(ERREUR);
    }

    @Override
    public void livrer(Commande commande, String adresse) {
        throw new IllegalStateException(ERREUR);
    }

    @Override
    public void annuler(Commande commande) {
        throw new IllegalStateException(ERREUR);
    }

    @Override
    public StatutCommande getStatut() {
        return StatutCommande.ANNULEE;
    }
}
