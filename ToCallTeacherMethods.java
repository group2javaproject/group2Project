package Class1;

import java.util.Scanner;

public class ToCallTeacherMethods {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);

        System.out.println("Please enter your teacher's ID");
        String typeTeacherID= scan.nextLine();
        System.out.println("Please type the number of student for your class");
        int typeNum= scan.nextInt();
        scan.nextLine();   // to catch end of line
        TeacherMethods T1= new TeacherMethods(typeTeacherID, typeNum);

       // 1. to define how many students teacher wants to have in his class



        //2. to add students

        T1.addStudentScanner();

        //3. to remove students

        T1.removeStudentScanner();

        //4.Take student attendance mark present, excused absent, unexcused absent


        T1.studentsAttendanceScanner();



    }

}
