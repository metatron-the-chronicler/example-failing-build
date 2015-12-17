package com.slate.me

import scalatags.Text.TypedTag
import scalatags.Text.all._
object pages {
  private def constructScriptTags(s: Option[Seq[String]]): Option[String] = {
    val result = s match {
      case Some(sf) ⇒ {
        val g = sf.map(sf ⇒ script(src := sf, `type` := "text/javascript").render).mkString("\n")
        Some(g)
      }
      case _ ⇒ None
    }
    result
  }

  def layout(content: TypedTag, source: String, js: Option[Seq[String]]) = {
    html(head(link(rel := "stylesheet", `type` := "text/css", href := source)),
      body(content,constructScriptTags(js)))
  }
}
