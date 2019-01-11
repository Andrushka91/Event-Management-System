package P1_Sistem_de_gestiune_inscrieri;

import java.util.ArrayList;


public class GuestsList {
	

	public int nrLocuri = 0;

	public ArrayList<Guest> guestsList;

	public ArrayList<Guest> waitingList;
	
	

	public GuestsList(int nrLocuri) {

		this.nrLocuri = nrLocuri;

		guestsList = new ArrayList<Guest>(this.nrLocuri);

		waitingList = new ArrayList<Guest>(1);

	}

	public GuestsList(Guest guest) {

		this.guestsList.add(guest);

	}

	// add methods

	public int addGuest(Guest guest) {

		if (!isOnGuestsList(guest.getPhoneNumber()) && this.guestsList.size() < this.nrLocuri) {

			guestsList.add(guest);

			System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");

			System.out.println();

			return 0;

		}

		if (this.guestsList.size() >= this.nrLocuri) {

			int nrOrdine;

			System.out.println("Lista de invitati este plina!");

			nrOrdine = this.addWaitingList(guest);

			System.out.println(
					"Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine: " + nrOrdine);

			System.out.println();

			return nrOrdine;
		}

		else

			System.out.println(guest.toString() + " este deja pe lista de invitati");

		System.out.println();

		System.out.println();

		return -1;

	}

	private int addWaitingList(Guest guest) {

		this.waitingList.add(guest);

		return this.waitingList.indexOf(guest);

	}

	// check methods

	public int check(String lastName, String firstName) {

		if (isOnGuestsList(lastName, firstName)) {

			return 1;

		} else

		if (isOnWaitingList(lastName, firstName)) {

			return 2;
		}

		return -1;

	}
	

	public int check(String email) {

		if (isOnGuestsList(email)) {

			return 1;

		} else

		if (isOnWaitingList(email)) {

			return 2;
		}

		return -1;

	}

	public int check(int phoneNumber) {

		if (isOnGuestsList(phoneNumber)) {

			return 1;

		} else

		if (isOnWaitingList(phoneNumber)) {

			return 2;
		}

		return -1;

	}

	// checks if a guest is on the Guests List searching by last name and first name

	private boolean isOnGuestsList(String lastName, String firstName) {

		for (int i = 0; i < this.guestsList.size(); i++) {

			if (guestsList.get(i).getLastName().equals(lastName)
					&& (guestsList.get(i).getFirstName().equals(firstName))) {

				return true;
			}
		}

		return false;

	}

	// check if a person is on the Waiting list by lastName and firstName

	private boolean isOnWaitingList(String lastName, String firstName) {

		for (int i = 0; i < this.guestsList.size(); i++) {

			if (this.waitingList.get(i).getLastName().equals(lastName)
					&& this.waitingList.get(i).getFirstName().equals(firstName)) {

				return true;
			}
		}

		return false;

	}

	// check if a person is on the Guests List by email

	private boolean isOnGuestsList(String email) {

		for (int i = 0; i < this.guestsList.size(); i++) {

			if (this.guestsList.get(i).getEmail().equals(email)) {

				return true;

			}
		}

		return false;

	}

	// check if a person is on the Waiting List by email

	private boolean isOnWaitingList(String email) {

		for (int i = 0; i < this.waitingList.size(); i++) {

			if (this.waitingList.get(i).getEmail().equals(email)) {

				return true;

			}

		}

		return false;

	}

	// check if a person is on the Guest List by phoneNumber

	public boolean isOnGuestsList(int phoneNumber) {

		for (int i = 0; i < this.guestsList.size(); i++) {

			if (this.guestsList.get(i).getPhoneNumber() == phoneNumber) {

				return true;

			}
		}
		return false;

	}

	// check if a person is on the Waiting List by phoneNumber

	public boolean isOnWaitingList(int phoneNumber) {

		for (int i = 0; i < this.waitingList.size(); i++) {

			if (this.guestsList.get(i).getPhoneNumber() == phoneNumber) {

				return true;
			}
		}

		return false;

	}

	// search person overloaded methods

	public int searchFullName(String lastName, String firstName) {

		if (check(lastName, firstName) == 1) {

			System.out.println("Guest first name and last name found on Guests List!\n");

		}

		else

		if (check(lastName, firstName) == 2) {

			System.out.println("Guest first name and last name found on Waiting List!\n");

		}

		else

			System.out.println("Guest first name and last name not found on any list!\n");

		return -1;

	}

	public int searchEmail(String email) {

		if (check(email) == 1) {

			System.out.println("Guest with the this email found on Guests List!\n");

		} else if (check(email) == 2) {

			System.out.println("Guest with the this email found on Waiting List!\n");

		} else {

			System.out.println("Guest with the this email not found on any list!\n");
		}
		
		return -1;

	}

