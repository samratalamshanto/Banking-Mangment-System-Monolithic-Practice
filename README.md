# Banking-System-Monolithic-Practice

Transaction management is crucial in scenarios like online banking transfers, where multiple database operations must be executed as a single unit of work. It ensures that database changes are either fully applied or rolled back, preventing data corruption and maintaining data integrity. Without transaction management, database operations could lead to inconsistent and unreliable application behavior.

## Framework Details:
1. Spring Boot (3.3.2)
2. Java (21)
3. Spring Security
4. PostgreSQL
5. Kafka

## Key Points:
1. Jwt Based Spring Security Implementation
2. Transactions are implemented using different isolation levels based on use cases.
3. Notifications are sent using Kafka.
4. AOP based Logging
5. Global Exception Handling
