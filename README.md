# Front end interface for Trail Query

### Instructions to setup Parliament Server

This project requires that you run a local instance of a Parliament Server. Parliamment can be downloaded [here](http://parliament.semwebcentral.org/). Parliament stores the RDF data for this projet. The query interface application sends SPARQL queries to the SPARQL endpoint in Paliamnet located at: http://localhost:8089/parliament/sparql. This is set at port 8089 in the code. You must set your local instance of Parliament at port **8089**. 

This project uses 2 datasets:

1. GeoHive Municipal District [dataset](http://data.geohive.ie/downloadAndQuery.html)
2. Sport Ireland Trails [dataset](https://data.gov.ie/dataset/sport-ireland-trails) (originally stored as CSV and converted to turtle RDF)

These datasets can be found in the [data folder](https://github.com/ammarqureshi/Trail-Front-End-Interface/tree/master/spring-boot-web-jsp/data) of this repository. Download the datasets and upload them to your local Parliament server. **Important!** After uploading the datasets to Parliament, go to the Indexes tab and click *Create All*. This will create the geospatial indexes for the data. This is needed as we are using GeoSPARQL functions in the SPARQL queries.


### Instructions to query interface

This project requires Maven. To run the project do the following: 

```
mvn clean package
```

```
java -jar target/spring-boot-web-jsp-1.0.war
```
go to ```http://localhost:8080/query``` to begin querying
