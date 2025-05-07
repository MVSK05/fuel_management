

import java.util.List;
import java.util.Scanner;

public class FuelView {
    private final FuelController controller = new FuelController();
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("\n--- Fuel Station Management ---");
            System.out.println("1. Add Fuel");
            System.out.println("2. View Fuel Stock");
            System.out.println("3. Sell Fuel");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addFuel();
                case 2 -> viewFuel();
                case 3 -> sellFuel();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void addFuel() {
        scanner.nextLine(); // consume newline
        System.out.print("Enter fuel type: ");
        String type = scanner.nextLine();
        System.out.print("Enter price per litre: ");
        double price = scanner.nextDouble();
        System.out.print("Enter initial stock (litres): ");
        double stock = scanner.nextDouble();
        controller.addFuel(type, price, stock);
        System.out.println("Fuel added successfully.");
    }

    private void viewFuel() {
        List<Fuel> fuels = controller.getAllFuel();
        System.out.println("ID | Type | Price/Litre | Stock");
        for (Fuel f : fuels) {
            System.out.printf("%d | %s | %.2f | %.2f\n",
                f.getId(), f.getType(), f.getPricePerLitre(), f.getStock());
        }
    }

    private void sellFuel() {
        viewFuel();
        System.out.print("Enter fuel ID to sell: ");
        int id = scanner.nextInt();
        System.out.print("Enter quantity (litres): ");
        double qty = scanner.nextDouble();
        controller.processSale(id, qty);
    }
}
