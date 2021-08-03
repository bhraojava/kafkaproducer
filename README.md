# kafkaproducer

How to Run Steps:
clone the kafkaproducer and kafkaconsumer projects into the local machine.
install docker into the machine if not and then make sure it is up and running.
open command prompt and then go to the project root folder i.e "kafkaproducer" and then run command "docker-compose up" make sure it is up and running.
open another command prompt and then go to project root folder i.e "kafkaconsumer" and then run command "mvn clean install" and make sure it is up and running. 
open another command prompt and then go to the project root folder i.e "kafkaproducer" and then run command "mvn clean install" but before running this command make sure kafkaconsumer is up and running.
observe the producer and consumer logs inside respective producer and consumer command prompts  where under producer command prompt you can observe lat and longs being sent and under consumer command prompt you will observe the total time and distance.
