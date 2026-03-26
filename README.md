# SmartFacility Backend

Das SmartFacility Backend ist eine REST-API für eine Facility-Management-Anwendung.
Es ermöglicht die Registrierung von Benutzern sowie die Verwaltung von Gebäuden und Räumen.

Das Projekt wurde mit **Java 17** und **Spring Boot** entwickelt und demonstriert typische Backend-Konzepte wie:

* REST API Design
* Controller / Service / Repository Architektur
* DTOs für Request- und Response-Verarbeitung
* Validierung mit Jakarta Validation
* Persistenz mit Spring Data JPA
* PostgreSQL-Anbindung
* API-Dokumentation mit Swagger / OpenAPI

## Features

* Benutzer registrieren und einloggen
* Gebäude erstellen, abrufen, aktualisieren und löschen
* Räume innerhalb eines Gebäudes verwalten
* Alle Räume eines Gebäudes abrufen
* Validierung von Eingabedaten
* Swagger UI zum Testen der API

## Tech Stack

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Validation
* PostgreSQL
* Maven
* Docker
* Swagger / OpenAPI

## Projektstruktur

```text
src/main/java/de/artur/smartfacility
├── building
│   ├── api
│   ├── dto
│   ├── entity
│   ├── repository
│   └── service
├── room
│   ├── api
│   ├── dto
│   ├── entity
│   ├── repository
│   └── service
├── user
│   ├── api
│   ├── dto
│   ├── entity
│   ├── repository
│   └── service
├── config
├── exception
├── HealthController.java
└── SmartfacilityApplication.java
```

## Voraussetzungen

Bevor du die Anwendung startest, benötigst du:

* Java 17
* Maven
* PostgreSQL
* (optional) Docker

## Konfiguration

Die Anwendung verwendet Umgebungsvariablen für die Datenbankverbindung.

Beispiel:

```bash
DB_URL=jdbc:postgresql://localhost:5432/smart_facility
DB_USER=your_db_user
DB_PASSWORD=your_db_password
```

## Anwendung starten

### 1. PostgreSQL starten

Du kannst PostgreSQL lokal oder per Docker starten:

```bash
docker run --name smartfacility-db \
  -e POSTGRES_DB=smart_facility \
  -e POSTGRES_USER=your_db_user \
  -e POSTGRES_PASSWORD=your_db_password \
  -p 5432:5432 \
  -d postgres:latest
```

### 2. Umgebungsvariablen setzen

Stelle sicher, dass `DB_URL`, `DB_USER` und `DB_PASSWORD` gesetzt sind.

### 3. Anwendung starten

```bash
./mvnw spring-boot:run
```

## API-Dokumentation

Nach dem Start ist die Swagger UI erreichbar unter:

```
http://localhost:8080/swagger-ui/index.html
```

## Beispiel-Endpunkte

### Auth

* `POST /auth/register`
* `POST /auth/login`
* `DELETE /auth/{id}`

### Buildings

* `POST /buildings/users/{userId}`
* `GET /buildings`
* `GET /buildings/{id}`
* `PUT /buildings/{id}`
* `DELETE /buildings/{id}`

### Rooms

* `POST /buildings/{buildingId}/rooms`
* `GET /buildings/{buildingId}/rooms`
* `GET /rooms`
* `GET /rooms/{id}`
* `PUT /rooms/{id}`
* `DELETE /rooms/{id}`

## Beispiel-Requests

### Benutzer registrieren

```json
{
  "username": "Artur",
  "email": "artur@example.com",
  "password": "secret123"
}
```

### Gebäude anlegen

```json
{
  "name": "Hauptgebäude",
  "address": "Musterstraße 1, Berlin"
}
```

### Raum anlegen

```json
{
  "name": "Konferenzraum A",
  "floor": "2",
  "size": 35.5
}
```

## Hinweise

* Die Datenbankverbindung wird über Umgebungsvariablen konfiguriert.
* Hibernate ist aktuell auf `ddl-auto: update` gesetzt.
* Swagger eignet sich gut zum Testen der API während der Entwicklung.

## Lernziele

Dieses Projekt wurde entwickelt, um praktische Erfahrung mit modernen Java-Backend-Technologien zu sammeln, insbesondere mit:

* Spring Boot
* REST API Entwicklung
* Datenmodellierung mit JPA
* Validierung und Fehlerbehandlung
* sauberer Backend-Architektur

## Zukünftige Erweiterungen

Mögliche nächste Schritte:

* Implementierung von JWT-Authentifizierung
* Rollen und Berechtigungen
* Unit- und Integrationstests
* Docker Compose Setup
* Deployment (z. B. Render oder Railway)
