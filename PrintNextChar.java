package week1.day3;

public class PrintNextChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String input = "A123B234";

char[] charArray = input.toCharArray();

for (int i=4;i<input.length();i++)
{
	System.out.print(charArray[i]);}
	}

}
