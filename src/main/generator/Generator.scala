package main.generator

/**
  * Modélise le comportement d'un générateur d'objets.
  * Sa fonction est très simple : offrir une méthode permettant de créer
  * un nouvel objet, selon sa propre logique de construction
  * (aléatoire, déterministe, ...)
  *
  * @tparam E Le type des objets générés
  */
trait Generator[E] {
  /**
    * Construit une nouvelle valeur
    */
  def getValue : E
}
