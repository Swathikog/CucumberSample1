package pages;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Programs {
	WebDriver driver;
	public Logger logs; //from mvnrepository, copy paste right jar which is Apache Log4j,not anything else.
	public Properties config;
	
	@Before
	public void browserSetup() throws IOException {
		config=new Properties();
		FileInputStream obj=new FileInputStream("browser.Properties");
		config.load(obj);
		String br=config.getProperty("browser");
		
		if(br.equals("chrome")) {		
		System.setProperty("webdriver.chrome.driver", config.getProperty("chromepath"));
		driver=new ChromeDriver();
		}
		else if(br.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", config.getProperty("FirefoxPath"));
			driver=new FirefoxDriver();
		}
		else if(br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", config.getProperty("edgePath"));
			driver = new EdgeDriver();
		}
//Add maven dependency log4j, create new folder named log under project,create new log4j.properties file under project and write 
//log file description from google.Under log4j.appender.TTCC.File, give this name"./log/testlog1.log".Run project and refresh
// log folder to see new  created file and open. we can see logs.	
	logs=logs.getLogger("ArtOfLiving");
    PropertyConfigurator.configure("Log4j.properties");
    }
	
	@Given("Launching browser")
	public void Launching_browser() {
		driver.get("https://www.artofliving.org/in-en");
	}

	@When("Opening url")
	public void Opening_url(){
		logs.info("==========Opening the browser=============");
		driver.findElement(By.xpath("//ul[@id='desktop-menu-content']/li[1]/a")).click();
		
	}
	@Then("Navigate to Programs Page")
	public void navigate_to_programs_page() throws InterruptedException {
		logs.info("==========User Navigating the programs page=============");
	  driver.findElement(By.xpath("//ul[@id='desktop-menu-content']/li[2]/a")).click(); 
	  Thread.sleep(2000);
	}

	@Then("close the driver")
	public void close_the_driver() {
	logs.info("==========closing the driver=============");
	driver.findElement(By.xpath("//ul[@id='desktop-menu-content']/li[3]/a")).click(); 
	}

	@After
	public void closing() {
		driver.close();
	}
	
	
}
