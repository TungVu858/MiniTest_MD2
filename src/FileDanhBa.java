import java.io.*;
import java.util.List;

public class FileDanhBa {
    public static void writeFile(String path, List<DanhBa> danhBaList) throws IOException {
        FileWriter fileWriter = new FileWriter(path,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str ="";
        for (int i = 0; i < danhBaList.size(); i++) {
            str+=danhBaList.get(i).toString() + "\n";
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
    }
    public static List<DanhBa> readFile(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (true){
            String str = bufferedReader.readLine();
            if (str == null){
                break;
            }
            System.out.println(str);
        }
        return null;
    }
}
