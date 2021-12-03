// --== CS400 File Header Information ==--
// Name: Elias Verdun
// Email: esverdun@wisc.edu
// Team: BG
// Role: Back End
// TA: Brianna Cochran
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;
import java.io.File;
import java.util.UUID;

/**
 * @author Eli Verdun
 * This class is meant allow to create, access data, and login users
 * as well as create and access user tickets
 */
public class BackEnd2 {
    
    public Hashtable<String, User> users = new Hashtable<>(); // store users by userName
    public Hashtable<String, Ticket> tickets = new Hashtable<>(); // store tickets by id
    private CSVReader csvReader = new CSVReader();
    private File usersFile = new File("hashtable1.csv");
    private File ticketsFile = new File("hashtable2.csv");

    /**
     * Extracts users and tickets from two csv files and stores them properly in hashtables with all new users being added
     */
    public void readCSV() {
	csvReader.readCSVFiles(usersFile, ticketsFile);
	users = csvReader.getUserTable();
	tickets = csvReader.getTicketTable();
    }
    
    /**
     * @param name user's name
     * @param email user's email
     * @param password user's password
     * @isAdmin true if user has Admin permissions
     * @return true if user is sucessfully added
     *
     * Store new users in hashtable with key of their username
     * and all their data stored
     */
    public boolean createNewUser(String name, String email, String userName, String password,  boolean isAdmin) {
        User user = new User(name, email, password, isAdmin);
	if (users.contains(userName)) return false; // user already exists in table
	users.put(userName, user); // create new user and put in table
	csvReader.addNewUser(userName, user, usersFile);
	return true;
    }

    /**
     * @param userName user log in id
     * @param password user log in password
     * @return User returns user that matches unique userName and password combination
     * Returns user that matches userName and password combination
     */
    public User login(String userName, String password) { // validate that user Info matches to login
	readCSV();
	User user = users.get(userName); // access user info under userName
	if (user == null) return null;
	if (password.equals(user.getPassword())) { // if password is correct, return user
	    return user;
	}
	return null;
	    }

    /**
     * @param userName userName to get user info
     * @return string representation of user info
     * Calls print method from user object to return user info
     */
    public LinkedList<Ticket> getUserTickets(String userName) {
	readCSV();
	User user = users.get(userName);
	if (user == null) return null;
	return user.getUserTickets(); // LinkedList of user tickets
    }

    /**
     * @param userName user name of user creating new ticket
     * @param issue title of ticket (problem)
     * @param details details of ticket 
     * @return true if ticket is successfully added to hashtable
     *
     * Creates a new ticket and adds to hashtable if ticket is not previously contained
     */
    public boolean createNewTicket(String userName, String issue, String details, boolean isResolved) {
	Ticket ticket = new Ticket(userName, issue, details, isResolved);
	if (tickets.contains(ticket.getID())) {
		return false; // ticket already contained in table
	    }
	tickets.put(ticket.getID(), ticket);
	csvReader.addNewTicket(ticket, ticketsFile);
	return true;
    }

    /**
     * @param userName users unique username
     * @param issue title of ticket issue
     * @param details information of problem
     * @return true if ticket sucessfully added
     * Second constructor without status of ticket as parameter - auto set to open ticket
     * 
     */
    public boolean createNewTicket(String userName, String issue, String details) {
	Ticket ticket = new Ticket(userName, issue, details);
	if (tickets.contains(ticket.getID())) {
	    return false; // ticket already conained in table
	}
	tickets.put(ticket.getID(), ticket);
	csvReader.addNewTicket(ticket, ticketsFile);
	return true;
    }

    /**
     * @param ID ID code of ticket being searched for
     * Returns ticket object based on ID
     */
    public Ticket getTicket(String ID) {
	return tickets.get(ID);
    }

    /**
     * @param ID ID of ticket that is being closed
     * @return true if ticket successfully closed
     * Changes status of ticket from open to close by acessing it by ID
     */
    public boolean resolveTicket(String ID) {
	Ticket ticket = tickets.get(ID);
	if(ticket == null) {
	    ticket.setStatus(true);
	    return true;
	}
	return false;
    }

    /**
     * @return String representation of open tickets
     * Creates linked list of all tickets and filters down to return all open tickets
     */
    public LinkedList<Ticket> getOpenTickets() {
	Set<String> allTix = tickets.keySet();
	LinkedList<Ticket> openTix = new LinkedList();
	String[] temp = allTix.toString().substring(1, allTix.toString().length() -1).split(".");
	for (String ID : temp) {
	    Ticket ticket = getTicket((ID.trim()));
	    if (ticket != null && ticket.getStatus() != true) {
		openTix.add(ticket);
	    }
	}
	return openTix;
    }
	
    
}
