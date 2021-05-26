package Utility;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.remote.*;
import org.openqa.selenium.remote.http.W3CHttpCommandCodec;
import org.openqa.selenium.remote.http.W3CHttpResponseCodec;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Utility {
	public static RemoteWebDriver getDriver(boolean reuseBrowser) throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
		System.setProperty("webdriver.ie.driver", "drivers\\IEDriverServer.exe");
		if (!reuseBrowser) {
			RemoteWebDriver driver = new ChromeDriver();
			//RemoteWebDriver driver = new FirefoxDriver();
			//RemoteWebDriver driver = new InternetExplorerDriver();
			HttpCommandExecutor executor = (HttpCommandExecutor) driver.getCommandExecutor();
			URL url = executor.getAddressOfRemoteServer();
			SessionId session_id = driver.getSessionId();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			System.out.println("Browser launched with port URL: " + url + " and Session Id: " + session_id.toString());
			Json_Utility.writeJson("chrome", url.toString(), session_id.toString());
			return driver;
		} else {
			String[] strVar = Json_Utility.readJson();
			URL url = new URL(strVar[1]);
			SessionId session_id = new SessionId(strVar[2]);
			RemoteWebDriver driver = createDriverFromSession(session_id, url);
			System.out.println("Browser reused with existing port URL: " + strVar[1] + " and Session Id: " + strVar[2]);
			return driver;
		}
	}

	private static RemoteWebDriver createDriverFromSession(final SessionId sessionId, URL command_executor) {
		CommandExecutor executor = new HttpCommandExecutor(command_executor) {
			@Override
			public Response execute(Command command) throws IOException {
				Response response = null;
				if (command.getName() == "newSession") {
					response = new Response();
					response.setSessionId(sessionId.toString());
					response.setStatus(0);
					response.setValue(Collections.<String, String>emptyMap());
					try {
						Field commandCodec = null;
						commandCodec = this.getClass().getSuperclass().getDeclaredField("commandCodec");
						commandCodec.setAccessible(true);
						commandCodec.set(this, new W3CHttpCommandCodec());

						Field responseCodec = null;
						responseCodec = this.getClass().getSuperclass().getDeclaredField("responseCodec");
						responseCodec.setAccessible(true);
						responseCodec.set(this, new W3CHttpResponseCodec());
					} catch (NoSuchFieldException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				} else {
					response = super.execute(command);
				}
				return response;
			}
		};
		return new RemoteWebDriver(executor, new DesiredCapabilities());
	}
}