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


IDE Set up
IntelliJ community for the IDE.  Location of download.

Make sure you have Java JDK 8 installed for dev environment.  You may need to specify your SDK in IntelliJ.

Once the project is imported to IntelliJ you will need to configure your run settings.
Click Run -> Edit Configuration -> Add new Maven profile ->

Name: BikeApp
Working Directory: C:/Personal/dev/bike_project/bike-app
Command Line: spring-boot:run





