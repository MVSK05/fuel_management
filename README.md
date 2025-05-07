# Fuel Management System
### **Fuel Station Management System — Project Description**

The **Fuel Station Management System** is a console-based Java application designed to efficiently manage the core operations of a fuel station. Built using the **Model-View-Controller (MVC)** architecture, this system ensures a modular structure that enhances maintainability, scalability, and separation of concerns. The backend uses **SQLite** for lightweight, fast, and embedded database management.

---

### **Core Features**

1. **Fuel Inventory Management**

   * Tracks fuel stock (Petrol, Diesel, etc.).
   * Alerts when fuel stock drops below minimum levels.
   * Allows station admin to refill stock.

2. **Sales Management**

   * Records every fuel sale with details like fuel type, quantity, amount, and date.
   * Auto-updates inventory after every sale.
   * Generates daily, weekly, or monthly sales summaries.

3. **Employee/User Management**

   * Login authentication for operators/admins.
   * Different access roles (admin vs operator).
   * Records operator activities for accountability.

4. **Customer Interaction**

   * Generates bill receipt after fuel filling.
   * Optionally stores vehicle numbers or phone numbers for future offers or analytics.

5. **Reports and Analytics**

   * Fuel consumption statistics.
   * Revenue generated over time.
   * Stock refill history and alerts.

---

### 🛠️ **Technology Stack**

* **Programming Language:** Java
* **Database:** SQLite
* **Architecture:** Model-View-Controller (MVC)
* **IDE:** VS Code
* **Version Control:** GitHub

---

###  **Architecture Overview**

* **Model**: Handles all database interactions (CRUD for fuel, sales, users, etc.)
* **View**: Console-based user interface for input/output operations.
* **Controller**: Manages user commands, links view to the model, and implements business logic.

---

### **Security Considerations**

* Password hashing for user login.
* Role-based access control (Admin/Operator).
* Data validation for inputs to avoid SQL injection.

---

### **Use Cases**

* Fuel Station owners to track inventory and sales.
* Operators to manage daily fueling tasks.
* Admins to analyze fuel station performance.

---

