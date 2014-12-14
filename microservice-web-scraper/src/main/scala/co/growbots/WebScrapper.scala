package co.growbots

import co.growbots.WebScrapper._
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import org.rovak.scraper.ScrapeManager._
import org.rovak.scraper.models.WebPage

import scala.collection.JavaConverters.asScalaIteratorConverter

object WebScrapper {
  private lazy val ClientsTagID = "#clients"
  private lazy val UrlsTag      = "a[href]"
  private lazy val ImagesTag    = "img[src]"

  implicit def iteratorForElements(elements: Elements) = elements.iterator.asScala
}

class WebScrapper {
  private lazy val messagePublisher = new PublishMessage

  def start = scrape from GrowbotsWebsite.url open { implicit page => interpretPageContent }

  private def interpretPageContent(implicit page: WebPage) = ClientsTagID each { extractClients }

  private def extractClients(htmlContent: Element) = {
    val listOfNamesWithURL = htmlContent select UrlsTag   map { parseUrlAndName }
    val listOfImages       = htmlContent select ImagesTag map { parseImage }
    joinClientInfo(listOfNamesWithURL, listOfImages)
  }

  private def parseUrlAndName(client: Element) = {
    val websiteURL = client.attr("abs:href")
    (websiteURL, ExtractDomainName.fromStringURL(websiteURL))
  }

  private def parseImage(client: Element) = client.attr("abs:src")

  private def joinClientInfo(namesWithURL: Iterator[(String, String)], images: Iterator[String]) = {
    val jsonResult = BuildJson.fromCustomersAndImages(namesWithURL, images)
    messagePublisher.call(jsonResult)
  }
}
