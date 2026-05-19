package org.sebsy.strategy;

public class Tri {

    private TriStrategy strategie;

    public Tri() {
    }

    public Tri(TriStrategy strategie) {
        this.strategie = strategie;
    }

    public void setStrategie(TriStrategy strategie) {
        this.strategie = strategie;
    }

    public void trier(Integer[] arr) {
        if (strategie == null) {
            throw new IllegalStateException("La stratégie de tri n'a pas été initialisée.");
        }
        strategie.trier(arr);
    }

    public void exec(int typeTri, Integer[] arr) {
        setStrategie(strategiePour(typeTri));
        trier(arr);
    }

    private TriStrategy strategiePour(int typeTri) {
        switch (typeTri) {
            case 1:
                return new BubbleSortStrategy();
            case 2:
                return new InsertionSortStrategy();
            case 3:
                return new SelectionSortStrategy();
            default:
                throw new IllegalArgumentException("Type de tri inconnu : " + typeTri);
        }
    }
}
