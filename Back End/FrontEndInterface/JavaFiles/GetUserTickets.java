// --== CS400 File Header Information ==--
// Name: Elan Graupe
// Email: graupe@wisc.edu
// Team: BG
// Role: Front End Developer 2
// TA: Brianna Cochran
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.util.LinkedList;

/**
 * Class called by website through CGI to get all the tickets that belong to a user
 * 
 * @author Elan Graupe
 *
 */
class GetUserTickets {

  /**
   * Main method called by CGI script to get tickets. Prints tickets as JSON to send back to website
   * through API
   * 
   * @param args - the username and password of the user in the following format:
   *             "userID=[userName]|[password]"
   */
  public static void main(String[] args) {
    try {
      String userID = args[0].split("=")[1]; // Parse the userID from the argument

      LinkedList<Ticket> tickets = getUserTickets(userID);
      String outputJSON = "";

      BackEnd2 backend = new BackEnd2(); // Create instance of back end and load CSV's to back
                                             // end from file
      backend.readCSV();

      for (Ticket t : tickets) { // Increment through all tickets and add them to JSON document
        String userName = t.getUserName();
        User user = backend.users.get(userName);
        outputJSON += "{\"customerName\":\"" + user.getName() + "\",\"customerEmail\":\""
            + user.getEmail() + "\",\"title\":\"" + t.getIssue() + "\",\"description\":\""
            + t.getDetails() + "\"}|";
      }

      System.out.print(outputJSON); // Print JSON to send back to website through API as JSON

    } catch (Exception e) {
      System.out.print("-1"); // Print -1 if user was not found
      e.printStackTrace();
    }
  }

  /**
   * Method to interface with back end and get all the tickets that belong to the user
   * 
   * @param userID - the username and password of the user in the following format:
   *               "[userName]|[password]"
   * @return a LinkedList of all the tickets
   */
  private static LinkedList<Ticket> getUserTickets(String userID) {
    BackEnd2 backend = new BackEnd2();
    return backend.getUserTickets(userID.split("\\|")[0]);
  }

}
