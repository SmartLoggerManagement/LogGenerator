package main.generator.examples

import main.generator.Generator

/**
  * Génère une chaine de manière aléatoire, décrivant une
  * heure au format HH:MM:SS
  */
class RandomHourTextGenerator extends Generator[String] {
  // ATTRIBUTS
  /** Le générateur du nombre de secondes caractéristique de l'heure à générer */
  private val generator: Generator[Int] = new RandomIntGenerator(0, 86400)

  // COMMANDE
  def getValue:String = {
    val s = generator.getValue
    "%02d:%02d:%02d".format(s/3600, (s % 3600)/60, s%60)
  }
}