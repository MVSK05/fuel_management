
import java.sql.Connection;
import java.sql.PreparedStatement;

public class SaleDAO {
    public void createTable() {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                "CREATE TABLE IF NOT EXISTS sale (id INTEGER PRIMARY KEY AUTOINCREMENT, fuel_id INTEGER, quantity REAL, total_amount REAL)"
             )) {
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void recordSale(Sale sale) {
        String sql = "INSERT INTO sale(fuel_id, quantity, total_amount) VALUES(?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, sale.getFuelId());
            pstmt.setDouble(2, sale.getQuantity());
            pstmt.setDouble(3, sale.getTotalAmount());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}