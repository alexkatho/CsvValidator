# CSV Validator

Java-basierte Anwendung zur Validierung und Transformation strukturierter CSV-Daten nach konkreten fachlichen Regeln.

## Features
- CSV-Import und -Export mit OpenCSV
- Bean Validation mit Hibernate Validator
- Ignorieren der Startzahl-Spalte bei der Verarbeitung
- Normalisierung numerischer Werte (Entfernung von Tausendertrennzeichen)
- Trennung gültiger und ungültiger Datensätze (invalid.csv)

## Architektur
- Klare Trennung zwischen Reader, Processor und Writer
- Domain-Modell mit Custom Validation Constraints
- Erweiterbar für zusätzliche Validierungsregeln

## Tech Stack
- Java 17
- Maven
- OpenCSV
- Hibernate Validator

## Use Case
Geeignet für Datenimport-Pipelines, ETL-Vorverarbeitung und Datenqualitätsprüfungen in Backend-Systemen.
