package fr.sdv.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import fr.sdv.factory.Unite;
import org.junit.Test;

public class ProduitBuilderTest {

    @Test
    public void testBuildProduitNominal() {
        Produit produit = new ProduitBuilder()
            .withId(1)
            .withNom("Baguette")
            .withQuantite(10)
            .withPrix(1.25)
            .withType(ProduitType.ALIMENTAIRE)
            .withUnite(Unite.MILLI_GRAMMES)
            .build();

        assertNotNull(produit);
        assertEquals(1, produit.getId());
        assertEquals("Baguette", produit.getNom());
        assertEquals(10, produit.getQuantite());
        assertEquals(1.25, produit.getPrix(), 0.0);
        assertEquals(ProduitType.ALIMENTAIRE, produit.getType());
        assertEquals(Unite.MILLI_GRAMMES, produit.getUnite());
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildProduitSansNomDoitLeverException() {
        new ProduitBuilder()
            .withId(2)
            .withQuantite(5)
            .withPrix(2.50)
            .withType(ProduitType.NON_ALIMENTAIRE)
            .build();
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildProduitPrixNegatifDoitLeverException() {
        new ProduitBuilder()
            .withId(3)
            .withNom("Flûte")
            .withQuantite(2)
            .withPrix(-0.5)
            .withType(ProduitType.ALIMENTAIRE)
            .build();
    }
}
