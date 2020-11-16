package Group2JavaProject;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Methods {
    static Scanner scan = new Scanner(System.in);
    public static HashMap<String,String> studentAccounts = new HashMap<>();
    public static HashMap<String,String> teacherAccounts = new HashMap<>();
    public static HashMap<String,String> admin = new HashMap<>();
    /**
     * Below are variables for attendance system.
     * 1st number in arraylist is ID.
     * 2nd number is assigned class.
     * 3rd number reflects total number of missed days.
     * 4th number reflects number of missed excused days(only for students)
     * 5th number reflects number of missed unexcused days(only for students)
     */
    public static ArrayList <Integer> teacher1 = new ArrayList<>();
    public static ArrayList <Integer> teacher2 = new ArrayList<>();
    public static ArrayList <Integer> teacher3 = new ArrayList<>();
    public static ArrayList <Integer> student1 = new ArrayList<>();
    public static ArrayList <Integer> student2 = new ArrayList<>();
    public static ArrayList <Integer> student3 = new ArrayList<>();
    public static ArrayList <Integer> student4 = new ArrayList<>();
    public static ArrayList <Integer> student5 = new ArrayList<>();
    public static ArrayList <Integer> student6 = new ArrayList<>();
    public static ArrayList <Integer> student7 = new ArrayList<>();
    public static ArrayList <Integer> student8 = new ArrayList<>();
    public static ArrayList <Integer> student9 = new ArrayList<>();
    public static ArrayList <Integer> student10 = new ArrayList<>();
    public static ArrayList <Integer> student11 = new ArrayList<>();
    public static ArrayList <Integer> student12 = new ArrayList<>();
    public static ArrayList <Integer> student13 = new ArrayList<>();
    public static ArrayList <Integer> student14 = new ArrayList<>();
    public static ArrayList <Integer> student15 = new ArrayList<>();
    public static ArrayList <Integer> student16 = new ArrayList<>();
    public static ArrayList <Integer> student17 = new ArrayList<>();
    public static ArrayList <Integer> student18 = new ArrayList<>();
    public static ArrayList <Integer> student19 = new ArrayList<>();
    public static ArrayList <Integer> student20 = new ArrayList<>();
    public static ArrayList <Integer> student21 = new ArrayList<>();
    public static ArrayList <Integer> student22 = new ArrayList<>();
    public static ArrayList <Integer> student23 = new ArrayList<>();
    public static ArrayList <Integer> student24 = new ArrayList<>();
    public static ArrayList <Integer> student25 = new ArrayList<>();
    public static ArrayList <Integer> student26 = new ArrayList<>();
    public static ArrayList <Integer> student27 = new ArrayList<>();
    public static ArrayList <Integer> student28 = new ArrayList<>();
    public static ArrayList <Integer> student29 = new ArrayList<>();
    public static ArrayList <Integer> student30 = new ArrayList<>();



    /**
     *

    public void notify (){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your message");
        String message = scan.nextLine();
        System.out.println("Please enter number of days you are planning to miss");
        int numOfDays = scan.nextInt();

    }
     */

    public static void start (){

        for(int i=0; i<4; i++) {
            System.out.println("Please enter your ID");
            String typeID = scan.nextLine();
            System.out.println("Please enter your password");
            String typePassword = scan.nextLine();

            if (studentAccounts.containsKey(typeID) && studentAccounts.containsValue(typePassword)) {
                System.out.println("Welcome Student");

                System.out.println("Please choose option from menu below" +
                        "\n" + "1s." + "View attendance" +
                        "\n" + "2s." + "Contact teacher");
                initiate();
                break;
            }else if (teacherAccounts.containsKey(typeID) && teacherAccounts.containsValue(typePassword)) {
                System.out.println("Welcome Teacher");
                //method that will show message from the student
                //method that will notify if teacher has too many absences (Shawan)
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
               // Attendance();
                break;
            case "2s":
               // presentMethod
                break;
            case "1t":
                // numOfStudents();// Uses sizeOfClass
                break;
            case "2t":
                // removeStudent();
                break;
            case "3t":
                // studentAttendance();
                break;
            case "4t":
                // Method to Take your own attendance (Shawan)
                break;
            case "5t":
                // Method to Contact Admin (Shawan)
                break;
            case "1a":
                // Method to Show individual student attendance report and show percentage of days present
                System.out.println("works");
                break;
            case "2a":
                teacherInd();

                break;
            case "3a":
                // Method to Show report of class attendance as a whole and show percentage of days present
                break;
            case "4a":
                // Method to Show report of all teacher attendance as a whole and show percentage of days present
                break;
            case "5a":
                // Method to Add new teacher (Alex)
                break;
            case "6a":
                // Method to Remove a teacher (Alex)
                break;
            case "7a":
               // addStudents();
                break;
            case "8a":
                // Method to Remove student (Alex)
                break;
            case "9a":
                // Method to Transfer student from one class to another (Alex)
                break;
        }

    }




    public static void teacherInd() {
        System.out.println("Enter teacher's ID");
        int typeID = scan.nextInt();
        if (typeID==teacher1.get(0)) {
            System.out.println("Teacher " + typeID +
                    "\n Present days " + (180 - teacher1.get(2)) +
                    "\n Missed days " + (teacher1.get(2)) +
                    "\n Percentage of days present " + ((180 - teacher1.get(2))*100/180) + "%");
        }else if (typeID==teacher2.get(0)) {
            System.out.println("Teacher " + typeID +
                    "\n Present days " + (180 - teacher2.get(2)) +
                    "\n Missed days " + (teacher2.get(2)) +
                    "\n Percentage of days present " + ((180 - teacher2.get(2))*100/180) + "%");
        }else if (typeID==teacher3.get(0)){
            System.out.println("Teacher " + typeID +
                    "\n Present days " + (180 - teacher3.get(2)) +
                    "\n Missed days " + (teacher3.get(2)) +
                    "\n Percentage of days present " + ((180 - teacher3.get(2))*100/180) + "%");
        }






    }





    public static void main(String[] args) {
    admin.put("58274","Alex1234");
    teacher1.add(1); teacher1.add(1); teacher1.add(5);



    start();



    }




}
