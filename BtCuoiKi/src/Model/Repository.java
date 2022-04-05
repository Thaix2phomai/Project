package Model;

import java.util.ArrayList;

public class Repository {
        public static ArrayList<User> getData() {
            ArrayList<User> listUser = new ArrayList<>();
            listUser.add(new User("thai226", "Thai123@", "thaithedoublecheese1@gmail.com"));
            listUser.add(new User("tuan123", "tuanNhe1@", "tuanok1@gmail.com"));
            listUser.add(new User("cuong99", "Cuong@anh2", "cuong123@gmail.com"));
            listUser.add(new User("dungpham1", "dUngchien@45", "dungchat1@gmail.com"));
            listUser.add(new User("khaigay33", "kPaiha9@", "khaihi1235@gmail.com"));
            return listUser;
        }
}
