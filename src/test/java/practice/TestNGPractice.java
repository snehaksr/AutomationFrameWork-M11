package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
@Test(priority = -2 , invocationCount = 3)
public void run()
{
	System.out.println("Hi all by run");
}
@Test (priority = -1,enabled = true)
public void walk()
{
	System.out.println("Hi all");
}
@Test (priority = 'a')
public void talk()
{
	Assert.fail();
	System.out.println("Welcome all");
}
@Test (priority = 'B')

public void jump()
{
	System.out.println("Jump all");
}

@Test (dependsOnMethods = {"jump","walk"})
public void empty()
{
	System.out.println("Nothing");
}

}
// if no priority it will execute based on ASCII value
