**Product-Edstruments** is a RESTful API that uses Java,Spring Boot and manages a list of Products with a list of custom exceptions . 

Instructions on **how to run the application** : 

1. **Prerequisites**
Java Development Kit (JDK): Ensure JDK is installed (preferably JDK 8 or later).
Maven/Gradle: Depending on your build tool, Maven or Gradle should be installed and configured.

2. **Build the application**
   Command to build : mvn clean install

3. **Run the application**
   Command to run : mvn spring-boot:run

While using an IDE, we can **right-click the main class and choose "Run"** or use the IDE's run button.

Once started , the application will **run on port 8080** . 
We can verify that through postman or any API tester using this URL :  http://localhost:8080


**Exception Handling and Validation Logic:**

The API throws custom exception incase of occurence of events such as Product not found or entering invalid input data. 
1. **Product Not Found** : This exception is thrown when we try to fetch a product with getAllProducts or getProductById and with error code 404. 

2. **Invalid input** : This exception is thrown when we try to update an API with invalid request parameters.

For name field not to be null or empty , I have used the @NotEmpty annotation of Springboot. 
For price field to be positive , I have used the @Positive annotation of Springboot. 

To connect the product API with MySQL Database , I have launched up **MySQL as a Docker container** on port 3306. 

**POSTMAN Collection URL** to test the APIs : 
https://web.postman.co/workspace/680b6dc1-17bc-4bcb-a178-e41ad680c02b/documentation/33479886-2e71080a-64e3-425c-a839-2fdf84e39d7e

The SQL file,Ecommerce.sql for Q2 is also attached herewith. 


