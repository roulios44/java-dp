package fr.sdv.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class FactoryTest {

    @Test
    public void testCreerIngredient() {
        Element element = ElementFactory.creerElement(
            ElementType.INGREDIENT,
            "Farine",
            500.0,
            Unite.MILLI_GRAMMES
        );

        assertNotNull(element);
        assertTrue(element instanceof Ingredient);
        assertEquals("Farine", element.getNom());
        assertEquals(500.0, element.getValeur(), 0.0);
        assertEquals(Unite.MILLI_GRAMMES, element.getUnite());
    }

    @Test
    public void testCreerAllergene() {
        Element element = ElementFactory.creerElement(
            ElementType.ALLERGENE,
            "Arachide",
            10.0,
            Unite.MICRO_GRAMMES
        );

        assertNotNull(element);
        assertTrue(element instanceof Allergene);
        assertEquals("Arachide", element.getNom());
        assertEquals(10.0, element.getValeur(), 0.0f);
        assertEquals(Unite.MICRO_GRAMMES, element.getUnite());
    }

    @Test
    public void testCreerAdditif() {
        Element element = ElementFactory.creerElement(
            ElementType.ADDITIF,
            "E300",
            100.0,
            Unite.MILLI_GRAMMES
        );

        assertNotNull(element);
        assertTrue(element instanceof Additif);
        assertEquals("E300", element.getNom());
        assertEquals(100.0, element.getValeur(), 0.0f);
        assertEquals(Unite.MILLI_GRAMMES, element.getUnite());
    }

    @Test
    public void testFactoryReturnsDifferentInstances() {
        Element ingredient = ElementFactory.creerElement(
            ElementType.INGREDIENT,
            "Sucre",
            200.0,
            Unite.MILLI_GRAMMES
        );

        Element allergene = ElementFactory.creerElement(
            ElementType.ALLERGENE,
            "Gluten",
            50.0,
            Unite.MICRO_GRAMMES
        );

        Element additif = ElementFactory.creerElement(
            ElementType.ADDITIF,
            "E200",
            75.0,
            Unite.MILLI_GRAMMES
        );

        assertFalse(ingredient.getClass().equals(allergene.getClass()));
        assertFalse(allergene.getClass().equals(additif.getClass()));
        assertFalse(ingredient.getClass().equals(additif.getClass()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactoryWithNullType() {
        ElementFactory.creerElement(null, "Test", 100.0, Unite.MILLI_GRAMMES);
    }

    @Test
    public void testElementHierarchy() {
        Element ingredient = ElementFactory.creerElement(
            ElementType.INGREDIENT,
            "Riz",
            300.0,
            Unite.MILLI_GRAMMES
        );

        assertTrue(ingredient instanceof Element);
        assertTrue(ingredient instanceof Ingredient);
    }
}
