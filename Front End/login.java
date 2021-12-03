
public class login {

	
	
	public static void main(String[] args) {
		String[] data = args[0].split("&");
		String username = data[0].split("=")[1].trim();
		String password = data[1].split("=")[1].trim();
		String userID = getUserID(username, password);
		
		System.out.println(userInfo.getUserInfo(userID));
	}
	
	public static String getUserID(String username, String password) {
		Back_End_1 back = new Back_End_1();
		User_1 user = back.login(username, password);
		if(user!=null) {
			return username+"&"+password;
		}
		return null;
		
	}

}
