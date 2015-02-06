import java.util.Random

object HelloWorld {

  def main(args: Array[String]) {

    val source = scala.io.Source.fromFile("quotes.txt", "UTF-8")
    val quotes = source.mkString.split("\n")

    val quotesList = quotesIntoList(quotes)
    val randomizedQuotes = randomizeQuotes(quotesList)

    randomizedQuotes.foreach(println)

    println("Hello, world!")
  }

  def quotesIntoList(quotes: Array[String]): List[String] = {

    var str = ""
    var quotesList = List[String]()

    for (i <- 0 until quotes.length) {

      if (quotes(i).trim.length > 0) {
        str = str + s"""${quotes(i)}""" + "\n"
      } else {
        quotesList = str.trim :: quotesList
        str = ""
      }
    }

    quotesList
  }

  def randomizeQuotes(quotes: List[String]): List[String] = {

    val t = quotes
    val t2 = t.zipWithIndex
    var tempQuotes = quotes
    var newQuotes = List[String]()

    val random = new Random(System.currentTimeMillis())
    var randomInt = 0

    for (i <- quotes.length to 1 by -1) {
      randomInt = random.nextInt(tempQuotes.length); println(tempQuotes.length)
      newQuotes = tempQuotes(randomInt) :: newQuotes
      tempQuotes = tempQuotes.drop(randomInt)
    }

    println(newQuotes.size)

    newQuotes
  }
}