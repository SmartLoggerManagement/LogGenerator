package log.statement;

/**
 * Définit une proposition basée sur une information unique
 */
class SimpleStatement implements Statement {
    // ATTRIBUTS
    /** La chaîne représentant l'objet décrit par cette proposition*/
    private final String content;


    // CONSTRUCTEUR
    <T> SimpleStatement(T object) {
        content = object.toString();
    }


    // REQUETE
    @Override
    public String toString() {
        return content;
    }
}
