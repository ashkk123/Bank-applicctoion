package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Utitity.Uitil;
import Utitity.eventListenClass;


public class Base {
	public Properties prop;
	public static  WebDriver driver;
	EventFiringWebDriver ev;
	eventListenClass listen;
	public Base(){
		
		//("C:\\Users\\pc\\workspace\\guru99\\src\\main\\java\\Config\\Config.Properties");
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\pc\\workspace\\guru99\\src\\main\\java\\Config\\Config.Properties");
			prop=new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	public void intilization()
	{
		String browser=prop.getProperty("browser");
		
		if(browser.equals("chrome")){
		
			ChromeOptions handlingSSL = new ChromeOptions();
			 
			 //Using the accept insecure cert method with true as parameter to accept the untrusted certificate
			 handlingSSL.setAcceptInsecureCerts(true);
			// Set ACCEPT_SSL_CERTS  variable to true
			//cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\workspace\\guru99\\drivers\\chromedriver.exe");
			
			driver=new ChromeDriver(handlingSSL);
		}
		
		
		//driver.get(prop.getProperty("URL"));
		
		
		ev=new EventFiringWebDriver(driver);
	listen=	new eventListenClass();
	ev.register(listen);
	driver=ev;
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Uitil.pageloadtimeout, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(Uitil.Imppilcitwait, TimeUnit.NANOSECONDS);
		
		//driver.manage().timeouts().pageLoadTimeout(Uitil.pageloadtimeout, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
	
	}
	

}
