# Starting
- It is a use-case of kafka with a simple spring boot app. User registers to user-service, then a message  is sent to the e-mail-service and account service via Kafka.

## Uploading
- Clone the project's GitHub repository;
- mvn install
- run app : mvn spring-boot:run

- user-service will run at default localhost:8081 other will run at random port
- kafka will run at localhost:9092
- kafka-ui will run at localhost:9090


## Dependencies
- Kafka
- Lombok
- Configuration Processor
- Spring Data JPA
- Spring Web
- PostgreSQL

## Licence

[MIT](https://choosealicense.com/licenses/mit/)
