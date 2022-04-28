
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner scc = new Scanner(System.in);
    ManageContact manageContact = new ManageContact();
    ManageUser manageUser = new ManageUser();
    private String name;
    private int phoneNumber;
    private String address;
    private int age;
    private String group;
    private String gender;
    private String email;
    private static final String PATH = "danhba.csv";

    public  void displayMenu() throws IOException {
        manageContact.setContactList(DocumentContact.readFile(PATH));
        System.out.println("------Chương trình quản lý danh bạ ------");
        System.out.println("Chọn chức năng theo số (để tiếp tục) : ");
        System.out.println("1. Xem danh sách ");
        System.out.println("2. Thêm mới ");
        System.out.println("3. Cập nhật ");
        System.out.println("4. Xóa ");
        System.out.println("5. Tìm kiếm ");
        System.out.println("6. Đổi mật khẩu  ");
        System.out.println("7. Thoát ");
        System.out.print("Chọn chức năng : ");
    }

    public void displayContactMenu() {
        System.out.println("Toàn bộ danh bạ : ");
        manageContact.displayAll();
    }

    public void addMenu() throws IOException {
        boolean check = false;
        phoneNumber = ExceptionMenu.checkExceptionNumber("Nhập sđt : ");
        if (manageContact.findByPhoneNumber(phoneNumber) == -1) {
            System.out.println("Nhập tên : ");
            name = scc.nextLine();
            age = ExceptionMenu.checkExceptionNumber("Nhập tuổi : ");
            System.out.println("Nhập địa chỉ : ");
            address = scc.nextLine();
            System.out.println("Nhập giới tính : ");
            gender = scc.nextLine();
            System.out.println("Nhập email : ");
            email = scc.nextLine();
            System.out.println("Nhập nhóm : ");
            group = scc.nextLine();
            manageContact.add(new Contact(name,phoneNumber,age,address,email,group,gender,LoginMenu.userName));
            DocumentContact.writeFile(PATH,manageContact.getContactList());
            System.out.println("Thêm thành công " + name + " !!!");
            check = true;
        }
        if (!check) {
            System.out.println("Bạn nhập trùng sđt!!!");
        }
    }

    public void editMenu() throws IOException {
        phoneNumber = ExceptionMenu.checkExceptionNumber("Nhập sđt cần sửa : ");
        if (manageContact.findByPhoneNumber(phoneNumber) != -1) {
            System.out.println("Nhập tên mới : ");
            name = scc.nextLine();
            System.out.println("Nhập nhóm mới : ");
            group = scc.nextLine();
            System.out.println("Nhập địa chỉ mới : ");
            address = scc.nextLine();
            System.out.println("Nhập giới tính : ");
            gender = scc.nextLine();
            System.out.println("Nhập email mới : ");
            email = scc.nextLine();
            age = ExceptionMenu.checkExceptionNumber("Nhập tuổi mới : ");
            manageContact.edit(phoneNumber, new Contact(name, phoneNumber, age, address, email, group, gender,LoginMenu.userName));
            DocumentContact.writeFile(PATH,manageContact.getContactList());
            System.out.println("Bạn đã sửa thành công " + name + " !!!");
        } else {
            System.out.println("Không tìm thấy sđt trong danh bạ!!");
        }
    }

    public void deleteMenu() throws IOException {
        phoneNumber = ExceptionMenu.checkExceptionNumber("Nhập vào sđt cần xóa : ");
        manageContact.displayFindByPhoneNumber(phoneNumber);
        if (manageContact.findByPhoneNumber(phoneNumber) != -1) {
            System.out.println("Bạn có muốn xóa hay không y/n");
            String flag = scc.nextLine();
            if (flag.equals("y")) {
                manageContact.delete(phoneNumber);
                DocumentContact.writeFile(PATH,manageContact.getContactList());
                System.out.println("Bạn đã xóa thành công !!");
            }
        }
    }

    public void findMenu() {
        phoneNumber = ExceptionMenu.checkExceptionNumber("Nhập sđt cần tìm ");
        manageContact.displayFindByPhoneNumber(phoneNumber);
    }
}
