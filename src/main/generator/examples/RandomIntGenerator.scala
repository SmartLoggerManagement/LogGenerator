package main.generator.examples

import main.generator.Generator

/**
  * Génère un nouveau nombre entier de manière aléatoire, dont
  * la valeur est comprise dans un certain intervalle donné
  */
class RandomIntGenerator(val min: Int, val max: Int) extends Generator[Int] {
  // CONSTRUCTION
  /**
    * Construit un nouveau générateur dont les valeurs générées,
    * appartiendront à l'intervalle [min, max] spécifié.
    *
    * @param min La borne inférieure de l'intervalle de génération
    * @param max La borne supérieure de l'intervalle de génération
    */
  assert(min <= max)

  /**
    * Construit un nouveau générateur de valeurs sans bornes, i.e
    * les valeurs générées couvriront tout l'intervalle de définition
    * des nombres entiers de type scala Int.
    */
  def this() {
    this(Integer.MIN_VALUE, Integer.MAX_VALUE)
  }

  // COMMANDE
  def getValue = min + (Math.random * (max - min + 1).toDouble).asInstanceOf[Int]
}