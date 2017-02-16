package main.log.models

import main.log.Log

/**
  * Réalise une fabrique de logs. La fabrique de logs définit la constrution
  * d'un log en suivant un format de texte bien précis (en redéfinissant les méthodes
  * correspondantes dans la définition de la classe associé au type de log souhaité)
  */
object LogBuilder {
  def getMeteoLog: Log = new MeteoLog
}
