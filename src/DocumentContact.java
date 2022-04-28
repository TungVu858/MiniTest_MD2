import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocumentContact {
    public static void writeFile(String path, List<Contact> contactList) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "name,sđt,tuổi,địa chỉ,email,nhóm,giới tính,user \n";
        for (Contact contact : contactList) {
            str += contact.getName() + "," + contact.getPhoneNumber() + "," + contact.getAge() + "," + contact.getAddress() + "," + contact.getEmail() + "," + contact.getGroup() + "," + contact.getGender() + ","+ LoginMenu.userName+"\n";
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
    }

    public static List<Contact> readFile(String path) throws IOException {
        List<Contact> contacts = new ArrayList<>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = bufferedReader.readLine();
        while ((str = bufferedReader.readLine()) != null) {
            String[] values = str.split(",");
            contacts.add(new Contact(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]), values[3], values[4], values[5], values[6],values[7]));
        }
        return contacts;
    }
}
