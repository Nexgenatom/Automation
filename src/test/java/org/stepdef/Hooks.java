package org.stepdef;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void beforeScenario(Scenario scenario) {
        logger.info("🔹 STARTING Scenario: {}", scenario.getName());
        Allure.step("🔹 STARTING Scenario: {}" + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        logger.info("🔸 FINISHED Scenario: {}", scenario.getName());
        Allure.step("🔸 FINISHED Scenario: {}"+ scenario.getName());
        if (scenario.isFailed()) {
            logger.error("❌ Scenario Failed: {}", scenario.getName());
            Allure.step("❌ Scenario Failed: {}"+ scenario.getName());
        }
    }
}