	public int searchPhoneNumber(int phoneNumber) {

		if (check(phoneNumber) == 1) {
			System.out.println("Guest with the this phoneNumber found on Guests List!\n");

		} else

		if (check(phoneNumber) == 2) {

			System.out.println("Guest with the this phoneNumber found on Waiting List!\n");

		} else

			System.out.println("Guest with the phoneNumber not found on any list!\n");

		return -1;

	}

	// remove overloaded methods

	public boolean removeFullName(String lastName, String firstName) {

		for (int i = 0; i < this.guestsList.size(); i++) {

			if (guestsList.get(i).getLastName().equals(lastName)
					&& guestsList.get(i).getFirstName().equals(firstName)) {

				guestsList.remove(i);

				System.out.println("Guest has been removed succesfully from Guests List\n");

				if (!this.waitingList.isEmpty()) {

					guestsList.add(waitingList.get(0));

					System.out.println("Guest from waiting list has been moved to guests list\n");

					waitingList.remove(waitingList.get(0));
				}

				return true;

			}

		}

		System.out.println("The guest searched by full name has not been found on Guests list");

		return false;
	}

	public boolean removeEmail(String email) {

		for (int i = 0; i < this.guestsList.size(); i++) {

			if (guestsList.get(i).getEmail().equals(email) && guestsList.get(i).getEmail().equals(email)) {

				guestsList.remove(i);

				System.out.println("Guest has been removed succesfully from Guests List\n");

				if (!this.waitingList.isEmpty()) {

					this.guestsList.add(this.waitingList.get(0));

					System.out.println("Guest from waiting list has been moved to guests list\n");

					waitingList.remove(waitingList.get(0));

				}

				return true;
			}

		}

		System.out.println("The guest searched by email has not been found on Guests list\n");

		return false;

	}

	public boolean removePhoneNumber(int phoneNumber) {

		for (int i = 0; i < this.guestsList.size(); i++) {

			if (guestsList.get(i).getPhoneNumber() == phoneNumber
					&& guestsList.get(i).getPhoneNumber() == phoneNumber) {

				guestsList.remove(i);

				System.out.println("Guest has been removed succesfully from Guests List\n");

				if (!this.waitingList.isEmpty()) {

					this.guestsList.add(this.waitingList.get(0));

					System.out.println("Guest from waiting list has been moved to guests list\n");

					waitingList.remove(waitingList.get(0));

				}

				return true;
			}

		}

		System.out.println("The searched guest by phone number has not been found on Guests list\n");

		return false;

	}

	public boolean removeFullNameWaitingList(String lastName, String firstName) {

		for (int i = 0; i < this.waitingList.size(); i++) {

			if (waitingList.get(i).getLastName().equals(lastName)
					&& waitingList.get(i).getFirstName().equals(firstName)) {

				waitingList.remove(i);

				System.out.println("Guest has been removed succesfully from waiting List\n");

				return true;
			}
		}

		return false;

	}

	public boolean removeEmailWaitingList(String email) {

		for (int i = 0; i < this.waitingList.size(); i++) {

			if (waitingList.get(i).getEmail().equals(email) && waitingList.get(i).getEmail().equals(email)) {

				waitingList.remove(i);

				System.out.println("Guest has been removed succesfully from waiting List\n");

				return true;
			}

		}

		return false;

	}

	public boolean removePhoneNumberWaitingList(int phoneNumber) {

		for (int i = 0; i < this.waitingList.size(); i++) {

			if (waitingList.get(i).getPhoneNumber() == phoneNumber
					&& waitingList.get(i).getPhoneNumber() == phoneNumber) {

				waitingList.remove(i);

				System.out.println("Guest with phone number has been removed succesfully from waiting List\n");

				return true;
			}

		}

		return false;

	}

	// update methods

	public boolean updateByFullName(String lastName, String firstName, Guest guest) {

		for (int i = 0; i < this.guestsList.size(); i++) {

			if (guestsList.get(i).getLastName().equals(lastName)
					&& guestsList.get(i).getFirstName().equals(firstName)) {

				guestsList.set(i, guest);

				return true;
			}
		}

		return false;
	}

	public boolean updateByFullNameWaitList(String lastName, String firstName, Guest guest) {

		for (int i = 0; i < this.waitingList.size(); i++) {

			if (waitingList.get(i).getLastName().equals(lastName)
					&& waitingList.get(i).getFirstName().equals(firstName)) {

				waitingList.set(i, guest);

				return true;
			}
		}

		return false;
	}

	public boolean updateByEmail(String email, Guest guest) {

		for (int i = 0; i < this.guestsList.size(); i++) {

			if (guestsList.get(i).getEmail().equals(email)){
					
				guestsList.set(i, guest);

				return true;
			}
		}

		return false;
	}
	
	public boolean updateByEmailWaitList(String email, Guest guest) {

		for (int i = 0; i < this.waitingList.size(); i++) {

			if (waitingList.get(i).getEmail().equals(email)){
					
				waitingList.set(i, guest);

				return true;
			}
		}

		return false;
	}
	
