import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scc = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);
        QuanLyDanhBa quanLyDanhBa = new QuanLyDanhBa();
        String name;
        int phoneNumber;
        String adress;
        String email;
        String gender;
        String gruop;
        int age;
        int choice = -1;
        while (choice != 8) {
            System.out.println("------Chương trình quản lý danh bạ ------");
            System.out.println("Chọn chức năng theo số (để tiếp tục) : ");
            System.out.println("1. Xem danh sách ");
            System.out.println("2. Thêm mới ");
            System.out.println("3. Cập nhật ");
            System.out.println("4. Xóa ");
            System.out.println("5. Tìm kiếm ");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát ");
            System.out.print("Chọn chức năng : ");
            try {
                choice = scs.nextInt();
                if (choice > 8 || choice < 1) {
                    throw new Exception();
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED+"Không được nhập chữ !!!"+ANSI_RESET);
                scs.nextLine();
                choice = -1;
            } catch (Exception e) {
                System.out.println(ANSI_RED+"Chỉ được nhập số từ 1 --> 8"+ANSI_RESET);
            }
            switch (choice) {
                case 1:
                    System.out.println("Toàn bộ danh bạ : ");
                    quanLyDanhBa.displayAll();
                    break;
                case 2:
                    System.out.println("Nhập tên : ");
                    name = scc.nextLine();
                    phoneNumber = checkExceptionNumber("Nhập sđt : ");
                    age = checkExceptionNumber("Nhập tuổi : ");
                    System.out.println("Nhập địa chỉ : ");
                    adress = scc.nextLine();
                    System.out.println("Nhập giới tính : ");
                    gender = scc.nextLine();
                    System.out.println("Nhập email : ");
                    email = scc.nextLine();
                    System.out.println("Nhập nhóm : ");
                    gruop = scc.nextLine();
                    quanLyDanhBa.add(new DanhBa(name, phoneNumber, adress, email, gruop, gender, age));
                    break;
                case 3:
                    phoneNumber = checkExceptionNumber("Nhập sđt cần sửa : ");
                    System.out.println("Nhập tên mới : ");
                    name = scc.nextLine();
                    System.out.println("Nhập nhóm mới : ");
                    gruop = scc.nextLine();
                    System.out.println("Nhập địa chỉ mới : ");
                    adress = scc.nextLine();
                    System.out.println("Nhập giới tính : ");
                    gender = scc.nextLine();
                    System.out.println("Nhập email mới : ");
                    email = scc.nextLine();
                    age = checkExceptionNumber("Nhập tuổi mới : ");
                    quanLyDanhBa.edit(phoneNumber, new DanhBa(name, phoneNumber, adress, email, gruop, gender, age));
                    break;
                case 4:
                    String flag;
                    phoneNumber = checkExceptionNumber("Nhập vào sđt cần xóa : ");
                    quanLyDanhBa.displayFindByPhoneNumber(phoneNumber);
                    System.out.println("Bạn có muốn xóa hay không y/n");
                    flag = scc.nextLine();
                    if (flag.equals("y")) {
                        quanLyDanhBa.delete(phoneNumber);
                        System.out.println("Bạn đã xóa thành công !!");
                    }
                    break;
                case 5:
                    phoneNumber = checkExceptionNumber("Nhập sđt cần tìm");
                    System.out.println(quanLyDanhBa.findByPhoneNumber(phoneNumber));
                    break;
                case 6:
                    FileDanhBa.readFile("danhba.csv");
                    break;
                case 7:
                    FileDanhBa.writeFile("danhba.csv", quanLyDanhBa.danhBaList);
                    break;
            }
        }
    }

    private static int checkExceptionNumber(String message) {
        int choice = -1;
        Scanner scs = new Scanner(System.in);
        boolean check = false;
        while (!check) {
            try {
                System.out.println(message);
                choice = scs.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Chỉ được nhập số !!!!!" + ANSI_RESET);
                scs.nextLine();
            }
        }
        return choice;
    }

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
}
