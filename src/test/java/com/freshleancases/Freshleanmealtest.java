package com.freshleancases;

import org.testng.annotations.Test;

import com.freshlean.Freshleanmealpage;

public class Freshleanmealtest extends Freshleanlogin {

	@Test
	public void freshleanmealpage() throws InterruptedException {
		Freshleanmealpage freshleanselectmeal = new Freshleanmealpage(driver);
		freshleanselectmeal.Freshleanmealselection();

	}

}
