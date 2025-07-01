//Testar ou orquestrar o fluxo da aplicação.

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ProductsDAO dao = new ProductsDAO();

        int opcao;

        do {
            System.out.println("=================================");
            System.out.println("--- INVENTORY SYSTEM ENHANCED ---");
            System.out.println("=================================");
            System.out.println("1. Add a Product");
            System.out.println("2. View inventory");
            System.out.println("3. Update a Product");
            System.out.println("4. Delete a product");
            System.out.println("5. Exit");
            System.out.println("=================================");
            System.out.print("Enter a number: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("\nName: ");
                    String name = scanner.nextLine();
                    System.out.print("Quantity: ");
                    int qtt = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Price: ");
                    double prizes = scanner.nextDouble();
                    scanner.nextLine();
                    dao.addProduct(new Products(name, qtt, prizes));
                    break;
                
                case 2:
                    System.out.println("=================================");
                    System.out.println("-- ALL INVENTORY CURRENT ITEMS --");
                    System.out.println("=================================");
                    List<Products> produtos = dao.getAllProducts();
                    for(Products p : produtos) {
                        System.out.println(p);
                    }
                    break;
                
                case 3:
                    System.out.print("Products ID you want to update: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Updated Name: ");
                    String nameUpdate = scanner.nextLine();
                    
                    System.out.print("Update Quantity: ");
                    int quantityUpdate = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Update Price: ");
                    double priceUpdate = scanner.nextDouble();
                    scanner.nextLine();

                    dao.updateProduct(new Products(idUpdate, nameUpdate, quantityUpdate, priceUpdate));
                    break;
                
                case 4:
                    System.out.print("Enter the Product ID to delete: ");
                    int idDelete = scanner.nextInt();
                    scanner.nextLine();

                    dao.deleteProduct(idDelete);
                    break;
                
                case 5:
                    System.out.println("Shuting down...");
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } while(opcao != 5);

        scanner.close();
    }
}
