
import java.util.Scanner;
import java.net.URL;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the implementation of the login page, account profiles,
 * admin access to tickets, and user access to their tickets 
 */
public class Tests {

    /**
     * Checks if the correct http response is sent back based on the http request with
     * and admin login query.
     * Tests the implementation of the CGI scripts, CSV files, java programs
     */
    @Test
    public void testAdminLogin(){
	try {
	    String username = "graupe";
	    String password = "myPassword";
	    Scanner webpage = new Scanner(new URL("https://pages.cs.wisc.edu/~elan/project-four-bg/graupe_Front_End_2/FrontEndInterface/CGIFiles/Login.cgi?Username="+ username +"&Password="+ password +"").openStream());
	    String expected = "{\"isAdmin\":\"true\",\"firstName\":\"Elan Graupe\",\"lastName\":\"Elan Graupe\",\"email\":\"graupe@wisc.edu\",\"userID\":\"graupe|myPassword\"}";
	    String received = "";
	    if(webpage.hasNextLine()){
		received = webpage.nextLine();
		if(!(received.equals(expected))){
			fail("FAILED, input did not mathc for CUSTOMER test" +
			     "\nExpected: " + expected +
			     "\nReceived: " + received);
		}
	    }
	}
	catch(Exception e) {
	    fail("FAILED, exception in CUSTOMER test occured");
	}
    }

    /**
     * Checks if the correct http response is sent back based on the http request with
     * and user login query.
     * Tests the implementation of the CGI scripts, CSV files, java programs
     */
    @Test
    public void testCustomerLogin(){
	try {
	    String username = "gdahl";
	    String password = "TotalyGarysPassword";
	    Scanner webpage = new Scanner(new URL("https://pages.cs.wisc.edu/~elan/project-four-bg/graupe_Front_End_2/FrontEndInterface/CGIFiles/Login.cgi?Username="+ username +"&Password="+ password +"").openStream());
	    String expected = "{\"isAdmin\":\"false\",\"firstName\":\"Gary Dahl\",\"lastName\":\"Gary Dahl\",\"email\":\"gdahl@wisc.edu\",\"userID\":\"gdahl|TotalyGarysPassword\"}";
	    String received = "";
	    if(webpage.hasNextLine()){
		received = webpage.nextLine();
		if(!(received.equals(expected))){
			fail("FAILED, input did not mathc for CUSTOMER test" +
			     "\nExpected: " + expected +
			     "\nReceived: " + received);
		}
	    }
	}
	catch(Exception e) {
	    fail("FAILED, exception in CUSTOMER test occured");
	}
    }

    /**
     * Checks the admin method for getting tickets and sees if a ticket found in the
     * CSV file of tickets is returned
     */
    @Test
    public void testGetATicket(){
	Back_End_1 backend = new Back_End_1();
	Ticket_1 ticket = backend.getOpenTickets().get(0);
	if(!ticket.getUserName().trim().equals("florian")){
	    fail("FAILED, expected florian, received " + ticket.getUserName());
	}
    }

    /**
     * Checks the admin method for getting tickets and sees if a ticket found in the
     * CSV file of tickets is returned
     */
    @Test
    public void testGetATicket2(){
	Back_End_1 backend = new Back_End_1();
	Ticket_1 ticket = backend.getOpenTickets().get(1);
	if(!ticket.getUserName().trim().equals("TheBestUser")){
	    fail("FAILED, expected TheBestUser, received " + ticket.getUserName());
	}	
    }

    /**
     * Checks the user method for getting tickets and sees if the number of tickets
     * found in the CSV files matches the number of tickets that user really has
     */
    @Test
    public void testGetNumberOfUsersTickets(){
	Back_End_1 backend = new Back_End_1();
	if(backend.getUserTickets("gdahl").size() != 4){
	    fail("FAILED, user gdahl has 4 tickets in CSV file");
	}
    }


}
