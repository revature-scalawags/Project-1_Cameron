# Project 1
Scala-Hadoop application to answer interesting questions about large datasets, using Hive or MapReduce.

## Examples
1. Which English wikipedia article got the most traffic on October 20?
2. What English wikipedia article has the largest fraction of its readers follow an internal link to another wikipedia article?
3. What series of wikipedia articles, starting with [Hotel California](https://en.wikipedia.org/wiki/Hotel_California), keeps the largest fraction of its readers clicking on internal links?  This is similar to (2), but you should continue the analysis past the first article.
4. Find an example of an English wikipedia article that is relatively more popular in the UK.  Find the same for the US and Australia.
5. Analyze how many users will see the average vandalized wikipedia page before the offending edit is reversed.
6. Run an analysis you find interesting on a reasonable dataset.

## Presentations
- Simple slide deck of results, high level overview of the process used to achieve those results, and any assumptions and simplifications made.
- 5-10 demonstration
- Friday, 1/8

## Technologies
- Hadoop MapReduce
- YARN
- HDFS
- Scala
- Hive
- Git + GitHub

## Example datasets
- [All Analytics](https://dumps.wikimedia.org/other/analytics/)
- [Pageviews Filtered to Human Traffic](https://dumps.wikimedia.org/other/pageviews/readme.html)
  - https://wikitech.wikimedia.org/wiki/Analytics/Data_Lake/Traffic/Pageviews
- [Page Revision and User History](https://dumps.wikimedia.org/other/mediawiki_history/readme.html)
  - https://wikitech.wikimedia.org/wiki/Analytics/Data_Lake/Edits/Mediawiki_history_dumps#Technical_Documentation
- [Monthly Clickstream](https://dumps.wikimedia.org/other/clickstream/readme.html)
  - https://meta.wikimedia.org/wiki/Research:Wikipedia_clickstream

## Initializing the Hadoop-Hive docker
1. cd ~
2. cd docker-hive/
3. docker-compose up -d
4. docker-compose exec hive-server bash
5. /opt/hive/bin/beeline -u jdbc:hive2://localhost:10000
  