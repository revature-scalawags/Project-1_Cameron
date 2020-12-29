object Main extends App {
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
    userInput match {
      case "pull"  => println("###PLACEHOLDER###: TODO: implement 'pull'")
      case "write" => println("###PLACEHOLDER###: TODO: implement 'write'")
      case "list"  => println("###PLACEHOLDER###: TODO: implement 'list'")
      case "query" => println("###PLACEHOLDER###: TODO: implement 'query'")
      case "exit"  => println("Exiting Program...")
      case _       => println("Input not recognized, please try a different input.")
    }
  }
}
