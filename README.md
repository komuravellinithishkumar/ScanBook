# ScanBook

## Steps to run the project

## Server 
* Clone the Repository from Github:https://github.com/komuravellinithishkumar/ScanBook 
* Install the Dependencies : java, spring, maven 
* Execute the java file “ScanbuydemoApplication” 

## Client
* Clone the repository from Github : 
https://github.com/komuravellinithishkumar/ScanBookReact 
* Install dependencies using: npm install 
* In the directory src/components/globals.js, update the server’s URL 4) Come back to the base directory and use the command: npm start to start server 

## BackendServer Application Architecture: 

### Database
I used MySQL database as a database choice for this project. Since the database needs to be available irrespective of the location and server, and also for easy setup of the project, I have used a deployed version of it. The database is currently running on an AWS instance that is managed using Aiven, a third party database management provider. I used Aiven specifically because it offers a 30 day free trial. The connection string to the database is initialized in the application properties of the application and doesn’t need to be reinitialized or updated while the project is being setup. 

The following is the architecture of the database I used:

**User Table:** This table contains the user details such as email, password, first name, and last name \
`USER_DETAILS (id, email, password, first_name, last_name)` \
**Books Table:** This table contains book-related information, such as the book title, author, number of pages, and ISBN number. \
`BOOK_DETAILS (id, title, author, pages, ISBN)` \
**User-Books Association Table:** This table establishes a many-to-many relationship between users and books. It includes the user object, book object, and user-specific notes about each book. It also includes information on whether the user has marked the book as read or not, which helps users keep track of their reading progress.

The above Database Architecture upto 3NF 
I have implemented a feature in my database system that allows the server to display only the books that belong to me when I log in. This means that I don't have to spend time searching through a long list of books to find the ones I own, which makes it much easier and faster for me to manage my collection. 
In addition, I have added a book search functionality that first checks if the book is already in my collection. If the book is not in my collection, the system will check the book table instead of calling the Google API every time, which can be a costly operation. This helps me save time and resources while searching for new books to add to my collection. 
For example, if I search for a book that is not in my collection or the book table, the system will call the Google API to retrieve the book information and add it to the book table. This way, if another user searches for the same book, the system can fetch the information from the local storage, which is a highly optimized way to retrieve data 
By using JPA's built-in methods for CRUD operations, I'm able to easily add, retrieve, update, and delete records in my database. For example, I can use JPA to retrieve Book objects so that I can easily retrieve all of them when a user requests it, instead of iterating over each column and fetching data one by one. which will save a operation time and cost 



## Frontend
The primary components the front end side contains are: 
* Login Module : I implemented LoginModule from scratch using local storage. I retrieved the email and stored it in the authentication context, allowing me to develop various functionalities dynamically. 
* Search Module : I have added validations that entered the ISBN number is valid , this checksum algorithm the following way 
  + Remove any hyphens from the input 
  `isbn = isbn.replace(/-/g, "");` 
  + Check that the input is a string of 13 digits 
  + Calculate the weighted sum 
  + Calculate the checksum and compare it to the last digit of the input 
This search module also implements the Google APi call , when ever the New ISBN that is not present in the local storage , it queries the google API for the ISBN information about the Book
and sends the async request to the server to store this information ,we are now redirected to bookdetails page in which logged in user can add this to his inventory . 

* Inventory Managment Module: This Module primarily makes use of the association table in the server side , here all the information like notes ,finished Status is stored and modified , when ever a new enty comes up in the association table , that signifies that , the user has a particular book into his inventory and the user cna now update the notes and status of book dynamically . 


## Improvements
* I used a window reloading method to refresh the page, but I know this is not the best way to do it. I had to use this method due to time constraints, but I understand that there are better ways to achieve the same result and I am willing to work on improving it
