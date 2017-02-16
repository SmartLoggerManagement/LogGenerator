package main.generator

/**
  * Génère un nouveau not aléatoire à partir d'un alphabet
  *
  * @construct Construit un nouveau générateur de mots, de longueur comprise entre
  *   minLength et maxLength, et dont les lettres appartiennent
  *   à l'intervalle de lettres [minLetter, maxLetter] spécifié.
  *
  * @param minLength La longueur minimale des mots pouvant être générés
  * @param maxLength La longueur maximale des mots pouvant être générés
  * @param minLetter La longueur minimale des mots pouvant être générés
  * @param maxLetter La longueur maximale des mots pouvant être générés
  */
class RandomTextGenerator(minLength: Int, maxLength: Int, minLetter: Char, maxLetter: Char) extends Generator[String] {
  // CONSTRUCTION
  /** Le générateur de taille de mot */
  assert(minLength >= 0)
  assert(maxLength >= minLength)
  private val lengthGen : Generator[Int] = new RandomIntGenerator(minLength, maxLength)

  /** Le générateur de lettre */
  assert(maxLetter >= minLetter)
  private val letterGen : Generator[Int] = new RandomIntGenerator(minLetter, maxLetter)

  /**
    * Construit un nouveau générateur de mots, de longueur comprise entre
    * minLength et maxLength, et dont les lettres appartiennent
    * à l'alphabet standard (en minuscules).
    *
    * @param minLength La longueur minimale des mots pouvant être générés
    * @param maxLength La longueur maximale des mots pouvant être générés
    */
  def this(minLength: Int, maxLength: Int) = this(minLength, maxLength, 'a', 'z')

  /**
    * Construit un nouveau générateur de mots, de longueur comprise entre
    * 5 et 10, et dont les lettres appartiennent
    * à l'alphabet standard (en minuscules).
    */
  def this() = this(5, 10)

  // COMMANDE
  def getValue : String = {
    var txt = ""
    for (i <- 0 until lengthGen.getValue) {
      txt += letterGen.getValue.asInstanceOf[Char]
    }
    txt
  }
}