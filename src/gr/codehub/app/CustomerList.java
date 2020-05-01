package gr.codehub.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerList {

    private ArrayList<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void displayCustomers() {

        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    public void removeCustomer(int index) {
        if (index >= 0 && index < customers.size()) {
            customers.remove(index);
        }
    }

    public void clearCustomer() {
        customers.clear();
    }

    public int CountTotalCustomers() {

        int totalCustomers;
        totalCustomers = customers.size();
        return totalCustomers;
    }
    public void saveCustomerlist(String filename) {

        try {
            PrintWriter printWriter = new PrintWriter(new File(filename));
            for (Customer c : customers) {
                printWriter.println(c.getCode() + "," + c.getName() + "," + c.getSurname() + "," + c.getAddress()
                        + "," + c.getPhone() + "," + c.getEmail() );
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file cannot be saved");
        }

    }


    public void loadCustomerlist(String filename) {
        customers.clear();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(",");
                Customer customer = new Customer(
                        words[0],
                        words[1],
                        words[2],
                        words[3],
                        words[4],
                        words[5]);
                customers.add(customer);
            }
        } catch (Exception e) {
        }
    }
}
