package co.growbots

import akka.actor.{ ActorRef, Props, ActorSystem }
import concurrent.Future
import concurrent.ExecutionContext.Implicits.global
import co.growbots.PublishMessage._
import com.thenewmotion.akka.rabbitmq._

object PublishMessage {
  private lazy val QueueName = "print"
}

class PublishMessage {
  private lazy val factory    = new ConnectionFactory
  private lazy val connection = factory.newConnection
  private lazy val channel    = connection.createChannel

  def call(json: String) = {
    declareQueueForChannel(channel)
    publishMessageInChannel(json, channel)
  }

  private def declareQueueForChannel(channel: Channel) =
    channel.queueDeclare(QueueName, false, false, false, null)

  private def publishMessageInChannel(json: String, channel: Channel) =
    channel.basicPublish("", QueueName, null, json.getBytes)
}
