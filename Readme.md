

Maven selenium project that showcases the below implementations
1. Resue existing browser instance for next (continued) run
2. Mouse over / hover events of specific application elements
3. Identify objects with multiple properties and index
4. 30% improvement of the automation scripting and maintenence effort 
Scoped browsers - Chrome, Firefox and Internet Explorer


Folder Structure (src\main\java) - 
1. PageFactory
1.1	LoginPage.java - POM of LoginPage with object locators and functions
1.2	QuickViewPopup.java - POM of Quick View with object locators and functions
1.3	ShoppingCartPage.java - POM of Shopping Cart with object locators and functions
1.4	VerifyApplicationUI.java - POM of Application with object locators and functions
2. TestScripts
2.1	Selenium_Test.java - selenium script
2.2	Selenium_Test1.java - selenium script with Testng annotations
3. Utility
3.1	AppUtility.java - Application Menu and other functions with object locators
3.2	Json_Utility.java - Json write, read and delete
3.3	Utility.java - to handle browser functions
4. drivers - browser drivers
5. pom.xml

To reuse existing browser
1. With 'reuserBrowser' = false for getDriver functions, comment driver.close/quit and execute to launch browser 
2. the message 'New browser launched is dispalyed with port and session id' and stored in driver/json file
3. update 'reuserBrowser' = true and execute code to continue using the browser launched in the earlier step
4. at the end run driver.close/quit code and ensure browser.json file is deleted programtically, reset reuserBrowser = false
5. The approach avoid test run that are specifically lengthy and error prone by halting and code update
6. For scripting, can iteratively implement (script, execute) newer code thus optimizing effort
 
Mouse over / hover events - refer code with action events.

Identify objects - refer code xpath entires evaluated in Chrome developer window with CTRL + F and Console evaluation

