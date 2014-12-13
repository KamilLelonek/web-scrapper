package co.growbots

import org.rovak.scraper.ScrapeManager._
import org.rovak.scraper.models.WebPage

import org.jsoup.nodes.Element
import org.jsoup.select.Elements

import co.growbots.WebScrapper._

import scala.collection.JavaConverters.asScalaIteratorConverter

object WebScrapper {
  val ClientsTagID = "#clients"
  val UrlsTag      = "a[href]"

  implicit def iteratorForElements(elements: Elements) = elements.iterator.asScala
}

class WebScrapper {
  def start = scrape from GrowbotsWebsite.url open { implicit page => interpretPageContent }

  private def interpretPageContent(implicit page: WebPage) =
    ClientsTagID each { extractClients }

  private def extractClients(htmlContent: Element) =
    htmlContent select UrlsTag foreach { parseClientInfo }

  private def parseClientInfo(client: Element) = println(client)
}
