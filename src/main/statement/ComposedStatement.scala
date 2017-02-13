package main.statement

/**
  * Permet de représenter des propositions composées de plusieurs informations,
  * Le texte de la proposition correspond alors à l'énumération des différents
  * textes, séparées par une chaine de séparation préalablement définie.
  */
class ComposedStatement(val separator: String) extends Statement {
  /** Le constructeur de texte de cette proposition */
  private val builder: StringBuilder = new StringBuilder

  // REQUETE
  override def toString: String = builder.toString

  // COMMANDE
  /**
    * Ajoute une nouvelle sous-proposition à la fin du contenu actuel
    * de cette proposition
    *
    * @param s La sous-proposition à ajouter
    */
  def add(s: Statement) {
    if (builder.length > 0) {
      builder.append(separator)
    }
    builder.append(s.toString)
  }
}