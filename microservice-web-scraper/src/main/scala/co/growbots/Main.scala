package co.growbots

import akka.actor.{ ActorRef, Props, ActorSystem }
import concurrent.Future
import concurrent.ExecutionContext.Implicits.global

import com.thenewmotion.akka.rabbitmq._

object Main extends App {

  // val QUEUE_NAME = "print"
  // val system = ActorSystem()
  // val factory = new ConnectionFactory()
  // val connection = system.actorOf(ConnectionActor.props(factory), "rabbitmq")

  // def setupPublisher(channel: Channel, self: ActorRef) = channel.queueDeclare(QUEUE_NAME, false, false, false, null)
  // connection ! CreateChannel(ChannelActor.props(setupPublisher), Some("publisher"))

  // Future {
  //   while(true) {
  //     val publisher = system.actorSelection("/user/rabbitmq/publisher")

  //     def publish(channel: Channel) = channel.basicPublish("", QUEUE_NAME, null, "Hello".getBytes)
  //     publisher ! ChannelMessage(publish, dropIfNoChannel = false)

  //     Thread.sleep(1000)
  //   }
  // }

  val webScrapper = new WebScrapper
  webScrapper.start
}
