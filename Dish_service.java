/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DbConnection.Dish_transferData;
import java.sql.SQLException;
import java.util.List;
import model.Dish;
import model.Ingredient;
public class Dish_service {
    private Dish_transferData dish_data = new Dish_transferData();
    public List<Dish> getDishByCategory(String category_name) throws ClassNotFoundException, SQLException{
        return dish_data.getDishByCategory(category_name);
    }
    public List<Dish> getAllDish() throws ClassNotFoundException, SQLException{
        return dish_data.getAllDish();
    }
    
    public List<Dish> getDishByOrigin(String origin_name) throws ClassNotFoundException, SQLException{
        return dish_data.getDishByOrigin(origin_name);
    }
    
    public List<Dish> getDishByCategorySearch(String category_name) throws ClassNotFoundException, SQLException{
        return dish_data.getDishByCategorySearch(category_name);
    }
    public List<Ingredient> getIngredient(String dish_name,  int dish_id) throws ClassNotFoundException, SQLException{
        return dish_data.getIngredient(dish_name, dish_id);
    }
}
