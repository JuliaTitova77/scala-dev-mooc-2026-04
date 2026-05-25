package ru.otus.homeworks.hw01

object App {
  def main(args: Array[String]): Unit = {
    println("Hello world")
    val f = hof.logRunningTime(hof.dumb)
    f("Oops")    
    val list1 = List(1,2,3)
    val list2 = List(7,8,9)
    val zipped = list1.zip(list2)    
    
  }
}
