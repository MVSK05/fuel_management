
public class Sale {
    private int id;
    private int fuelId;
    private double quantity;
    private double totalAmount;

    public Sale(int fuelId, double quantity, double totalAmount) {
        this.fuelId = fuelId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    // Getters
    public int getFuelId() { return fuelId; }
    public double getQuantity() { return quantity; }
    public double getTotalAmount() { return totalAmount; }
}
