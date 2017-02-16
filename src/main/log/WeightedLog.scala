package main.log

/**
  * Définit les logs à pondération variable. Ce type de log voit son label être
  * directement déterminé à partir du texte présent dans son contenu
  * et dans son entête.
  * La valeur est déterminée par une (ou plusieurs) règles, représentées
  * comme des fonctions, qui si elles sont vérifiées par le contenu du log,
  * vont ajouter une certaine valeur (le poids), à la valeur totale du label
  */
abstract class WeightedLog extends AbstractLog {
  // REQUETE
  /**
    * Renvoie l'ensemble des règles associées à la pondération
    * du contenu de ce type de log
    */
  protected def getRules(): Seq[(Unit => Double)]

  /**
    * Calcule la valeur du label, à partir des règles de pondération définies
    */
  override def getLabel: Double = {
    val txt = getLabel + getContent
    var label: Double = 0

    for (r <- getRules()) label += r()
    label
  }
}
