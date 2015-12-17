// Turn this project into a Scala.js project by importing these settings
lazy val sharedSettings=Seq(scalaVersion := "2.11.7",organization := "com.slate.me",version := "0.1-SNAPSHOT",name:="Website",dependencyOverrides += "org.scala-lang" % "scala-reflect" % scalaVersion.value)

lazy val sprayVersion = "1.3.3"

lazy val website = crossProject.in(file(".")).jsSettings(
		//persistLauncher := true,
		//persistLauncher in Test := false,
		jsDependencies +=RuntimeDOM,
		libraryDependencies ++= Seq(

					"com.lihaoyi" %%% "scalatags" % "0.5.3",
					"com.github.japgolly.scalacss" %%% "ext-scalatags" % "0.3.1",
					
			        "org.scala-js" %%% "scalajs-dom" % "0.8.2")
).settings(sharedSettings: _*).enablePlugins(ScalaJSPlugin).jvmSettings(

  libraryDependencies ++= Seq("org.webjars" % "foundation" % "6.0.5",
							  //"org.scala-lang.modules" %% "scala-async" % "0.9.6-RC2",
				"com.typesafe.akka" %% "akka-actor" % "2.3.14" withSources() withJavadoc(),
				"io.spray" %% "spray-can" % sprayVersion withSources() withJavadoc(),
				"io.spray" %% "spray-routing" % sprayVersion withSources() withJavadoc(),
				"io.spray" %% "spray-json" % "1.3.2" withSources() withJavadoc(),
				"io.spray" %% "spray-client" % "1.3.2" withSources() withJavadoc(),
				"io.spray" %% "spray-http" % "1.3.2" withSources() withJavadoc())
		)
lazy val websiteJVM = website.jvm
lazy val websiteJS = website.js
lazy val root = project.in(file("."))
	.aggregate(websiteJS, websiteJVM).settings(sharedSettings: _*)
	.settings(
			publish := {},
			publishLocal := {}
	)
