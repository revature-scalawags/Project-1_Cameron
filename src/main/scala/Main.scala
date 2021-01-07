import com.typesafe.scalalogging.LazyLogging
import java.sql._

object Main extends App with LazyLogging {
  logger.info("New program run start")
  var userInput = ""
  println("Program started, connecting to hive jdbc...")

  var con: Connection = null
  try {
    val connectionString = "jdbc:hive2://localhost:10000/default"
    Class.forName("org.apache.hive.jdbc.HiveDriver")
    con = DriverManager.getConnection(connectionString, "", "")

  } catch {
    case e: Exception => e.printStackTrace()
  }

  val statement = con.createStatement()

  println("jdbc successfully connected, continuing to CLI.")
  println(
    "\nWelcome, the following options below are avilable to you:\n" +
      "\tq1 || q2 || q3:\truns a function that queries the hive jdbc based on\n" +
      "\t\tthe questions asked in the project's README file.\n" +
      "\tcustom:\tQueries the database using standard SQL formatting.\n" +
      "\texit:\tExits the program."
  )
  while (userInput != "exit") {
    println("Please enter a command: ")
    userInput = scala.io.StdIn.readLine()
    logger.info(s"user input registered: '$userInput'.")
    userInput match {
      case "q1"     => q1()
      case "q2"     => q2()
      case "q3"     => q3()
      case "custom" => query()
      case "exit"   => println("Exiting Program...")
      case _ => {
        logger.error(s"Invalid input entered: '$userInput'.")
        println("Input not recognized.")
      }
    }
  }

  /** q1
    * runs a query on the hive jdbc that answers the first question of the project readme
    */
  def q1() {
    logger.info("running 'q1' function.")
    println(
      "Running Question 1 in the connection: 'Which color of LEGO brick is used most across all sets?'\nNum_Sets\tColor"
    )

    var resultSet =
      statement.executeQuery(
        "SELECT i.color_id, count(*) as count, c.name as color FROM inventory_parts i JOIN colors c ON(i.color_id = c.id) GROUP BY color_id, name SORT BY count desc"
      ) //TODO: SQL Query execution here
    while (resultSet.next) {
      //This loop iterates each row of the resultSet until there are no more
      val count = resultSet.getString("count")
      val colorName = resultSet.getString("color")
      println(count + "\t" + colorName)
    }

    logger.info("'q1' function complete.")
  }

  /** q2
    * runs a query on the hive jdbc that answers the second question of the project readme
    */
  def q2() {
    logger.info("running 'q2' function.")
    println(
      "Running Question 2 in the connection: 'What are the top 10 parts used as spares for all sets?'\nCount\tPart Name"
    )

    var resultSet =
      statement.executeQuery(
        "select count(*) as c, p.name as name from inventory_parts i join parts p on(i.part_num=p.part_num) where is_spare=\"t\" group by  p.name sort by c desc limit 10"
      ) //TODO: SQL Query execution here
    while (resultSet.next) {
      //This loop iterates each row of the resultSet until there are no more
      val count = resultSet.getString("c")
      val partName = resultSet.getString("name")
      println(count + "\t" + partName)
    }

    logger.info("'q2' function complete.")
  }

  /** q3
    * runs a query on the hive jdbc that answers the third question of the project readme
    */
  def q3() {
    logger.info("running 'q3' function.")
    println(
      "Running Question 3 in the connection: 'What sets had the highest number of parts included in the year 2017?'\nSet Name\tCount"
    )

    var resultSet =
      statement.executeQuery(
        "select name, num_parts from sets where year=2017 sort by num_parts desc limit 10"
      ) //TODO: SQL Query execution here
    while (resultSet.next) {
      //This loop iterates each row of the resultSet until there are no more
      val name = resultSet.getString("name")
      val numParts = resultSet.getString("num_parts")
      println(name + "\t" + numParts)
    }

    logger.info("'q3' function complete.")
  }

  /** query
    * Queries the database using arguements parsed from the CLI.
    *
    * @note this has only been tested on select statements. Due to the format
    * of the while loop, the program will most likely crash if attempting to
    * run a non-select query since there is no resultset to parse.
    */
  def query() {
    logger.info("running 'query' function.")
    println("Please enter the query using standard HQL:")
    val queryInput = scala.io.StdIn.readLine()

    var resultSet =
      statement.executeQuery(queryInput) //TODO: SQL Query execution here
    val rsmd = resultSet.getMetaData()
    println(s"querying $queryInput")
    val colNum = rsmd.getColumnCount()
    while (resultSet.next) {
      for (i <- 1 to colNum) {
        if (i > 1)
          print(",\t")
        val colVal = resultSet.getString(i)
        print(colVal)
      }
      println("")
    }

    logger.info("'query' function complete.")
  }
  con.close()
}
