package vn.fpt.spark.streaming

case class ApacheAccess(ip: String, date: String, method: String, request: String)
{
  override def toString() = {
    s"$date - $ip - $method - $request"
  }
}

object ApacheAccess {

  def apply(line: String): Option[ApacheAccess] = {

    val ip = """(\d+.\d+.\d+.\d+)"""
    val date = """(\d+\/.*\/\d+:\d+:\d+:\d+) \+0100"""
    val method = """(GET|POST)"""
    val req = s"""(\\/[^ ]*)"""

    val urlRegex = s"""$ip - - \\[$date\\] "$method $req.*""".r

    line match {
      case urlRegex(ip, date, method, req) => Some(ApacheAccess(ip, date, method, req))
      case _ => None
    }
  }
}