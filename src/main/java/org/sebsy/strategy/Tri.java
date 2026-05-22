package org.sebsy.strategy;

public class Tri {

    private Strategy strategie;

    public Tri() {
    }

    public Tri(Strategy strategie) {
        this.strategie = strategie;
    }

    public void setStrategie(Strategy strategie) {
        this.strategie = strategie;
    }

    public void trier(Integer[] arr) {
        if (strategie == null) {
            throw new IllegalStateException("La stratégie de tri n'a pas été initialisée.");
        }
        strategie.trier(arr);
    }

    public void exec(SortType typeTri, Integer[] arr) {
        setStrategie(StrategyFactory.createStrategy(typeTri));
        trier(arr);
    }
}
