# <u>Quora</u>
Quora Backend implemented in ***<u>SpringBoot</u>*** using technologies like:-
1. ***REST Api***
2. ***MVC***
3. ***Spring***
4. ***Hibernate***
5. ***Lombok***
6. ***Inheritance***
7. ***Swagger Documentation***

### <u>Use Case</u>
This backend application enables the user to do the following:-
1. ***User Management*** : Create, Modify & Fetch User
2. ***Question Management*** : Post & Fetch a Question
3. ***Answer Management*** : Search a Question & Answer it.
4. ***Comment Management*** : Comment on an Answer or comment on a comment.
5. ***Like Management*** : Like a Question, Answer or a Comment.
6. ***Topic Management*** : Post some topics or search any topic.
7. ***Follow Management*** : Follow a user.

### <u>User Management</u>
1. Create a user
   1. @PostMapping : "/Quora/v1/users"
   2. Request Body : UUID userId, String username, String emailId & String bio.
   
2. Modify a user
   1. @PutMapping : "/Quora/v1/users/{userId}"
   2. Request Body : UUID userId, String emailId, String bio.

3. Fetch a user
   1. @GetMapping : "/Quora/v1/users/{userId}"

### <u>Question Management</u>
1. Post a Question
   1. @PostMapping : "/Quora/v1/questions"
   2. Request Body : 