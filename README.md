# Watch Management System

## Overview

A web-based watch store management system built with Java EE technologies. The system allows users to browse, purchase luxury watches while providing administrators with tools to manage products, users, and orders.

## Technologies Used

- Java EE 7
- JSP/Servlet
- MSSQL Server
- Bootstrap 4.5.2
- HTML/CSS/JavaScript

## Features

### Customer Features

- Browse watch catalog
- Search watches by name/ID
- Shopping cart functionality
- User authentication
- Wishlist management
- Order processing

### Admin Features

- Product management (CRUD operations)
- User management
- Order/Invoice management

## Project Structure

### Key Components

1. **Frontend**

- JSP pages for user interface
- CSS styling (see `web/css/` directory)
- Bootstrap for responsive design
- Video backgrounds for enhanced UX

2. **Backend**

- Java Servlets for request handling
- DAO pattern for database operations
- MVC architecture

3. **Database**

- MSSQL Server database
- JDBC for database connectivity

## Setup Instructions

1. **Prerequisites**

- JDK 1.8
- Apache Tomcat 8.x
- NetBeans IDE
- MSSQL Server

2. **Database Configuration**

- Configure MSSQL connection in your project
- Import required SQL driver (sqljdbc4.jar)

3. **Build & Deploy**

- Open project in NetBeans
- Build using Ant
- Deploy to Tomcat server

## Key Files

### Frontend

- `Home.jsp`: Main landing page
- `shopping.jsp`: Product catalog
- `login.jsp`: User authentication
- `admin.jsp`: Admin dashboard

### Styling

- `Home.css`: Main styling
- `Shopping.css`: Product catalog styling
- `Header.css`: Navigation styling

## Author

- Hau Huynh
- Contact: ngochau1310@gmail.com

## License

This project is protected under standard copyright laws.

## Notes

- Project developed as part of PRJ301 course at FPT University
- For educational purposes only
