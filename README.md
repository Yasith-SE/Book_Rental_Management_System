# 🏛️ Book Rental Management System

A comprehensive desktop application designed to modernize library operations. This system efficiently manages book rentals, member registrations, and library inventory. Built using **JavaFX** and **MySQL**, it follows a strict **Layered Architecture (MVC)** to ensure data integrity and scalable performance.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-000?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![JFoenix](https://img.shields.io/badge/JFoenix-Library-green?style=for-the-badge)

---

## 📸 System Previews

| Rental Dashboard | Member Registration |
|:---:|:---:|
| <img src="https://github.com/Yasith-SE/Book_Rental_Management_System/blob/dev/Book_Rental_Management_System/src/main/resources/view/images/Book%20Rental%20Frame.png" width="400"> | <img src="https://github.com/Yasith-SE/Book_Rental_Management_System/blob/dev/Book_Rental_Management_System/src/main/resources/view/images/Library%20Frame.png" width="400"> |
| *Efficient Book Issue & Rental Cart* | *New Member Signup (Student/Adult)* |

---

## 🚀 Key Modules & Features

### 1. 👥 Library Member Management
* **Member Registration:** Register new library members with detailed profiles (NIC, Name, DOB, Address).
* **Membership Types:** categorize members as **Student** or **Adult** for custom rental rules.
* **Duplicate Protection:** Automatically validates NICs to prevent duplicate member entries.

### 2. 📚 Library Catalog & Inventory
* **Smart Search:** Instantly locate books by **Book ID** or **Title**.
* **Stock Control:** Real-time updates of book quantities; stock automatically decreases upon rental.
* **Auto-ID Generation:** System automatically generates the next Book ID (e.g., `B001` → `B002`) to maintain catalog order.

### 3. 🔄 Rental & Issue System
* **Book Bucket (Cart):** Issue multiple books to a single member in one transaction.
* **Date Validation:** Enforces logic ensuring Due Dates are not before Issue Dates.
* **Transactional Integrity:** Uses SQL Transactions (`commit`/`rollback`) to ensure that Rental Records and Stock Updates happen simultaneously—preventing data discrepancies.

---

## 🛠️ Technical Architecture

* **Language:** Java (JDK 11/17+)
* **UI Framework:** JavaFX (with JFoenix for Material Design)
* **Database:** MySQL
* **Design Pattern:** MVC (Model-View-Controller)
    * **Controller:** Manages UI logic and input validation.
    * **Service:** Handles business rules and transaction management.
    * **Repository (DAO):** Executes raw SQL queries and DB connections.

---

## 🗄️ Database Schema

To set up the library database, run the following SQL script:

```sql
CREATE DATABASE library_db;
USE library_db;

-- 1. Book Catalog
CREATE TABLE book_registration (
    bookId VARCHAR(20) PRIMARY KEY,
    bookTitle VARCHAR(100),
    bookAuthor VARCHAR(100),
    category VARCHAR(50),
    quantity INT,
    price DOUBLE
);

-- 2. Member/Customer Records
CREATE TABLE customer (
    NIC VARCHAR(20) PRIMARY KEY,
    Name VARCHAR(100),
    DOB DATE,
    Age INT,
    PhoneNumber VARCHAR(20),
    Cust_Email VARCHAR(100),
    Cust_HomeAdress VARCHAR(255),
    Adult_Student VARCHAR(20)
);

-- 3. Rental Header (Transaction Info)
CREATE TABLE rental (
    rentalId VARCHAR(20) PRIMARY KEY,
    NIC VARCHAR(20),
    customerName VARCHAR(100),
    issue_date DATE,
    due_date DATE,
    FOREIGN KEY (NIC) REFERENCES customer(NIC)
);

-- 4. Rental Details (Books per Transaction)
CREATE TABLE rental_item (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rentalId VARCHAR(20),
    bookId VARCHAR(20),
    bookTitle VARCHAR(100),
    quantity INT,
    rentalCost DOUBLE,
    FOREIGN KEY (rentalId) REFERENCES rental(rentalId),
    FOREIGN KEY (bookId) REFERENCES book_registration(bookId)
);
