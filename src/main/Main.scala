package main

import main.generator.{Generator, SeqGenerator}
import main.log.Log
import main.log.models.LogBuilder

/**
  * Objet MAIN !
  */
object Main {
  def main(args: Array[String]): Unit = {
    // Mécanisme de génération des log
    val generator = new SeqGenerator[Log](new Generator[Log] {
      override def getValue = LogBuilder.getMeteoLog
    }, 10)

    // Affichage sur la sortie standard
    for (log <- generator.getValue) println(log)
  }
}
