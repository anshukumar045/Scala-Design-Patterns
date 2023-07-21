package com.anshu.scaladesignpattern.mainforall

import scopt.OptionParser

class CommandLineParser(args: Array[String]){
  import CommandLineParser._

  val parseCommandLine = new OptionParser[ApplicationArguments]("scala-design-patter") {
    opt[String]('a', "app-name")
      .action((value,options) => options.copy(appName = Some(value)))
      .text("specify an application name")
  }

}

object CommandLineParser {
  def apply(args: Array[String]): CommandLineParser = new CommandLineParser(args)
  case class ApplicationArguments(appName : Option[String] = None)
}
