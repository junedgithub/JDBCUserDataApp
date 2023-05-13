package jdbcTest.Question1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Que1_Main {
    static Scanner sc = new Scanner(System.in);
    static Que1_DAO dao = new Que1_DAO();
    public static void main(String[] args) {
        boolean status = true;
        while (status) {
            System.out.println("Enter Operation to be performed!!");
            System.out.println("1. Insert User Data!!");
            System.out.println("2. Display User Data!!");
            System.out.println("3. Count of User based city!!");
            System.out.println("4. Display user in Decending order by age!!");
            System.out.println("5. Delete specific record by accepting contactNo!!");
            System.out.println("6. Exit!!");
            int ch = sc.nextInt();
            if (ch==1)
            {
                insertUser();
            }
            else if (ch==2)
            {
                displayUser();
            }
            else if (ch==3)
            {
                countByCity();
            }else if (ch==4)
            {
                displayUserByAge();
            }else if (ch==5)
            {
                deleteRecord();
            }
        }

    }

    private static void deleteRecord() {
        System.out.println("Enter contact No");
        long contactNo = sc.nextLong();
        int count = dao.deleteRecord(contactNo);
        System.out.println(count+" Deleted Successfully!!");
    }

    private static void displayUserByAge() {
        List<Que1_DTO> user = dao.displayUserByAge();
        System.out.println("UserName\t\tAge");
        for (Que1_DTO u: user)
        {
            System.out.println(u.getUsername()+"\t\t"+u.getAge());
        }
    }

    private static void countByCity() {
        System.out.println("Enter name Of City!!");
        String city = sc.next();
        List<Que1_DTO> user =dao.countByCity(city);
        System.out.println("User  :  City ");
        System.out.println("==============");
        for (Que1_DTO u: user) {
            System.out.println(u.getCount() + " :  " + u.getCity());
        }
    }

    private static void displayUser() {
        System.out.println("ID\t\tUSERNAME\t\tPASSWORD\t\tAGE\t\tCONTACT\t\tCITY");
        List<Que1_DTO> user = dao.displayUser();
        for (Que1_DTO u: user)
        {
            System.out.println(u);
        }

    }

    private static void insertUser() {
        System.out.print("Enter username  ");
        String user = sc.next();
        System.out.print("Enter password  ");
        String  pass = sc.next();
        System.out.print("Enter age  ");
        int age = sc.nextInt();
        System.out.print("Enter contact  ");
        long contact= sc.nextLong();
        System.out.print("Enter city  ");
        String city= sc.next();
        int count = dao.insertUser(user,pass,age,contact,city);
        System.out.println(count+ " Added successfully");
    }
}
