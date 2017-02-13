package main.statement

/**
  * Permet de construire une proposition à partir de valeurs quelconques,
  * en gérant de facon simplifiée, les éventuelles imbrications possibles.
  */
class StatementBuilder extends IStatementBuilder {
  /** La proposition principale, en cours de construction **/
  private val main: ComposedStatement = new ComposedStatement("")

  // REQUETES
  /** Renvoie la proposition associée à ce constructeur **/
  override def toStatement: Statement = main

  /** Renvoie le texte correspondant à la proposition construite, jusqu'à présent */
  override def toString: String = main.toString

  // COMMANDES
  /**
    * Rajoute un nouvel élément simple à la proposition (sous sa représentation texte)
    *
    * @param e Le nouvel élément à ajouter à la proposition
    */
  override def append[E](e: E) {
    main.add(new SimpleStatement(e))
  }

  /**
    * Rajoute une liste d'éléments, à faire correspondre sous forme d'une unique proposition
    * (énumérations de valeurs)
    *
    * @param collection Les éléments à énumérer dans une sous-proposition
    * @param separator  La chaîne séparant les différents éléments de la collection.
    */
  override def append[E](collection: Seq[E], separator: String) {
    assert(collection != null)
    assert(separator != null)

    val test = Seq.empty
    val cs: ComposedStatement = new ComposedStatement(separator) {
      collection.foreach((e: E) => cs.add(new SimpleStatement(e)))
    }

    main.add(cs)
  }
}