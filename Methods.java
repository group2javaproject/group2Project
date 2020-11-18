package Group2JavaProject;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Methods {
    public static String ID;
    static Scanner scan = new Scanner(System.in);
    public static HashMap<String,String> studentAccounts = new HashMap<>();
    public static HashMap<String,String> teacherAccounts = new HashMap<>();
    public static HashMap<String,String> admin = new HashMap<>();
    /**
     * Below are variables for attendance system.
     * 1st number in arraylist is ID.(0)
     * 2nd number is assigned class.(1)
     * 3rd number is number of missed days
     */
    public static ArrayList <Integer> teacher1 = new ArrayList<>();
    public static ArrayList <Integer> teacher2 = new ArrayList<>();
    public static ArrayList <Integer> teacher3 = new ArrayList<>();


    public static ArrayList <String> studentIds = new ArrayList<>();
    public static ArrayList <Integer> studentClass= new ArrayList<>();
    public static ArrayList <Integer> studentMissedDays = new ArrayList<>();
    public static ArrayList <Integer> studentExcused= new ArrayList<>();
    public static ArrayList <Integer> studentUnexcused = new ArrayList<>();




    public static int searchStudent() {

        int index = -1;
        for (int i=0;i<studentIds.size();i++){
            if (ID.equals(studentIds.get(i))){
                index = i;
                break;
            }


            }
        return index;

    }

    public static void viewAttendance(){
        System.out.println(
                "\n Present days " + (180 - studentMissedDays.get(searchStudent())) +
                "\n Missed days " + studentMissedDays.get(searchStudent()) +
                "\n Excused missed days " + studentExcused.get(searchStudent()) +
                "\n UnExcused missed days " + studentUnexcused.get(searchStudent()));

    }

    public static void markStudentAttendance(){
        System.out.println("Please enter student ID");
        ID = scan.nextLine();
        int index = searchStudent();
        System.out.println("Is this student present today?");
        String answer1 = scan.nextLine();
        if (answer1.equalsIgnoreCase("no")){
            System.out.println("Is it excused absence?");
            String answer2 = scan.nextLine();
            if(answer2.equalsIgnoreCase("excused")){
                studentMissedDays.set(searchStudent(),studentMissedDays.get(searchStudent())+1);
                studentExcused.set(searchStudent(),studentExcused.get(searchStudent())+1);
            }else if (answer2.equalsIgnoreCase("unexcused")){
                studentMissedDays.set(searchStudent(),studentMissedDays.get(searchStudent())+1);
                studentUnexcused.set(searchStudent(),studentUnexcused.get(searchStudent())+1);
            }
        }


    }


    public static void start (){

        for(int i=0; i<4; i++) {
            System.out.println("Please enter your ID");
            String typeID = scan.nextLine();
            System.out.println("Please enter your password");
            String typePassword = scan.nextLine();

            if (studentAccounts.containsKey(typeID) && studentAccounts.get(typeID).equals(typePassword)) {
                System.out.println("Welcome Student");

                System.out.println("Please choose option from menu below" +
                        "\n" + "1s." + "View attendance" +
                        "\n" + "2s." + "Contact teacher");
                ID = typeID;
                initiate();
                break;
            }else if (teacherAccounts.containsKey(typeID) && teacherAccounts.get(typeID).equals(typePassword)) {
                System.out.println("Welcome Teacher");
                //method that will show message from the student
                //method that will notify if teacher has too many absences (Shawan)
                System.out.println("Please choose option from menu below" +
                        "\n" + "1t." + "Change max number of students in your class" +
                        "\n" + "2t." + "remove student from the Class" +
                        "\n" + "3t." + "Take student attendance" +
                        "\n" + "4t." + "Take your own attendance" +
                        "\n" + "5t." + "Contact Admin");
                ID = typeID;
                initiate();
                break;
            }else if (admin.containsKey(typeID) && admin.get(typeID).equals(typePassword)) {
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
               viewAttendance();
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
                 markStudentAttendance();
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
    admin.put("Alex","Alex1234");
    teacherAccounts.put("John","John1234");
    teacher1.add(1); teacher1.add(1); teacher1.add(5);
    studentAccounts.put("Shawan","Shawan1234"); studentIds.add("Shawan"); studentClass.add(1); studentMissedDays.add(9);studentUnexcused.add(3);studentExcused.add(6);
    studentAccounts.put("David","David1234"); studentIds.add("David"); studentClass.add(1); studentMissedDays.add(7);studentUnexcused.add(3);studentExcused.add(4);
    System.out.println(studentIds);




    start();



    }




}
