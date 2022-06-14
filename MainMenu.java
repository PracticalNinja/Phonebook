package myPhonebook;

import java.util.Arrays;
import java.util.Scanner;

public class MainMenu{

    static Scanner in = new Scanner(System.in);
    static int answer;
    static Phonebook phoneBook;

    public static void main(String[] args) {
        try {
            System.out.println("Enter size of phonebook: ");
            int size = in.nextInt();
            phoneBook = new Phonebook(size);

            int choice = 0;
            menu();
        }catch(Exception error) {
            System.out.println("You have entered an invalid entry. ");
        }
    }
    static void menu() {

        System.out.println("1 - Add a new phonebook entry.");
        System.out.println("2 - Search for an existing entry.");
        System.out.println("3 - Display all records of existing entries."); // delete and update in here
        System.out.println("4 - Exit myPhonebook.");

        int choice = in.nextInt();
        switch (choice) {
            case 1:
                System.out.println("You have selected to add a new entry. Is that correct? 1 - Yes, 2 - No ");
                int answer = in.nextInt();
                in.nextLine();
                if (answer == 1) {
                    System.out.println("Enter profile information (name, address, phone number, birthday, email) as one line: ");
                    String info = in.nextLine();

                    Scanner scan = new Scanner(info);
                    scan.useDelimiter(", ");

                    String name = scan.next();
                    String firstName = name.substring(0,name.indexOf(" "));
                    name = name.replaceFirst(firstName + " ", "");
                    String lastName = name.substring(name.lastIndexOf(" ")+1);
                    name = name.replaceFirst(" " + lastName, "");
                    String middleName = name;
                    String street = scan.next();
                    String streetNum = street.substring(0,street.indexOf(" "));
                    String streetName = street.substring(street.indexOf(" ")+1);
                    String city = scan.next();
                    String state = scan.next();
                    String zip = scan.next();
                    String phoneNum = scan.next();
                    String birthday = scan.next();
                    String email = scan.next();

                    Person person = new Person(phoneNum, firstName, lastName, middleName, birthday, email);
                    person.addAddress(streetNum, streetName, city, state, zip);

                    phoneBook.addPerson(person);
                   
                }
                else if (answer == 2) {
                    menu();
                }
                else {
                    while (choice != 1 && choice != 2) {
                        System.out.println("You have entered an invalid entry. Please try again. ");
                        answer = in.nextInt();
                    }
                }
                break;

            case 2:
                System.out.println("You have selected to search for an existing entry. Is that correct? 1 - Yes, 2 - No ");
                answer = in.nextInt();
                if (answer == 1) {
                    System.out.println("1 - search by first name");
                    System.out.println("2 - search by last name");
                    System.out.println("3 - search by full name");
                    System.out.println("4 - search by telephone number");
                    System.out.println("5 - search by city");
                    System.out.println("6 - search by state");
                    System.out.println("7 - search by birthday");
                    System.out.println("8 - search by email");

                    answer = in.nextInt();
                    switch (answer) {
                        case 1:
                            in.nextLine();
                            System.out.println("Enter first name to search: ");
                            String firstName = in.nextLine();
                            Person[] results = phoneBook.searchForPerson(1, firstName);
                            System.out.println(Arrays.toString(results));
                            break;
                        case 2:
                        	in.nextLine();
                        	System.out.println("Enter last name to search: ");
                        	String lastName = in.nextLine();
                        	results = phoneBook.searchForPerson(2, lastName);
                        	System.out.println(Arrays.toString(results));
                        	break;
                        case 3:
                        	in.nextLine();
                        	System.out.println("Enter full name to search: ");
                        	String fullName = in.nextLine();
                        	results = phoneBook.searchForPerson(3, fullName);
                        	System.out.println(Arrays.toString(results)); 	
                        	break;
                        case 4:
                        	in.nextLine();
                        	System.out.println("Enter phone number to search: ");
                        	String phoneNum = in.nextLine();
                        	results = phoneBook.searchForPerson(4, phoneNum);
                        	System.out.println(Arrays.toString(results));
                        	break;
                        case 5:
                        	in.nextLine();
                        	System.out.println("Enter city to search: ");
                        	String city = in.nextLine();
                        	results = phoneBook.searchForPerson(5, city);
                        	System.out.println(Arrays.toString(results));
                        	break;
                        case 6:
                        	in.nextLine();
                        	System.out.println("Enter state to search: ");
                        	String state = in.nextLine();
                        	results = phoneBook.searchForPerson(6, state);
                        	System.out.println(Arrays.toString(results));
                        	break;
                        case 7:
                        	in.nextLine();
                        	System.out.println("Enter birthday to search: ");
                        	String birthday = in.nextLine();
                        	results = phoneBook.searchForPerson(7, birthday);
                        	System.out.println(Arrays.toString(results));
                        	break;
                        case 8:
                        	in.nextLine();
                        	System.out.println("Enter email to search: ");
                        	String email = in.nextLine();
                        	results = phoneBook.searchForPerson(8, email);
                        	System.out.println(Arrays.toString(results));
                        	break;
                	
                    }
                }
                else if (answer == 2) {
                    menu();
                }
                else {
                    while (choice != 1 && choice != 2) {
                        System.out.println("You have entered an invalid entry. Please try again. ");
                        answer = in.nextInt();
                    }
                }

                break;
            case 3:
            	System.out.println("You have selected to display all existing entries. Is that correct? 1 - Yes, 2 - No ");
                answer = in.nextInt();
                if (answer == 1) {

                    System.out.println(phoneBook.toString());

                    System.out.println("1 - update an existing record");
                    System.out.println("2 - delete an existing record");
                    System.out.println("3 - return to main menu");

                    answer = in.nextInt();
                    if (answer == 1) {
                        in.nextLine();
                        System.out.println("Enter existing phone number to update: ");
                        String phoneNum = in.nextLine();
                        System.out.println("Enter new phone number: ");
                        String newNum = in.nextLine();
                        boolean updated = phoneBook.updatePerson(phoneNum, newNum);
                        if (updated) {
                            System.out.println("Record with phone number " + phoneNum + " has been updated to phone number " + newNum);
                        } else {
                            System.out.println("Record not found.");
                        }
                    } else if (answer == 2) {
                        in.nextLine();
                        System.out.println("Enter phone number to delete: ");
                        String phoneNum = in.nextLine();
                        boolean deleted = phoneBook.deletePerson(phoneNum);
                        if (deleted) {
                            System.out.println("Record with phone number " + phoneNum + " has been deleted.");
                        } else {
                            System.out.println("Record not found.");
                        }
                    } else if (answer == 3) {
                        menu();
                    }
                }
                else if (answer == 2) {
                    menu();
                }
                else {
                    while (choice != 1 && choice != 2) {
                        System.out.println("You have entered an invalid entry. Please try again. ");
                        answer = in.nextInt();
                    }
                }
                break;
            case 4:
                System.out.println("Thank you for trying out myPhonebook. Goodbye. ");
                return;

            default:
                System.out.println("You have entered an invalid entry.");
                break;
        }

        menu();
        return;
    }
}
