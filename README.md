# spabbit
Spring Rabbit Demo Project
1. Run container my-rabbit
docker-compose up my-rabbit
    
2. Create exchange on http://localhost:15672/#/exchanges
Name: jsa.exchange
Type: direct
Durability: Durable
   
3. Create que on http://localhost:15672/#/queues
Name: jsa.queue
Durability: Transient
    
4. Run container producer
docker-compose up producer
    
5. Run container consumer
docker-compose up consumer
    
6. Send message
curl -v --header "Content-Type: application/json" --header "Accept: */*" "http://127.0.0.1:8080/events" -d '{"name":"Apple","products":[{"name":"Iphone 7"},{"name":"IPadPro"}]}'
