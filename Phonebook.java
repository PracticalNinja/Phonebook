package myPhonebook;

import java.util.Arrays;

public class Phonebook {
    Person[] directory;
    int recordNum;

    public Phonebook(int size) {
        directory = new Person[size];
        recordNum = 0;
    }

    public boolean addPerson(Person person) {
        if (recordNum > 0) {
            for (int i=0; i < recordNum; i++) {
                if (directory[i].equals(person)) {
                    return false;
                }
            }
        }
        
        directory[recordNum] = person;
        recordNum++;
        System.out.println(directory[0]);
        return true;
    }

    public Person[] searchForPerson(int methodOfSearch, String searchTerm) {
        Person[] results = new Person[recordNum];
        int resultNum = 0;
        switch (methodOfSearch) {
            case 1:
                for (int i=0; i < recordNum; i++) {
                    if (directory[i].getFirstName().equalsIgnoreCase(searchTerm)) { 
                        results[resultNum] = directory[i];
                        resultNum++;
                    }
                }
                break;

            case 2:
                for (int i=0; i < recordNum; i++) {
                    if (directory[i].getLastName().equalsIgnoreCase(searchTerm)) {
                        results[resultNum] = directory[i];
                        resultNum++;
                    }
                }
                break;
            case 3:
            	 boolean firstMatches = false, lastMatches = false;
                 String firstName = searchTerm.substring(0,searchTerm.indexOf(" "));
                 searchTerm = searchTerm.replaceFirst(firstName + " ", "");
                 String lastName = searchTerm.substring(searchTerm.lastIndexOf(" ")+1);
                 searchTerm = searchTerm.replaceFirst(" " + lastName, "");

                 for (int i=0; i < recordNum; i++) {
                     if (directory[i].getFirstName().equalsIgnoreCase(firstName)) {
                         firstMatches = true;
                     }
                     if (directory[i].getLastName().equalsIgnoreCase(lastName)) {
                         lastMatches = true;
                     }

                     if (firstMatches && lastMatches) {
                         results[resultNum] = directory[i];
                         resultNum++;
                         firstMatches = false;
                         lastMatches = false;
                     } else if (firstMatches && !lastMatches) {
                         firstMatches = false;
                     } else if (!firstMatches && lastMatches) {
                         lastMatches = false;
                     }
                 }
                break;

            case 4:
                for (int i=0; i < recordNum; i++) {
                    if (directory[i].getPhoneNum().equalsIgnoreCase(searchTerm)) {
                        results[resultNum] = directory[i];
                        resultNum++;
                    }
                }
                break;
            case 5:
                for (int i=0; i < recordNum; i++) {
                    if (directory[i].getAddress().getCity().equalsIgnoreCase(searchTerm)) {
                        results[resultNum] = directory[i];
                        resultNum++;
                    }
                }
                break;
            case 6:
                for (int i=0; i < recordNum; i++) {
                    if (directory[i].getAddress().getState().equalsIgnoreCase(searchTerm)) {
                        results[resultNum] = directory[i];
                        resultNum++;
                    }
                }
                break;
            case 7:
                for (int i=0; i < recordNum; i++) {
                    if (directory[i].getBirthday().equalsIgnoreCase(searchTerm)) {
                        results[resultNum] = directory[i];
                        resultNum++;
                    }
                }
                break;
            case 8:
                for (int i=0; i < recordNum; i++) {
                    if (directory[i].getEmail().equalsIgnoreCase(searchTerm)) {
                        results[resultNum] = directory[i];
                        resultNum++;
                    }
                }
                break;
        }
        
        return results;
    }

    public boolean deletePerson(String phoneNum) {
        for (int i=0; i < recordNum; i++) {
            if (directory[i].getPhoneNum().equalsIgnoreCase(phoneNum)) {
                directory[i] = null;
                recordNum--;
                return true;
            }
        }
        return false;
    }

    public boolean updatePerson(String phoneNum, String newNum) {
        for (int i=0; i < recordNum; i++) {
            if (directory[i].getPhoneNum().equalsIgnoreCase(phoneNum)) {
                directory[i].setPhoneNum(newNum);
                return true;
            }
        }
        System.out.println("No changes have been made.");
        return false;
    }

    @Override
    public String toString() {
        Person temp;
        for (int i=0; i<recordNum-1; i++) {
            for (int j=i+1; j<recordNum; j++) {
                int compare = directory[i].getLastName().compareTo(directory[j].getLastName());
                if (compare > 0) {
                    temp = directory[i];
                    directory[i] = directory[j];
                    directory[j] = temp;
                }
            }
        }

        String print = "";
        System.out.println("Phonebook:\n");
        for (int k=0; k<recordNum; k++) {
            print += directory[k].toString() + "\n\n";
        }
        return print;
    }
}
