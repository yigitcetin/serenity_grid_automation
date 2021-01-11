# Serenity BDD Automation Test With Zalenium Docker Grid

This project is built with Cucumber, Serenity, Junit and Selenium. Also used Docker and Zalenium for Grid structure

## Setting Up The Environment
All Webdrvers are added to webdriver folder under resources
```
.
├── ...
├── test                   
│   ├── resources 
│       └── webdriver      # webdriver files
└── ...
```
You can change environment url from serenity.conf file
```
.
├── ...
├── test                   
│   ├── resources 
│       └── serenity.conf
└── ...
```

Parallel runs have been implemented with docker container using the Zalenium. Docker & Docker Compose needs to be preinstalled in your machine to run the tests with Zalenium.
Use Docker Info if everything is fine after installation. 
```
docker info
```
To use selenium with Docker. Run below command 
```
docker pull elgalu/selenium
```

Under project folder run this command:
```
docker-compose up --force-recreate
```
To change Docker setttings, you can find compose file under project folder.
```
.
├── src                   
└── docker-compose.yml 
```


## Running the tests

Now, Zalenium grid & Docker is up and ready. When you run ```mvn clean verify``` from the command line, all features will run in parallel separate browsers.
- You can see live stream of the tests while running in chrome and firefox from http://localhost:4444/grid/admin/live
- You can visit Zalenium dashboard http://localhost:4444/dashboard/ to view the test video, logs and results.

You can also run tests without Docker by overriding the driver system property. You just need to change command

With Firefox
```
mvn verify -Dwebdriver.driver=firefox
``` 
With Chrome
```
mvn verify -Dwebdriver.driver=chrome
```

## Reports

Test results will be recorded under ``` target/site/serenity/index.html```.
To see the result, run the below command from root directory after test execution.
``` 
open target/site/serenity/index.html 
```

To stop the grid, you can use below command
``` 
docker stop zalenium
``` 

## Built With

* [Junit](https://junit.org/junit5/) 
* [Maven](https://maven.apache.org/) 
* [Selenium Webdriver](https://www.selenium.dev/) 
* [Cucumber](https://cucumber.io/) 
* [Serenity BDD](http://www.thucydides.info/#/) 
* [Zalenium](https://opensource.zalando.com/zalenium/) 
* [Jackson](https://opensource.zalando.com/zalenium/)

