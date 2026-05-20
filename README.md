# ⌚ Watch Management System

> A web-based e-commerce and management system for a luxury watch store — built with Java EE, JSP/Servlet, and SQL Server as a solo project for the PRJ301 course at FPT University.

---

## 📖 About the Project

**Watch Management System** is a full-featured web application for a luxury watch store, developed solo for the PRJ301 course (Semester 3) at FPT University. The system supports the full customer shopping flow — browsing, searching, cart management, wishlist, and checkout — alongside a complete admin panel for managing products, users, and invoices.

Watch brands featured: Rolex, Cartier, Patek Philippe, Hublot, Richard Mille, Casio.

---

## ✨ Features

### Customer
- Browse the full watch catalog with brand and type filtering
- Search watches by name, ID, brand, type, or price range
- View detailed watch information page
- Add to cart, update quantities, remove items
- Wishlist management (add, view, remove)
- User registration and login with session management
- Checkout and order placement
- View personal order/invoice history

### Admin
- Product management — add, update, delete watches with images
- User management — view and update user accounts
- Invoice management — view all orders, search by user ID

---

## 🛠️ Tech Stack

| Technology | Details |
|---|---|
| Language | Java (JDK 1.8) |
| Web Layer | JSP / Servlet (Java EE 7) |
| Architecture | MVC (Model-View-Controller) |
| Database | SQL Server (MSSQL) |
| Data Access | JDBC + DAO pattern |
| Frontend | HTML, CSS, JavaScript, Bootstrap 4.5.2 |
| Build Tool | Apache Ant (NetBeans) |
| Server | Apache Tomcat 8.x |

---

## 🏛️ Project Structure

```
FinalProject/
├── src/java/
│   ├── controller/          # 30 Servlet controllers
│   └── sample/
│       ├── product/         # WatchDTO, WatchDAO
│       ├── user/            # UserDTO, UserDAO, UserError
│       ├── invoice/         # InvoiceDTO, InvoiceDAO
│       ├── cart/            # Cart logic
│       ├── wishlist/        # Wishlist logic
│       └── utils/           # Utility helpers
└── web/
    ├── Home.jsp             # Landing page with video background
    ├── shopping.jsp         # Product catalog
    ├── WatchInfo.jsp        # Watch detail page
    ├── viewCart.jsp         # Shopping cart
    ├── CheckOut.jsp         # Checkout page
    ├── ThankYou.jsp         # Order confirmation
    ├── login.jsp            # User login
    ├── Register.jsp         # User registration
    ├── Account.jsp          # User profile
    ├── about.jsp            # About page
    ├── admin.jsp            # Admin dashboard
    ├── ManageWatch.jsp      # Admin — product list
    ├── InsertWatch.jsp      # Admin — add product
    ├── UpdateWatch.jsp      # Admin — edit product
    ├── ManageUser.jsp       # Admin — user list
    ├── ManageInvoice.jsp    # Admin — invoice list
    ├── header.jsp           # Shared header component
    └── css/                 # Per-page stylesheets
```

---

## 📡 Controllers

| Controller | Description |
|---|---|
| `loginController` | User login with session creation |
| `logoutController` | Session invalidation |
| `registerController` | New user registration |
| `UpdateUserController` | User updates own profile |
| `UpdateUserByAdminController` | Admin updates any user account |
| `getAllUserController` | Admin — list all users |
| `getAllWatchController` | Load full product catalog |
| `GetInformationController` | Load single watch detail |
| `SearchController` | General search entry point |
| `SearchWatchByIdOrName` | Search by watch ID or name |
| `SearchWatchByBrand` | Filter by brand |
| `SearchWatchByType` | Filter by type |
| `SearchWatchByPrice` | Filter by price range |
| `AddNewWatchController` | Admin — add new watch |
| `UpdateWatchController` | Admin — update watch |
| `UpdateWatchInfoController` | Admin — update watch details |
| `DeleteWatchController` | Admin — delete watch |
| `AddToCartController` | Add item to session cart |
| `ViewCartController` | View cart contents |
| `UpdateCartController` | Update item quantity in cart |
| `RemoveCartController` | Remove item from cart |
| `CheckOutController` | Process checkout and create invoice |
| `getAllInvoicesController` | Admin — list all invoices |
| `SearchInvoiceByUserID` | Search invoices by user |
| `AddToWishListController` | Add watch to wishlist |
| `InsertWishListController` | Persist wishlist entry |
| `ViewWishListController` | View user wishlist |
| `DeleteWishListController` | Remove item from wishlist |
| `DeleteController` | Generic delete handler |
| `MainController` | Front controller / dispatcher |

---

## 🚀 Getting Started

### Prerequisites

- JDK 1.8
- Apache Tomcat 8.x
- NetBeans IDE (or any IDE with Ant support)
- SQL Server
- `sqljdbc4.jar` driver

### Database Setup

1. Create a new SQL Server database
2. Import the SQL script (if available) or configure the schema manually
3. Update the JDBC connection string in `web/META-INF/context.xml`:

```xml
<Resource name="jdbc/WatchDB"
          auth="Container"
          type="javax.sql.DataSource"
          driverClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver"
          url="jdbc:sqlserver://localhost:1433;databaseName=YOUR_DB_NAME"
          username="YOUR_USERNAME"
          password="YOUR_PASSWORD" />
```

### Build & Run

1. Open the project in NetBeans
2. Add `sqljdbc4.jar` to the project libraries
3. Build using Ant: `ant build`
4. Deploy to Tomcat: `ant deploy`
5. Access at `http://localhost:8080/FinalProject/`

---

## 📚 Course Information

- **Course**: PRJ301 — Java Web Application Development
- **Semester**: Semester 3
- **University**: FPT University
- **Type**: Solo project

---

## 📝 License

Developed for educational purposes as part of the FPT University PRJ301 course.
