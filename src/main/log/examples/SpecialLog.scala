package main.log.examples

import main.generator.examples.RandomIntGenerator
import main.log.{Log, TextBuilder}

/**
  * Construit un log décrivant le danger que représente une personne
  * en fonction de ses attributs S.P.E.C.I.A.L et son karma.
  */
class SpecialLog extends Log {
  // ATTRIBUTS
  /** Le générateur des valeurs de S.P.E.C.I.A.L */
  private val attrGen = new RandomIntGenerator(1, 10)

  /** La table des caractéristiques */
  private val caracs: Map[String, Int] = defineKeys
  private def defineKeys = {
    var caracs = Map.empty[String,Int]
    caracs += ("Strength" -> attrGen.getValue)
    caracs += ("Perception" -> attrGen.getValue)
    caracs += ("Endurance" -> attrGen.getValue)
    caracs += ("Charisma" -> attrGen.getValue)
    caracs += ("Intelligence" -> attrGen.getValue)
    caracs += ("Agility" -> attrGen.getValue)
    caracs += ("Luck" -> attrGen.getValue)
    caracs += ("Karma" -> new RandomIntGenerator(-1000, 1000).getValue)
    caracs
  }


  // DEFINITION DU CONTENU DU LOG
  /** Le contenu du log */
  var builder = new TextBuilder()
  for (key <- caracs.keys) builder.add(key + " = " + caracs(key))
  private val content = builder.toString


  // REQUETES
  /**
    * Rédéfinition du label qui représente ici le danger potentiel
    * de la personne décrite par le log.
    */
  override def getLabel: Double = {
    // Danger de par son Karma
    var label = caracs("Karma") / 500.0

    // Danger de par son SPECIAL
    var sum = 0
    for ((_, v) <- caracs filterKeys (x => !x.equals("Karma"))) sum += v
    label += sum / 70.0
    label
  }

  override def getContent : String = content
}
