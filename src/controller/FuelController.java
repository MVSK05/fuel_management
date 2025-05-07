
import model.*;
import java.util.List;

public class FuelController {
    private final FuelDAO fuelDAO = new FuelDAO();
    private final SaleDAO saleDAO = new SaleDAO();

    public FuelController() {
        fuelDAO.createTable();
        saleDAO.createTable();
    }

    public void addFuel(String type, double price, double stock) {
        fuelDAO.addFuel(new Fuel(type, price, stock));
    }

    public List<Fuel> getAllFuel() {
        return fuelDAO.getAllFuel();
    }

    public boolean processSale(int fuelId, double quantity) {
        Fuel fuel = fuelDAO.getFuelById(fuelId);
        if (fuel != null && fuel.getStock() >= quantity) {
            double totalAmount = quantity * fuel.getPricePerLitre();
            fuelDAO.updateStock(fuelId, quantity);
            saleDAO.recordSale(new Sale(fuelId, quantity, totalAmount));
            System.out.println("Bill Amount: ₹" + totalAmount);
            return true;
        } else {
            System.out.println("Insufficient fuel stock!");
            return false;
        }
    }
}