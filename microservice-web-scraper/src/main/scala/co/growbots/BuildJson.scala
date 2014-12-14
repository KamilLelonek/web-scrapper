package co.growbots

import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._

object BuildJson {
  def fromCustomersAndImages(namesWithURL: Iterator[(String, String)], images: Iterator[String]) = {
    val result = namesWithURL.zip(images).map {
      case (nameWithURL, image) =>
        Map("name" -> nameWithURL._1, "url" -> nameWithURL._2, "image" -> image)
    }
    fromListOfMaps(result)
  }

  def fromListOfMaps(listOfMaps: Iterator[Map[String, String]]) =
    compact(render("items" -> listOfMaps.toList))
}
