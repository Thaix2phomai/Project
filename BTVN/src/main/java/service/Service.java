package service;

import model.film;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Service {

    public ArrayList<film> getFilmByRating(Connection conn) {
        String query = "SELECT title, description, release_year, length, rating,JSON_ARRAYAGG(name) AS 'category' \n" +
                "FROM film\n" +
                "INNER JOIN film_category ON film.film_id = film_category.film_id\n" +
                "INNER JOIN category ON film_category.category_id = category.category_id\n" +
                "WHERE rating = 'PG'\n" +
                "GROUP BY film.film_id";

        ArrayList<film> filmbycategory = new ArrayList<>();
        try {
            //Tạo truy vấn
            Statement stm = conn.createStatement();

            //Thực thi truy vấn
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String title = (rs.getString("title"));
                String description = (rs.getString("description"));
                int release_year = (rs.getInt("release_year"));
                int length = (rs.getInt("length"));
                String rating = (rs.getString("rating"));
                String category = (rs.getString("category"));
                filmbycategory.add(new film(title, description, release_year, length, rating, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmbycategory;

    }

    public void filmAndActor(Connection conn) {
        String query = "SELECT title , first_name , last_name\n" +
                "FROM film\n" +
                "INNER JOIN film_actor ON film.film_id = film_actor.film_id\n" +
                "INNER JOIN actor ON film_actor.actor_id = actor.actor_id\n" +
                "WHERE title LIKE '%ACADEMY%'";

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                System.out.println("title : " + rs.getString("title"));
                System.out.println("first name : " + rs.getString("first_name"));
                System.out.println("last name : " + rs.getString("last_name"));
                System.out.println("-----------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchByTitle(Connection conn, String title) {
        String query = "SELECT * FROM film \n" +
                "WHERE title LIKE '%" + title + "%'";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            int count = 0;
            while (rs.next()) {
                System.out.println("id : " + rs.getInt("film_id"));
                System.out.println("title : " + rs.getString("title"));
                System.out.println("description : " + rs.getString("description"));
                System.out.println("release_year : " + rs.getInt("release_year"));
                System.out.println("original_language_id : " + rs.getInt("original_language_id"));
                System.out.println("rental_duration : " + rs.getInt("rental_duration"));
                System.out.println("language_id : " + rs.getInt("language_id"));
                System.out.println("rental_rate : " + rs.getDouble("rental_rate"));
                System.out.println("length : " + rs.getInt("length"));
                System.out.println("replacement_cost : " + rs.getDouble("replacement_cost"));
                System.out.println("rating : " + rs.getString("rating"));
                System.out.println("special_features : " + rs.getString("special_features"));
                System.out.println("last_update : " + rs.getString("last_update"));
                System.out.println("--------------");
                count ++;
            }
            if (count == 0){
                System.out.println("Không có phim tìm kiếm!!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void Updatefilm(Connection conn) {
        String query = "UPDATE film \n" +
                "SET film.description = 'Giáo sư Cường và những người bạn'\n" +
                "WHERE film_id = 1";

        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            System.out.println("Sửa thành công");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
