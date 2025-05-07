
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuelDAO {
    public void createTable() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS fuel (id INTEGER PRIMARY KEY AUTOINCREMENT, type TEXT, price REAL, stock REAL)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addFuel(Fuel fuel) {
        String sql = "INSERT INTO fuel(type, price, stock) VALUES(?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fuel.getType());
            pstmt.setDouble(2, fuel.getPricePerLitre());
            pstmt.setDouble(3, fuel.getStock());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Fuel> getAllFuel() {
        List<Fuel> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM fuel")) {
            while (rs.next()) {
                list.add(new Fuel(
                    rs.getInt("id"),
                    rs.getString("type"),
                    rs.getDouble("price"),
                    rs.getDouble("stock")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateStock(int fuelId, double quantity) {
        String sql = "UPDATE fuel SET stock = stock - ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, quantity);
            pstmt.setInt(2, fuelId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Fuel getFuelById(int id) {
        String sql = "SELECT * FROM fuel WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Fuel(rs.getInt("id"), rs.getString("type"),
                        rs.getDouble("price"), rs.getDouble("stock"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}