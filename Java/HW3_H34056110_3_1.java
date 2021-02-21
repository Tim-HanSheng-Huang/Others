package hw3_1;

import java.util.Scanner;

public class H34056110_3_1 {


	   public static void main(String[] args)
	   {
		   Scanner input= new Scanner(System.in);
		   int number_of_students,number_of_exams;
		   String course_name;
		   System.out.println("please input the course name");
		   course_name=input.next();
		   System.out.println("please input the number of students");
		   number_of_students=input.nextInt();
		   System.out.println("please input the number of exams");
		   number_of_exams=input.nextInt();
		   
		   GradeBook myGradeBook=new GradeBook(course_name,number_of_students,number_of_exams);
		   
		   for(int i=0;i>=0;i++)
		   {
			   int student,exam,grade;
			   System.out.println("please input the student number.(-1 for no more grade)");
			   student=input.nextInt();
			   if(student==-1) break;
			   else if(student>number_of_students)
			   {
				   System.out.println("wrong input");
			   }
			   else
			   {
				   System.out.println("please input the exam number.");
				   exam=input.nextInt();
				   if(exam<=number_of_exams)
				   {
					   System.out.println("please input the grade.");
					   grade=input.nextInt();
					   myGradeBook.setGrade(student,exam,grade);
				   }
				   else
				   {
					   System.out.println("wrong input");
				   }
			   }
		   }
		   
	      System.out.printf("Welcome to the grade book for%n%s%n%n", 
	         myGradeBook.getCourseName());
	      myGradeBook.processGrades();
	   } 

}
