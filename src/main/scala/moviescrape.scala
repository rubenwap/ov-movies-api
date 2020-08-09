package io.github.rubenwap.moviescrape
import com.typesafe.scalalogging.LazyLogging
import io.getquill._



object moviescrape extends cask.MainRoutes with LazyLogging {

  case class Movies(
                   cinema: String,
                   details: String,
                   title: String,
                   movie_date: String,
                   movie_time: String
                 )

  override def port: Int = 8081
  lazy val ctx = new PostgresJdbcContext(SnakeCase, "ctx")
  import ctx._
  @cask.get("/movies")
  def getMovies(): cask.Response[String] = {

    val content = ctx.run(query[Movies]).map(m => {ujson.Obj("cinema" -> ujson.Str(m.cinema),
        "details" -> ujson.Str(m.details), "title" -> ujson.Str(m.title),
        "movie_date" -> ujson.Str(m.movie_date),
        "movie_time" -> ujson.Str(m.movie_time))})
    val resp = upickle.default.write(ujson.Obj("data" -> content))
    new cask.Response(data=resp, statusCode = 200, headers = List(("content-type", "application/json")), cookies= List())

  }

  initialize()
}
