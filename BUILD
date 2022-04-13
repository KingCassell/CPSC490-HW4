
#======================================================================
# Bare-bones Bazel BUILD file for MyPL
# CPSC 490
# Spring, 2022
#======================================================================

load("@rules_java//java:defs.bzl", "java_test")

java_library(
  name = "cpsc490-lib",
  srcs = glob(["src/*.java"]),
)

#----------------------------------------------------------------------
# TEST SUITES:
#----------------------------------------------------------------------


java_test(
  name = "hw4-test",
  srcs = ["tests/HW4Test.java"], 
  test_class = "HW4Test",
  deps = ["lib/junit-4.13.2.jar", "lib/hamcrest-core-1.3.jar", ":cpsc490-lib"],
)




