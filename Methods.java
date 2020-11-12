package Group2JavaProject;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Methods {
    static Scanner scan = new Scanner(System.in);
    public static HashMap<String,String> studentAccounts = new HashMap<>();
    public static HashMap<String,String> teacherAccounts = new HashMap<>();
    public static HashMap<String,String> admin = new HashMap<>();



    public static void start (){

        for(int i=0; i<4; i++) {
            System.out.println("Please enter your ID");
            String typeID = scan.nextLine();
            System.out.println("Please enter your password");
            String typePassword = scan.nextLine();
            if (studentAccounts.containsKey(typeID) && studentAccounts.containsValue(typePassword)) {
                System.out.println("Welcome Student");
                //method that will notify if student has too many absences
                System.out.println("Please choose option from menu below" +
                        "\n" + "1s." + "View attendance" +
                        "\n" + "2s." + "Contact teacher");
                initiate();
                break;
            }else if (teacherAccounts.containsKey(typeID) && teacherAccounts.containsValue(typePassword)) {
                System.out.println("Welcome Teacher");
                //method that will show message from the student
                //method that will notify if teacher has too many absences
                System.out.println("Please choose option from menu below" +
                        "\n" + "1t." + "Change max number of students in your class" +
                        "\n" + "2t." + "remove student from the Class" +
                        "\n" + "3t." + "Take student attendance" +
                        "\n" + "4t." + "Take your own attendance" +
                        "\n" + "5t." + "Contact Admin");
                initiate();
                break;
            }else if (admin.containsKey(typeID) && admin.containsValue(typePassword)) {
                //method that will show message from the student
                //method that will notify if teacher has too many absences
                System.out.println("Please choose option from menu below" +
                        "\n" + "1a." + "Show individual student attendance report and show percentage of days present" +
                        "\n" + "2a." + "Show individual teacher attendance report and show percentage of days present" +
                        "\n" + "3a." + "Show report of class attendance as a whole and show percentage of days present" +
                        "\n" + "4a." + "Show report of all teacher attendance as a whole and show percentage of days present" +
                        "\n" + "5a." + "Add new teacher" +
                        "\n" + "6a." + "Remove a teacher" +
                        "\n" + "7a." + "Add student" +
                        "\n" + "8a." + "Remove student" +
                        "\n" + "9a." + "Transfer student from one class to another");

                initiate();
                break;

            } else {
                System.out.println("Login or password are incorrect. Please try again.");
            }
        }
    }

    public static void initiate (){
        String menuChoice = "";
        menuChoice = scan.nextLine();
        switch (menuChoice){
            case "1s":
                // Method to View attendance
                break;
            case "2s":
                // Method to Contact teacher
                break;
            case "1t":
                // Method to Change max number of students in your class
                break;
            case "2t":
                // Method to remove student from the Class
                break;
            case "3t":
                // Method to Take student attendance
                break;
            case "4t":
                // Method to Take your own attendance
                break;
            case "5t":
                // Method to Contact Admin
                break;
            case "1a":
                // Method to Show individual student attendance report and show percentage of days present
                System.out.println("works");
                break;
            case "2a":
                // Method to Show individual teacher attendance report and show percentage of days present
                break;
            case "3a":
                // Method to Show report of class attendance as a whole and show percentage of days present
                break;
            case "4a":
                // Method to Show report of all teacher attendance as a whole and show percentage of days present
                break;
            case "5a":
                // Method to Add new teacher
                break;
            case "6a":
                // Method to Remove a teacher
                break;
            case "7a":
                // Method to Add student
                break;
            case "8a":
                // Method to Remove student
                break;
            case "9a":
                // Method to Transfer student from one class to another
                break;
        }

    }


    public static void main(String[] args) {
    admin.put("Alex","Alex1234");
    start();



    }




}
