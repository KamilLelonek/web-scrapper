# WebScrapper based on MicroSevices with Scala and Ruby

## Description

The purpose of this code is to crawl [growbots.co](http://www.growbots.co/) website.

[![growbots.co](http://www.growbots.co/images/growbots-web-2.png)](http://www.growbots.co/)

The application consists of **two micro-services**.

1. **Scala scrapping service** - it is used to traverse page source and extract interesting information.
2. **Ruby printing library** - it is used to receive and print crawling results.


We are interested particular code from that part of Growbots website:

```
<div class="row" style="margin-top:20px;">
  <div class="two columns offset-by-one text-center" style="padding:0 5px;">
     		<a href="http://www.reviewtrackers.com/" target="_blank"><img src="images/logos/reviewtrackers.png" width="181" height="75" class="pop" style="margin:auto;" /></a>
  </div>
  <div class="two columns text-center" style="padding:0 5px;">
     		<a href="https://www.getvero.com/" target="_blank"><img src="images/logos/vero.png" width="181" height="75" class="pop" style="margin:auto;" /></a>
  </div>
  <div class="two columns text-center" style="padding:0 5px;">
     		<a href="https://www.frontleaf.com/" target="_blank"><img src="images/logos/frontleaf.png" width="181" height="75" class="pop" style="margin:auto;" /></a>
  </div>
  <div class="two columns text-center" style="padding:0 5px;">
     		<a href="https://www.cloud9charts.com/" target="_blank"><img src="images/logos/cloud9.png" width="181" height="75" class="pop" style="margin:auto;" /></a>
  </div>
  <div class="two columns text-center" style="padding:0 5px;">
     		<a href="http://www.pandastream.com/" target="_blank"><img src="images/logos/panda.png" width="181" height="75" class="pop" style="margin:auto;" /></a>
  </div>
  <div class="one column text-center" style="padding:0 5px;">
  		&nbsp;
  </div>
</div>
```

![clients](https://monosnap.com/image/DZAb9VCmh8r2uoRviIP5RRGYmWoBh1.png)

which contains information about their clients. **We want to extract clients names, URLs and logos.**

## Prerequisites

I assume that you have covered the following steps by yourself already:

1. you have [Ruby](https://www.ruby-lang.org/en/documentation/installation/) installed
2. you have [Scala](http://www.scala-lang.org/download/) and [SBT](http://www.scala-sbt.org/download.html) installed
2. you have repository cloned `git clone https://github.com/KamilLelonek/web-scrapper.git`
3. you are in project directory `cd web-scrapper/`

## Installation

1. Download and install [rabbitmq](https://www.rabbitmq.com/download.html)
2. Run `rabbitmq` server

## Run

### Printing micro-service

1. `cd microservice-printing-results/`
2. `bundle install` (only for the first time)
3. `./main.rb`

### Crawling micro-service

1. `cd microservice-web-scraper/`
2. `sbt` (that will fetch all **Scala** dependencies)
3. `> run` (inside `sbt` session, that will fetch all **Project** dependencies)

## Results

Gathered results should be dumped in:

    web-scrapper/result.html
