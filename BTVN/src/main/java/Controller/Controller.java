package Controller;

import database.ConnectJDBC;
import model.film;
import service.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    Service service;
    ConnectJDBC connectJDBC;
    Connection conn;
    ArrayList<film> film;
    Scanner sc;
    public Controller() {
        service = new Service();
        connectJDBC = new ConnectJDBC();
        conn = connectJDBC.connect();
        film = service.getFilmByRating(conn);
        sc = new Scanner(System.in);
    }
    public void MainMenu (){
    Boolean isCheck = false;
        while (!isCheck){
        menu();
        System.out.print("Nhập lựa chọn : ");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice){
            case 1:
                for (film f: film){
                    System.out.println(f);
                }
                break;
            case 2:
                service.filmAndActor(conn);
                break;
            case 3:
                System.out.print("Nhập tên phim muốn tìm : ");
                String title = sc.nextLine();
                service.searchByTitle(conn,title);
                break;
            default:
                System.out.println("Kết thúc chương trình!!!");
                isCheck  = true;
        }
    }
}
    public static void menu(){
        System.out.println("1 - Lấy ra phim có rating PG");
        System.out.println("2 - Lấy ra tên phim và diễn viên phim có tên chứa ACADEMY");
        System.out.println("3 - Tìm phim theo tên");
        System.out.println("Bấm số bất kì để thoát");
    }

    public void Update (){
        service.Updatefilm(conn);
    }
}
