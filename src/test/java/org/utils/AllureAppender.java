package org.utils;


import java.io.Serializable;

import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;

import io.qameta.allure.Allure;

@Plugin(name = "AllureAppender", category = "Core", elementType = Appender.ELEMENT_TYPE)
public class AllureAppender extends AbstractAppender {

    protected AllureAppender(String name, Layout<? extends Serializable> layout) {
        super(name, null, layout, false, null);
    }

    @PluginFactory
    public static AllureAppender createAppender(
            @PluginAttribute("name") String name,
            @PluginElement("Layout") Layout<? extends Serializable> layout
    ) {
        return new AllureAppender(name, layout);
    }

    @Override
    public void append(LogEvent event) {
        String message = new String(getLayout().toByteArray(event));
        Allure.addAttachment("log", "text/plain", message);
    }
}