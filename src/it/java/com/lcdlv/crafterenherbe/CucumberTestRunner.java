package com.lcdlv.crafterenherbe;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = "classpath:features/",
        plugin = { "pretty", "html:target/cucumber", "json:target/cucumber-reports/cucumber.json" },
        glue = "steps")
public class CucumberTestRunner {
}
