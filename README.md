#Plivo Rest Assured Project



### Install the required plugins
mvn clean install

### To run the Project-	
src/test/resources contains TestNg.xml file- Right click and Run with TestNg configuration

Reporting is currently not implemented in the code due to Time constraints

##Project Structure Explaination-

src/main/respurce- Contains The configuration file config.properties

src/test/java-
Contains the Test script- PilvoMessagingTest

src/main/java-
pilvo.businessLogic
SendMessageAssertions is the Main controller to make the Test script clean
CoreBusinessLogic-- Reusable business logic is implemented as methods
CountryToIsoMapping- Country Iso mapping.

plivo.common.utils-
All the common project utils are kept here

pilvo.response.pojos-
All the Pojo classes are kept in this package

pilvo.servicehelper-
This contains the Service helper class




# pilvoProject
