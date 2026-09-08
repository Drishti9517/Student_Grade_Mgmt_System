import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of students: ");
        int n;
        while(true) {
            try{
                n = sc.nextInt();
                if(n<=0) {
                    System.out.print("Enter a positive integer: ");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Enter a positive integer: ");
                sc.next();
            }
        }

        ArrayList<String> name = new ArrayList<>();
        ArrayList<Float> marks = new ArrayList<>();

        sc.nextLine();
        for(int i=0; i<n; i++) {
            System.out.print("Enter name of student " + (i+1) + ": ");
            String stu_name;
            stu_name = sc.nextLine();
            boolean isValid = false;
            while(!isValid) {
                isValid = true;
                if(stu_name.isBlank()) {
                    isValid = false;
                    System.out.print("Invalid name! Enter valid name: ");
                    stu_name = sc.nextLine();
                }
                for(int j=0; j<stu_name.length(); j++) {
                    if (!Character.isAlphabetic(stu_name.charAt(j)) && stu_name.charAt(j) != ' '){
                        isValid = false;
                        System.out.print("Invalid name! Enter valid name: ");
                        stu_name = sc.nextLine();
                        break;
                    }
                }
            }
            name.add(stu_name);
            System.out.print("Enter marks of " + stu_name + ": ");
            float stu_marks;
            while(true) {
                try {
                    stu_marks = sc.nextFloat();
                    if(stu_marks<0 || stu_marks>100 || Float.isNaN(stu_marks)) {
                        System.out.print("Invalid input! Enter valid marks: ");
                        continue;
                    }
                    break;
                } catch (InputMismatchException s) {
                    System.out.print("Invalid input! Enter valid marks: ");
                    sc.next();
                }
            }
            marks.add(stu_marks);
            sc.nextLine();
        }

        System.out.println("==============================");
        System.out.println("    STUDENT GRADE REPORT");
        System.out.println("==============================");
        System.out.println("------------------------------");
        System.out.printf("%-15s  %-10s%n" , "Name" , "Marks");
        System.out.println("------------------------------");

        for(int i=0; i<n; i++) {
            System.out.printf("%-15s %-10.2f%n", name.get(i) , marks.get(i));
        }

        System.out.println("------------------------------");
        System.out.println("Average marks: " + GradeCalculator.avg(marks));
        System.out.println("Maximum marks: " + GradeCalculator.max(marks));
        System.out.println("Minimum marks: " + GradeCalculator.min(marks));
        System.out.println("==============================");
    }

}
