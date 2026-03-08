# SmartFacility Backend
SmartFacility ist eine REST API zur Verwaltung von Gebäuden und Räumen innerhalb einer Facility-Management Anwendung.
Das Backend wurde mit Spring Boot entwickelt und stellt APIs bereit, über die Gebäude erstellt, verwaltet und Räume innerhalb eines Gebäudes organisiert werden können.
## Tech Stack
- Java 17
- Docker
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Swagger
## Features
- Gebäude erstellen, bearbeiten und löschen
- Räume innerhalb von Gebäuden verwalten
- REST API Architektur
- DTOs
- Swagger
## Projektstruktur
- Controller
- Service
- Repository
- Entity
- DTO
## Anwendung starten
- 1.PostgreSQL (Docker Container) starten
###  2. Environment Variables setzen
Das Projekt verwendet PostgreSQL in einem Docker Container.
Beispiel:
- DB_URL = jdbc:postgresql://localhost:5432/smart_facility
- DB_USER = your_db_user
- DB_PASSWORD = your_db_password
### 3. Anwendung starten:
- ./mvwn spring-boot:run
### 4. API Dokumentation (Swagger)
- Nach dem Start der Anwendung ist Swagger verfügbar unter:
- http://localhost:8080/swagger-ui/index.html
