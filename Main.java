package P1_Sistem_de_gestiune_inscrieri;

import java.util.Scanner;

public class Main {

	public static void menu() {

		System.out.println("help         - Afiseaza aceasta lista de comenzi\n"
				+ "add          - Adauga o noua persoana (inscriere)\n"
				+ "check        - Verifica daca o persoana este inscrisa la eveniment\n"
				+ "remove       - Sterge o persoana existenta din lista\n"
				+ "update       - Actualizeaza detaliile unei persoane\n"
				+ "guests       - Lista de persoane care participa la eveniment\n"
				+ "waitlist     - Persoanele din lista de asteptare\n" + "available    - Numarul de locuri libere\n"
				+ "guests_no    - Numarul de persoane care participa la eveniment\n"
				+ "waitlist_no  - Numarul de persoane din lista de asteptare\n"
				+ "subscribe_no - Numarul total de persoane inscrise\n"
				+ "search       - Cauta toti invitatii conform sirului de caractere introdus\n"
				+ "quit         - Inchide aplicatia");
		System.out.println();

	}

	public static Guest newDetails() {

		System.out.println("Searched person was found and is ready to be updated:");

		Scanner input = new Scanner(System.in);

		System.out.println("New last name:");

		String uLastName = input.next();

		System.out.println("New first name");

		String uFirstName = input.next();

		System.out.println("New email:");

		String uEmail = input.next();

		System.out.println("New phone number:");

		int uPhoneNumber = input.nextInt();

		Guest guest = new Guest(uLastName, uFirstName, uEmail, uPhoneNumber);

		return guest;
	}


	public static String dataSearch() {

		Scanner input = new Scanner(System.in);

		System.out.println("Type your search criteria here: ");

		String string  = input.nextLine();

		return string;

	}

