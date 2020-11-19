package Group2JavaProject;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Methods {
    public static HashMap<String,String> studentNotifications = new HashMap<>(); // variable to store notifications from students.
    public static HashMap<String,String> teacherNotifications = new HashMap<>(); // variable to store notifications from teachers.
    public static String ID; // variable used to connect various methods
    static Scanner scan = new Scanner(System.in);
    public static HashMap<String,String> studentAccounts = new HashMap<>(); // variable that stores Login and password for students
    public static HashMap<String,String> teacherAccounts = new HashMap<>(); // variable that stores Login and password for teachers
    public static HashMap<String,String> admin = new HashMap<>(); // variable that stores Login and password for Admin/Admins
    /**
     Specific index in arraylists below assigned to particular teacher/student.
     I.e. Student 1 will have information stored only in index 0 in arraylists: studentIds studentClass studentMissedDays studentExcused studentUnexcused.
     Student 2 will have information at index 1 and etc.
     */
    public static ArrayList <String> teacherId = new ArrayList<>();
    public static ArrayList <Integer> teacherClass = new ArrayList<>();
    public static ArrayList <Integer> teacherMissedDays = new ArrayList<>();


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
    public static int searchTeacher() {

        int index = -1;
        for (int i=0;i<teacherId.size();i++){
            if (ID.equals(teacherId.get(i))){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void viewAttendance(){
        System.out.println(
                "\n Present days " + (180 - studentMissedDays.get(searchStudent())) +
                "\n Missed days " + studentMissedDays.get(searchStudent()) + studentExcused.get(searchStudent()) + " of them are excused and " + studentUnexcused.get(searchStudent()) + "unexcused" +
                "\n Percentage of days present " + ((180 - studentMissedDays.get(searchStudent()))*100/180 + "%"));
        System.out.println("Go back to the main menu?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes")){
            studentMenu();
        }
    }
    public static void notifyTeacher (){
        System.out.println("Please enter the message to the teacher and number of days you are planning to miss.");
        String message = scan.nextLine();
        studentNotifications.put(ID,message);
        System.out.println("Thank you for letting us know");
        System.out.println("Go back to the main menu?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes"))
            studentMenu();
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
    public static void notifyAdmin (){
        System.out.println("Please enter the message to the Admin and number of days you are planning to miss.");
        String message = scan.nextLine();
        teacherNotifications.put(ID,message);
        System.out.println("Thank you for letting us know");
        System.out.println("Go back to the main menu?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes"))
            teacherMenu();
    }


    public static void start (){

        for(int i=0; i<4; i++) {
            System.out.println("Please enter your ID");
            String typeID = scan.nextLine();
            System.out.println("Please enter your password");
            String typePassword = scan.nextLine();

            if (studentAccounts.containsKey(typeID) && studentAccounts.get(typeID).equals(typePassword)) {
                ID = typeID;
                if (studentMissedDays.get(searchStudent())>20){
                    System.out.println("You missed too many lessons, please speak to your teacher");
                }
                studentMenu();
                break;
            }else if (teacherAccounts.containsKey(typeID) && teacherAccounts.get(typeID).equals(typePassword)) {
                System.out.println("below are notifications from the students" +
                        studentNotifications);
                studentNotifications.clear();

                //method that will notify if teacher has too many absences (Shawan)
                ID = typeID;
                teacherMenu();

                initiate();
                break;
            }else if (admin.containsKey(typeID) && admin.get(typeID).equals(typePassword)) {
                System.out.println("below are notifications from the teachers" +
                        teacherNotifications);
                teacherNotifications.clear();

                adminMenu();
                break;

            } else {
                System.out.println("Login or password are incorrect. Please try again.");
            }
        }
    }

    public static void studentMenu () {
        System.out.println("Welcome Student " + ID);

        System.out.println("Please choose option from menu below" +
                "\n" + "1s." + "View attendance" +
                "\n" + "2s." + "Contact teacher");

        initiate();

    }
    public static void teacherMenu () {
        System.out.println("Welcome teacher " + ID);

        System.out.println("Please choose option from menu below" +
                "\n" + "1t." + "Change max number of students in your class" +
                "\n" + "2t." + "remove student from the Class" +
                "\n" + "3t." + "Take student attendance" +
                "\n" + "4t." + "Take your own attendance" +
                "\n" + "5t." + "Contact Admin");

        initiate();

    }
    public static void adminMenu () {
        System.out.println("Welcome Master");

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

    }

    public static void initiate (){
        String menuChoice = "";
        menuChoice = scan.nextLine();
        switch (menuChoice){
            case "1s":
               viewAttendance();
                break;
            case "2s":
               notifyTeacher();
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
                notifyAdmin();
                break;
            case "1a":
                studentInd();
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
                addTeacher();
                break;
            case "6a":
                removeTeacher();
                break;
            case "7a":
                addStudents();
                break;
            case "8a":
                removeStudent();
                break;
            case "9a":
                studentTransfer();
                break;
        }

    }

    public static void addStudents (){
        System.out.println("Please create a login for a new student");
        String login = scan.nextLine();
        System.out.println("Please create a password for a new student");
        String password = scan.nextLine();
        System.out.println("Please assign class for a new student");
        Integer cClass = scan.nextInt();
        studentAccounts.put(login,password);
        studentIds.add(login); studentClass.add(cClass); studentMissedDays.add(0);studentExcused.add(0);studentUnexcused.add(0);
        System.out.println("Go back to the main menu?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            adminMenu(); }
    }
    public static void studentTransfer (){
        System.out.println("Please enter ID of the student you want to transfer");
        ID = scan.nextLine();
        System.out.println("Please enter new class for the student");
        int newClass = scan.nextInt();
        studentClass.set(searchStudent(),newClass);
        System.out.println("Go back to the main menu?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            adminMenu(); }
    }
    public static void removeStudent(){
        System.out.println("Please enter ID of the student you want to remove from the system.");
        ID = scan.nextLine();
        if (studentAccounts.containsKey(ID)){
            studentIds.remove(searchStudent()); studentMissedDays.remove(searchStudent());studentClass.remove(searchStudent());studentUnexcused.remove(searchStudent());studentExcused.remove(searchStudent());
            studentAccounts.remove(ID);
        }else {
            System.out.println("Student not found");
        }
        System.out.println("Go back to the main menu?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            adminMenu(); }
    }
    public static void addTeacher (){
        System.out.println("Please create a login for a new teacher");
        String login = scan.nextLine();
        System.out.println("Please create a password for a new teacher");
        String password = scan.nextLine();
        System.out.println("Please assign class for the new teacher");
        Integer tClass = scan.nextInt();
        teacherAccounts.put(login,password);
        teacherId.add(login); teacherClass.add(tClass);teacherMissedDays.add(0);
        System.out.println("Go back to the main menu?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            adminMenu(); }

    }
    public static void removeTeacher(){
        System.out.println("Please enter ID of the teacher you want to remove from the system.");
        ID = scan.nextLine();
        if (teacherAccounts.containsKey(ID)){
            teacherId.remove(searchTeacher()); teacherMissedDays.remove(searchTeacher());teacherClass.remove(searchTeacher());
            teacherAccounts.remove(ID);
        }else {
            System.out.println("Teacher not found");
        }
        System.out.println("Go back to the main menu?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            adminMenu(); }
    }
    public static void teacherInd() {
        System.out.println("Enter teacher's ID");
        String typeID = scan.nextLine();
        ID = typeID;
        System.out.println(
                        "\n Present days " + (180 - teacherMissedDays.get(searchTeacher())) +
                        "\n Missed days " + teacherMissedDays.get(searchTeacher()) +
                        "\n Percentage of days present " + ((180 - teacherMissedDays.get(searchTeacher()))*100/180 + "%"));
        System.out.println("Go back to the main menu?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes")){
            adminMenu();
        }
    }
    public static void studentInd () {
        System.out.println("Enter student's ID");
        String typeID = scan.nextLine();
        ID = typeID;
        System.out.println(
                "\n Present days " + (180 - studentMissedDays.get(searchStudent())) +
                        "\n Missed days " + studentMissedDays.get(searchStudent()) + studentExcused.get(searchStudent()) + " of them are excused and " + studentUnexcused.get(searchStudent()) + "Unexcused" +
                        "\n Percentage of days present " + ((180 - studentMissedDays.get(searchStudent()))*100/180 + "%"));
        System.out.println("Go back to the main menu?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes")){
            adminMenu();
        }
    }




    public static void main(String[] args) {
    admin.put("Alex","Alex1234");
    teacherAccounts.put("John","John1234"); teacherId.add("John"); teacherClass.add(1); teacherMissedDays.add(9);

    studentAccounts.put("Shawan","Shawan1234"); studentIds.add("Shawan"); studentClass.add(1); studentMissedDays.add(9);studentUnexcused.add(3);studentExcused.add(6);
    studentAccounts.put("David","David1234"); studentIds.add("David"); studentClass.add(1); studentMissedDays.add(7);studentUnexcused.add(3);studentExcused.add(4);
    System.out.println(studentIds);




    start();



    }




}
