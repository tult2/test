package org.test;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

//New branch5
public class NewTest1 {
	public WebDriver wd;
	  @BeforeClass
	  public void beforeClass() {
		  	String baseUrl = "http://localhost:8080/portal/intranet/home";
		  	wd = new FirefoxDriver();
			wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			wd.manage().window().maximize();
			wd.get(baseUrl);
	  }
	  
  @Test
  public void main() {
	  wd.findElement(By.id("username")).sendKeys("root");
		wd.findElement(By.id("UIPortalLoginFormControl")).sendKeys("gtngtn");
		wd.findElement(By.xpath("//*[@id='UIPortalLoginFormAction']/button")).click();
		//Click on Wiki
		wd.findElement(By.xpath("//*[@id='18940f34-d0d8-4f64-a687-617d54b62e71']/div/div/ul/li[3]/a/span")).click();
		//Click on Add Page
		wd.findElement(By.xpath("//*[@id='UIWikiPageControlArea_PageToolBar']/ul/li[2]/div")).click();
		//Click on Blank Page
		wd.findElement(By.xpath("//*[@id='UIWikiPageControlArea_PageToolBar']/ul/li[2]/ul/li[1]/a[1]")).click();
		//Input title for wiki page
		wd.findElement(By.id("titleInput")).sendKeys("Firtst Wiki page from Ecipse 3");
		System.out.println("It's OK when add Title");
		//Input content for Wiki Page (Souorce Editor)
		wd.findElement(By.xpath("//*[@id='UIEditorTabs']/button[1]")).click();
		wd.findElement(By.id("Markup")).sendKeys("Hehehehe");
		//Click save button
		wd.findElement(By.id("UISubmitToolBarBottom_SavePage_")).click();
		//Click in the wiki page which just creared
		wd.findElement(By.xpath("//*[@id='iconTreeExplorer']/a")).click();
		//Click on more button
		wd.findElement(By.xpath("//*[@id='UIWikiPageControlArea_PageToolBar']/ul/li[3]/div")).click();
		//Click on Permanent link
		wd.findElement(By.xpath("//*[@id='UIWikiPageControlArea_PageToolBar']/ul/li[3]/ul/li[1]/a")).click();
		//Switch to pop up
		Set handles = wd.getWindowHandles();
		for (String handle1 : wd.getWindowHandles()){
			System.out.println(handle1);
			wd.switchTo().window(handle1);			
		}
		System.out.println("It's OK when switch to pop up");
  }

 

  @AfterClass
  public void afterClass() {
	  wd.quit();
  }

}
