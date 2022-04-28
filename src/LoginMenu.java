import java.io.IOException;
import java.util.Scanner;

public class LoginMenu {
    ManageUser manageUser = new ManageUser();
    Scanner scc = new Scanner(System.in);
    Scanner scs = new Scanner(System.in);
    private static final String PATH_USER = "user.csv";
    public static String userName;
    public static String userPass;
    public void displayMenuUser() throws IOException {
        manageUser.setUserList(DocumentUser.readFile(PATH_USER));
        System.out.println("------Chào mừng bạn đến-------");
        System.out.println("1. Đăng nhập ");
        System.out.println("2. Đăng kí ");
        System.out.println("3. Thoát ");
        System.out.print("Chọn chức năng : ");
    }
    public void loginMenuUser(){
        System.out.println("----Chào mừng bạn đến màn hình đăng nhập----");
        System.out.println("Nhập tài khoản :");
        userName = scc.nextLine();
        System.out.println("Nhập mật khẩu : ");
        userPass = scc.nextLine();
        if (manageUser.findByUser(userName,userPass)!=-1){
            System.out.println("Bạn đã đăng nhập thành công !!!!");
            System.out.println("---------------------------------");
            System.out.println(manageUser.displayUser(userName,userPass));
        }else System.out.println("Bạn nhập sai tên đăng nhập hoặc mật khẩu !!!");
    }
    public void addMenuUser() throws IOException {
        System.out.println("Nhập tài khoản : ");
        userName = scc.nextLine();
        if (manageUser.findByNameUser(userName)==-1){
            System.out.println("Nhập mật khẩu : ");
            userPass = scc.nextLine();
            System.out.println("Nhập lại mật khẩu");
            String repass = scc.nextLine();
            if (userPass.equals(repass)) {
                manageUser.addUser(new User(userName, userPass));
                System.out.println("Bạn đã đăng kí thành công tài khoản : " + userName);
                DocumentUser.writeFile(PATH_USER,manageUser.getUserList());
            }else System.out.println("Bạn cần nhập 2 mật khẩu giống nhau !!");
        }else {
            System.out.println("Tài khoản đã tồn tại !!!");
        }
    }
    public void editMenuUser() throws IOException {
        int choice = -1;
        while (choice != 2) {
            System.out.println("Thông tin tài khoản của bạn : ");
            manageUser.inforUser(userName,userPass);
            System.out.println("1.Đổi mật khẩu ");
            System.out.println("2.Thoát");
            choice = ExceptionMenu.getChoice(scs,choice);
            if (choice == 1) {
                User user1 = new User();
                user1.setUserName(userName);
                String oldPass = userPass;
                System.out.println("Nhập mật khẩu mới : ");
                userPass = scc.nextLine();
                user1.setUserPass(userPass);
                manageUser.editUser(userName, oldPass, user1);
                System.out.println("Bạn đã thay đổi mật khẩu thành công :");
                DocumentUser.writeFile(PATH_USER,manageUser.getUserList());
            }
        }
    }
}
