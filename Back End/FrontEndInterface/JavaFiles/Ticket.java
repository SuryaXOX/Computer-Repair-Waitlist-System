// --== CS400 File Header Information ==--                                                                                                                                                                 
// Name: Elias Verdun                                                                                                                                                                                      
// Email: esverdun@wisc.edu                                                                                                                                                                                
// Team: BG                                                                                                                                                                                                
// Role: Back End                                                                                                                                                                                          
// TA: Brianna Cochran                                                                                                                                                                                     
// Lecturer: Gary Dahl                                                                                                                                                                                    
// Notes to Grader: <optional extra notes>

import java.util.UUID;

/**
 * @author Eli Verdun
 * Ticket object to store relevant information related to open/close tickets
 */
public class Ticket {
    private String ID; // unique ticket id
    private String userName; // user name of user creating ticket
    private String issue; // ticket title
    private String details; // ticket details of issue
    private boolean status; // if ticket is resolved (true)

    /**
     * @param userName user name
     * @param issue ticket title
     * @param details ticket details
     * @param status if ticket is open
     *
     * Constructor to create new ticket with userName, title, details, and status
     *
     */
    public Ticket(String userName, String issue, String details, boolean status) {
	this.userName = userName;
	this.issue = issue;
	this.details = details;
	this.status = status;
	this.ID = UUID.randomUUID().toString();
    }
    /**
     * @param userName user name                                                                                                                                                                           
     * @param issue ticket title                                                                                                                                                                           
     * @param details ticket details                                                                                                                                                                       
     * @param status if ticket is open
     * Second constructor without status parameter - auto set to true
     */
    public Ticket(String userName, String issue, String details) {
	this.userName = userName;
	this.issue = issue;
	this.details = details;
	this.status = false;
	this.ID = UUID.randomUUID().toString();
    }

    /**
     * @return ID ticket unique id
     * Returns ticket id
     */
    public String getID() {
	return ID;
    }

    /**
     * @param ID sets ticket id
     * Sets ticket id
     */
    public void setID(String ID) {
	this.ID = ID;
    }
    /**
     * @return userName user who created ticket
     * Returns userName of user who created ticket
     */
    public String getUserName() {
	return userName;
    }

    /**
     * @param userName new user username
     * Sets new userName
     */
    public void setUserName(String userName) {
	this.userName = userName;
    }

    /**
     * @return issue title of ticket
     * Returns title of ticket associated with user
     */
    public String getIssue() {
	return issue;
    }

    /**
     * @param issue sets ticket title
     * Sets ticket title
     */
    public void setIssue(String issue) {
	this.issue = issue;
    }

    /**
     * @returns details gives description of ticket
     * Returns description of ticket
     */
    public String getDetails() {
	return details;
    }

    /**
     * @param details sets details of ticket
     * Sets details of ticket
     */
    public void setDetails(String details) {
	this.details = details;
    }

    /**
     * @return true if ticket is open
     * Returns status of ticket
     */
    public boolean getStatus() {
	return status;
    }

    /**
     * @param status set status of ticket
     * Sets status of ticket (open = true / closed = false)
     */
    public void setStatus(boolean status) {
	this.status = status;
    }
}
