package ru.otus.module1

import java.io.{BufferedReader, Closeable, File}
import scala.io.{BufferedSource, Source}
import scala.runtime.Nothing$
import scala.util.{Try, Using}


object type_system {

  /**
   * Scala type system
   *
   */


  def absurd(v: Nothing) = ???


  // Generics


  lazy val file: File = File("ints.txt")
  lazy val source: BufferedSource = Source.fromFile(file)

  lazy val lines = try source.getLines().toList finally source.close()

  def ensureClose[S, R](source: S)(release: S => Any)(use: S => R): R =
    try use(source) finally release(source)

  lazy val lines2 = ensureClose(source)(_.close()){s =>
    s.getLines().toList

  }


  trait CanFly:
    def fly(): String = "Flying high"

  trait CanSwim:
    def swim(): String = "Swimming..."

  class Duck (val color: String) extends CanFly, CanSwim

  object Duck:
    def greyDuck: Duck = Duck("Grey")

  val duck = Duck.greyDuck


  def treat(o: CanFly & CanSwim) = {
    println(o.fly())
    println(o.swim())
  }

  treat(duck)


  sealed trait Input
  case class StringInput(str: String) extends Input
  case class IntInput(str: Int) extends Input
  case class BooleanInput(str: Boolean) extends Input
  
  def parseInput(input: UserInput): String = input match {
    case s: String => "String"
    case s: Int => "Int"
    case s: Boolean => "Boolean"
  }
  
  parseInput("Hello")
  parseInput(10)
  parseInput(true)
  
  // type alias
  
  type UserInput = String | Int | Boolean
  
  
  // dependent types
  
  trait Identifiable:
    type Id
    def id: Id
  
  trait Entity extends Identifiable
  
  class Payment(_id: Int) extends Entity:
    override type Id = Int

    override def id: Id = _id
    
  def getEntityById(entity: Entity) = ???

    /**
   * case class
   *
   */

   case class User(id: Int, email: String)

   val user = User(1, "foo@gmail.com")
   val user2 = user.copy(id = 2)







  class A {
    def foo() = "A"
  }

  trait B extends A {
    override def foo() = "B" + super.foo()
  }

  trait C extends B {
    override def foo() = "C" + super.foo()
  }

  trait D extends A {
    override def foo() = "D" + super.foo()
  }

  trait E extends C {
    override def foo(): String = "E" + super.foo()
  }

  // A -> D -> B -> C
  val v = new A with D with C with B


   // A -> B -> C -> E -> D
  val v1 = new A with E with D with C with B
  // DECBA
}