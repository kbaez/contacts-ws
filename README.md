# contacts-ws
How to run project:

#1 - Install STS - Spring, POSTMAN and XAMPP or mysql workbench.
#2 - Run MySQL and import project in STS. 
#3 - Only the first time, uncomment on application-uat.properties file the line spring.jpa.hibernate.ddl-auto=create
#4 - Run project in STS.
#5 - On POSTMAN create a GET http://localhost:8080/contact. It'll return all contacts.
#6 - If you run again, before comment application-uat.properties file the line spring.jpa.hibernate.ddl-auto=create
