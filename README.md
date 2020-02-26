Setup

> _Note: tested in IntelliJ IDEA with Chrome driver only!_
1. Checkout project, import to IDE
2. Let Gradle sync
3. Copy contents of file /src/test/resources/configuration.sample into a new file, update values to be used as configuration for running test scenarios. **_DO NOT REMOVE THE SAMPLE FILE_**
4. Copy contents of file /src/test/resources/credentials.sample into a new file, update values. **_DO NOT REMOVE THE SAMPLE FILE_**
5. To run individual test cases, right click on scenario, choose Run/Debug scenario
6. Add VM options to the run configuration:
* `-Dselenide.browser=ie`
* `-Dwebdriver.ie.driver=<path>` Path to WebDriver
* `-Didm.configuration.path=<path>` Path to configuration required for running the tests (file from step 3)
* `-Didm.credentials.path=<path>` Path to credentials to be used for logging into InforOS (file from step 4)
 
*Example VM options for Run/Debug configuration:*

`-Dselenide.browser=ie -Dwebdriver.chrome.driver=C:\bin\IEDriverServer.exe -Didm.configuration.path=C:\configuration\e2e_idm1_configuration -Didm.credentials.path=C:\configuration\e2e_idm1_credentials`

_**Running from command line**_

`gradlew <chrome|firefox> -Pidm.configuration.path=<path> -Pidm.credentials.path=<path>`

__**Run in docker**__  
> _Currently only chrome and firefox can be tested in Docker, since IE webdriver does not support headless mode_

> _Windows host OS is assumed in running scripts_

>_When run in container, there's no need for local Chrome browser or webdriver_

* Set environment variables **IDM_CRED** (path to credentials file), and IDM_CONF (path to configuration file)
* Run `docker-compose up -d`
* (Windows) Inside the project directory, run `docker-run-chrome.cmd` to initialize tests for chrome browser
* (Windows) Inside the project directory, run `docker-run-firefox.cmd` to initialize tests for firefox browser
