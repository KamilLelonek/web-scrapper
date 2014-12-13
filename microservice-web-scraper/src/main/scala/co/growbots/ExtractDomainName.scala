package co.growbots

import java.net.URL

object ExtractDomainName {
  def fromStringURL(stringURL: String) = {
    val url            = urlFromString(stringURL)
    val host           = url.getHost
    val hostWithoutWWW = trimWwwPrefix(host)

    chopTopLevelDomain(hostWithoutWWW)
  }

  private def urlFromString(string: String)    = new URL(string)
  private def trimWwwPrefix(host: String)      = host.replaceFirst("^www.*?\\.", "")
  private def chopTopLevelDomain(host: String) = {
    val lastDotPosition     = host lastIndexOf "."
    val substringUpperBound = if(lastDotPosition != -1) lastDotPosition else host.length
    host.substring(0, substringUpperBound)
  }
}
