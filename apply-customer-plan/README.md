# Order Service SaaS

This project demonstrates a Spring Boot application that uses Aspect-Oriented Programming (AOP) to implement feature checks based on user subscription plans. It includes the following components:
- Order Service
- Feature Check Aspect
- Feature Access Service
- Plan Configuration
- Logging

## Getting Started

### Prerequisites

- Java 17
- Maven 3.x

### Installing

1. Clone the repository
   ```sh
   git clone https://github.com/yourusername/feature-check-service.git
   cd apply-customer-plan
2. Build the project
   ```sh
   mvn clean install
3. Run the application
   ```sh
   java -javaagent:./lib/spring-instrument-6.0.11.jar -jar ./target/orderservice-0.0.1-SNAPSHOT.jar
