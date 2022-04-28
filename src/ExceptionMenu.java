import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionMenu {
    public static int checkExceptionNumber(String message) {
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
    public static int getChoice(Scanner scs, int choice) {
        try {
            choice = scs.nextInt();
            if (choice > 8 || choice < 1) throw new Exception();
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + "Không được nhập chữ !!!" + ANSI_RESET);
            scs.nextLine();
            choice = -1;
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Chỉ được nhập số từ 1 --> 8" + ANSI_RESET);
        }
        return choice;
    }

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
}
