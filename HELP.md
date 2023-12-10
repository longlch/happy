# Getting Started

### Reference Documentation

This project for me improve my coding skills

- check comment TO-LEARN for my notes:
  - Example: // TO-LEARN:

### Version 1.0.0

- Build services
  - Happy service
  - Authorization server

#### Key learning

- UserDetails: interface provides necessary information about a user that Spring Security needs for authentication.
- Authenticate: Using AuthenticationManager class for query db to check user existing in service
- Authorization: Using `SecurityContextHolder.getContext().setAuthentication(authToken)` to set Role for User all
  Application

