package week1.day1;
public class Android {
	//variable declaration
	int releaseYear =2018;
	boolean isRefurbished = false;
	String phonemodel = "OnePlus";
	float androidVersion =10.0f;
	long imeiNum= 1234567898;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Android phone =new Android(); //initialization

//Printing the required output
System.out.println("Android Phone Details");
System.out.println("Phone Name : "+phone.phonemodel);
System.out.println("Released Year:"+phone.releaseYear);
System.out.println("Refurbished :"+phone.isRefurbished);
System.out.println("IMEI Number :"+phone.imeiNum);
System.out.println("Android Version :"+phone.androidVersion);
	}

}
