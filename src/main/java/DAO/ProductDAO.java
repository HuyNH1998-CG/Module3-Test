package DAO;

import Connector.Connect;
import Model.Category;
import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Connection connection;
    private String query;
    private PreparedStatement statement;
    private ResultSet rs;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertProduct(String name, int amount, String colour, String description, int category, float price) {
        try {
            query = "insert into product (name, amount, color, description, category, price) VALUE (?,?,?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2, amount);
            statement.setString(3, colour);
            statement.setString(4, description);
            statement.setInt(5, category);
            statement.setFloat(6, price);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editProduct(int id, String name, int amount, String colour, String description, int category, float price) {
        try {
            query = "update product set name=?, amount=?, color=?, description=?, category=?, price=? where id=?;";
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2, amount);
            statement.setString(3, colour);
            statement.setString(4, description);
            statement.setInt(5, category);
            statement.setFloat(6, price);
            statement.setInt(7, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        try {
            query = "delete from product where id=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getProduct() {
        List<Product> list = new ArrayList<>();
        try {
            query = "select product.id, product.name, amount, color, description, price, c.name as category from product inner join category c on product.category = c.id";
            statement = connection.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int amount = rs.getInt("amount");
                String colour = rs.getString("color");
                String description = rs.getString("description");
                float price = rs.getFloat("price");
                String category = rs.getString("category");
                list.add(new Product(id, name, price, amount, colour, description, category));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getProductByName(String name) {
        List<Product> list = new ArrayList<>();
        try {
            query = "select product.id, product.name, amount, color, description, price, c.name as category from product inner join category c on product.category = c.id where product.name like '%" + name +"%'";
            statement = connection.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fname = rs.getString("name");
                int amount = rs.getInt("amount");
                String colour = rs.getString("color");
                String description = rs.getString("description");
                float price = rs.getFloat("price");
                String category = rs.getString("category");
                list.add(new Product(id, fname, price, amount, colour, description, category));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public Product getProductById(int id) {
        Product list = null;
        try {
            query = "select product.id, product.name, amount, color, description, price, c.name as category from product inner join category c on product.category = c.id where product.id=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int amount = rs.getInt("amount");
                String colour = rs.getString("color");
                String description = rs.getString("description");
                float price = rs.getFloat("price");
                String category = rs.getString("category");
                list = new Product(id, name, price, amount, colour, description, category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Category> getCategory(){
        List<Category> list = new ArrayList<>();
        try {
            query ="select * from category";
            statement = connection.prepareStatement(query);
            rs = statement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                list.add(new Category(id,name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
