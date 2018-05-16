Copy from https://springframework.guru/spring-boot-web-application-part-6-spring-security-with-dao-authentication-provider/

# My own Re-implemenation at https://github.com/PeaceUCR/SpringBootMySecure

**/domain
https://springframework.guru/solid-principles-object-oriented-programming/


@MappedSuperclass
Designates a class whose mapping information is applied to the entities that inherit from it. A mapped superclass has no separate table defined for it.

https://docs.jboss.org/hibernate/orm/4.0/hem/en-US/html/listeners.html
@PrePersist	Executed before the entity manager persist operation is actually executed or cascaded. This call is synchronous with the persist operation.
@PreUpdate	Executed before the database UPDATE operation.


@Transient
https://stackoverflow.com/questions/2154622/why-does-jpa-have-a-transient-annotation
@Transient is used to annotate field or method that is not mapped to relational database .

@JoinTable
https://stackoverflow.com/questions/5478328/jpa-jointable-annotation
?????




**/repo
By extending CrudRepository, both the repositories inherit several methods for working with entity persistence, including methods for saving, deleting, and finding entities. Spring Data JPA uses generics and reflection to generate the concrete implementations of both the interfaces.


**/services
//use Spring Data JPA to perform CRUD operations on the User and Role entities.

Both RoleService and UserService extends CRUDService that defines the basic CRUD operations on entities. UserService, with the additional findByUsername() method is a more specialized service interface for CRUD operations on User.

implementations can be Spring Data JPA with repository, DAO, or Map patterns, or even plain JDBC, or some external Web service.

auto-wired in UserRepository

@Transactional
method with @Transactional that any failure causes the entire operation to roll back to its previous state, and to re-throw the original exception


**/security
encrypt password and check password

UserDetails
https://docs.spring.io/spring-security/site/docs/4.2.4.RELEASE/apidocs/org/springframework/security/core/userdetails/UserDetails.html
Provides core user information.
Implementations are not used directly by Spring Security for security purposes. They simply store user information which is later encapsulated into Authentication objects. This allows non-security related user information (such as email addresses, telephone numbers etc) to be stored in a convenient location.

 we have defined the fields of our data model and their corresponding setter methods. The SimpleGrantedAuthority we set on Line 16 is a Spring Security implementation of an authority that we will convert from our role. Think of an authority as being a “permission” or a “right” typically expressed as strings.



UserDetailsService
Core interface which loads user-specific data.
It is used throughout the framework as a user DAO and is the strategy used by the DaoAuthenticationProvider.

The interface requires only one read-only method, which simplifies support for new data-access strategies.

UserDetailsService interface to lookup the username, password and GrantedAuthorities for any given user.


But the challenge is that the findByUsername() method of our UserService returns a User entity, while Spring Security expects a UserDetails object from the loadUserByUsername() method.


**/converter

Convert the User to UserDetails

**/config

WebSecurityConfigurerAdapter
WebSecurityConfigurerAdapter to configure two things. An authentication provider and the application routes to protect

The @EnableWebSecurity annotation and WebSecurityConfigurerAdapter work together to provide web based security.
@EnableGlobalMethodSecurity vs @EnableWebSecurity
https://stackoverflow.com/questions/29721098/enableglobalmethodsecurity-vs-enablewebsecurity



@Qualifier
handling multiple autowire candidates


configure(HttpSecurity httpSecurity)
The configure(HttpSecurity) method defines which URL paths should be secured and which should not.


AuthenticationManagerBuilder to add authenticationProvider(custom provider)
The AuthenticationManager is really just a container for authentication providers, giving a consistent interface to them all.
https://stackoverflow.com/questions/9787409/what-is-the-default-authenticationmanager-in-spring-security-how-does-it-authen
https://stackoverflow.com/questions/42316643/spring-security-configureauthenticationmanagerbuilder-auth-vs-authentication



**/handle the event in spring
authentication success event
https://www.tutorialspoint.com/spring/event_handling_in_spring.htm

**/get current user after authentication/login
https://stackoverflow.com/questions/31159075/how-to-find-out-the-currently-logged-in-user-in-spring-boot


**/remember me
can be add in the configure(HttpSecurity httpSecurity) pending????
