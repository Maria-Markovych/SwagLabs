# UI Automation Project
Project developed to perform automated tests on the website https://www.saucedemo.com/
## Installation
Clone this repository to your local machine using the command below:
- $ git clone https://Github.com/Maria-Markovych/SwagLabs
- download chromedriver and edgedriver and place them
in folder "src/test/resources"
## Technologies:
- Selenium WebDriver
- Java
- Maven
## Patterns
- Page Object
- PageFactory
## Dependencies
- selenium-java
- testng
- assertj-core
- ini4j
## Running tests
You can run tests either  in Classes LoginTest 
and ProductsTest or in file testng.xml. 
## Settings 
If you want to change settings in the project, 
such as BROWSER, USERNAME, CHROMEDRIVER_PATH or
EDGEDRIVER_PATH you might create a file
“Config.ini” in the root of the project. 
An example of the "Config.ini" file is located
in this project.
## Parameters
- BROWSER - the browser on which the website is 
being tested(Example: Chrome, Edge)
- USERNAME - authorization data(Example: standard_user,
  locked_out_user, problem_user, performance_glitch_user)
- CHROMEDRIVER_PATH and EDGEDRIVER_PATH - the path to
the chromedriver and edgedriver