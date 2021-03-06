
1. Install cassandra locally on docker.
2. Create simple REST API Java spring boot application
3. App should provide endpoints: 

    - POST /api/message
    - POST /api/send              e.g.     curl -X POST localhost:8080/api/send -d ‘{“magic_number”:101}’
    - GET /api/messages/{emailValue} <-- Pagination - should return all messages with given email

4. App usage examples
 
    ```
    curl -X POST localhost:8080/api/message -d ‘{“email”:“jan.kowalski@example.com”,“title”:“Interview”,“content”:“simple text”,“magic_number”:101}’
    curl -X POST localhost:8080/api/message -d ‘{“email”:“jan.kowalski@example.com”,“title”:“Interview 2”,“content”:“simple text 2”,“magic_number”:22}’
    curl -X POST localhost:8080/api/message -d ‘{“email”:“anna.zajkowska@example.com”,“title”:“Interview 3",“content”:“simple text 3",“magic_number”:101}’
        
    The App should store all 3 messages into cassandra.
    
    curl -X POST localhost:8080/api/send -d ‘{“magic_number”:101}’
    
        The App should send all messages with given magic_number and delete them from database.
        In our example there will be two email messages:
        - one to jan.kowalski@example.com with title “Interview”, email text “simple text”
        - second to “anna.zajkowska@example.com” with title “Interview 3", email text “simple text 3”
    ```

5. The App should delete automatically messages older than 5 min from DB
6. Install docker locally
7. Create Dockerfile for this App
8. Build Docker image with App (when we run docker image, docker should start The App)