# Banking-System-Monolithic-Practice

Transaction management is crucial in scenarios like online banking transfers, where multiple database operations must be executed as a single unit of work. It ensures that database changes are either fully applied or rolled back, preventing data corruption and maintaining data integrity. Without transaction management, database operations could lead to inconsistent and unreliable application behavior.

1. User Registration and Account Creation
Allow users to register for an account by providing their name, email, address, and other necessary details. Upon successful registration, an associated account with a unique account number and balance will be created for the user.

2. User Authentication with JWT
Secure user authentication using JSON Web Tokens (JWT). Users can log in with their account number and password, and upon successful login, they will receive a JWT token to authenticate future API requests.

3. Cash Deposit
Allow users to deposit money into their accounts securely. The API will update the account balance and record the transaction history.

4. Cash Withdrawal
Enable users to withdraw money from their accounts, ensuring sufficient balance and updating the account balance and transaction history accordingly.

5. Fund Transfer
Facilitate fund transfers between accounts. Users can transfer money from their accounts to other accounts securely, updating account balances, and recording transaction histories for both sender and receiver.

6. Error Handling
Implement custom exception handling to gracefully manage various error scenarios, providing appropriate HTTP status codes and error messages to clients.

7. Token-Based Authorization
Token-based authorization using JWT ensures secure communication between the client and the server, preventing unauthorized access to sensitive operations.

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

## Sample Postman Request & Response:

1. Withdraw:
Request Body:
```json
{
    "transactionType": "Withdraw",
    "amount": 1000.0,
    "accountNumberFrom": "A-0000000002"
}
```
Response Body:
```json
{
    "code": 400,
    "success": false,
    "message": "Insufficient Balance",
    "data": null
}
```

