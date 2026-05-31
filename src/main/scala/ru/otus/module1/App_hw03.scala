package ru.otus.module1

import ru.otus.homeworks.hw03.collectionsTask.*

object App_hw03 {
  def main(args: Array[String]): Unit = {
    println("Задание capitalizeIgnoringASCII")
    val str = List(
      "Оказывается",
      "ЗвУк",
      "КЛАВИШЬ",
      "печатной",
      "Машинки",
      "не",
      "СТАЛ",
      "ограничивающим",
      "фактором",
      "Lorem",
      "ipsum",
      "dolor",
      "sit",
      "amet"
    )
    val str1 = capitalizeIgnoringASCII(str)
    println(s"Результат text: $str1")
    println()

    println("Задание numbersToNumericString")
    val str2 = "Room 305, code 12"
    val str3 = numbersToNumericString(str2)
    println(s"Содержимое text: $str3")
    println()

    println("Задание intersectionAuto и filterAllLeftDealerAutoWithoutRight")
    val dealerOne = List(
      Auto("Toyota", "Camry"),
      Auto("Ford", "Focus"),
      Auto("Toyota", "Camry"),
      Auto("Honda", "Civic")
    )

    val dealerTwo = List(
      Auto("Ford", "Focus"),
      Auto("BMW", "X5"),
      Auto("BMW", "X5"),
      Auto("Audi", "A4")
    )

    println("--- ИСХОДНЫЕ БАЗЫ ДАННЫХ ---")
    println(s"Дилер 1 (${dealerOne.size} записей): ${dealerOne.mkString(", ")}")
    println(
      s"Дилер 2 (${dealerTwo.size} записей): ${dealerTwo.mkString(", ")}\n"
    )
    println(
      s"Машины, которые есть У ОБОИХ дилеров: \n${intersectionAuto(dealerOne, dealerTwo)}"
    )
    println()
    println(
      s"Машины ПЕРВОГО дилера, которых НЕТ у ВТОРОГО: \n${filterAllLeftDealerAutoWithoutRight(dealerOne, dealerTwo)}"
    )
  }
}
