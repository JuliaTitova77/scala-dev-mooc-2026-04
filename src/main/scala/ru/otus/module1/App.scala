package ru.otus.module1

object App {
  def main(args: Array[String]): Unit = {
    println("Hello world!")

    val f: String => Unit = hof.logRunningTime(hof.dumb)
    f("Ooops")
  }
}
