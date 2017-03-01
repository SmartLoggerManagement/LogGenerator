package main

import main.generator.{Generator, SeqGenerator}
import main.log.Log
import main.log.examples.SpecialLog

/**
  * Objet MAIN !
  * Réalise l'affichage d'un certain nombre de logs produit par le
  * format donné.
  */
object Main {
  def main(args: Array[String]): Unit = {
    // Mécanisme de génération des log
    val generator = new SeqGenerator[Log](new Generator[Log] {
      /*
       * Modifiez la surchage de cette fonction
       * pour indiquer le type de log à utiliser
       */
      override def getValue = new SpecialLog()
    }, 10) // Modifiez ce nombre pour augmenter/diminuer le nombre produit

    // Affichage des logs sur la sortie standard
    for (log <- generator.getValue) println(log)
  }s
}
