package main.generator

/**
  * Modélise un générateur de tableau. Ce générateur itère
  * la fonction de génération d'un autre générateur donné, afin de fournir
  * une collection d'un certain nombre d'objets
  *
  * @tparam E Le type des objets manipulés
  */
class SeqGenerator[E](generator: Generator[E], length: Int) extends Generator[Seq[E]] {
  assert(generator != null);

  override def getValue : Seq[E] = {
    var seq = Seq.empty[E]

    for (i <- 0 until length) {
      seq = seq.+:(generator.getValue)
    }
    seq
  }
}
