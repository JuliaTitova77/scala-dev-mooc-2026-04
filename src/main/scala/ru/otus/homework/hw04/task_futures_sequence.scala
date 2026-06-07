package ru.otus.homework.hw04

import ru.otus.homework.hw04.HomeworksUtils.task

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

object task_futures_sequence {

  /** В данном задании Вам предлагается реализовать функцию fullSequence,
    * похожую на Future.sequence, но в отличие от нее,
    * возвращающую все успешные и не успешные результаты.
    * Возвращаемое тип функции - кортеж из двух списков,
    * в левом хранятся результаты успешных выполнений,
    * в правовой результаты неуспешных выполнений.
    * Не допускается использование методов объекта Await и мутабельных переменных var
    */

  /** @param futures список асинхронных задач
    * @return асинхронную задачу с кортежом из двух списков
    */
  def fullSequence[A](
      futures: List[Future[A]]
  )(implicit ex: ExecutionContext): Future[(List[A], List[Throwable])] = {
    task"Реализуйте метод `fullSequence`"
    val safeFutures: List[Future[Either[Throwable, A]]] = futures.map { f =>
      f.transform {
        case Success(value) => Success(Right(value))
        case Failure(error) => Success(Left(error))
      }
    }
    safeFutures
      .foldRight(Future.successful(List.empty[Either[Throwable, A]])) {
        case (currentFuture, accumulatedFuture) =>
          for {
            currentVal <- currentFuture
            accVal <- accumulatedFuture
          } yield currentVal :: accVal

      }
      .map { results =>
        (
          results.collect { case Right(value) =>
            value
          },
          results.collect { case Left(error) =>
            error
          }
        )
      }
  }
}
