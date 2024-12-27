package com.anshu.scaladesignpattern.mainandconfig.typeclasses

import com.anshu.scaladesignpattern.mainandconfig.configtrait.AppArg
import scopt.OptionParser


case class TypeClassAppConfig(override val appName: String = "") extends AppArg(appName)
object TypeClassAppConfig {
  val typeClassAppConfig = "TypeClassAppConfig"
  val parser: OptionParser[TypeClassAppConfig] = new OptionParser[TypeClassAppConfig](typeClassAppConfig) {
    head(typeClassAppConfig)
    opt[String]("app-name").action((x,c) => c.copy(appName = x))
  }


}
