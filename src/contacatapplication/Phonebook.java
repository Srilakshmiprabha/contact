package contacatapplication;

import java.util.*;
import java.util.regex.*;

public class Phonebook {
	Scanner sc = new Scanner(System.in);
	HashMap<Integer, Create> map = new HashMap<>();
	Create create = new Create();
	ArrayList<Create> array = new ArrayList<>();

	public int getid(int limit) {
		int num = 0;
		boolean r = true;

		do {
			try {
				num = sc.nextInt();
				if (num > limit || num <= 0) {
					System.out.println(" Please Enter within :" + limit);
					continue;
				}
				if (num > 0 && num < limit)

					r = false;
			} catch (InputMismatchException e) {
				System.out.println("Enter positive Integer value within :" + limit);
				sc.next();
				continue;
			}

		} while (r == true);
		return num;
	}

	public void Creating() {
		System.out.println("\tCreating a contact");
		System.out.println("Enter the id");
		// Scanner sc=new Scanner(System.in);
		int id = getid(999);
		if (!map.containsKey(id)) {

			map.put(id, create);
			System.out.println("Enter the name :");
			create.setName(sc.next());
			System.out.println("Enter the number:");
			long PhNo = get_num();
			create.setPhno(PhNo);
			System.out.println("Enter your mail id :");
			String s = get_mail();
			create.setMail(s);
			System.out.println("Enter your address :");
			create.setAddr(sc.next());
			System.out.println("\tSaved Successfully");
			Displaying(id);
		} else
			System.out.println("Contact Already Present");
	}

	public long get_num() {
		// Set<Long> PhNo = new HashSet<>();
		long num = 0;
		boolean a = true;

		do {

			try {
				num = sc.nextLong();

				if (num > 999999999 && num <= 9999999999L)
					a = false;
				else
					System.out.println("The entered number is not a valid ph number");
			} catch (InputMismatchException e) {
				System.out.println("Please enter your phone number correctly");
				sc.next();
				continue;
			}
		} while (a == true);
		// PhNo.add(num);
		return num;
	}

	public String get_mail() {
		boolean p = true;
		String s;
		do {
			s = sc.nextLine();
			Pattern pattern = Pattern
					.compile("[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})");
			Matcher match = pattern.matcher(s);
			if (match.matches()) {
				p = false;
			} else
				System.out.println("Please Enter a valid email id ");
		} while (p == true);
		return s;
	}

	public void Editing() {
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
				} catch (InputMismatchException e) {
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
				System.out.println("Enter the num :");
				map.get(id).setPhno(sc.nextLong());
				System.out.println("\t Edited Successfully");
				break;
			case 3:
				System.out.println("Enter your mail id :");
				String s = get_mail();
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

	public void Deleting() {
		System.out.println("\tDeleting A Contact");
		System.out.println("Enter the id");
		int id = getid(99);
		if (map.containsKey(id)) {
			map.remove(id);
			System.out.println("Contact deleted of id :" + id);
		} else
			System.out.println("No Such Contact To be Deleted ");
	}

	public void Displaying(int id) {
		System.out.println("\tContact info");
		// System.out.println("enter id to display");

		array.add(create);
		System.out.println(array.get(0).getName());
		System.out.println(array.get(0).getPhno());
		System.out.println(array.get(0).getMail());
		System.out.println(array.get(0).getAddr());

	}

	public void Display() {
		System.out.println("\tDisplaying Contact");
		

		System.out.println("Enter the id");
		int id = sc.nextInt(); // Displaying a Contact
		boolean a = true;
		if (map.containsKey(id)) {

			for(Map.Entry<Integer, Create> m:map.entrySet()){  
			Integer key=m.getKey();
			Create create1=m.getValue();
			System.out.println(create1.getName()+create1.getPhno()+create1.getMail()+create1.getAddr());
				 }

			} else {
				System.out.println("no such id");
				System.out.println("want to enter other 1/0");
				int s=sc.nextInt();
				if(s==1)
				{
					System.out.println("enter valid id to display");
					Display();
				}
				
				else
				{
					System.exit(0);
				}
			}
		

	}

	
	public void Selection(int option) {

		switch (option) {
		case 1:
			Creating();

			break;
		case 2:
			Editing();

			break;
		case 3:
			Deleting();
			break;
		case 4:
			Display();
			break;
		
		default:
			System.out.println("Exiting");
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Phonebook obj = new Phonebook();
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

						obj.Selection(option);
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
