public class DanhBa {
    private String name;
    private int phoneNumber;
    private String adress;
    private String email;
    private String nhom;
    private String gender;
    private int age;

    public DanhBa() {
    }

    public DanhBa(String name, int phoneNumber, String adress, String email, String nhom, String gender,int age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.email = email;
        this.nhom = nhom;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNhom() {
        return nhom;
    }

    public void setNhom(String nhom) {
        this.nhom = nhom;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "DanhBa{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", adress='" + adress + '\'' +
                ", nhom='" + nhom + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
