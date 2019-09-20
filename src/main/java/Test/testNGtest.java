package Test;

import org.testng.annotations.Test;

public class testNGtest {

@Test(groups = {"Mango"})
public void test1() {
	
	System.out.println("I am test1");
	
}
@Test(groups = {"Apple"})
public void test2() {
	System.out.println("I am test2");
}
@Test(groups = {"Mango"})
public void test3() {
	System.out.println("I am test3");
}
@Test(groups = {"Apple"})
public void test4() {
	System.out.println("I am test4");
}
}
