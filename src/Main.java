import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scs = new Scanner(System.in);
        Menu menu = new Menu();
        LoginMenu loginMenu = new LoginMenu();
        int choice_1 = -1;
        while (choice_1 != 3) {
            loginMenu.displayMenuUser();
            choice_1 = ExceptionMenu.getChoice(scs,choice_1);
            switch (choice_1) {
                case 1:
                    int choice = -1;
                    loginMenu.loginMenuUser();
                    while (choice != 7) {
                        menu.displayMenu();
                        choice = ExceptionMenu.getChoice(scs, choice);
                        switch (choice) {
                            case 1:
                                menu.displayContactMenu();
                                break;
                            case 2:
                                menu.addMenu();
                                break;
                            case 3:
                                menu.editMenu();
                                break;
                            case 4:
                                menu.deleteMenu();
                                break;
                            case 5:
                                menu.findMenu();
                                break;
                            case 6:
                                loginMenu.editMenuUser();
                                break;
                        }
                    }
                    break;
                case 2:
                    loginMenu.addMenuUser();
                    break;
            }
        }
    }
}
