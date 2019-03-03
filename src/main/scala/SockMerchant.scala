import scala.collection.mutable

object SockMerchant extends App {
  override def main(args: Array[String]): Unit = {
    val pairs = sockMerchant(9, Array(10, 20, 20, 10, 10, 30, 50, 10, 20))
    print(pairs)
  }

  // Complete the sockMerchant function below.
  def sockMerchant(n: Int, ar: Array[Int]): Int = {
    val map = mutable.HashMap[Int, Int]()
    ar.foreach { elem =>
      val value = map.getOrElse(elem, 0)
      map(elem) = value + 1
    }
    map.values.map { value =>
      (value - (value % 2)) / 2
    }.sum
  }
}
