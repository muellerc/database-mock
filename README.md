# Database mock

The goal is to provide an easy solution to "mock" a database because you don't have an instance available during your
development, dev test or your CI execution.

## How it's set up
This Java EE 7 application is using an JPA persistence unit to get access to the database. Why? Because you are probably
already using JPA in your application and so you can refere to the same persistence unit.
Of course, you could also use the data source @Resource directly without using a persistence unit.

## How it works
This applications contains a @Singleton EJB which is executed @Startup to initialize the database with the script 'init.sql'
which is provided as resource. This is a good approach to separate the SQL code from the application/java code.

This application also offers the possibility to reset the database to the initial state by executing an HTTP GET request
to http://localhost:8080/database-mock/reset. This is a good approach if you have to reset your database to the initial
state during your integration tests.

Another possibility to reset your database to the initial state for business people (none developers) is provided with a
very simple graphical user interface at http://localhost:8080/database-mock/. Just click the 'Reset Database' button.

Enjoiy ;-)