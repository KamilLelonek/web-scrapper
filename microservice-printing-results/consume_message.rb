require 'bunny'

class ConsumeMessage
  CHANNEL_NAME = 'print'

  attr_reader :dump_result

  def initialize(dump_result)
    @dump_result = dump_result
  end

  def call
    start_connection
    subscribe_to_queue
  end

  private
  def start_connection
    connection.start
  end

  def connection
    @connection ||= Bunny.new
  end

  def channel
    @channel ||= connection.create_channel
  end

  def queue
    @queue ||= channel.queue CHANNEL_NAME
  end

  def subscribe_to_queue
    queue.subscribe(block: true) do |delivery_info, _, body|
      next unless request_valid?(delivery_info)
      dump_result.(body)
    end
  end

  def request_valid?(delivery_info)
    delivery_info.routing_key == CHANNEL_NAME
  end
end
