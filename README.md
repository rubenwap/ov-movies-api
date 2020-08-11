# OV-Movies API

This API reads from the movies scraped via [the tools here](https://github.com/rubenwap/ov-movies-scraper), and presents the results. 

Uses Scala 2.13 and Cask library

You need the env variables:

    MOVIEDBUSER
    MOVIEDBPASSWORD
    MOVIEDBHOST
    MOVIEDBNAME

If you have those in your local environment, you can run the api with `sbt run`. Alternatively, a `Dockerfile` is provided. 

