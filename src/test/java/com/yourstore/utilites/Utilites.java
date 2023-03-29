package com.yourstore.utilites;





import java.util.Date;

import com.yourstore.base.Baseclass;

public class Utilites extends Baseclass {

	public static final int IMPLICIT_WAIT_TIME = 10;
	
	public static final long PAGE_Load_TIME = 10;
	

	public static String random_EmailID() {
		Date date = new Date();
		String num = date.toString().replace(" ", "_").replace(":", "_");
		String email = "sai" + num + "@gmail.com";
		return email;

	}
}

