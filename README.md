"# ACM_System" 
Air company management system web app.

Please, follow these steps to run the app. 
1. Ensure you have installed MySQL database.

2. Go to src/main/resources/application.properties file and
change the credentials to connect to DB (i.e. username and password).
   
3. Please create schema in your DB with a name "acm_system". If
you want to use another schema specify the schema name in
   src/main/resources/application.properties file, filed @spring.datasource.url.
   WARNING: don't change any other text in spring.datasource.url field.

4. Note, all the table are created automatically. By default, data would be erased at every run of the project. If you would like to persist all the data in the database change the field
   spring.jpa.hibernate.ddl-auto in application.properties to any suitable for you.
5. Now you are able to run the project.
6. You can inject a little of test data executing src/main/java/com/data/sql_data.sql file.
7. For testing the app you can use a Postman app. For that a collection of request 
is stored src/main/resources/templates/ACM_system.postman_collection.json. 
   Import the collection to Postman, you can start from PostRequests. 
8. Another way to test all the endpoints is to go on the link http://localhost:8080/swagger-ui.html.
There you will find all the endpoints and would be able to test all of them.
   
9. You can contribute to the project forking from GiTHub the project
   https://github.com/Ketch92/ACM_System.git and creating a pull request for changes.
