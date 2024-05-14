package testpkg;

import java.time.Duration;

import org.testng.annotations.Test;

import basepkg.BaseClassHB;
import pagepkg.HotelBooking;
 
import utilpkg.UtilClassHB;

public class TestClassHB extends BaseClassHB  {
	@Test
	public void login() throws InterruptedException
	{
		HotelBooking h1=new HotelBooking(driver);
        h1.login(); 
		
        String xl="E:\\HBproject\\HBcred.xlsx";
        String Sheet="Sheet1";
        int rowcount=UtilClassHB.getRowCount(xl, Sheet);
        for(int i=1;i<=rowcount;i++)
        {
        	 String Phone=UtilClassHB.getCellValue(xl, Sheet, i, 0);
    		 System.out.println("Phone---"+Phone);
    		String password=UtilClassHB.getCellValue(xl, Sheet, i, 1);
    		System.out.println("passsword---"+password);
    		
    		h1.setvalues(Phone,password);
    		h1.verify();
    		 Thread.sleep(3000);
    		 System.out.println(driver.getCurrentUrl());
    		if(driver.getCurrentUrl().equalsIgnoreCase("https://www.oyorooms.com/"))
    		{
    			h1.locationbyhover();
    		}
    		else
    		{
    			h1.refresh();
    			h1.passwordlogin();
    		}
        }
	}

}
