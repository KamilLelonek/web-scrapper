require 'slim'
require 'json'

class DumpResult
  FILE_NAME = 'result.html'

  def call(content)
    dump_result parse_content(content)
  end

  private
  def parse_content(content)
    JSON.parse(content).tap do |result|
      puts "Received message: #{result}"
    end
  end

  def dump_result(content)
    write_file rendered_slim(content)
    puts "Message dumped!"
  end

  def write_file(content)
    File.write(FILE_NAME, content)
  end

  def rendered_slim(content)
    slim_with_template.render content
  end

  def slim_with_template
    Slim::Template.new { file_with_template }
  end

  def file_with_template
    File.read 'template.slim'
  end
end
