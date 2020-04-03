package week1.day4;

import java.util.Arrays;

public class StringArrays {

	public static void main(String[] args) {
int input[]= {1000,408,70,100};
//avg
int sum =0;
for (int i = 0; i < input.length; i++) {
	sum=sum+input[i];
}
System.out.println(sum);

//min and max of numbers

Arrays.sort(input);
System.out.println("The min number is"+input[0]);
System.out.println("The max number is"+input[3]);

//for (int i = 0; i < input.length; i++) {
	//for (int j = 0; j < input.length-1; j++) {
		//if (input[j]>input[j+1])
		//	int temp =input[j];
		//input[j]=input[j+1];
		//input[j+1]=temp;
int min =input[0];
for (int i = 0; i < input.length; i++) {
	if (input[i]<min) {
		min=input[i];
		}
}
	int max =input[0];
	for (int j = 0; j < input.length; j++) {
		if (input[j]>max) {
			max=input[j];
			
		}
	}
	System.out.println(min);
	System.out.println(max);
	//index number of given item
	for (int i = 0; i < input.length; i++) {
		if (input[i]==70)
		{
		System.out.println(i);
		break; //to come out after first match 
		}
		
	}
	}

}
		
		
	



//find index number of given item from array

