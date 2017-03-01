package main.log.examples

import main.generator.examples.{RandomDoubleGenerator, RandomHourTextGenerator}
import main.log.{Log, TextBuilder}

/**
  * Construit un log décrivant une application fictive
  * de gestion des données météo
  */
class MeteoLog extends Log {
  // ATTRIBUTS DU LOG
  /** La température */
  private val temperature: Double = new RandomDoubleGenerator(-10, 40).getValue

  /** La vitesse vent */
  private val windSpeed: Double = new RandomDoubleGenerator(0, 130).getValue

  /** L'heure du relevé */
  private val date: String = new RandomHourTextGenerator().getValue

  // DEFINITION DU CONTENU DU LOG
  /** Le contenu du log */
  private val content = new TextBuilder()
    .add("Heure : " + date)
    .add("Température : %.2f°C".format(temperature))
    .add("Vitesse du vent : %.2f km/h".format(windSpeed))
    .toString

  // REQUETES
  override def getLabel: Double = temperature / 10.0 + windSpeed / 100.0

  override def getContent : String = content
}