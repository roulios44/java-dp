package state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class CommandeTest {

    @Test
    public void testCommandeCycleNominal() {
        Commande commande = new Commande();
        commande.ajouterProduit(new Produit("Produit A"));
        commande.ajouterProduit(new Produit("Produit B"));

        assertEquals(StatutCommande.CREATION, commande.getStatut());

        double total = commande.payer();
        assertEquals(1.0, total, 0.0);
        assertEquals(StatutCommande.PAIEMENT, commande.getStatut());

        commande.livrer("12 rue de Paris");
        assertEquals(StatutCommande.EN_LIVRAISON, commande.getStatut());
        assertEquals("12 rue de Paris", commande.getAdresse());
    }

    @Test
    public void testAnnulerDepuisCreation() {
        Commande commande = new Commande();
        commande.ajouterProduit(new Produit("Produit A"));

        commande.annuler();
        assertEquals(StatutCommande.ANNULEE, commande.getStatut());
    }

    @Test
    public void testAnnulerDepuisPaiement() {
        Commande commande = new Commande();
        commande.ajouterProduit(new Produit("Produit A"));
        commande.payer();

        commande.annuler();
        assertEquals(StatutCommande.ANNULEE, commande.getStatut());
    }

    @Test
    public void testAnnulerEnLivraisonImpossible() {
        Commande commande = new Commande();
        commande.ajouterProduit(new Produit("Produit A"));
        commande.payer();
        commande.livrer("12 rue de Paris");

        IllegalStateException exception = assertThrows(IllegalStateException.class, commande::annuler);
        assertEquals("La commande est déjà en cours de livraison et l'annulation est impossible.", exception.getMessage());
    }

    @Test
    public void testAnnulerDejaAnnuleeImpossible() {
        Commande commande = new Commande();
        commande.annuler();

        IllegalStateException exception = assertThrows(IllegalStateException.class, commande::annuler);
        assertEquals("La commande a déjà été annulée.", exception.getMessage());
    }
}
