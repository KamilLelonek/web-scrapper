# WebScrapper based on MicroSevices with Scala and Ruby

## Description

The purpose of this code is to crawl [growbots.co](http://www.growbots.co/) website.

[![growbots.co](http://www.growbots.co/images/growbots-web-2.png)](http://www.growbots.co/)

The application consists of **two micro-services**.

1. **Scala scrapping service** - it is used to traverse page source and extract interesting information.
2. **Ruby printing library** - it is used to receive and print crawling results.


We are interested particular code from that part of rowboats website:

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

![](https://d2oawfjgoy88bd.cloudfront.net/538df4ae007791166b92a197/538df4c8007791166b92a19a/548a6e4d38d387330b8bd654.png?Expires=1418444773&Signature=boddH1AlQO61IVWMvYf6BXjxwV-Qf~8N-4KxsoT1nUiWrXC5QDOXpdVTqJMzK6cy0bOOB0Gk3kk-tFZyra0MhddNMOlyOfdRvIOtrZn2YqY2QBq~qiTVXL-ftA97h1QgR6VhtMlJxlyFQBfO07lg5JhTaES7ck4N5~4iwsW4KeKeHEw1rMoNBWqXho6jqHM6Ir9~dnS7LEjd7u6lH4JmrmiHJ25NyrrMva8Ud9bjRBeBatKTWUId99avDHfm4zeD0sA82scKqMmBBblKDJRkZWAYiL6U~71f~w0Mi~7pmszW8NRIKLR8J3M2LYp3Jw4TfIDUL6xGb0hnqz20h4Eqhw__&Key-Pair-Id=APKAJHEJJBIZWFB73RSA)

which contains information about their clients. **We want to extract clients names, URLs and logos.**

## Prerequisites

1. `git clone https://github.com/KamilLelonek/web-scrapper.git`
2. `cd web-scrapper/`

## Installation

1. Download and install [rabbitmq](https://www.rabbitmq.com/download.html)
2. Run `rabbitmq` server

## Run

### Printing micro-service

1. `cd microservice-printing-results`
2. `./main.rb`

### Crawling micro-service

1. `cd ../microservice-web-scraper`
2. `set` (that will fetch all **Scala** dependencies)
3. `~ run` (inside `set` session, that will fetch all **Project** dependencies)