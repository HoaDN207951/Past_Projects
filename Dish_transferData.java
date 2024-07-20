/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DbConnection;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Dish;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import model.Ingredient;
public class Dish_transferData {
    public List<Dish> getDishByCategory(String category_name) throws ClassNotFoundException, SQLException{
        List<Dish> dishes = new ArrayList<>();
        DbConnection DB = new DbConnection();
        Connection con = (Connection) DB.getConnection();
        
        String sql = "SELECT * FROM dish WHERE id IN (SELECT dish_id FROM dish_categ WHERE category_id IN (SELECT id FROM category WHERE name = ?)) AND status = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, category_name);
            preparedStatement.setInt(2, 1);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Dish dish = new Dish();
                dish.setID(rs.getInt("id"));
                dish.setName(rs.getString("name"));
                dish.setPrice(rs.getInt("price"));

                dishes.add(dish);
            }
        } catch (SQLException e) {}
        return dishes;
    }
    public List<Dish> getDishByOrigin(String origin_name) throws ClassNotFoundException, SQLException{
        List<Dish> dishes = new ArrayList<>();
        DbConnection DB = new DbConnection();
        Connection con = (Connection) DB.getConnection();
        
        String sql = "SELECT * FROM dish WHERE id IN (SELECT dish_id FROM dish_org WHERE org_id IN (SELECT id FROM origin WHERE name = ?)) AND status = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, origin_name);
            preparedStatement.setInt(2, 1);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Dish dish = new Dish();
                dish.setID(rs.getInt("id"));
                dish.setName(rs.getString("name"));
                dish.setPrice(rs.getInt("price"));

                dishes.add(dish);
            }
        } catch (SQLException e) {}
        return dishes;
    }
    public List<Dish> getDishByCategorySearch(String category_name) throws ClassNotFoundException, SQLException{
        List<Dish> dishes = new ArrayList<>();
        DbConnection DB = new DbConnection();
        Connection con = (Connection) DB.getConnection();
        
        String sql = "SELECT * FROM dish WHERE id IN (SELECT dish_id FROM dish_categ WHERE category_id in (SELECT id FROM category WHERE name = ?)) AND status = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, category_name);
            preparedStatement.setInt(2, 1);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Dish dish = new Dish();
                dish.setID(rs.getInt("id"));
                dish.setName(rs.getString("name"));
                dish.setPrice(rs.getInt("price"));

                dishes.add(dish);
            }
        } catch (SQLException e) {}
        return dishes;
    }
    public List<Dish> getAllDish() throws ClassNotFoundException, SQLException{
        List<Dish> dishes = new ArrayList<>();
        DbConnection DB = new DbConnection();
        Connection con = (Connection) DB.getConnection();
        
        String sql = "SELECT * FROM dish WHERE status = 1";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Dish dish = new Dish();
                dish.setID(rs.getInt("id"));
                dish.setName(rs.getString("name"));
                dish.setPrice(rs.getInt("price"));

                dishes.add(dish);
            }
        } catch (SQLException e) {}
        return dishes;
    }
    
    public List<Ingredient> getIngredient(String dish_name, int dish_id) throws ClassNotFoundException, SQLException{
        List<Ingredient> ingredients = new ArrayList<>();
        DbConnection DB = new DbConnection();
        Connection con = (Connection) DB.getConnection();
        
        String sql = "select s1.name , amount, unit from (select ingredients.id, ingredients.name, unit.name as unit from ingredients, unit where unit_id = unit.id) as s1, (select name, ingre_id, amount from dish, dish_ingredients where dish_id = ?) as s2 where ingre_id = s1.id and s2.name = ?";
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, dish_id);
            preparedStatement.setString(2, dish_name);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Ingredient ingre = new Ingredient();
                ingre.setName(rs.getString("name"));
                ingre.setAmount(rs.getInt("amount"));
                ingre.setUnit(rs.getString("unit"));
                ingredients.add(ingre);
            }
        } catch (SQLException e) {}
        return ingredients;
    }
}
