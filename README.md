# Spring Boot with Kafka Producer Example
control center: http://localhost:9021

This Project covers how to use Spring Boot with Spring Kafka to Publish JSON/String message to a Kafka topic
#### Confluent Start/Stop:
     confluent local services start
     confluent local services stop

#### List all available services or status:
    confluent local services list
    confluent local services status

#### Check if specific service  is UP in confluent:
    confluent local services kafka status
    confluent local services kafka start
    confluent local services kafka stop
 
#### Create topics with default options at specified cluster(providing Kafka REST Proxy endpoint)
    kafka-topics --create --topic topic1 --bootstrap-server localhost:9092
    kafka-topics --create --topic topic2 --bootstrap-server localhost:9092
    kafka-topics --create --topic topic3 --partitions 2 --replication-factor 2 --bootstrap-server localhost:9092

#### List all topics.
    kafka-topics --list --bootstrap-server localhost:9092

#### Describe a topic. This shows partitions, replication factor, and in-sync replicas for the topic.
    kafka-topics --describe --topic topic1 --bootstrap-server localhost:9092
_note: If you run kafka-topics --describe with no specified topic, you get a detailed description of every topic on the cluster (system and user topics)._

#### Delete a topic.
    kafka-topics --delete --topic topic1 --bootstrap-server localhost:9092

#### Run a Producer to produce to topic <topic-name>
    kafka-console-producer --topic topic1 --bootstrap-server localhost:9092
######Send some messages.

- ######Type your messages at the prompt (>), and hit Return after each one.
- ######Your command window will resemble the following:
    >hi cool topic
  
    >did you get this message?
  
    >first
  
    >second
  
    >third
  
    >yes! I love you cool topic


- ######In the other command window, run a consumer to read messages from cool-topic. Specify that you want to start consuming from the beginning, as shown.
    kafka-console-consumer --topic topic1 --from-beginning --bootstrap-server localhost:9092

- ######Your output will resemble the following:

    >hi cool topic on origin cluster

    >is this getting to your replica?

    >first

    >second

    >third

    >yes! I love you cool topic
    
