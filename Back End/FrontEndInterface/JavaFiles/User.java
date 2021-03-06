// --== CS400 File Header Information ==--                                     
// Name: Elias Verdun                                                          
// Email: esverdun@wisc.edu                                                   
// Team: BG                                                                   
// Role: Back End                                                             
// TA: Brianna Cochran                                                        
// Lecturer: Gary Dahl                                                        
// Notes to Grader: <optional extra notes> 
import java.util.LinkedList;

/**
 * @author Eli Verdun
 * Creates user object to store user info
 */
public class User {
    private String name = "";
    private String email = "";
    private String password = "";
    private boolean isAdmin = false;
    private LinkedList<Ticket> userTickets;
    
    /**
     * @param name user's name
     * @param email user's email
     * @param password user's password
     * @param isAdmin user's admin status
     *
     * User constructor to create new user and store all necessary info
     */
    public User(String name, String email, String password, boolean isAdmin) {
	this.name = name;
	this.email = email;
	this.password = password;
	this.isAdmin = isAdmin;
	userTickets = new LinkedList<Ticket>();
    }
    /**
     * @return String of user name
     * Return user name
     */
    public String getName() {
	return name;
    }
    /**
     * @param name set user to new name
     * Set user name to new name
     */
    public void setName(String name) {
	this.name = name;
    }
    /**
     * @return String of user email
     * Return user email
     */
    public String getEmail() {
	return email;
    }
    /**
     * @parm email set user email
     * Set user email
     */
    public void setEmail(String email) {
	this.email = email;
    }
    /**
     * @return String of password
     * Returns string of user password
     */
    public String getPassword() {
	return password;
    }
    /**
     * @param password set user password
     * Set user password
     */
    public void setPassword(String password) {
	this.password = password;
    }
    /**
     * @return boolean of admin status
     * Return admin status (true/false)
     */
    public boolean getIsAdmin() {
	return this.isAdmin;
    }
    /**
     * @param isAdmin set admin status
     * Set user admin status
     */
    public void setIsAdmin(boolean isAdmin) {
	this.isAdmin = isAdmin;
    }

    /**
     * @return LinkedList of user tickets
     * Returns list of user tickets
     */
    public LinkedList<Ticket> getUserTickets() {
	return userTickets;
    }

    /**
     * @param userTickets list of user tickets to be set
     * Sets Linked of user tickets
     */
    public void addTicket(Ticket newTicket) {
	userTickets.add(newTicket);
    }
}
