scalaVersion := "2.11.12"

// Set to false or remove if you want to show stubs as linking errors
nativeLinkStubs := false
nativeLinkingOptions ++= Seq(
  "-v",
  s"-L${baseDirectory.value.getAbsolutePath()}/src/main/cpp",
)

//nativeMode := "release"

enablePlugins(ScalaNativePlugin)
