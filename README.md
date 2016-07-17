# WeatherReporter

This is a Java library to retrieve  current weather information from Open Weather Map.

This application uses spring boot to run using embedded tomcat server.

I am using org.JSON api to parse the JSON object but parsing is being done for each element. Jackson for JSON api can be used as well which converts the JSON into a bean directly.

#BUILD STEPS

Please run on local machine using mvn command below :

mvn spring-boot:run

Note : Please change the app key under application.properties if required.

#Usage

1. Run the build using the command above
2. Run the URL on browser : [http://localhost:8080/todaysWeather](http://localhost:8080/todaysWeather)
3. Select the city for which you want the weather information
4. The required weather information will be displayed.


#TODO
In the interest of time , i crated a basic application which is production ready. I am sharing few ideas which can be used to add more features/flexibility.

1. Exception handling to translate and display the error messages properly
2. Junit to test the spring application end to end
3. More methods can be added for other weather information like weather forcast , weather history etc
4. City names are a drop down , this can be changed to text box (need more validation) , coordination based , zip codes based , current location of the browser etc.
5. City name to city id is hard coded , this mapping can be moved to a property file or database and the translation can be done on runtime.
