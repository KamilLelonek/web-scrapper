package co.growbots

import org.rovak.scraper.ScrapeManager._
import org.rovak.scraper.models.WebPage

import org.jsoup.nodes.Element
import org.jsoup.select.Elements

import co.growbots.WebScrapper._
import co.growbots.ExtractDomainName

import scala.collection.JavaConverters.asScalaIteratorConverter

object WebScrapper {
  private lazy val ClientsTagID = "#clients"
  private lazy val UrlsTag      = "a[href]"
  private lazy val ImagesTag    = "img[src]"

  implicit def iteratorForElements(elements: Elements) = elements.iterator.asScala
}

class WebScrapper {
  def start = scrape from GrowbotsWebsite.url open { implicit page => interpretPageContent }

  private def interpretPageContent(implicit page: WebPage) =
    ClientsTagID each { extractClients }

  private def extractClients(htmlContent: Element) = {
    htmlContent select UrlsTag   foreach { parseUrlAndName }
    htmlContent select ImagesTag foreach { parseImage }
  }

  private def parseUrlAndName(client: Element) = {
    val websiteURL = client.attr("abs:href")

    println(websiteURL)
    println(ExtractDomainName.fromStringURL(websiteURL))
  }
  private def parseImage(client: Element) = {
    val logoURL    = client.attr("abs:src")

    println(logoURL)
  }
}
