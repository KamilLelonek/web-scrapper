require_relative 'consume_message'
require_relative 'dump_result'

class DumpQueue
  def call
    consume_message.()
  end

  private
  def consume_message
    ConsumeMessage.new(dump_result)
  end

  def dump_result
    DumpResult.new
  end
end
