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
     I.e. Student 1 will have information stored only in index 0 in all student arraylists.
     Student 2 will have information at index 1 and etc.
     */
    public static ArrayList <String> teacherId = new ArrayList<>();
    public static ArrayList <Integer> teacherClass = new ArrayList<>();
    public static ArrayList <Integer> teacherMissedDays = new ArrayList<>();
    public static ArrayList <Integer> teacherClassSize = new ArrayList<>();


    public static ArrayList <String> studentIds = new ArrayList<>();
    public static ArrayList <Integer> studentClass= new ArrayList<>();
    public static ArrayList <Double> studentMissedDays = new ArrayList<>();
    public static ArrayList <Integer> studentExcused= new ArrayList<>();
    public static ArrayList <Integer> studentUnexcused = new ArrayList<>();




    public  int searchStudent() {

        int index = -1;
        for (int i=0;i<studentIds.size();i++){
            if (ID.equals(studentIds.get(i))){
                index = i;
                break;
            }
        }
        return index;
    }
    public  int searchTeacher() {

        int index = -1;
        for (int i=0;i<teacherId.size();i++){
            if (ID.equals(teacherId.get(i))){
                index = i;
                break;
            }
        }
        return index;
    }

    public  void reLogin(){
        System.out.println("Thank you for using our Attendance system");
        System.out.println("Do you want to login as a different user?");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("yes")){
            start();
        }

    }


    public void viewAttendance(){
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
    public void notifyTeacher (){
        System.out.println("Please enter the message to the teacher and number of days you are planning to miss.");
        String message = scan.nextLine();
        studentNotifications.put(ID,message);
        System.out.println("Thank you for letting us know");
        System.out.println("Go back to the main menu?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes"))
            studentMenu();
    }

    public void defineClassSize (){
        System.out.println("Please define number of students in your class");
        int num = scan.nextInt();
        if (num>0 && num<10) {
            teacherClassSize.set(searchTeacher(), num);
        }else{
            System.out.println("You should have between 0 and 10 students in your class");
        }
        System.out.println("Maximum number of students in your class is " + teacherClassSize.get(searchTeacher()));
        System.out.println("Go back to the main menu?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes"))
            teacherMenu();
    }
    public void removeStudentT (){
        String teacherID = ID;
        int indexT = searchTeacher();
        System.out.println("Please enter student ID");
        ID = scan.nextLine();
        int indexS = searchStudent();
        if (studentClass.get(indexS)==teacherClass.get(indexT)) {
            studentClass.set(indexS,0);
            System.out.println("Student has been removed from your class");

        }else{
            System.out.println("You can't remove student from another teacher class");
        }
        ID = teacherID;
        System.out.println("Go back to the main menu?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes"))
            teacherMenu();
    }

    public void markStudentAttendance(){
        String teacherID = ID;
        int indexT = searchTeacher();
        System.out.println("Please enter student ID");
        ID = scan.nextLine();
        int indexS = searchStudent();
        if (studentClass.get(indexS)==teacherClass.get(indexT)) {
            System.out.println("Is this student present today?");
            String answer1 = scan.nextLine();
            if (answer1.equalsIgnoreCase("no")) {
                System.out.println("Is it excused absence?");
                String answer2 = scan.nextLine();
                if (answer2.equalsIgnoreCase("excused")) {
                    studentMissedDays.set(indexS, studentMissedDays.get(indexS) + 1);
                    studentExcused.set(indexS, studentExcused.get(indexS) + 1);
                } else if (answer2.equalsIgnoreCase("unexcused")) {
                    studentMissedDays.set(indexS, studentMissedDays.get(indexS) + 1);
                    studentUnexcused.set(indexS, studentUnexcused.get(indexS) + 1);
                }
            }
        }else{
            System.out.println("You can't take student attendance from another class");
        }
        ID = teacherID;
        System.out.println("Go back to the main menu?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes"))
            teacherMenu();
    }
    public void takeAttendanceT (){
        System.out.println("Are you planning to work today?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("no")){
            teacherMissedDays.set(searchTeacher(),teacherMissedDays.get(searchTeacher())+1);
        }else{
            System.out.println("Enjoy your work");
        }
        System.out.println("Go back to the main menu?");
        String answer1 = scan.nextLine();
        if (answer1.equalsIgnoreCase("yes"))
            teacherMenu();
    }
    public void notifyAdmin (){
        System.out.println("Please enter the message to the Admin and number of days you are planning to miss.");
        String message = scan.nextLine();
        teacherNotifications.put(ID,message);
        System.out.println("Thank you for letting us know");
        System.out.println("Go back to the main menu?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes"))
            teacherMenu();
    }


    public void start (){

        for(int i=0; i<4; i++) {
            System.out.println("Please enter your ID");
            String typeID = scan.nextLine();
            System.out.println("Please enter your password");
            String typePassword = scan.nextLine();

            if (studentAccounts.containsKey(typeID) && studentAccounts.get(typeID).equals(typePassword)) {
                ID = typeID;
                if (studentMissedDays.get(searchStudent())>20){
                    System.out.println("ATTENTION! You missed too many lessons, please speak to your teacher");
                }
                studentMenu();
                break;
            }else if (teacherAccounts.containsKey(typeID) && teacherAccounts.get(typeID).equals(typePassword)) {
                System.out.println("!You have notifications from the students" +
                        "\n" + studentNotifications);
                studentNotifications.clear();

                ID = typeID;
                if (teacherMissedDays.get(searchTeacher())>20){
                    System.out.println("ATTENTION! You missed too many lessons, please speak to your Supervisor");
                }
                teacherMenu();
                break;
            }else if (admin.containsKey(typeID) && admin.get(typeID).equals(typePassword)) {
                System.out.println("!You have notifications from the teachers" +
                                "\n" + teacherNotifications);
                teacherNotifications.clear();
                adminMenu();
                break;

            } else {
                System.out.println("Login or password are incorrect. Please try again.");
            }
        }
    }

    public  void studentMenu () {
        System.out.println("Welcome Student " + ID);

        System.out.println("Please choose option from menu below" +
                "\n" + "1." + "View attendance" +
                "\n" + "2." + "Contact teacher" +
                "\n" + "3." + "Log out");

        initiateStudent();

    }
    public  void teacherMenu () {
        System.out.println("Welcome teacher " + ID);

        System.out.println("Please choose option from menu below" +
                "\n" + "1." + "Change max number of students in your class" +
                "\n" + "2." + "Remove student from the Class" +
                "\n" + "3." + "Take student attendance" +
                "\n" + "4." + "Take your own attendance" +
                "\n" + "5." + "Contact Admin" +
                "\n" + "6." + "Log out");

        initiateTeacher();

    }
    public  void adminMenu () {
        System.out.println("Welcome Master");

        System.out.println("Please choose option from menu below" +
                "\n" + "1." + "Show individual student attendance report and show percentage of days present" +
                "\n" + "2." + "Show individual teacher attendance report and show percentage of days present" +
                "\n" + "3." + "Show report of class attendance as a whole and show percentage of days present" +
                "\n" + "4." + "Show report of all teacher attendance as a whole and show percentage of days present" +
                "\n" + "5." + "Add new teacher" +
                "\n" + "6." + "Remove a teacher" +
                "\n" + "7." + "Add student" +
                "\n" + "8." + "Remove student" +
                "\n" + "9." + "Transfer student from one class to another" +
                "\n" + "10." + "Log out");
        initiateAdmin();

    }

    public  void initiateAdmin (){
        String menuChoice = "";
        menuChoice = scan.nextLine();
        switch (menuChoice){
            case "1":
                studentInd();
                break;
            case "2":
                teacherInd();
                break;
            case "3":
                classAttendance();
                break;
            case "4":
                teacherAttendance();
                break;
            case "5":
                addTeacher();
                break;
            case "6":
                removeTeacher();
                break;
            case "7":
                addStudents();
                break;
            case "8":
                removeStudent();
                break;
            case "9":
                studentTransfer();
                break;
            case "10":
                reLogin();
                break;
        }
    }

    public  void initiateStudent (){
        String menuChoice = "";
        menuChoice = scan.nextLine();
        switch (menuChoice){
            case "1":
                viewAttendance();
                break;
            case "2":
                notifyTeacher();
                break;
            case "3":
                reLogin();
                break;

        }

    }

    public  void initiateTeacher (){
        String menuChoice = "";
        menuChoice = scan.nextLine();
        switch (menuChoice){
            case "1":
                defineClassSize();
                break;
            case "2":
                removeStudentT();
                break;
            case "3":
                markStudentAttendance();
                break;
            case "4":
                takeAttendanceT();
                break;
            case "5":
                notifyAdmin();
                break;
            case "6":
                reLogin();
                break;
        }

    }

    public  void addStudents (){
        System.out.println("Please create a login for a new student");
        String login = scan.nextLine();
        System.out.println("Please create a password for a new student");
        String password = scan.nextLine();
        System.out.println("Please assign class for a new student");
        Integer cClass = scan.nextInt();
        studentAccounts.put(login,password);
        studentIds.add(login); studentClass.add(cClass); studentMissedDays.add(0.0);studentExcused.add(0);studentUnexcused.add(0);
        System.out.println("Go back to the main menu?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            adminMenu(); }
    }
    public  void studentTransfer (){
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
    public  void removeStudent(){
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
    public  void addTeacher (){
        System.out.println("Please create a login for a new teacher");
        String login = scan.nextLine();
        System.out.println("Please create a password for a new teacher");
        String password = scan.nextLine();
        System.out.println("Please assign class for the new teacher");
        Integer tClass = scan.nextInt();
        teacherAccounts.put(login,password);
        teacherId.add(login); teacherClass.add(tClass);teacherMissedDays.add(0);teacherClassSize.add(0);
        System.out.println("Go back to the main menu?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            adminMenu(); }

    }
    public  void removeTeacher(){
        System.out.println("Please enter ID of the teacher you want to remove from the system.");
        ID = scan.nextLine();
        if (teacherAccounts.containsKey(ID)){
            teacherId.remove(searchTeacher()); teacherMissedDays.remove(searchTeacher());teacherClass.remove(searchTeacher());teacherClassSize.remove(searchTeacher());
            teacherAccounts.remove(ID);
        }else {
            System.out.println("Teacher not found");
        }
        System.out.println("Go back to the main menu?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            adminMenu(); }
    }
    public  void teacherInd() {
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
    public  void studentInd () {
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

    public  Double classAttendance (){
        ArrayList<Double> classMissedDays = new ArrayList();
        System.out.println("Which class would you like to view attendance on? ");
        int classObject = scan.nextInt();
        for (int j=0;j<studentClass.size();j++) {
            if (classObject == (studentClass.get(j))) {
                classMissedDays.add(studentMissedDays.get(j));
            }
        }
        double sum = 0;
            for (int i = 0 ; i < classMissedDays.size() ; i++){
                sum += classMissedDays.get(i);
            }
            Double percentageOfDays = 100 * sum/180;
            System.out.println("Percentage of days Present for class " +classObject +percentageOfDays + " %");

        return sum;
    }
    public  Double teacherAttendance (){

        double sum = 0;
        for (int i = 0 ; i < teacherMissedDays.size() ; i++){
            sum += teacherMissedDays.get(i);
        }
        Double percentageOfDays = 100 * sum/180;
        System.out.println("Percentage of days Present for teachers are : " +percentageOfDays + " %");

        return sum;
    }








}
