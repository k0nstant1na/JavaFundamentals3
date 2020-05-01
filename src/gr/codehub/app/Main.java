package gr.codehub.app;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice = 0;
        System.out.println("1. Customer   2. Company ");
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt();
        }
        catch(Exception e){
            System.out.println("Press 1 or 2");
        }

        if(choice == 1) {
            Ui ui = new Ui();
            Basket basket = new Basket();
            ui.manageBasket(basket);
        }
        if(choice == 2) {
            UIC uic = new UIC();
            CustomerList customerlist = new CustomerList();
            uic.manageCustomerList(customerlist);
        }
    }

}
