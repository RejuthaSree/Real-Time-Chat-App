# 💬 Real-Time Chat Application

A full-stack real-time chat application built using **Spring Boot**, **WebSockets (STOMP, SockJS)**, **PostgreSQL**, and **Docker**, enabling scalable and persistent real-time communication.

---

## 🚀 Features

* 🔴 Real-time messaging(no page refresh)
* 👥 Multiple users chatting simultaneously
* 💾 Persistent message storage using PostgreSQL
* ⏱️ Timestamp for each message
* 📜 Auto-scrolling chat UI
* 🐳 Containerized using Docker
* 🔌 WebSocket-based communication

---

## 🛠️ Tech Stack

**Backend:**

* Java
* Spring Boot
* WebSockets (STOMP, SockJS)
* PostgreSQL

**Frontend:**

* HTML
* CSS
* Bootstrap
* JavaScript

**DevOps:**

* Docker

---

## ⚙️ How It Works

1. Client connects using **SockJS**
2. STOMP protocol manages messaging
3. Messages sent to:

   ```
   /app/sendMessage
   ```
4. Backend processes and stores in PostgreSQL
5. Server broadcasts to:

   ```
   /topics/messages
   ```
6. All clients receive messages instantly

---

## 🗄️ Database Configuration

```id="1v8o7r"
spring.datasource.url=jdbc:postgresql://localhost:5432/chatdb
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
```

---

## 📂 Project Structure

```id="4nyy39"
src/
 ├── main/
 │   ├── java/com/chat/app/
 │   │   ├── config/
 │   │   ├── controller/
 │   │   ├── model/
 │   │   ├── repository/
 │   │   └── service/
 │   └── resources/
 │       ├── templates/
 │       └── application.properties
```

---

## ▶️ Run Locally (Without Docker)

1. Start PostgreSQL
2. Create DB:

   ```
   chatdb
   ```

4. Open:

   ```
   http://localhost:8080/chat
   ```

---

## 🔮 Future Improvements

* 🔐 Authentication (JWT)
* ☁️ Cloud deployment (AWS/Render)
* ⚙️ CI/CD using GitHub Actions
* 📱 Mobile responsive UI

---

## 👩‍💻 Author

**Rejuthasree M**

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!
