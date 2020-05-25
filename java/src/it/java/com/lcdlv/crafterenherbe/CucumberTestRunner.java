package com.lcdlv.crafterenherbe;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = "src/it/java/com/lcdlv/crafterenherbe/feature",
//        tags = {"@LCDLV"},
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-reports/cucumber.json"},
        glue = "com/lcdlv/crafterenherbe/steps")
public class CucumberTestRunner {
}
