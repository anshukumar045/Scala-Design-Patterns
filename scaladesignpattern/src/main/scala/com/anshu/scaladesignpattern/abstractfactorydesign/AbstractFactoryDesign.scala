package com.anshu.scaladesignpattern.abstractfactorydesign

import com.anshu.scaladesignpattern.mainforall.{CommandLineParser, MainForall}

/*
 building a UI library that supports multiple themes.
 We want to have different UI elements like buttons and checkboxes for each theme
  - Light Theme and Dark Theme.
 */

class AbstractFactoryDesign extends MainForall{
  import AbstractFactoryDesign._
  override def run(appRags: CommandLineParser.ApplicationArguments): Unit = {
    println("executing abstract factory design")
    //step6 Implementation

    //Light Theme
    Client.createUI(LightThemeFactory)

    // Dark Theme
    Client.createUI(DarkThemeFactory)
  }
}
object AbstractFactoryDesign{
  // step1 Abstract factory
  trait UIElement {
    def render: Unit
  }

  // step2 Abstract Product
  trait UiFactory{
    def createButton: UIElement
    def createCheckbox: UIElement
  }

  //step 3 concrete product
  class LightThemeButton extends UIElement {
    override def render: Unit = println("Rendering Light Theme Button")
  }
  class LightThemeCheckBox extends UIElement {
    override def render: Unit = println("Rendering Light Theme Checkbox")
  }

  class DarkThemeButton extends UIElement {
    override def render: Unit = println("Rendering Dark Theme Button")
  }
  class DarkThemeCheckBox extends UIElement {
    override def render: Unit = println("Rendering Dark Theme Checkbox")
  }

  // step 4 concrete factory
  object LightThemeFactory extends UiFactory{
    override def createButton: UIElement = new LightThemeButton()
    override def createCheckbox: UIElement = new LightThemeCheckBox()
  }

  object DarkThemeFactory extends UiFactory{
    override def createButton: UIElement = new DarkThemeButton()
    override def createCheckbox: UIElement = new DarkThemeCheckBox()
  }

  //step 5 client
  object Client {
    def createUI(factory: UiFactory): Unit ={
      val button : UIElement = factory.createButton
      val checkbox: UIElement = factory.createCheckbox
      button.render
      checkbox.render
    }
  }
}

