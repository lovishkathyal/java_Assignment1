import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;
    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + emailAddress;
    }
}
class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }
    public void viewAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    // Method to search for a contact by name
    public void searchContactByName(String name) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println(contact);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No contact found with the name: " + name);
        }
    }
}

// Main class with menu-driven interface
public class AddressBookApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new contact");
            System.out.println("2. View all contacts");
            System.out.println("3. Search for a contact by name");
            System.out.println("4. Exit the program");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String emailAddress = scanner.nextLine();

                    Contact newContact = new Contact(name, phoneNumber, emailAddress);
                    addressBook.addContact(newContact);
                    break;
                case 2:
                    System.out.println("All Contacts:");
                    addressBook.viewAllContacts();
                    break;
                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    addressBook.searchContactByName(searchName);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
