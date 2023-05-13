package jdbcTest.Question1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Que1_DAO {
    static Connection con = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    static String query = null;

    static Statement stmt = null;

    static List<Que1_DTO> data = new ArrayList<>();
    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertUser(String user, String pass, int age, long contact, String city) {
        int count =0;
        Que1_DTO dto = new Que1_DTO();
        dto.setUsername(user);
        dto.setPassword(pass);
        dto.setAge(age);
        dto.setContactNo(contact);
        dto.setCity(city);
        query = "insert into user_info(user_name,user_password,user_age,user_contactNo,user_city) values (?,?,?,?,?)";
        try {
            pstmt= con.prepareStatement(query);
            pstmt.setString(1,dto.getUsername());
            pstmt.setString(2,dto.getPassword());
            pstmt.setInt(3,dto.getAge());
            pstmt.setLong(4,dto.getContactNo());
            pstmt.setString(5,dto.getCity());
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     return count;
    }

    public List<Que1_DTO> displayUser() {
        query = "select * from user_info";
        try {
            pstmt= con.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt(1);
                String user = rs.getString(2);
                String pass = rs.getString(3);
                int age = rs.getInt(4);
                long contact = rs.getLong(5);
                String city = rs.getString(6);
                Que1_DTO dto = new Que1_DTO();
                dto.setId(id);
                dto.setUsername(user);
                dto.setPassword(pass);
                dto.setAge(age);
                dto.setContactNo(contact);
                dto.setCity(city);
                data.add(dto);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public List<Que1_DTO> countByCity(String city) {
        query = "select count(user_name),user_city from user_info where user_city = '"+city+"'";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next())
            {
                int count = rs.getInt("count(user_name)");
                String city1 = rs.getString(2);
                Que1_DTO dto = new Que1_DTO();
                dto.setCount(count);
                dto.setCity(city1);
                data.add(dto);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
      return data;
    }

    public List<Que1_DTO> displayUserByAge() {
        query = "select user_name, user_age from user_info order by user_age desc";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next())
            {
                String user = rs.getString(1);
                int age = rs.getInt(2);
                Que1_DTO dto = new Que1_DTO();
                dto.setUsername(user);
                dto.setAge(age);
                data.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     return data;
    }

    public int deleteRecord(long contactNo) {
        int count = 0;
        query = "delete from user_info where user_contactNo = ?";
        try {
            pstmt= con.prepareStatement(query);
            pstmt.setLong(1,contactNo);
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
