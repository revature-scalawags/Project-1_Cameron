import com.typesafe.scalalogging.LazyLogging
object Main extends App with LazyLogging {
  logger.info("New program run start")
  var userInput = ""
  println(
    "\nWelcome, the following options below are avilable to you:\n" +
      "\tpull:\tPulls the data from the website source.\n" +
      "\twrite:\tWrites the data to the Hadoop cluster.\n" +
      "\tlist:\tlists all entries in the cluster.\n" +
      "\tquery:\tQueries the database using standard SQL formatting.\n" +
      "\texit:\tExits the program."
  )
  while (userInput != "exit") {
    println("Please enter a command: ")
    userInput = scala.io.StdIn.readLine()
    logger.info(s"user input registered: '$userInput'.")
    userInput match {
      case "pull"  => pull()
      case "write" => write()
      case "list"  => list()
      case "query" => query()
      case "exit"  => println("Exiting Program...")
      case _       => {
        logger.error(s"Invalid input entered: '$userInput'.")
        println("Input not recognized.")
    }
    }
  }

  /** pull
	* Pulls data from the website source.
	*/
  def pull() {
    logger.info("running 'pull' function.")

    logger.info("'pull' function complete.")
  }

  /** write
	* Writes the data to the hadoop cluster
	*/
  def write() {
    logger.info("running 'write' function.")

    logger.info("'write' function complete.")
  }

  /** list
	* Lists all of the entries in the hadoop database in the CLI
	*/
  def list() {
    logger.info("running 'list' function.")
    
    logger.info("'list' function complete.")
  }

  /** query
	* Queries the database using arguements parsed from the CLI
	*/
  def query() {
    logger.info("running 'query' function.")

    logger.info("'query' function complete.")
  }
}
