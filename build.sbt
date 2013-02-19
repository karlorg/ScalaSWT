name := "Scala SWT"

version := "0.1"

organization := "de.mritter.swt.dsl"

scalaVersion := "2.9.2"

scalacOptions ++= Seq("-unchecked", "-deprecation")//, "-language:reflectiveCalls")

// see http://code.google.com/p/swt-repo/source/browse/#svn%2Frepo%2Forg%2Feclipse%2Fswt
resolvers += "swt-repo" at "https://swt-repo.googlecode.com/svn/repo/"

libraryDependencies += {
	// get the right swt jar for the current operating system
	val os = (sys.props("os.name"), sys.props("os.arch")) match {
		case ("Linux", _) => "gtk.linux.x86"
		case ("Mac OS X", "amd64" | "x86_64") => "cocoa.macosx.x86_64"
		case ("Mac OS X", _) => "cocoa.macosx.x86"
		case (os, "amd64") if os.startsWith("Windows") => "win32.win32.x86_64"
		case (os, _) if os.startsWith("Windows") => "win32.win32.x86"
		case (os, arch) => sys.error("Cannot obtain lib for OS '" + os + "' and architecture '" + arch + "'")
	}
	val artifact = "org.eclipse.swt." + os
	"org.eclipse.swt" % artifact % "4.2.1"
}

libraryDependencies ++= Seq(
	"org.scalatest" % "scalatest_2.10" % "1.9.1" % "test",
	// "org.eclipse.core" % "databinding" % "1.0.0-I20070606-0010",
	// "org.eclipse.core.databinding" % "beans" % "1.1.1",
	// "org.mod4j.org.eclipse.core.databinding" % "property" % "1.2.0",
	"org.eclipse" % "jface" % "3.2.1-M20060908-1000",
	"org.mod4j.org.eclipse.jface" % "databinding" % "1.3.0"
)
