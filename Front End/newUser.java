
public class newUser {

	public static void main(String[] args) {
		String[] data = args[0].split("&");
		String username = data[0].split("=")[1].trim();
		String password = data[1].split("=")[1].trim();
		String name = data[2].split("=")[1].trim();
		String contactInfo = data[3].split("=")[1].trim();
		boolean isAdmin = data[4].split("=")[1].equals("true");
		
		Back_End_1 back = new Back_End_1();
		back.readCSV();
		back.createNewUser(name, contactInfo, username, password, isAdmin);
		login.getUserID(username, password);
	}

}
