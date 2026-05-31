package ru.otus.module1

import ru.otus.homeworks.hw02.Urn

object App_hw02 {
  def main(args: Array[String]): Unit = {

    val experimentSize = 10000
    val experiment: List[Urn] = List.fill(experimentSize)(new Urn)
    val result: List[Boolean] = experiment.map(_.choice())

    val successCounts = result.count(_ == true)
    val totalCount = experimentSize
    val check = successCounts.toDouble / totalCount

    println(f"Всего экспериментов: $totalCount%d")
    println(f"Успешных исходов:  $successCounts%d")
    println(f"Вероятность с успешным выбором: $check%.4f")
  }
}
