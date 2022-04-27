import java.util.ArrayList;
import java.util.List;

public class QuanLyDanhBa {
    List<DanhBa> danhBaList = new ArrayList<>();
    public void add(DanhBa danhBa){
        danhBaList.add(danhBa);
    }
    public int findByPhoneNumber(int phoneNumber){
        for (int i = 0; i < danhBaList.size(); i++) {
            if (phoneNumber == danhBaList.get(i).getPhoneNumber()){
                return i;
            }
        }
        return -1;
    }
    public void findByName(String name){
        boolean check = false;
        for (int i =0;i<danhBaList.size();i++){
            if (name.equals(danhBaList.get(i).getName())){
                System.out.println(danhBaList.get(i));
                check = true;
            }
        }
        if (!check) System.out.println("Không tìm thấy tên : ");
    }
    public void delete(int phoneNumber){
        danhBaList.remove(findByPhoneNumber(phoneNumber));
    }
    public void edit(int phoneNumber,DanhBa danhBa){
        danhBaList.set(findByPhoneNumber(phoneNumber),danhBa);
    }
    public void displayAll(){
        boolean check = false;
        for (int i = 0; i < danhBaList.size(); i++) {
            System.out.println(danhBaList.get(i));
            check = true;
        }
        if (!check) System.out.println("Chưa có danh bạ nào");
    }
    public void displayFindByPhoneNumber(int phoneNumber){
        boolean check = false;
        for (int i =0;i<danhBaList.size();i++){
            if (phoneNumber == danhBaList.get(i).getPhoneNumber()){
                System.out.println(danhBaList.get(i));
                check = true;
            }
        }
        if (!check) System.out.println("Không tìm thấy sđt này !!");
    }
}
