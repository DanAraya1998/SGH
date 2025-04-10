# 🏥 Hospital Management System (HMS)

This is a desktop application developed in **Java** using **Swing** and **MySQL**, designed to manage a hospital's core operations. It provides user-friendly interfaces to handle patients, doctors, surgeries, and surgery types efficiently.

## ✨ Features

- 🔐 **User Authentication**: Login and registration system with password encryption.
- 👨‍⚕️ **Doctor Management**: Register, search, update, and delete doctor records including specialties and work shifts.
- 🧍 **Patient Management**: Complete CRUD operations for patients with age, weight, and height data.
- 🗓️ **Surgery Scheduling**: Schedule surgeries assigning patient, doctor, type, and duration.
- 🧪 **Surgery Types**: Manage and filter surgery types by specialty.
- 🗃️ **Database Integration**: Seamless connection to MySQL using JDBC.

## 🧰 Technologies Used

- Java SE (Swing for GUI)
- JDBC for database communication
- MySQL
- NetBeans (recommended, due to `.form` files)

## 📁 Project Structure

| File | Description |
|------|-------------|
| `FormHospital.java` | Main window with tabs for managing patients, doctors, surgeries, and specialties. |
| `PanelEntrada.java` | Login window. |
| `PanelRegistro.java` | User registration interface. |
| `Cirugia.java`, `Paciente.java`, `Doctor.java`, `tiposCirugia.java` | Logic and database access classes for CRUD operations. |
| `Conexion.java` | Handles MySQL database connection. |
| `Persona.java` | Abstract base class for `Doctor` and `Paciente`. |

## 🛠️ Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/hospital-management-system.git
cd hospital-management-system
```

### 2. Requirements
- Java JDK 8 or higher
- MySQL Server running
- NetBeans IDE or any Java IDE with Swing support

### 3. Database Setup 🧱

1. Open MySQL Workbench or your preferred SQL client.
2. Run the HospitalSGH script. It has some preloaded information, so You can test the functions freely. 
### 4. Configure Database Credentials 🔧

Edit the `Conexion.java` file to match your MySQL credentials:
```java
this.url = "jdbc:mysql://localhost:3306/";
this.db = "HospitalSGH";
this.user = "your_mysql_user";
this.password = "your_mysql_password";
```

💡 Default values used:
- User: `root`
- Password: `mysql_2025`
- DB: `HospitalSGH`

### 5. Run the Project
- Open the project in NetBeans.
- Build and run the project.
- Use `PanelEntrada` to login or register a new user.

## 🖼️ Screenshots

> Add some GUI screenshots here to show how it works

## 🤝 Contributing

Pull requests are welcome! If you find any bugs or have suggestions for improvement, feel free to open an issue.

## 📜 License

This project is licensed under the **MIT License**.

---

Enjoy coding and improving hospital management! 🩺💻
