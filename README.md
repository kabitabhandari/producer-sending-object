# Spring Boot with Kafka Producer Example

This Project covers how to use Spring Boot with Spring Kafka to Publish JSON/String message to a Kafka topic
## Start Zookeeper
- `bin/zookeeper-server-start.sh config/zookeeper.properties `

## Start Kafka Server
- `bin/kafka-server-start.sh config/server.properties `

## Create Kafka Topic {One time work!}
- `bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic blacktea `
- `bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic milktea `
- `bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic greentea `

## Consume from the Kafka Topic via Console
- `bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic blacktea --from-beginning ` 
- `bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic milktea --from-beginning `
- `bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic greentea --from-beginning `

## Publish message via Postman
- `http://localhost:8082/producer/string/{name} `
- `http://localhost:8082/producer/json/userdetails `
- `http://localhost:8082/producer/json/employeedetails `

## delete topic:
- `./bin/kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic blacktea `

## see list of all topics
- `./bin/kafka-topics.sh --bootstrap-server=localhost:9092 --list `