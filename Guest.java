package P1_Sistem_de_gestiune_inscrieri;
import java.util.Scanner;

public class Guest {

	private String lastName;
	
	private String firstName;
	
	private String email;
	
	private int phoneNumber;
	
	public Guest() {
		
	}
	
	public Guest(String lastName, String firstName, String email, int phoneNumber) {
		
		this.lastName = lastName;
		
		this.firstName = firstName;
		
		this.email = email;
		
		this.phoneNumber = phoneNumber;
		
	}


	public void setLastName(String lastName) {
		
		this.lastName = lastName;
		
	}

	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
		
	}

	public void setEmail(String email) {
		
		this.email = email;
		
	}

	public void setPhoneNumber(int phoneNumber) {
		
		this.phoneNumber = phoneNumber;
		
	}

	public String getLastName() {
		
		return lastName;
		
	}

	public String getFirstName() {
		
		return firstName;
		
	}

	public String getEmail() {
		
		return email;
		
	}

	public int getPhoneNumber() {
		
		return phoneNumber;
		
	}
	
	
	@Override
	
	public String toString() {
		
		return String.format("%s %s %s +40%d",getLastName(),getFirstName(),getEmail(),getPhoneNumber());
		
	}



	

}
