# Getting Started

### Reference Documentation

This project for me improve my coding skills

- check comment TO-LEARN for my notes:
  - Example: // TO-LEARN:

### Version 1.0.0

- Build services
  - Happy service
  - Authorization server

#### User Flow

- User Register
- User Login
  - AuthenticationManager for authenticate User
- User access to Admin, Manager controller
  - userDetails.getAuthorities() -> Get Authorities
  - Set token for `SecurityContextHolder.getContext()`

#### Key learning

- Interface UserDetails: provides necessary information about a user that Spring Security needs for authentication.
  - Ex: SecurityBeanConfiguration.java
- Authenticate: Using AuthenticationManager class for query db to check user existing in service
  - Ex: LoginController.java
- Authorization: Using `SecurityContextHolder.getContext().setAuthentication(authToken)` to set Role for User all
  Application
  - Ex: JwtAuthenticationFilter.java

- Spring Security Context:
  - @EnableWebSecurity in SecurityConfiguration
  - AuthenticationProvider, AuthenticationManager, UserDetailsService, UsernamePasswordAuthenticationToken

