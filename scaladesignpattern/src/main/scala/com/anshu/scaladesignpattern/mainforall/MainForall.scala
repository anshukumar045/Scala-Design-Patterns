package com.anshu.scaladesignpattern.mainforall

trait MainForall1 {
  import CommandLineParser._

  def run(appRags: ApplicationArguments): Unit

}

object MainForall{
  import CommandLineParser._
  import DesignPatternMaps._

  def main(args: Array[String]): Unit = {
    val commandLineParser = CommandLineParser(args)
    val parser = commandLineParser.parseCommandLine

    parser.parse(args,ApplicationArguments()) match {
      case Some(options) =>
        val appClass = options.appName.map(ap => appMap.get(ap))
        .map(_ match {
          case Some(app) => app
          case _ => throw new RuntimeException("not a valid app")
        }).getOrElse(throw new RuntimeException("no app name found"))

        val appInstance = appClass.getDeclaredConstructor().newInstance()
        appInstance.run(options)
    }
  }

}
