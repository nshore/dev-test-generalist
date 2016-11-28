#Instruction to set up Nick Shore Bike API Service

Follow instructions as per README_original.MD to get Docker running with a Mongo DB container and test data.  The application requires Docker running on ip address 192.168.99.100 and the port 27017.

##Additional

For my dev environment I had to install Docker Toolbox as Docker requires WIndows 10+ and I had a dev environment running Windows 7.  Below are the additional steps I had to take to get Docker Toolbox running on Windows 7.

Make sure the Mongo container is running as a service with the following command.
```
docker start jlmongo
```

Confirm it is running
```
docker ps
```

Enter the container for MongoDB
```
docker exec -it jlmongo bash
```

Copy conf file
```
cp /etc/mongod.conf.original /etc/mongod.conf
```

Add editor to container
```
apt-get update
apt-get install vim
```

Edit conf file
```
Add 0.0.0.0
```

Get docker ip to check it is running at ip address 192.168.99.100
```
docker-machine ls
```

To connect to the mongodb container use the docker-machine ip address and port 27017

Note - if you restart the docker service you will need to run the following command to start the mongdb container
```
docker start jlmongo
```

##Testing API - TWO Options

###1. Easy Option - Run Jar from the command line

Pull down the jar file for the Spring Boot to a local folder located "/bike-app/target/bike-rest-service-1.0.0.jar" in the Git Repository.  Open a command line at this location and run the following command:
```
java -Dserver.port=8081 -jar bike-rest-service-1.0.0.jar
```

This will run the application on port 8081 and will allow you to execute the API calls that are detailed in the Postman Commands section below. 


###2. Less Easy Option - Set up IntelliJ IDE

##IDE Set up
- Install/Open IntelliJ community for the IDE (free).

- Make sure you have Java JDK 8 installed for dev environment.  You may need to specify your SDK in IntelliJ.

- Import Project.  The location of the project is "/bike-app" in the Git Repository

- Once the project is imported to IntelliJ you will need to configure your run settings.

```
Click Run -> Edit Configuration -> Add new Maven profile -> 

Name: BikeApp
Working Directory: {project path}/bike-app
Command Line: spring-boot:run -Drun.jvmArguments='-Dserver.port=8081'
```

This will then run the spring boot app using port 8081.

##Testing API
###Postman Commands

Get all Bikes from database
```
Method: GET
URL: http://localhost:8081/getAllBikes
```

Get bike by Bike id (Note Bike id is part of url and must be an integer)
```
Method: GET
URL: http://localhost:8081/getBikeById/{Bike Id} e.g. http://localhost:8081/getBikeById/4
```

Create a new Bike 
Parameters required are bikeName, bikeDescription, bikePrice.  String values expected for all.
```
Method: POST
URL example: http://localhost:8081/createBike?bikeName='chopper'&bikeDescription='Old school bike my Dad use to have'&bikePrice='500'
```


##What Else??

There were quite a few things that I would have liked to have done given more time but I wanted to time box myself as per instructions to see what I could deliver.

1.  Ideally I would have approached this using TDD and written tests before building the functionality.  However, I wanted to focus on fulfilling the user stories in the required time.
2.  My Spring Boot application needs refinement.  I included redundant classes so you could see my approach.  I was planning on using a Bike Domain to handle the data back from the DB calls and then present this back to the controller.  But that was more for future enhanced functionality and didnt prevent the json being output.
3.  As this is a role focusing on frontend skills it would have been good to have built the view elements and provided an interface to communicate with the API.
4.  I researched putting my Spring Boot Jar file into a docker container which is achievable in my Maven build but I did not have time to do this.






