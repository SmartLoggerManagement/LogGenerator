package main.log

/**
  * Modélise un log. Un fichier log se décompose en deux parties
  * distinctes :
  *   1) Un indice (nombre réel) désignant la valeur d'un certain label
  *   2) Un contenu, dont la forme et le texte dépend de la nature du log
  */
trait Log {
  /**
    * Renvoie la valeur du label associé au log
    */
  def getLabel : Double

  /**
    * Renvoie la partie correspondant au contenu textuel du log
    */
  def getContent : String

  /**
    * Renvoie la chaîne correspondant à l'intégralité du contenu du log
    */
  override def toString : String = new TextBuilder().
    add("%01.05f".format(getLabel)).
    add(getContent).toString
}
