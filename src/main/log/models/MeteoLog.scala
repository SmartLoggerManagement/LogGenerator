package main.log.models

import main.generator.{RandomDoubleGenerator, RandomIntGenerator}
import main.log.{AbstractLog, TextBuilder}

/**
  * Construit un log décrivant une application de gestion des
  * données météo
  */
class MeteoLog protected[models] extends AbstractLog {
  // ATTRIBUTS DU LOG
  /** La température */
  private val temperature:Double = new RandomDoubleGenerator(-10, 40).getValue

  /** La vitesse vent */
  private val windSpeed:Double = new RandomDoubleGenerator(0, 130).getValue

  /** L'heure du relevé (en secondes) */
  private val date:Int = new RandomIntGenerator(0, 86000).getValue


  // DEFINITION DU LABEL
  override def getLabel: Double = temperature / 10 + windSpeed / 100

  // ENTÊTE
  override def defineHeader() : TextBuilder = {
    val build = new TextBuilder(", ")
      build.add("Heure : " + date/3600 + ":" + (date % 3600)/60 + ":" + date%60)
      build.add("Température : " + temperature + "°C")
      build.add("Vitesse du vent : " + windSpeed + "km/h")
    build
  }

  // CONTENU : Pas de texte supplémentaire => Pas de rédéfinition
}