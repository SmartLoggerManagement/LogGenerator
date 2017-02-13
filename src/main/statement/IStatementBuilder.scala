package main.statement

/**
  * Created by caronfr1 on 13/02/17.
  */
trait IStatementBuilder {
  /** Renvoie la proposition associée à ce constructeur **/
  def toStatement: Statement

  /** Renvoie le texte correspondant à la proposition construite, jusqu'à présent */
  def toString: String

  // COMMANDES
  /**
    * Rajoute un nouvel élément simple à la proposition (sous sa représentation texte)
    *
    * @param e Le nouvel élément à ajouter à la proposition
    */
  def append[E](e : E): Unit

  /**
    * Rajoute une liste d'éléments, à faire correspondre sous forme d'une unique proposition
    * (énumérations de valeurs)
    *
    * @param collection Les éléments à énumérer dans une sous-proposition
    * @param separator  La chaîne séparant les différents éléments de la collection.
    */
  def append[E](collection: Seq[E], separator: String): Unit
}
