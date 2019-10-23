package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    private static final String FIRSTNAME_INPUT_XPATH = "//input[@id=\"u_0_p\"]";
    private static final String LASTNAME_INPUT_XPATH = "//input[@id=\"u_0_r\"]";
    private static final String EMAIL_INPUT_XPATH = "//input[@id=\"u_0_u\"]";
    private static final String EMAIL_REPEAT_INPUT_XPATH = "//input[@id=\"u_0_x\"]";
    private static final String PASSWORD_INPUT_XPATH = "//input[@id=\"u_0_11\"]";
    private static final String SELECT_DAY_XPATH = "//select[@id=\"day\"]";
    private static final String SELECT_MONTH_XPATH = "//select[@id=\"month\"]";
    private static final String SELECT_YEAR_XPATH = "//select[@id=\"year\"]";
    private static final String SEX_INPUT_XPATH = "//input[@id=\"u_0_6\"]";
    private static final String XPATH_WAIT_FOR = "//select";

    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com/r.php");

        WebElement firstnameField = driver.findElement(By.xpath(FIRSTNAME_INPUT_XPATH));
        firstnameField.sendKeys("Magdalena");

        WebElement lastnameField = driver.findElement(By.xpath(LASTNAME_INPUT_XPATH));
        lastnameField.sendKeys("Majka");

        WebElement emailField = driver.findElement(By.xpath(EMAIL_INPUT_XPATH));
        emailField.sendKeys("megg.maier@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath(PASSWORD_INPUT_XPATH));
        passwordField.sendKeys("password");

        WebElement emailRepeatField = driver.findElement(By.xpath(EMAIL_REPEAT_INPUT_XPATH));
        emailRepeatField.sendKeys("megg.maier@gmail.com");

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed());

        WebElement selectCombo1 = driver.findElement(By.xpath(SELECT_DAY_XPATH));
        Select selectDay = new Select(selectCombo1);
        selectDay.selectByIndex(21);

        WebElement selectCombo2 = driver.findElement(By.xpath(SELECT_MONTH_XPATH));
        Select selectMonth = new Select(selectCombo2);
        selectMonth.selectByIndex(12);

        WebElement selectCombo3 = driver.findElement(By.xpath(SELECT_YEAR_XPATH));
        Select selectYear = new Select(selectCombo3);
        selectYear.selectByValue("1991");

        driver.findElement(By.xpath(SEX_INPUT_XPATH)).click();
    }
}
