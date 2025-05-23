# poc-ncpdp-parser-java

This project is a Java 21 application managed with Gradle.

## Purpose

The purpose of this project is to implement a NCPDP Telecommunication Standard (NCPDP) parser.
The parser should be able to read and parse NCPDP files, extract relevant data, and provide methods to access the parsed information.
The NCPDP standard is a set of guidelines for electronic healthcare transactions, and the parser should be able to handle the D0 version of the standard.

## Getting Started

- To build the project: `./gradlew build`
- To run tests: `./gradlew test`

## Project Structure
- `src/main/java` - Main Java source code
- `src/test/java` - Unit tests

## Using the Parser

The main entry point for interacting with this library is the `Parser` class. The `Parser` provides methods to parse a raw NCPDP Transmission and return structured Java objects representing the contents of those files. Depending on your needs, you can choose to work with either the domain model objects (`Request`, `Response`) or their corresponding Data Transfer Objects (`RequestDTO`, `ResponseDTO`).

### Four Ways to Parse

- **Request**:  
  Use `Parser.parseRequest(String rawContent)` to parse a request file and get a `Request` object, which provides access to the header, transmission group, and transaction groups.

- **Response**:  
  Use `Parser.parseResponse(String rawContent)` to parse a response file and get a `Response` object, which provides access to the header, transmission group, and transaction groups.

- **RequestDTO**:  
  Use `Parser.parseRequestIntoDTO(String rawContent)` to parse a request file and get a `RequestDTO` object, which is a simplified, serializable representation suitable for APIs or external systems.

- **ResponseDTO**:  
  Use `Parser.parseResponseIntoDTO(String rawContent)` to parse a response file and get a `ResponseDTO` object, which is a simplified, serializable representation suitable for APIs or external systems.
