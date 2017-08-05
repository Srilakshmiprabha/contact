package contacatapplication;

import java.util.*;
import java.util.regex.*;

public class Phonebook {
	Scanner sc = new Scanner(System.in);
	HashMap<Integer, Create> map = new HashMap<>();
	Create create = new Create();
	ArrayList<Create> array = new ArrayList<>();

	public int getid(long limit) {
		int id = 0;
		boolean r = true;

		do {
			try {
				id = sc.nextInt();
				if (id > limit || id <= 0) {
					System.out.println(" Please Enter within :" + limit);
					continue;
				}
				if (id > 0 && id < limit)

					r = false;
			} catch (InputMismatchException e) {
				System.out.println("Enter positive Integer value within :" + limit);
				sc.next();
				continue;
			}

		} while (r == true);
		return id;
	}

	public void creating() {
		System.out.println("\tCreating a contact");
		System.out.println("Enter the id");

		int id = getid(9999999999L);
		if (!map.containsKey(id)) {

			map.put(id, create);
			System.out.println("Enter the name :");
			create.setName(sc.next());
			System.out.println("Enter the number:");
			long phonenumber = getphonenumber();
			create.setPhno(phonenumber);
			System.out.println("Enter your mail id :");
			String email = getmail();
			create.setMail(email);
			System.out.println("Enter your address :");
			create.setAddr(sc.next());
			System.out.println("\tSaved Successfully");
			displaying(id);
		} else
			System.out.println("Contact Already Present");
	}

	public long getphonenumber() {

		long phone = 0;
		boolean a = true;

		do {

			try {
				phone = sc.nextLong();

				if (phone > 999999999 && phone <= 9999999999L)
					a = false;
				else
					System.out.println("The entered number is not a valid phone number");
			} catch (InputMismatchException exception) {
				System.out.println("Please enter your phone number correctly");
				sc.next();
				continue;
			}
		} while (a == true);

		return phone;
	}

	public String getmail() {
		boolean p = true;
		String mailid;
		do {
			mailid = sc.nextLine();
			Pattern pattern = Pattern
					.compile("[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})");
			Matcher match = pattern.matcher(mailid);
			if (match.matches()) {
				p = false;
			} else
				System.out.println("Please Enter a valid email id ");
		} while (p == true);
		return mailid;
	}

	public void editing() {
		System.out.println("\tEditing a Contact");
		System.out.println("Enter the id");
		int id = getid(999);
		if (map.containsKey(id)) {
			System.out.println("Select the Field to Edit");
			System.out.println("1.Name \n2.Phone Number \n3.Mail id \n4.Address \n");
			boolean k = true;
			int Select = 0;
			do {
				try {
					Select = sc.nextInt();
					if (Select > 0 && Select < 5)
						k = false;
				} catch (InputMismatchException exception) {
					System.out.println("Please Make A Right Choice");
					sc.next();
				}
			} while (k == true);

			switch (Select) {
			case 1:
				System.out.println("Enter the name :");
				map.get(id).setName(sc.next());
				System.out.println("\t Edited Successfully");
				break;
			case 2:
				System.out.println("Enter the phonenumber :");
				map.get(id).setPhno(sc.nextLong());
				System.out.println("\t Edited Successfully");
				break;
			case 3:
				System.out.println("Enter your mail id :");
				String s = getmail();
				map.get(id).setMail(s);
				System.out.println("\t Edited Successfully");
				break;
			case 4:
				System.out.println("Enter your address :");
				map.get(id).setAddr(sc.next());
				System.out.println("\t Edited Successfully");
				break;
			}
		} else
			System.out.println("Entered Contact doesn't Exist");
	}

	public void deleting() {
		System.out.println("\tDeleting A Contact");
		System.out.println("Enter the id");
		int id = getid(9999999999l);
		if (map.containsKey(id)) {
			map.remove(id);
			System.out.println("Contact deleted of id :" + id);
		} else
			System.out.println("No Such Contact To be Deleted ");
	}

	public void displaying(int id) {
		System.out.println("\tContact info");
		// System.out.println("enter id to display");

		array.add(create);
		System.out.println(array.get(0).getName());
		System.out.println(array.get(0).getPhno());
		System.out.println(array.get(0).getMail());
		System.out.println(array.get(0).getAddr());

	}

	public void display() {
		System.out.println("\tDisplaying Contact");

		System.out.println("Enter the id");
		int id = sc.nextInt(); // Displaying a Contact
		boolean a = true;
		if (map.containsKey(id)) {

			for (Map.Entry<Integer, Create> m : map.entrySet()) {
				Integer key = m.getKey();
				Create create1 = m.getValue();
				System.out.println(create1.getName() + create1.getPhno() + create1.getMail() + create1.getAddr());
			}

		} else {
			System.out.println("no such id");
			System.out.println("want to enter other 1/0");
			int s = sc.nextInt();
			if (s == 1) {
				System.out.println("enter valid id to display");
				display();
			}

			else {
				System.exit(0);
			}
		}

	}

	public void Selection(int option) {

		switch (option) {
		case 1:
			creating();

			break;
		case 2:
			editing();

			break;
		case 3:
			deleting();
			break;
		case 4:
			display();
			break;

		default:
			System.out.println("Exiting");
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Phonebook phone = new Phonebook();
		boolean x = true;
		int option = 0;
		do {
			System.out.println("\tCONTACT CREATION");
			System.out.println("1.Create \n2.Edit \n3.Delete \n4.Display \n5.exit");
			boolean y = true;
			do {
				try {
					option = sc.nextInt();
					if (option >= 1 && option <= 5) {
						y = false;

						phone.Selection(option);
					} else
						System.out.println(" Make a Proper Choice ");
				} catch (Exception e) {
					System.out.println("Enter Integer Value to continue");
					option = sc.nextInt();
					continue;
				}
			} while (y == true);
		} while (x == true);
	}
}
