//	Executar comandos no banco (inserir, buscar, atualizar, deletar produtos).

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.naming.spi.DirStateFactory.Result;

import java.sql.*;

public class ProductsDAO {
    

    //CREATE - Input a new product
    public void addProduct(Products product) {
        String sql = "INSERT INTO products (name, quantity, price) VALUES (?, ?, ?)";

        try(Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, product.getName());
                stmt.setInt(2, product.getQuantity());
                stmt.setDouble(3, product.getPrice());

                stmt.executeUpdate();
                System.out.println("✅ Produto inserido com sucesso!");


            } catch (SQLException e) {
                System.out.println("❌ Erro ao inserir produto:");
                e.printStackTrace();
            }
        }

    //READ - List all products    
    public List<Products> getAllProducts() {
        List<Products> productList = new ArrayList<>();
        String sql = "SELECT * FROM products";
        
        try(Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

                while(rs.next()) {
                    Products p = new Products(
                        rs.getInt("id"), 
                        rs.getString("name"), 
                        rs.getInt("quantity"), 
                        rs.getDouble("price")
                    );
                    productList.add(p);
                }
            } catch (SQLException e) {
                System.out.println("❌ Erro ao buscar produtos:");
                e.printStackTrace();
            }

        return productList;
    }

    //UPDATE - Updating a product
    public void updateProduct(Products product) {
        String sql = "UPDATE products SET name = ?, quantity = ?, price = ? WHERE id = ?";

        try(Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                
                stmt.setString(1, product.getName());
                stmt.setInt(2, product.getQuantity());
                stmt.setDouble(3, product.getPrice());
                stmt.setInt(4, product.getId());

                stmt.executeUpdate();
                System.out.println("✅ Produto atualizado com sucesso!");

            } catch (SQLException e) {
                System.out.println("❌ Erro ao atualizar produto:");
                e.printStackTrace();
            }
    }

    //DELETE - Delete a product
    public void deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try(Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, id);
                stmt.executeUpdate();
                System.out.println("✅ Produto deletado com sucesso!");
        
            } catch (SQLException e) { 
                System.out.println("❌ Erro ao deletar produto:");
                e.printStackTrace();
        }
    }
}
