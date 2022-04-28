import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocumentUser {
    public static void writeFile(String path, List<User> userList) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "name,pass \n";
        for (User user : userList) {
            str += user.getUserName() + "," + user.getUserPass() + "\n";
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
    }

    public static List<User> readFile(String path) throws IOException {
        List<User> userList = new ArrayList<>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = bufferedReader.readLine();
        while ((str = bufferedReader.readLine()) != null) {
            String[] values = str.split(",");
            userList.add(new User(values[0],values[1]));
        }
        return userList;
    }
}
