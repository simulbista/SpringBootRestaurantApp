package com.humber.Week5JPARestaurantApp.repositories;

import com.humber.Week5JPARestaurantApp.models.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

//        public List<Dish> findByCategoryAndPrice(String category, Double price);


//    custom query
//    @Query("select d from Dish d where lower(d.category)=lower(?1) and d.price=?2")
//    public List<Dish> findByCategoryAndPrice(String category, Double price);

    @Query(value = "select * from Dish where lower(category)=lower(?1) and price=?2", nativeQuery = true)
    public List<Dish> findByCategoryAndPrice(String category, Double price);

}
