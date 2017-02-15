package main.generator

trait Generator[E] {
  /**
    * Construit une nouvelle valeur
    */
  def getValue : E
}
