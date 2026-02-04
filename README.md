# Investment Portfolio API

Backend API untuk menghitung ringkasan portofolio investasi berdasarkan **unit price harian** dan **transaksi pembelian**.

Project ini dibuat menggunakan **Spring Boot** dan **PostgreSQL** sebagai bagian dari simulasi / technical test backend.

---

## Tech Stack

- Java 25
- Spring Boot
- Spring Data JPA (Hibernate)
- PostgreSQL with Docker
- Gradle
- Lombok


### Running the Application  :
1. run docker-compose up --build
2. run gradle wrapper/app
3. http://localhost:8080/api/portfolio
4. modified data di data.sql

Expected Deliverables
{
    "totalUnits": 100.8750,
    "currentNav": 1500.00,
    "currentBalance": 151312.50,
    "totalInvested": 148035.00,
    "totalReturn": 3277.50
}
