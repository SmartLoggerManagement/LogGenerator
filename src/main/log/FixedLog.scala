package main.log

/**
  * Définit les logs à pondération fixe, déterminée à la construction.
  */
class FixedLog(label:Double) extends AbstractLog {
  override def getLabel = label
}
