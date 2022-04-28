import java.util.ArrayList;
import java.util.List;

public class ManageUser {
    public static List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public int findByUser(String username, String userpass) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUserName()) && userpass.equals(userList.get(i).getUserPass())) {
                return i;
            }
        }
        return -1;
    }

    public int findByNameUser(String name) {
        for (int i = 0; i < userList.size(); i++) {
            if (name.equals(userList.get(i).getUserName())) {
                return i;
            }
        }
        return -1;
    }

    public void editUser(String name, String pass, User user) {
        if (findByUser(name, pass) != -1) {
            userList.set(findByUser(name, pass), user);
        } else {
            System.out.println("Không tìm thấy user!!");
        }
    }

    public String displayUser(String username, String userpass) {
        String str = "username : ";
        if (findByUser(username, userpass) != -1) {
            str += username;
        }
        return str;
    }

    public void inforUser(String name, String pass) {
        if (findByUser(name, pass) != -1) {
            System.out.println("Tên tài khoản : " + name + " ,Mật khẩu : " + pass);
        }
    }
}
