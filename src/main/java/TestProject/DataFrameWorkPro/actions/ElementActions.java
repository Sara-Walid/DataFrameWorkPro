package TestProject.DataFrameWorkPro.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import TestProject.DataFrameWorkPro.TestBase;

public class ElementActions extends TestBase {

    public WebElement getElement(By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
            scrollPageToElement(element);
        } catch (Exception ignored) {
        }
        return element;
    }

 
    public WebElement getElementByIndex(By locator, int index) {
    	
        WebElement element = driver.findElements(locator).get(index);
        scrollPageToElement(element);
        return element;
    }

   
    public int getIndexOfListByText(By locator, String selectionText) {
        int index = 0;
        List <WebElement> elementList = driver.findElements(locator);
        for(WebElement element : elementList){
            System.out.println(element.getText());
            if(selectionText.contains(element.getText())){
                if(element.getText().equals("-")) continue; 
                index = elementList.indexOf(element); break;
            }
        }
        return index;
    }

   
    public void scrollPageToElement(WebElement element) {
    	
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            actions.moveToElement(element).build().perform();
            highlightElement(element);
            unhighlightElement(element);
        } catch (Exception ignored) {
//            e.printStackTrace();
        }
    }

   
    public void highlightElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].setAttribute('style', 'background: #ffffe6; border: 2px solid yellow;');", element);
    }

  
    public void unhighlightElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].removeAttribute('style','')", element);
    }

 
    public WebElement retrieveElementByAttributeValue(String attribute, String value) {
        return driver.findElement(By.xpath("//*[@" + attribute + "='" + value + "']"));
    }

   
    public void forceClickOnElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
    }

  
    public void switchToFrame(By frameLocator) {
        WebElement frame = getElement(frameLocator);
        driver.switchTo().frame(frame);
    }
    public void acceptAlert() {
        try {
            driver.switchTo().alert().accept();
        }
        catch (NoAlertPresentException Ex) {
            System.out.println("no alerts appear");
        }
    }
    public void dismissAlert() {
    	
        try {
            driver.switchTo().alert().dismiss();
        }
        catch (NoAlertPresentException Ex) {
            System.out.println("no alerts appear");
        }
    }
    
  
    public int getListSize(By locator) {
    	
        return driver.findElements(locator).size();
    }
   
    public void pressTab(By locator) {
    	
        driver.findElement(locator).sendKeys(Keys.TAB);
    }
   
    public void pressEnter(By locator) {
    	
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }
}
