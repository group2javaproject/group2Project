package Group2JavaProject;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Methods {
    public static HashMap<Integer,String> studentNotifications = new HashMap<>(); // variable to store notifications from students.
    public static HashMap<Integer,String> teacherNotifications = new HashMap<>(); // variable to store notifications from teachers.
    public static int ID; // variable used to connect various methods
    Scanner scanInt = new Scanner(System.in); //Scanner for numbers
    Scanner scanString = new Scanner(System.in); // Scanners for words
    public static int count = 356781; // ID generator
    public static HashMap<Integer,String> studentAccounts = new HashMap<>(); // variable that stores Login and password for students
    public static HashMap<Integer,String> teacherAccounts = new HashMap<>(); // variable that stores Login and password for teachers
    public static HashMap<Integer,String> admin = new HashMap<>(); // variable that stores Login and password for Admin/Admins
    /**
     Specific index in arraylists below assigned to particular teacher/student.
     I.e. Student 1 will have information stored only in index 0 in all student arraylists.
     Student 2 will have information at index 1 and etc.
     */
    public static ArrayList <Integer> teacherId = new ArrayList<>();
    public static ArrayList <Integer> teacherClass = new ArrayList<>();
    public static ArrayList <Double> teacherMissedDays = new ArrayList<>();
    public static ArrayList <Integer> teacherClassSize = new ArrayList<>();


    public static ArrayList <Integer> studentIds = new ArrayList<>();
    public static ArrayList <Integer> studentClass= new ArrayList<>();
    public static ArrayList <Double> studentMissedDays = new ArrayList<>();
    public static ArrayList <Integer> studentExcused= new ArrayList<>();
    public static ArrayList <Integer> studentUnexcused = new ArrayList<>();





    public  int searchStudent() { //Alex

        int index = -1;
        for (int i=0;i<studentIds.size();i++){
            if (ID==(studentIds.get(i))){
                index = i;
                break;
            }
        }
        return index;
    }
    public  int searchTeacher() { //Alex

        int index = -1;
        for (int i=0;i<teacherId.size();i++){
            if (ID==(teacherId.get(i))){
                index = i;
                break;
            }
        }
        return index;
    }

    public  void reLogin(){
        System.out.println("Thank you for using our Attendance system");
        System.out.println("Do you want to login as a different user?");
        String answer = scanString.nextLine();

        if (answer.equalsIgnoreCase("yes")){
            start();
        }

    } //Alex


    public void viewAttendance(){ //Mohiuddin
        System.out.println(
                "\n Present days " + (180 - studentMissedDays.get(searchStudent())) +
                "\n Missed days " + studentMissedDays.get(searchStudent()) +
                "\n " + studentExcused.get(searchStudent()) + " of them are excused and " + studentUnexcused.get(searchStudent()) + " unexcused" +
                "\n Percentage of days present " + ((180 - studentMissedDays.get(searchStudent()))*100/180 + "%"));
        System.out.println("Go back to the main menu?");
        String answer = scanString.nextLine();
        if (answer.equalsIgnoreCase("yes")){
            studentMenu();
        }
    }
    public void notifyTeacher (){ //Mohiuddin
        System.out.println("Please enter the message to the teacher and number of days you are planning to miss.");
        String message = scanString.nextLine();
        studentNotifications.put(ID,message);
        System.out.println("Thank you for letting us know");
        System.out.println("Go back to the main menu?");
        String answer = scanString.nextLine();
        if (answer.equalsIgnoreCase("yes"))
            studentMenu();
    }

    public void defineClassSize (){ //Balzhima
        System.out.println("Please define number of students in your class");
        int num = scanInt.nextInt();
        if (num>0 && num<10) {
            teacherClassSize.set(searchTeacher(), num);
        }else{
            System.out.println("You should have between 0 and 10 students in your class");
        }
        System.out.println("Maximum number of students in your class is " + teacherClassSize.get(searchTeacher()));
        System.out.println("Go back to the main menu?");
        String answer = scanString.nextLine();
        if (answer.equalsIgnoreCase("yes"))
            teacherMenu();
    }

    public void removeStudentT (){ //Balzhima
        int teacherID = ID;
        int indexT = searchTeacher();
        System.out.println("Please enter student ID");
        ID = scanInt.nextInt();
        int indexS = searchStudent();
        if (studentClass.get(indexS)==teacherClass.get(indexT)) {
            studentClass.set(indexS,0);
            System.out.println("Student has been removed from your class");

        }else{
            System.out.println("You can't remove student from another teacher class");
        }
        ID = teacherID;
        System.out.println("Go back to the main menu?");
        String answer = scanString.nextLine();
        if (answer.equalsIgnoreCase("yes"))
            teacherMenu();
    }

    public void markStudentAttendance(){ //Balzhima
        int teacherID = ID;
        int indexT = searchTeacher();
        System.out.println("Please enter student ID");
        ID = scanInt.nextInt();
        int indexS = searchStudent();
        if (studentClass.get(indexS)==teacherClass.get(indexT)) {
            System.out.println("Is this student present today?");
            String answer1 = scanString.nextLine();
            if (answer1.equalsIgnoreCase("no")) {
                System.out.println("Is it excused absence?");
                String answer2 = scanString.nextLine();
                if (answer2.equalsIgnoreCase("yes")) {
                    studentMissedDays.set(indexS, studentMissedDays.get(indexS) + 1);
                    studentExcused.set(indexS, studentExcused.get(indexS) + 1);
                    System.out.println("Student absence excused. Attendance record has been modified accordingly.");
                } else if (answer2.equalsIgnoreCase("no")) {
                    studentMissedDays.set(indexS, studentMissedDays.get(indexS) + 1);
                    studentUnexcused.set(indexS, studentUnexcused.get(indexS) + 1);
                    System.out.println("Student absence Unexcused. Attendance record has been modified accordingly.");
                }
            }
        }else{
            System.out.println("You can't take student attendance from another class");
        }
        ID = teacherID;
        System.out.println("Go back to the main menu?");
        String answer = scanString.nextLine();
        if (answer.equalsIgnoreCase("yes"))
            teacherMenu();
    }
    public void takeAttendanceT (){ //Shawan
        System.out.println("Are you planning to work today?");
        String answer = scanString.nextLine();
        if (answer.equalsIgnoreCase("no")){
            teacherMissedDays.set(searchTeacher(),teacherMissedDays.get(searchTeacher())+1);
            System.out.println("Your attendance record has been modified");
        }else{
            System.out.println("Enjoy your work");
        }
        System.out.println("Go back to the main menu?");
        String answer1 = scanString.nextLine();
        if (answer1.equalsIgnoreCase("yes"))
            teacherMenu();
    }
    public void notifyAdmin (){ //Shawan
        System.out.println("Please enter the message to the Admin and number of days you are planning to miss.");
        String message = scanString.nextLine();
        teacherNotifications.put(ID,message);
        System.out.println("Thank you for letting us know");
        System.out.println("Go back to the main menu?");
        String answer = scanString.nextLine();
        if (answer.equalsIgnoreCase("yes"))
            teacherMenu();
    }


    public void start (){ //Alex

        for(int i=0; i<4; i++) {
            System.out.println("Please enter your ID");
            int typeID = scanInt.nextInt();
            System.out.println("Please enter your password");
            String typePassword = scanString.nextLine();

            if (studentAccounts.containsKey(typeID) && studentAccounts.get(typeID).equals(typePassword)) {
                ID = typeID;
                if (studentMissedDays.get(searchStudent())>20){ //Mohiuddin
                    System.out.println("ATTENTION! You missed too many classes, please speak to your teacher"); //Mohiuddin
                }
                studentMenu();
                break;
            }else if (teacherAccounts.containsKey(typeID) && teacherAccounts.get(typeID).equals(typePassword)) {
                if(!studentNotifications.isEmpty()) { //Shawan
                    System.out.println("!You have notifications from the students" + //Shawan
                            "\n" + studentNotifications); //Shawan
                    studentNotifications.clear(); //Shawan
                }
                ID = typeID;
                if (teacherMissedDays.get(searchTeacher())>20){ //Shawan
                    System.out.println("ATTENTION! You missed too many classes, please speak to your Supervisor"); //Shawan
                } //Shawan
                teacherMenu();
                break;
            }else if (admin.containsKey(typeID) && admin.get(typeID).equals(typePassword)) {
                if(!teacherNotifications.isEmpty()) {
                    System.out.println("!You have notifications from the teachers" +
                            "\n" + teacherNotifications);
                    teacherNotifications.clear();
                }
                adminMenu();
                break;

            } else {
                System.out.println("Login or password are incorrect. Please try again.");
            }
        }
    }

    public  void studentMenu () { //Alex
        System.out.println("Welcome Student " + ID);

        System.out.println("Please choose option from menu below" +
                "\n" + "1." + "View attendance" +
                "\n" + "2." + "Contact teacher" +
                "\n" + "3." + "Log out");

        initiateStudent();

    }
    public  void teacherMenu () { //Alex
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
    public  void adminMenu () { //Alex
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

    public  void initiateAdmin (){ //Alex
        String menuChoice = "";
        menuChoice = scanString.nextLine();
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

    public  void initiateStudent (){ //Alex
        String menuChoice = "";
        menuChoice = scanString.nextLine();
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

    public  void initiateTeacher (){ //Alex
        String menuChoice = "";
        menuChoice = scanString.nextLine();
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

    public  void addStudents (){ //Alex
        int login =count++;
        System.out.println("Please create a password for a new student with login " + login);
        String password = scanString.nextLine();
        System.out.println("Please assign class for a new student");
        int cClass = scanInt.nextInt();
        studentAccounts.put(login,password);
        studentIds.add(login); studentClass.add(cClass); studentMissedDays.add(0.0);studentExcused.add(0);studentUnexcused.add(0);
        System.out.println("Student has been successfully added to the system");

            adminMenu();
    }
    public  void studentTransfer (){ //Alex
        System.out.println("Please enter ID of the student you want to transfer");
        ID = scanInt.nextInt();
        System.out.println("Please enter new class for the student");
        int newClass = scanInt.nextInt();
        studentClass.set(searchStudent(),newClass);
        System.out.println("Student has been successfully transferred to another class");
        System.out.println("Go back to the main menu?");
        String answer = scanString.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            adminMenu(); }
    }
    public  void removeStudent(){ //Alex
        System.out.println("Please enter ID of the student you want to remove from the system.");
        ID = scanInt.nextInt();
        int index = searchStudent();
        if (studentAccounts.containsKey(ID)){
            studentIds.remove(index); studentMissedDays.remove(index);studentClass.remove(index);studentUnexcused.remove(index);studentExcused.remove(index);
            studentAccounts.remove(ID);
            System.out.println("Student has been successfully removed from the system");
        }else {
            System.out.println("Student not found");
        }
        System.out.println("Go back to the main menu?");
        String answer = scanString.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            adminMenu(); }
    }
    public  void addTeacher (){ //David
        int login =count++;
        System.out.println("Please create a password for a new teacher with login " + login);
        String password = scanString.nextLine();
        System.out.println("Please assign class for the new teacher");
        Integer tClass = scanInt.nextInt();
        teacherAccounts.put(login,password);
        teacherId.add(login); teacherClass.add(tClass);teacherMissedDays.add(0.0);teacherClassSize.add(0);
        System.out.println("Go back to the main menu?");
        String answer = scanString.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            adminMenu(); }

    }
    public  void removeTeacher(){ //David
        System.out.println("Please enter ID of the teacher you want to remove from the system.");
        ID = scanInt.nextInt();
        int index = searchTeacher();
        if (teacherAccounts.containsKey(ID)){
            teacherId.remove(index); teacherMissedDays.remove(index);teacherClass.remove(index);teacherClassSize.remove(index);
            teacherAccounts.remove(ID);
            System.out.println("Teacher has been successfully removed from the system");
        }else {
            System.out.println("Teacher not found");
        }
        System.out.println("Go back to the main menu?");
        String answer = scanString.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            adminMenu(); }
    }
    public  void teacherInd() { //David
        System.out.println("Enter teacher's ID");
        int typeID = scanInt.nextInt();
        ID = typeID;
        System.out.println(
                        "\n Present days " + (180 - teacherMissedDays.get(searchTeacher())) +
                        "\n Missed days " + teacherMissedDays.get(searchTeacher()) +
                        "\n Percentage of days present " + ((180 - teacherMissedDays.get(searchTeacher()))*100/180 + "%"));
        System.out.println("Go back to the main menu?");
        String answer = scanString.nextLine();
        if (answer.equalsIgnoreCase("yes")){
            adminMenu();
        }
    }
    public  void studentInd () { //David
        System.out.println("Enter student's ID");
        int typeID = scanInt.nextInt();
        ID = typeID;
        System.out.println(
                "\n Present days " + (180 - studentMissedDays.get(searchStudent())) +
                        "\n Missed days " + studentMissedDays.get(searchStudent()) +
                        "\n " + studentExcused.get(searchStudent()) + " of them are excused and " + studentUnexcused.get(searchStudent()) + " Unexcused" +
                        "\n Percentage of days present " + ((180 - studentMissedDays.get(searchStudent()))*100/180 + "%"));
        System.out.println("Go back to the main menu?");
        String answer = scanString.nextLine();
        if (answer.equalsIgnoreCase("yes")){
            adminMenu();
        }
    }

    public  Double classAttendance (){ //David
        ArrayList<Double> classMissedDays = new ArrayList();
        System.out.println("Which class would you like to view attendance on? ");
        int classObject = scanInt.nextInt();
        for (int j=0;j<studentClass.size();j++) {
            if (classObject == (studentClass.get(j))) {
                classMissedDays.add(studentMissedDays.get(j));
            }
        }
        double sum = 0;
            for (int i = 0 ; i < classMissedDays.size() ; i++){
                sum += classMissedDays.get(i);
            }
            System.out.println("Class " + classObject + " was fully present " + (180-sum) + " days out of 180 days of the school year." );
            Double percentageOfDays =100- (sum/180/classMissedDays.size()*100);
            System.out.println("Average percentage of days present for class " +classObject + " is " +percentageOfDays + " %");

        System.out.println("Go back to the main menu?");
        String answer = scanString.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            adminMenu(); }
        return sum;
    }
    public  Double teacherAttendance (){ //David

        double sum = 0;
        for (int i = 0 ; i < teacherMissedDays.size() ; i++){
            sum += teacherMissedDays.get(i);
        }
        System.out.println("Teachers were fully present " + (180-sum) + " days out of 180 days of the school year." );
        Double percentageOfDays = 100- (sum/180/teacherMissedDays.size()*100);;
        System.out.println("Average percentage of days Present for teachers are : " + percentageOfDays + " %");

        System.out.println("Go back to the main menu?");
        String answer = scanString.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            adminMenu(); }
        return sum;
    }








}
