package org.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/resources",
        plugin={"pretty"},
tags="@Login",
glue="org.example",
monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}
