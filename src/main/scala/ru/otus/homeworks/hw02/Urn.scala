package ru.otus.homeworks.hw02

import scala.util.Random

class Urn(w: Int = 3, b: Int = 3) {
  private val urn: List[Int] = List.fill(w)(1) ++ List.fill(b)(0)
  private val rnd = new Random()
  def choice(): Boolean = {
    val selectable: List[Int] = rnd.shuffle(urn).take(2)
    selectable.contains(1)
  }
}
