
public class Fuel {
    private int id;
    private String type;
    private double pricePerLitre;
    private double stock;

    public Fuel(int id, String type, double pricePerLitre, double stock) {
        this.id = id;
        this.type = type;
        this.pricePerLitre = pricePerLitre;
        this.stock = stock;
    }

    public Fuel(String type, double pricePerLitre, double stock) {
        this.type = type;
        this.pricePerLitre = pricePerLitre;
        this.stock = stock;
    }
    public int getId() { return id; }
    public String getType() { return type; }
    public double getPricePerLitre() { return pricePerLitre; }
    public double getStock() { return stock; }

    public void setId(int id) { this.id = id; }
    public void setType(String type) { this.type = type; }
    public void setPricePerLitre(double pricePerLitre) { this.pricePerLitre = pricePerLitre; }
    public void setStock(double stock) { this.stock = stock; }
}