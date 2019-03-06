object CountingValleys extends App {

  override def main(args: Array[String]): Unit = {
    val valleys = countingValleys(12, "DDUUDDUDUUUD")
    print(valleys)
  }

  def countingValleys(n: Int, s: String): Int = {
    var valleyStarted = false
    var nrOfValleys = 0
    var groundLevel = 0

    s.toStream.zipWithIndex.foreach { char =>
      if (isGround(groundLevel) && char._1 == 'D') {
        if (valleyStarted) nrOfValleys += 1
        valleyStarted = true
      } else if (isGround(calculateGroundLevel(groundLevel, char._1)) && valleyStarted) {
        valleyStarted = false
        nrOfValleys += 1
      }
      groundLevel = calculateGroundLevel(groundLevel, char._1)
    }
    nrOfValleys
  }

  def calculateGroundLevel(level: Int, dir: Char): Int = {
    if (dir == 'D') level - 1
    else if (dir == 'U') level + 1
    else throw new RuntimeException("Not expected")
  }

  def isGround(level: Int) = level == 0

}
