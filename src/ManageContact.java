import java.util.ArrayList;
import java.util.List;

public class ManageContact {
    private List<Contact> contactList = new ArrayList<>();

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
    public void add(Contact contact){
        contactList.add(contact);
    }
    public int findByPhoneNumber(int phoneNumber){
        for (int i = 0; i < contactList.size(); i++) {
            if (phoneNumber == contactList.get(i).getPhoneNumber()){
                return i;
            }
        }
        return -1;
    }
    public void findByName(String name){
        boolean check = false;
        for (Contact contact : contactList) {
            if (name.contains(contact.getName())) {
                System.out.println(contact);
                check = true;
            }
        }
        if (!check) System.out.println("Không tìm thấy tên : ");
    }
    public void delete(int phoneNumber){
        contactList.remove(findByPhoneNumber(phoneNumber));
    }
    public void edit(int phoneNumber, Contact contact){
        contactList.set(findByPhoneNumber(phoneNumber), contact);
    }
    public void displayAll(){
        boolean check = false;
        for (Contact contact : contactList) {
            System.out.println(contact);
            check = true;
        }
        if (!check) System.out.println("Chưa có danh bạ nào");
    }
    public void displayFindByPhoneNumber(int phoneNumber){
        boolean check = false;
        for (Contact contact : contactList) {
            if (phoneNumber == contact.getPhoneNumber()) {
                System.out.println(contact);
                check = true;
            }
        }
        if (!check) System.out.println("Không tìm thấy sđt này !!");
    }
}
