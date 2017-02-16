package main.log

/**
  * Modélise un log. Un fichier log se décompose en trois parties
  * distinctes :
  *   1) Un indice (nombre réel) désignant la valeur d'un certain label
  *   2) Une entête contenant des informations propres au log (date, heure, ... )
  *   3) Un contenu, dont la forme et le texte dépend de la nature du log
  */
trait Log {
  /**
    * Renvoie la valeur du label associé au log
    */
  def getLabel : Double

  /**
    * Renvoie la partie correspondant à l'entête du log
    */
  def getHeader : String

  /**
    * Renvoie la partie correspondant au contenu textuel du log
    */
  def getContent : String

  /**
    * Renvoie la chaîne correspondant à l'intégralité du contenu du log
    */
  def toString : String
}
