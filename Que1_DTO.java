package jdbcTest.Question1;

public class Que1_DTO {
    private int id;
    private String username;
    private String password;
    private int age;
    private long contactNo;
    private String city;

    private int count;

    public Que1_DTO()
    {

    }

    public Que1_DTO(int id, String username, String password, int age, long contactNo, String city) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.contactNo = contactNo;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    public String getCity() {
        return city;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return id+"\t\t"+username+"\t\t"+password+"\t\t"+age+"\t\t"+contactNo+"\t\t"+city;
    }
}
