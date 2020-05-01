package gr.codehub.app;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Basket {

    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayProducts() {

        for (Product p : products) {
            System.out.println(p);
        }
    }

    public void removeProduct(int index) {
        if (index >= 0 && index <= products.size()) {
            products.remove(index);
        }
    }

    public void clearProducts() {
        products.clear();
    }

    public float getTotalCost() {

        float totalProductsPrice;


        //2nd method
        totalProductsPrice = 0;
        for (Product p : products) {
            totalProductsPrice += p.getPrice() * p.getQuantity();
        }


        return totalProductsPrice;
    }


    public void saveBasket(String filename) {

        try {
            PrintWriter printWriter = new PrintWriter(new File(filename));
            for (Product p : products) {
                printWriter.println(p.getCode() + "," + p.getName() + "," + p.getPrice()
                        + "," + p.getQuantity());
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file cannot be saved");
        }

    }


    public void loadBasket(String filename) {
        products.clear();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(",");
                Product product = new Product(
                        words[0],
                        words[1],
                        Float.parseFloat(words[2]),
                        Integer.parseInt(words[3]));
                products.add(product);
            }
        } catch (Exception e) {
        }
    }

}

