package main.generator.examples

import main.generator.Generator

/**
  * Génère un nouveau nombre réel à précision double de manière aléatoire,
  * dont la valeur est comprise strictement dans un certain intervalle donné
  */
class RandomDoubleGenerator(val min: Double, val max: Double) extends Generator[Double] {
  // CONSTRUCTION
  /**
    * Construit un nouveau générateur dont les valeurs générées,
    * appartiendront à l'intervalle ]min, max[ spécifié.
    *
    * @param min La borne inférieure de l'intervalle de génération
    * @param max La borne supérieure de l'intervalle de génération
    */
  assert(min <= max)

  /**
    * Construit un nouveau générateur de valeurs sans bornes, i.e
    * les valeurs générées couvriront tout l'intervalle de définition
    * des nombres réels de type scala Double.
    */
  def this() {
    this(Double.MinValue, Double.MaxValue)
  }

  // COMMANDE
  def getValue = min + Math.random * (max - min)
}