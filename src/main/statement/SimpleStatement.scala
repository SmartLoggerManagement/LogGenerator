package main.statement

/**
  * Définit une proposition basée sur une information unique
  */
class SimpleStatement private[statement](val `object`: T) extends Statement {
  /** La chaîne représentant l'objet décrit par cette proposition */
  private val content: String = `object`.toString

  // REQUETE
  override def toString: String = content
}