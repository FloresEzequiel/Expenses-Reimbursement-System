# Expenses Reimbursement System
## Project Description
The Expense Reimbursement System will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.
## Technologies Used
* IntelliJ
* DBeaver
* Visual Studio Code
* Amazon AWS
* TomCat
## Features
* Register as an Employee or Finance Manager and receive an email with your login credientials
* Employees can submit reimbursement requests and view their past tickets
* Finance managers can log in and view all pending and resolved reimbursement requests of all the employees
* All passwords are encrytped in the database
* Finance managers are authorized to approve and deny requests for expense reimbursement

To-do list:
* Add a feature that will allow employees to submite an image of a receipt
* Add a feature that allows FInance managers to view the image of the receipt of the reimbursement request

## Getting Started
* Install DBeaver and link your Amazon AWS Database
* Install TomCat
* Download the project and open it with Intelliji
* Once The project is open, add a TomCat configuration
* Given any name to the configuration in the Name: section as you can see in the image tomcat.png
* Then in Tomcat Server select the option thats in the image tomcat.png
* Set the Server port to 9000
* Set the Admin port to 9005 
* Add the pathing of the webapp folder to the Deployment Directory by clicking the folder image beside it as you can see in the tomcat.png
![Screenshot](tomcat.PNG) 

* Next go to DBeaver and create a new database with the name reimbursement_db
* Open a script in that database and run the scripts that can be seen in images

* After you run each script you should have the following tables that are in image tables.png
![Screenshot](tables.PNG) 

* Next go to the file location that you can see in EditConnection.PNG image
* Once there you are going to need to add your Amazon AWS database connection information here
* In the url variable you are going to add your database url and /database name, in the variable username your are going to add your username and lastly add your password to the password variable 
![Screenshot](EditConnection.PNG) 

## Usage


