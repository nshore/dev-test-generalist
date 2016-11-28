Follow instructions as per README_original.MD


Additional

Docker toolbox installed as Docker requires WIndows 10 +


#B. start the Mongo container as a service
docker run -d --name jlmongo -p 27017:27017 jujhars13/dev-test-generalist-mongo:latest

#B. Enter the container for MongoDB
docker exec -it jlmongo bash

#B. copy conf file
cp /etc/mongod.conf.original /etc/mongod.conf

#B. addeditor to container
apt-get update
apt-get install vim

#B. edit conf file
Add 0.0.0.0

#B. get docker ip
docker-machine ls

To connect to the mongodb container use the docker-machine ip address and the port 27017

#B. Note - if you restart the docker service will need to run the following command to start the mongdb container
docker start jlmongo


#B. IDE Set up
IntelliJ community for the IDE.  Location of download.

#B. Make sure you have Java JDK 8 installed for dev environment.  You may need to specify your SDK in IntelliJ.

#B. Once the project is imported to IntelliJ you will need to configure your run settings.
Click Run -> Edit Configuration -> Add new Maven profile ->

Name: BikeApp
Working Directory: C:/Personal/dev/bike_project/bike-app
Command Line: spring-boot:run


Curl/Postman Commands

#B. Get all Bikes from database
http://localhost:8081/getAllBikes


#B. Get bike by Bike id (Note Bike id is part of url and must be an integer)
http://localhost:8081/getBikeById/{Bike Id} e.g. http://localhost:8081/getBikeById/4


#B. Create a new Bike (POST method only)
Parameter required are bikeName, bikeDescription, bikePrice.  String values expected.
http://localhost:8081/createBike?bikeName="chopper"&bikeDescription="Old school bike my Dad use to have"&bikePrice="500"

### OPTION 2 - Run from the command line (Property in square brackets is optional, default is port 8080)
java [-Dserver.port=8081] -jar bike-rest-service-1.0.0.jar 





