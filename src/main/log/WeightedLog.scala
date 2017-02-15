package main.log

/**
  * Modélise un log pondéré. Un log pondéré voit son label être
  * directement déterminé à partir du texte présent dans son contenu
  * et dans son entête.
  * La valeur est déterminée par une (ou plusieurs) règles, représentées
  * comme des fonctions, qui si elles sont vérifiées par le contenu du log,
  * vont ajouter une certaine valeur (le poids), à la valeur totale du label
  */
abstract class WeightedLog(rules: Seq[(String => Double)]) extends Log {
  // CONSTRUCTION
  def this(rules: Seq[(String => Boolean)]) {
    this(weightRules(rules))
  }

  // REQUETE
  /**
    * Calcule la valeur du label, à partir des règles de pondération définies
    */
  override def getLabel: Double = {
    val txt = getLabel + getContent
    var label = 0

    for (r <- rules) label += r(txt)
    label
  }

  // OUTILS
  /**
    * Convertit une liste de règles booléennes en règles pondérées, en transformant
    * chaque règle de manière à renvoyer une valeur réelle (1.0 ou 0.0),
    * à la place du retour booléen initial
    *
    * @param booleanRules L'ensemble des règles à pondérer
    * @return L'ensemble des règles pondérés correspondante
    */
  private def weightRules(booleanRules: Seq[(String => Boolean)]) : Seq[(String => Double)] = {
    val rules:Seq[(String => Double)] = Seq.empty
    val weight:(Boolean => Double) = b => if (b) { 1 } else { 0 }

    for (r <- booleanRules) rules.+:((x:String) => weight(r(x)))
    rules
  }
}
