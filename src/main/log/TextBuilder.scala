package main.log

/**
  * Permet de construire des textes composées de plusieurs informations,
  * Le texte de la proposition correspond alors à l'énumération des différents
  * textes, séparées par une chaine de séparation préalablement définie.
  */
class TextBuilder(val separator: String) {
  // CONSTRUCTION
  /** Le constructeur de texte utilisé */
  private val builder: StringBuilder = new StringBuilder

  def this() = this(" ")

  // REQUETE
  override def toString: String = builder.toString

  // COMMANDE
  /**
    * Ajoute une portion de texte supplémentaire à la fin du contenu actuel,
    * à partir de la représentation textuelle d'un objet quelconque
    *
    * @param obj La sous-proposition à ajouter
    */
  def add(obj: Any) {
    if (builder.length > 0) {
      builder.append(separator)
    }
    builder.append(obj.toString)
  }

  /**
    * Ajoute une nouvelle sous-proposition à la fin du contenu actuel
    * de cette proposition
    *
    * @param collection La collection des objets à ajouter dans le texte
    * @param separator La chaine de séparation utilisée pour séparer les objets
    */
  def add(collection: Seq[Any], separator: String) {
    assert(collection != null)
    assert(separator != null)

    val cs: TextBuilder = new TextBuilder(separator) {
      collection.foreach(e => cs.add(e))
    }

    add(cs)
  }
}