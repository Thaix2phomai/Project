import Model.Repository;
import Model.User;
import Service.Service;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    Service service = new Service();
    Scanner sc = new Scanner(System.in);
    ArrayList<User> listUser = Repository.getData();
    public void mainMenu() {
        boolean isCheck = false;
        while (!isCheck) {
            menu();
            int choice = checkInput();
            switch (choice) {
                case 1:
                    service.goLogin();
                    break;
                case 2:
                    service.goSignin();
                    break;
                case 0:
                    isCheck = true;
                    System.exit(1);
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
            }
        }
    }

    public static void menu() {
        System.out.println("Bạn có thể thực hiện: ");
        System.out.println("1 - Đăng Nhập");
        System.out.println("2 - Đăng Ký");
        System.out.println("0 - Dừng chương trình");
        System.out.println("Lựa chọn của bạn là: ");
    }

    public static int checkInput() {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        boolean isCheck = false;
        while (!isCheck) {
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number < 0) throw new ArithmeticException("Nhập số không hợp lệ");
                isCheck = true;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage() + " " + "vui lòng nhập lại");
            } catch (NumberFormatException e) {
                System.out.println("Bạn cần phải nhập số, vui lòng nhập lại");
            }
        }
        return number;
    }
}
