package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

public class BaseClass {
	public static WebDriver driver;
	public static Actions action;
	public static WebDriverWait wait;
	public static ChromeOptions options;
	public static Properties prop;

	@BeforeTest
	public void launchApplication() throws IOException {
		prop = new Properties();
		File proFile = new File(
				System.getProperty("user.dir") + "\\src\\test\\java\\Properties\\configuration.properties");
		FileInputStream fis = new FileInputStream(proFile);
		prop.load(fis);
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("URL"));

	}

	public List<HashMap<String, String>> getJsonDataToMap(String path) throws IOException {

		// read json data to string
		String jsonConnect = FileUtils.readFileToString(
				new File(path),
				StandardCharsets.UTF_8);

		// String to HashMap jackson databind

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonConnect,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	@AfterTest
	public void closeApplication() {
		driver.quit();
	}

}
