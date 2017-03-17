# accelerometer-rest-to-cassandra

REST API receiving accelorometers data and storing them into Cassandra. Each acceleration contains:
* date when it has been captured as a timestamp (eg, 1428773040488)
* acceleration force along the x axis (unit is m/s²) 
* acceleration force along the y axis (unit is m/s²)
* acceleration force along the z axis (unit is m/s²) 

## Prerequisites
* Cassandra [3.10 installed](http://www.apache.org/dyn/closer.lua/cassandra/3.10/apache-cassandra-3.10-bin.tar.gz) 
* Java 8+
* Gradle 3.4+

## Start Cassandra 
First step is to start Cassandra:
```sudo sh /bin/cassandra```

We don't need any specific configuration, so Cassandra can be started using the default configuration.
Cassandra will listen on `http://localhost:9042`

Next step is to start the console to use CQL:
```sudo sh /bin/cqlsh```

Then now you can execute the command listed in the project `data.cql`

## Start the application
`gradle build && java -jar build/libs/accelerometer-rest-to-cassandra-1.0.jar`

## Use the API
##### /POST http://localhost:8080/activity/acceleration
* Header `Content-Type` must be set: application/json
* body: 
```
{
  "timestamp": 1428773040488,
  "x": 0.98,
  "y": 6.43,
  "z": 9.01,
}
```
* returned status: 201 CREATED


##### /GET http://localhost:8080/activity/acceleration
* return the last prediction result


##### /POST http://localhost:8080/activity/training
* Header `Content-Type` must be set: application/json
* body: 
```
{
  "user_id": "user1",
  "activity": "walking",
  "timestamp": 1428773040488,
  "x": 0.98,
  "y": 6.43,
  "z": 9.01,
}
```
* returned status: 201 CREATED
