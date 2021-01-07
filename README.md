# Project 1
Scala-Hadoop application to answer interesting questions about large datasets, using Hive or MapReduce.

## Examples
1. Which color of lego brick is used most across all sets?
2. What are the top 10 parts used as spares for all sets?
3. What sets had the highest part numbers included in the year 2017? 

**optional**

4. What category of parts utilizes the highest number of unique parts?
5. How many sets include 'brick' in the name of the set?
6. How many 'Sloped Bricks' are included in all 'Star Wars' sets?

## Technologies
- Hadoop MapReduce
- YARN
- HDFS
- Scala
- Hive
- Git + GitHub

## Dataset
- https://www.kaggle.com/rtatman/lego-database

## Initializing the Hadoop-Hive docker
1. cd ~
2. cd docker-hive/
3. docker-compose up -d

### Entering hive for direct query entry
4. docker-compose exec hive-server bash
5. {in hive} > hive
  