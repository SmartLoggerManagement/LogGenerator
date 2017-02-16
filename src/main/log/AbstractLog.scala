package main.log

/**
  * Factorise le comportement commun à tous les sous-types de logs existants
  */
abstract class AbstractLog extends Log {
  // CONSTRUCTION
  /** Le constructeur de texte de l'entête du log */
  protected var headerBuild: TextBuilder = defineHeader()

  /** Le constructeur de texte du contenu du log */
  protected var contentBuild: TextBuilder = defineContent()


  // REQUETES
  def getHeader : String = headerBuild.toString

  def getContent : String = contentBuild.toString

  override def toString : String = {
    val textBuilder = new TextBuilder()
    textBuilder.add(getLabel)
    textBuilder.add(getHeader)
    textBuilder.add(getContent)

    textBuilder.toString
  }


  // OUTILS
  /**
    * Définit comment sera construit le partie textuelle
    * correspondant à l'entête du log.
    * Vise à être rédéfinit dans les classes filles
    */
  protected def defineHeader() : TextBuilder = new TextBuilder

  /**
    * Définit comment sera construit le partie textuelle
    * correspondant au contenu du log
    * Vise à être rédéfinit dans les classes filles
    */
  protected def defineContent() : TextBuilder = new TextBuilder
}
