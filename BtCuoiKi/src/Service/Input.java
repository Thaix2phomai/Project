package Service;

import java.util.Scanner;

public class Input {


    public static String checkUsername() {
        Scanner sc = new Scanner(System.in);
        String username = null;
        boolean isCheck = false;
        while (!isCheck) {
            try {
                username = sc.nextLine();
                if (username.trim().isEmpty()) throw new MyException("Tài khoản không được để trống ");
                isCheck = true;
            } catch (MyException e) {
                System.out.println(e.getMessage() + " vui lòng nhập lại !!!");
            }
        }
        return username;
    }

    public static String checkEmail() {
        Scanner sc = new Scanner(System.in);
        String email = null;
        boolean isCheck = false;
        while (!isCheck) {
            try {
                email = sc.nextLine();
                if (!Validate.validateEmail(email)) throw new MyException("Nhập Email không hợp lệ, ");
                isCheck = true;
            } catch (MyException e) {
                System.out.println(e.getMessage() + "vui lòng nhập lại");
            }
        }
        return email;

    }

    public static String checkPassword() {
        Scanner sc = new Scanner(System.in);
        String password = null;
        boolean isCheck = false;
        while (!isCheck) {
            try {
                password = sc.nextLine();
                if (!Validate.validatePassword(password))
                    throw new MyException("Nhập pass word 7-14 ký tự bao gồm 1 chữ viết Hoa và 1 ký tự đặc biệt, ");
                isCheck = true;
            } catch (MyException e) {
                System.out.println(e.getMessage() + "vui lòng nhập lại");
            }
        }
        return password;

    }
}