	public static void main(String[] args) {


		Scanner input = new Scanner(System.in);

		GuestsList guestsList = new GuestsList(2);

		menu();

		String inputString = input.next();




		while (!inputString.equals("quit")) {

			if (inputString.equals("help")) {
				menu();

			} else

				if (inputString.equals("add")) {

					System.out.println("Nume:");

					String nume = input.next();

					System.out.println("Prenume:");

					String prenume = input.next();

					System.out.println("Email:");

					String email = input.next();

					System.out.println("Nr telefon:");

					int nrTelefon = input.nextInt();

					Guest guest = new Guest(nume, prenume, email, nrTelefon);

					guestsList.addGuest(guest);

				}

			if (inputString.equals("check")) {

				System.out.println("Optiuni de cautare:\n" + "1 - last name si first name\n" + "2 - email\n"
						+ "3 - phoneNumber\n");

				int option = input.nextInt();

				if (option == 1) {

					System.out.println("Type first name:");

					String lastName = input.next();

					System.out.println("Type last name:");

					String firstName = input.next();

					guestsList.searchFullName(lastName, firstName);

				} else	if (option == 2) {

					System.out.println("Type the Email:");

					String email = input.next();

					guestsList.searchEmail(email);

				} else if (option == 3) {

					System.out.println("Type the Phone Number:");

					int phoneNumber = input.nextInt();

					guestsList.searchPhoneNumber(phoneNumber);

				}

			}

			if (inputString.equals("remove")) {


				System.out.println("Optiuni de cautare:\n" + "1 - last name si first name\n" + "2 - email\n"
						+ "3 - phoneNumber\n");

				int option = input.nextInt();

				if (option == 1) {

					System.out.println("Type last name:");

					String lastName = input.next();

					System.out.println("Type first name:");

					String firstName = input.next();

					if (!guestsList.removeFullName(lastName, firstName)) {

						if (!guestsList.removeFullNameWaitingList(lastName, firstName)) {

							System.out.println("Guest searched by full name has not been found on any list!\n");

						}

					}

				} else

					if (option == 2) {

						System.out.println("Type email:");

						String email = input.next();

						if (!guestsList.removeEmail(email)) {

							if (!guestsList.removeEmailWaitingList(email)) {

								System.out.println("Guest searched by email has not been found on any list!\n");

							}

						}

					} else

						if (option == 3) {

							System.out.println("Type phone number:");

							int phoneNumber = input.nextInt();

							if (!guestsList.removePhoneNumber(phoneNumber)) {

								if (!guestsList.removePhoneNumberWaitingList(phoneNumber)) {

									System.out.println("Guest searched by phone number has not been found on any list!\n");

								}

							}
						}

			}


			if (inputString.equals("update")) {


				System.out.println("Optiuni de cautare:\n" + "1 - last name si first name\n" + "2 - email\n"
						+ "3 - phoneNumber\n");

				int option = input.nextInt();


				if (option == 1) {


					System.out.println("Type last name:");

					String lastName = input.next();

					System.out.println("Type first name");

					String firstName = input.next();

					if (guestsList.check(lastName, firstName) != -1) {

						Guest guest = newDetails();

						if (guestsList.updateByFullName(lastName, firstName, guest)) {


							System.out.println("Person searched by full name was updated successfully on guests list\n");
						}

						if (guestsList.updateByFullNameWaitList(lastName, firstName, guest)) {

							System.out.println("Person searched by full name was updated successfully on wait list\n");
						}

					}else {

						System.out.println("Searched guest by full name has not been found on any list, it can't be updated\n");

					}

				} else


					if (option == 2) {


						System.out.println("Type email:");

						String email = input.next();

						if (guestsList.check(email) != -1) {

							Guest guest = newDetails();

							if (guestsList.updateByEmail(email, guest)) {

								System.out.println("Person searched by email was updated successfully on guests list\n");
							}


							if (guestsList.updateByEmailWaitList(email, guest)) {

								System.out.println("Person searched by email was updated successfully on wait list\n");
							}

						}else {

							System.out.println("Searched guest by full name has not been found on any list, it can't be updated\n");

						}

					}else


						if(option == 3) {


							System.out.println("Type phone number:");

							int phoneNumber = input.nextInt();

							if (guestsList.check(phoneNumber) != -1) {

								Guest guest = newDetails();

								if (guestsList.updateByPhoneNumber(phoneNumber, guest)) {

									System.out.println("Person searched by phone number was updated updated successfully on guests list\n");
								}

								if (guestsList.updateByPhoneNumber(phoneNumber, guest)) {

									System.out.println("Person searched by phone number was updated successfully on wait list\n");
								}

							}else {

								System.out.println("Searched guest by phone number has not been found on any list, it can't be updated\n");

							}

						}

			}


			if (inputString.equals("guests")) {

				guestsList.print();

			}


			if (inputString.equals("waitlist")) {

				guestsList.printwaitingList();
			}


			if(inputString.equals("available")) {

				guestsList.availableSeats();

			}

			if(inputString.equals("guests_no")) {

				guestsList.numberOfGuests();

			}

			if(inputString.equals("waitlist_no")){

				guestsList.numberOfGuestsWaitList();
			}

			if(inputString.equals("subscribe_no")) {

				guestsList.numberOfAllPersons();

			}

			if(inputString.equals("search")) {

				String string  = dataSearch();

				if(guestsList.isWhiteSpace(string) != 0) {


					String word1 = string.substring(0, string.indexOf(" "));

					String word2 = string.substring(string.indexOf(" ") + 1,string.length());


					if(guestsList.search(word1,word2) != null) {

						Guest guest = guestsList.search(word1,word2);

						System.out.println("The guest has been found on guests list: " + guestsList.getIndex(guest) + "." + guest.toString() + "\n");

					}else

						System.out.println("None of the guests matched the input data\n");


				}else


					if(guestsList.search(string) != null) {

						Guest guest = guestsList.search(string);

						System.out.println("The guest has been found on guests list: " + guestsList.getIndex(guest) + "." + guest.toString() + "\n");

					}else

						System.out.println("None of the guests matched the input data\n");


			}







			menu();

			inputString = input.next();

		}

	}

}


