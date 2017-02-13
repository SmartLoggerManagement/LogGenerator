package main.statement

/**
  * Modélise une proposition. Une proposition représente une suite d'informations
  * (mots, nombres, date, etc...) sous forme textuelle, en énumérant
  * toutes les informations qu'elle contient.
  */
trait Statement {
  // REQUETES
  /**
    * Renvoie la description textuelle associée à cette proposition
    */
  def toString: String
}
