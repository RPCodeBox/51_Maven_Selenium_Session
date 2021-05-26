

Maven selenium project that showcases the below implementations
1. Resue existing browser instance for next (continued) run
2. Mouse over / hover events of specific application elements
3. Identify objects with multiple properties and index
4. 30% improvement of the automation scripting and maintenence effort 
Scoped browsers - Chrome, Firefox and Internet Explorer


Folder Structure (src\main\java) - 
PageFactory
	LoginPage.java - POM of LoginPage with object locators and functions
	QuickViewPopup.java - POM of Quick View with object locators and functions
	ShoppingCartPage.java - POM of Shopping Cart with object locators and functions
	VerifyApplicationUI.java - POM of Application with object locators and functions
TestScripts
	Selenium_Test.java - selenium script
	Selenium_Test1.java - selenium script with Testng annotations
Utility
	AppUtility.java - Application Menu and other functions with object locators
	Json_Utility.java - Json write, read and delete
	Utility.java - to handle browser functions
drivers - browser drivers
pom.xml

To reuse existing browser
1. With 'reuserBrowser' = false for getDriver functions, comment driver.close/quit and execute to launch browser 
2. the message 'New browser launched is dispalyed with port and session id' and stored in driver/json file
3. update 'reuserBrowser' = true and execute code to continue using the browser launched in the earlier step
4. at the end run driver.close/quit code and ensure browser.json file is deleted programtically, reset reuserBrowser = false
5. The approach avoid test run that are specifically lengthy and error prone by halting and code update
6. For scripting, can iteratively implement (script, execute) newer code thus optimizing effort
 
Mouse over / hover events - refer code with action events.

Identify objects - refer code xpath entires evaluated in Chrome developer window with CTRL + F and Console evaluation

