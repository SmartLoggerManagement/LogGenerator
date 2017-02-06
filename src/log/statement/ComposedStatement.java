package log.statement;

/**
 * Permet de représenter des propositions composées de plusieurs informations,
 * Le texte de la proposition correspond alors à l'énumération des différents
 * textes, séparées par une chaine de séparation préalablement définie.
 */
class ComposedStatement implements Statement {
    // ATTRIBUTS
    /** Le constructeur de texte de cette proposition */
    private final StringBuilder builder;

    /** La chaîne de séparation utilisée pour produire le texte */
    private final String separator;


    // CONSTRUCTEUR
    public ComposedStatement(String separator) {
        this.separator = separator;
        builder = new StringBuilder();
    }


    public ComposedStatement() {
        this(" ");
    }


    // REQUETES
    public String toString() {
        return builder.toString();
    }


    // COMMANDES
    /**
     * Ajoute une nouvelle sous-proposition à la fin du contenu actuel
     * de cette proposition
     *
     * @param s La sous-proposition à ajouter
     */
    public void add(Statement s) {
        if (builder.length() > 0) builder.append(separator);
        builder.append(s.toString());
    }
}
