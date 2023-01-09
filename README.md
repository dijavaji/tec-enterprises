"# tec-enterprises"

# Technical Interview Proposal

This is my solution for Technical Interview Proposal Here's an overview of the application structure:

## Problem Description
What Needs to Be Evaluated
Mandatory
1.Create a screen that allows companies to be listed.
2.Create a screen to create companies.
3.Create a screen to edit the companies.
4.Create a screen that allows you to list the departments.
5.Create a screen to create departments.
6.Create a screen to edit the departments.
7.Create a screen that allows you to list the employees.
8.Create a screen to create employees.
9.Create a screen to edit the employees.
10.Create an installation guide to get the application up and running.
11.Source code for review.
12.Access to the code versioning repository.
13.Document with images with evidence of the application
Optional
Unit test backend.
Unit test frontend.
Session handling.
Role management.
Acceptance criteria
Code quality.
Code complexity.
Handling tools.
Use of technologie

## Solution Overview
For development used the following technologies.
Development Ide
Spring Tool Suite and Sublime Text
Source control
• GIT
Database
• MySQL
Backend
•Java
o Spring boot
Frontend
Angular 7
Methodology
• Scrum


The tec-enterprises solution contains a two project:
tec-enterprise-app
Is the frontend project this project contains efficient and sophisticated single-page apps

tec-enterprise-ws
Is the backend project this project contains all the classes which are used to manipulate the logic business of application, necessary data model and components the rest-api type.

## Available Scripts

In the project directory tec-enterprise-ws , you can run:

## Development server

### `mvn clean install`

Builds the app for production to the `target` folder.\
It correctly bundles jar in production mode and optimizes the build for the best performance.

### `mvn spring-boot:run`
Run Spring Boot applications Navigate to `http://127.0.0.1:8080/`. You have the nexts apis built for creating, retrieving, updating, deleting and searching enterprises, employees and departments.
`http://127.0.0.1:8080/api/enterprises/`
`http://127.0.0.1:8080/api/employees/`
`http://127.0.0.1:8080/api/departments/`

### `mvn test`

### `mvn -q test`

Launches the test runner in the interactive watch mode.\

Test input:


In the project directory tec-enterprise-app , you can run:

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

