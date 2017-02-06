package log.statement;

import java.util.Collection;

/**
 * Permet de construire une proposition à partir de valeurs quelconques,
 * en gérant de facon simplifiée, les éventuelles imbrications possibles.
 */
public class StatementBuilder {
    // ATTRIBUTS
    /** La proposition principale, en cours de construction **/
    private final ComposedStatement main;


    // CONSTRUCTEUR
    public StatementBuilder() {
        main = new ComposedStatement();
    }


    // REQUÊTES
    /** Renvoie la proposition associée à ce constructeur **/
    public Statement toStatement() {
        return main;
    }

    /** Renvoie le texte correspondant à la proposition construite, jusqu'à présent */
    public String toString() {
        return main.toString();
    }

    // COMMANDES
    /**
     * Rajoute un nouvel élément simple à la proposition (sous sa représentation texte)
     *
     * @param e Le nouvel élément à ajouter à la proposition
     */
    public <E> void append(E e) {
        main.add(new SimpleStatement(e));
    }

    /**
     * Rajoute une liste d'éléments, à faire correspondre sous forme d'une unique proposition
     * (énumérations de valeurs)
     *
     * @param collection Les éléments à énumérer dans une sous-proposition
     * @param separator La chaîne séparant les différents éléments de la collection.
     */
    public <E> void append(Collection<E> collection, String separator) {
        assert collection != null;
        assert separator != null;

        ComposedStatement cs = new ComposedStatement(separator); {
            for (E e : collection) {
                cs.add(new SimpleStatement(e));
            }
        }

        main.add(cs);
    }
}
