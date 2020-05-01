package gr.codehub.app;

import java.util.Scanner;

public class UIC {

    public ChoiceCustomer menu() {
        int choice;
        ChoiceCustomer returnChoice;
        System.out.println("1. Add a customer   2. Remove a customer" +
                "    3. Display customer     4.  Clear Customer List  5. Count Total Customers 6. Save to file 7. Load from file  0. Exit" +
                "");

        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    return ChoiceCustomer.ADD;
                case 2:
                    return ChoiceCustomer.REMOVE;
                case 3:
                    return ChoiceCustomer.DISPLAY;
                case 4:
                    return ChoiceCustomer.CLEAR;
                case 5:
                    return ChoiceCustomer.TOTALCUSTOMERS;
                case 6:
                    return ChoiceCustomer.SAVE;
                case 7:
                    return ChoiceCustomer.LOAD;
                case 0:
                    return ChoiceCustomer.EXIT;
                default:
                    return ChoiceCustomer.ERROR;
            }
        } catch (Exception e) {
            return ChoiceCustomer.ERROR;
        }

    }

    //factory method design pattern
    public Customer newCustomer() {
        String code;
        String name;
        String surname;
        String phone;
        String address;
        String email;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the customer code ");
        code = scanner.next();
        System.out.println("Give the customer name ");
        name = scanner.next();
        System.out.println("Give the customer surname ");
        surname = scanner.next();
        System.out.println("Give the customer phone ");
        phone = scanner.next();
        System.out.println("Give the customer address ");
        address = scanner.next();
        System.out.println("Give the customer email ");
        email = scanner.next();

        Customer customer = new Customer(code, name, surname, phone, address, email);

        return customer;

    }


    public void manageCustomerList(CustomerList customerlist) {
        ChoiceCustomer choice;
        do {
            choice = menu();

            switch (choice) {
                case ADD:
                    Customer customer = newCustomer();
                    customerlist.addCustomer(customer);
                    break;
                case REMOVE:
                    System.out.println("Give an index to remove");
                    Scanner scanner = new Scanner(System.in);
                    int index = scanner.nextInt();
                    customerlist.removeCustomer(index);
                    break;
                case DISPLAY:
                    customerlist.displayCustomers();
                    break;
                case CLEAR:
                    customerlist.clearCustomer();
                    break;
                case TOTALCUSTOMERS:
                    System.out.println("TotalCustomers= " + customerlist.CountTotalCustomers());
                    break;
                case EXIT:
                    break;
                case SAVE:
                    customerlist.saveCustomerlist("customerlist.txt");
                    break;
                case LOAD:
                    customerlist.loadCustomerlist("customerlist.txt");
                    break;
                case ERROR:
                    System.out.println("You gave erroneous input");
                    break;

            }
        } while (choice != ChoiceCustomer.EXIT);

    }


}


