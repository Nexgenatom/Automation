package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch();
            Page page = browser.newPage();
            page.navigate("https://playwright.dev");
            System.out.println("Page Title: " + page.title());
        }

    }
}