	public boolean updateByPhoneNumber(int phoneNumber, Guest guest) {

		for (int i = 0; i < this.guestsList.size(); i++) {

			if (guestsList.get(i).getPhoneNumber() == phoneNumber){
					
				guestsList.set(i, guest);

				return true;
			}
		}

		return false;
	}
	
	public boolean updateByPhoneNumberWaitList(int phoneNumber, Guest guest) {

		for (int i = 0; i < this.waitingList.size(); i++) {

			if (waitingList.get(i).getPhoneNumber() == phoneNumber){
					
				waitingList.set(i, guest);

				return true;
			}
		}

		return false;
	}
	
	
	//number of available seats methods
	
	public void availableSeats() {
	 
	  ArrayList<Guest> temp = new ArrayList(this.guestsList);
	  
	  System.out.println("Available seats:" + (this.guestsList.size() - temp.size()));		
	  System.out.println("\n");
	}
	
	
	//number of guests method
	
	
	public void numberOfGuests() {
		
	 ArrayList<Guest> temp = new ArrayList(this.guestsList);
	 
	 temp.trimToSize();
	 
	 System.out.println("Number of guests that will participate on the event is:" + temp.size());
	 System.out.println("\n");	
	 
	}
	
	//number of guests on waiting list
	
	public void numberOfGuestsWaitList() {
		
	  ArrayList<Guest> temp = new ArrayList(this.waitingList);
	  
	  temp.trimToSize();
	   
	  System.out.println("Number of persons from the wait list:" + temp.size());
	  System.out.println("\n");	
	}
	
	//
	
	public void numberOfAllPersons() {
		
	  ArrayList<Guest> temp = new ArrayList(this.guestsList);
	  
	  temp.trimToSize();
	  
	  int total = temp.size() + this.waitingList.size();
	  
	  System.out.println("Number of all persons on all lists: " + total);
	  System.out.println("\n");	
	}
	
	
	//overloaded methods for search 
	
	public Guest search(String input1,String input2) {
		
		boolean b = true;
		
		Guest guest = new Guest(" "," "," ",0);
	
		
		String word1 = input1.toLowerCase();
		
		String word2 = input2.toLowerCase();
			
			if(searchGuestsList(word1,word2) != -1) {
				
				guest = guestsList.get(searchGuestsList(word1,word2));
				
			}else
				
				b = false;
			
		if(b){
			
			return guest;
			
		}else
		
		return null;	
}
	

 public Guest search(String input) {
	 
 
	 boolean b = true;
	 
	 Guest guest = new Guest(" "," "," ",0);
	 
	 if(isInteger(input)) {
			
			int phoneNumber = Integer.parseInt(input);
			
			for(int i = 0; i < guestsList.size();i++) {
				
				if(guestsList.get(i).getPhoneNumber() == phoneNumber) {
					
					 guest = guestsList.get(i);
					
				}else
				
					b = false;
				
			}
	 }else{
	 
			
			String email = input.toLowerCase();
			
			for(int i = 0; i< guestsList.size();i++) {
				
				if(guestsList.get(i).getEmail().toLowerCase().equals(email)){
					
					 guest = guestsList.get(i);
					
				}else
					
					b = false;
				
			}
			
	 }
	 
	 if(b) {
		 
		 return guest;
		 
	 }
	 
	 return null;
	 
 }
 
	 
	
	
	public int isWhiteSpace(String input) {
		
		for(int i = 0;i<input.length();i++) {
			
			if(Character.isWhitespace(input.charAt(i))) {
				
			return i;
			
			}
		}
		return 0;
		
	}
	
	
	
	
	private int searchGuestsList(String input1,String input2) {
		
		int index = -1;
				
		for(int i = 0;i< this.guestsList.size();i++) {
			
			
			if((this.guestsList.get(i).getLastName().toLowerCase().equals(input1)) && (this.guestsList.get(i).getFirstName().toLowerCase().equals(input2))){
				
				index = i;
				
			}else
				
			if((this.guestsList.get(i).getLastName().toLowerCase().equals(input2)) && (this.guestsList.get(i).getFirstName().toLowerCase().equals(input1))){
				
				index = i;
			}
			
			
		}
		
		return index;
		
		
	}
	
	
	private boolean isInteger(String input ) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}
	
	
	public int getIndex(Guest guest) {
		
		return guestsList.indexOf(guest);
	}
	
	


	// methods that prints the guest details on the screen

	public void print() {

		for (int i = 0; i < guestsList.size(); i++) {

			System.out.println(i + 1 + "." + guestsList.get(i).toString());

		}
		System.out.println();
		System.out.println();
	}

	public void printwaitingList() {

		for (int i = 0; i < waitingList.size(); i++) {

			System.out.println(i + 1 + "." + waitingList.get(i).toString());

		}
		System.out.println();
		System.out.println();

	}

}
