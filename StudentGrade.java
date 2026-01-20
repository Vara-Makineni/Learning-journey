import java.util.Scanner;

public class StudentGrade {

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter marks");
        int grade=sc.nextInt();
        if(grade>=90){
            System.out.println("student got A grade");

        }

        else if(grade>=80){
            System.out.println("Student got B grade");
        }

        else if(grade>=70){
            System.out.println("student got C grade");
        }

        else{
            System.out.println("student is failed");
        }

        }
        
    }

    

