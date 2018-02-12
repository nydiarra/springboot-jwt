# springboot-jwt
## An Example Spring Boot Application for Securing a REST API with JSON Web Token (JWT)

This application can be used as a seed to quick start your spring boot REST API project with a fully functional security module.

## Main building blocks
 * Spring Boot 1.5.3.RELEASE go to http://docs.spring.io/spring-boot/docs/1.5.3.RELEASE/reference/htmlsingle/ to learn more about spring boot
 * JSON Web Token go to https://jwt.io/ to decode your generated token and learn more
 * H2 Database Engine - used for rapid prototyping and development, but not suitable for production at least in most cases. Go to www.h2database.com to learn more



## To run the application
Use one of the several ways of running a Spring Boot application. Below are just three options:

1. Build using maven goal: `mvn clean package` and execute the resulting artifact as follows `java -jar springboot-jwt-0.0.1-SNAPSHOT.jar` or
2. On Unix/Linux based systems: run `mvn clean package` then run the resulting jar as any other executable `./springboot-jwt-0.0.1-SNAPSHOT.jar`
3. Build and start as a Docker container. Instructions at: [README](src/main/docker/README.md)


## To test the application

 ### First you will need the following basic pieces of information:

 * client: testjwtclientid
 * secret: XY7kmzoNzl100
 * Non-admin username and password: john.doe and jwtpass
 * Admin user: admin.admin and jwtpass
 * Example of resource accessible to all authenticated users:  http://localhost:8080/springjwt/cities
 * Example of resource accessible to only an admin user:  http://localhost:8080/springjwt/users

 1. Generate an access token

   Use the following generic command to generate an access token:
   `$ curl client:secret@localhost:8080/oauth/token -d grant_type=password -d username=user -d password=pwd`

   For this specific application, to generate an access token for the non-admin user john.doe, run:
   `$ curl testjwtclientid:XY7kmzoNzl100@localhost:8080/oauth/token -d grant_type=password -d username=john.doe -d password=jwtpass`
    You'll receive a response similar to below

    `
    {
      "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4uYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNDk0NDU0MjgyLCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIiwiQURNSU5fVVNFUiJdLCJqdGkiOiIwYmQ4ZTQ1MC03ZjVjLTQ5ZjMtOTFmMC01Nzc1YjdiY2MwMGYiLCJjbGllbnRfaWQiOiJ0ZXN0and0Y2xpZW50aWQifQ.rvEAa4dIz8hT8uxzfjkEJKG982Ree5PdUW17KtFyeec",
      "token_type": "bearer",
      "expires_in": 43199,
      "scope": "read write",
      "jti": "0bd8e450-7f5c-49f3-91f0-5775b7bcc00f"
    }`

 2. Use the token to access resources through your RESTful API

    * Access content available to all authenticated users

        Use the generated token  as the value of the Bearer in the Authorization header as follows:
        `curl  http://localhost:8080/springjwt/cities -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4uYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNDk0NDU0MjgyLCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIiwiQURNSU5fVVNFUiJdLCJqdGkiOiIwYmQ4ZTQ1MC03ZjVjLTQ5ZjMtOTFmMC01Nzc1YjdiY2MwMGYiLCJjbGllbnRfaWQiOiJ0ZXN0and0Y2xpZW50aWQifQ.rvEAa4dIz8hT8uxzfjkEJKG982Ree5PdUW17KtFyeec" `

        The response will be:
        `
        [
          {
            "id": 1,
            "name": "Bamako"
          },
          {
            "id": 2,
            "name": "Nonkon"
          },
          {
            "id": 3,
            "name": "Houston"
          },
          {
            "id": 4,
            "name": "Toronto"
          },
          {
            "id": 5,
            "name": "New York"
          },
          {
            "id": 6,
            "name": "Mopti"
          },
          {
            "id": 7,
            "name": "Koulikoro"
          },
          {
            "id": 8,
            "name": "Moscow"
          }
        ]`

    * Access content available only to an admin user

       As with the previous example first generate an access token for the admin user with the credentials provided above then run
           `curl  http://localhost:8080/springjwt/users -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4uYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNDk0NDU0OTIzLCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIiwiQURNSU5fVVNFUiJdLCJqdGkiOiIyMTAzMjRmMS05MTE0LTQ1NGEtODRmMy1hZjUzZmUxNzdjNzIiLCJjbGllbnRfaWQiOiJ0ZXN0and0Y2xpZW50aWQifQ.OuprVlyNnKuLkoQmP8shP38G3Hje91GBhu4E0HD2Fes" `
           The result will be:
           `
           [
             {
               "id": 1,
               "username": "john.doe",
               "firstName": "John",
               "lastName": "Doe",
               "roles": [
                 {
                   "id": 1,
                   "roleName": "STANDARD_USER",
                   "description": "Standard User - Has no admin rights"
                 }
               ]
             },
             {
               "id": 2,
               "username": "admin.admin",
               "firstName": "Admin",
               "lastName": "Admin",
               "roles": [
                 {
                   "id": 1,
                   "roleName": "STANDARD_USER",
                   "description": "Standard User - Has no admin rights"
                 },
                 {
                   "id": 2,
                   "roleName": "ADMIN_USER",
                   "description": "Admin User - Has permission to perform admin tasks"
                 }
               ]
             }
           ]
           `
