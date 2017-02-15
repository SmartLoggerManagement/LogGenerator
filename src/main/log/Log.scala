package main.log

/**
  * Modélise un log. Un fichier log se décompose en trois parties
  * distinctes :
  *   1) Un indice (nombre réel) désignant la valeur d'un certain label
  *   2) Une entête contenant des informations propres au log (date, heure, ... )
  *   3) Un contenu, dont la forme et le texte dépend de la nature du log
  */
abstract class Log {
  // CONSTRUCTION
  /** Le constructeur de texte de l'entête du log */
  protected var headerBuild: TextBuilder = new TextBuilder

  /** Le constructeur de texte du contenu du log */
  protected var contentBuild: TextBuilder = new TextBuilder


  // REQUETES
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
  def toString : String = {
    var main = new TextBuilder()
    main.add(getLabel)
    main.add(getHeader)
    main.add(getContent)
  }


  // OUTILS
  /**
    * Définit comment sera construit le partie textuelle
    * correspondant à l'entête du log
    */
  def defineHeader() {}

  /**
    * Définit comment sera construit le partie textuelle
    * correspondant au contenu du log
    */
  def defineContent() {}
}
