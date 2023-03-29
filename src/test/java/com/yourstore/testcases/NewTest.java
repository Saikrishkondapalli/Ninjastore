package com.yourstore.testcases;

import org.testng.annotations.Test;

import com.yourstore.base.Baseclass;

public class NewTest extends Baseclass {
  @Test
  public void f() throws InterruptedException {
	  Thread.sleep(3000);
//driver.get("www.youtube.com");
	  String s= driver.getCurrentUrl();
	  System.out.println(s);
	  
  }
}
