package fr.sdv.composite;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompositeTest {

    @Test
    public void testCalculSalaireServiceComposite() {
        Service dsin = new Service("DSIN");
        Service bigData = new Service("Big Data");
        Service javaDev = new Service("Java Dev");

        Employe directrice = new Employe("Cécile RASPEY", 10000.0);
        Employe sousDirecteur = new Employe("Bilel BECHKAR", 8000.0);
        Employe chefBigData = new Employe("JB RANMEY", 7500.0);
        Employe concepteur = new Employe("Jane DOE", 3500.0);
        Employe chefJavaDev = new Employe("KEVIN GUINEAU", 7500.0);
        Employe leadDev = new Employe("Paul Martin", 3500.0);

        bigData.ajouter(chefBigData);
        bigData.ajouter(concepteur);
        javaDev.ajouter(chefJavaDev);
        javaDev.ajouter(leadDev);

        dsin.ajouter(directrice);
        dsin.ajouter(sousDirecteur);
        dsin.ajouter(bigData);
        dsin.ajouter(javaDev);

        assertEquals(40000.0, dsin.calculerSalaire(), 0.0);
        assertEquals(11000.0, bigData.calculerSalaire(), 0.0);
        assertEquals(11000.0, javaDev.calculerSalaire(), 0.0);
    }
}
