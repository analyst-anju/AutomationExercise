package com.automation.test.features_ui;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber", "json:target/cucumber.json" }, tags = {
   "~@ignore" })
public class ITRunCukesUIChrome
{}
