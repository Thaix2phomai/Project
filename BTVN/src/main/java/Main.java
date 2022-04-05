import Controller.Controller;
import database.ConnectJDBC;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Controller co = new Controller();
//      co.MainMenu();
        co.Update();
    }
}
