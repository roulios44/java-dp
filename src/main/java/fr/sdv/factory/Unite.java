package fr.sdv.factory;

/**
 * Énumération représentant les unités de mesure
 */
public enum Unite {
    MICRO_GRAMMES("µg"),
    MILLI_GRAMMES("mg");

    private final String symbole;

    Unite(String symbole) {
        this.symbole = symbole;
    }

    public String getSymbole() {
        return symbole;
    }
}
