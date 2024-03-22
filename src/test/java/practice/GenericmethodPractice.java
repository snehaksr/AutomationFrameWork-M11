package practice;

public class GenericmethodPractice {
public static void main(String[] args) {//caller function//test script
	
//	int a = 30;
//	int b = 40;
//	int c= a+b;
//	
//	System.out.println(c);
	
	int sum = add(10,20);
	
	System.out.println(sum);
	
	
	add(10,30);
	
	add(39,58);
	
	add(42,78);
}
                   //parameterization - 1
public static int add(int a,int b) //called method/function- generic/reusable
{
	int c = a+b;
	return c;
	
	// return the output to caller - 2
}
}
