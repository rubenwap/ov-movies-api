# OV-Movies API

This API reads from the movies scraped via [the tools here](https://github.com/rubenwap/ov-movies-scraper), and presents the results. 

Uses Scala 2.12 and Cask library

You need the env variables:

    MOVIEDBUSER
    MOVIEDBPASSWORD
    MOVIEDBHOST
    MOVIEDBNAME

As this is deployed to Heroku, I can run it without setting the variable `PORT`, because Heroku will create that automatically. But in order to run it in local or elsewhere, you would also need `PORT`. 

Run the api with `sbt run`. Alternatively, a `Dockerfile` is provided. 

