

import java.util.UUID;

/**
 * Ticket object to contain all relevant ticket info
 */
public class Ticket_1 {

    private UUID ID;
    private String userName;
    private String title;
    private String content;
    private boolean isResolved;

    /**
     * Ticket object constructor
     * @param userName username of user who submitted ticket
     * @param title title of ticket
     * @param content content of ticket
     */
    public Ticket_1(String userName, String title, String content) {
        this.ID = UUID.randomUUID();
        this.userName = userName;
        this.title = title;
        this.content = content;
    }
    
    /**
     * Ticket object constructor with isResolved
     * @param userName username of user who submitted ticket
     * @param title title of ticket
     * @param content content of ticket
     * @param isResolved boolean value of whether ticket is resolved or not
     */
    public Ticket_1(String userName, String title, String content, boolean isResolved) {
        this.ID = UUID.randomUUID();
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.isResolved = isResolved;
    }

    /**
     * @return unique UUID of ticket
     */
    public UUID getID() {
        return ID;
    }

    /**
     * @param ID unique UUID of ticket to be set
     */
    public void setID(UUID ID) {
        this.ID = ID;
    }

    /**
     * @return username of user who submitted ticket
     */
    public String getUserName() { return userName; }

    /**
     * @param userName username associated with ticket to be set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return title of ticket
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title title of ticket to be set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return content of ticket
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content content of ticket to be set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return true if ticket is resolved, false if otherwise
     */
    public boolean isResolved() {
        return isResolved;
    }

    /**
     * @param resolved set if ticket is resolved or not
     */
    public void setResolved(boolean resolved) {
        isResolved = resolved;
    }
}
