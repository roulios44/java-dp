package org.sebsy.strategy;

/**
 * Fabrique de stratégies de tri.
 */
public class StrategyFactory {

    public static Strategy createStrategy(SortType sortType) {
        if (sortType == null) {
            throw new IllegalArgumentException("Le type de tri ne peut pas être null");
        }

        switch (sortType) {
            case BUBBLE:
                return new BubbleSortStrategy();
            case INSERTION:
                return new InsertionSortStrategy();
            case SELECTION:
                return new SelectionSortStrategy();
            default:
                throw new IllegalArgumentException("Type de tri inconnu : " + sortType);
        }
    }
}
