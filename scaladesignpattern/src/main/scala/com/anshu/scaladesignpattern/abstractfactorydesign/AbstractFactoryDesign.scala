package com.anshu.scaladesignpattern.abstractfactorydesign

import com.anshu.scaladesignpattern.mainforall.{CommandLineParser, MainForall}

class AbstractFactoryDesign extends MainForall{
  override def run(appRags: CommandLineParser.ApplicationArguments): Unit =
    println("executing abstract factory design")
}
