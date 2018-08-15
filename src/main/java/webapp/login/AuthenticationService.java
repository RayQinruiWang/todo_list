package webapp.login;

public class AuthenticationService{
	public boolean isUserVaild(String name, String password) {
		if ((name.equals("Ray")&&password.equals("develop"))||
			(name.equals("David")&&password.equals("admin"))||
			(name.equals("Simon")&&password.equals("admin"))){
			return true;
		}
		else return false;
	}
}
