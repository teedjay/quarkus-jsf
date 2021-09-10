package com.teedjay;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class IndexHtmlTest {

    @TestHTTPResource
    URL url;

    @Test
    public void shouldOpenIndexPage() throws Exception {
        try (final WebClient webClient = new WebClient(BrowserVersion.CHROME)) {
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setUseInsecureSSL(true);
            webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
            webClient.getCookieManager().setCookiesEnabled(true);
            webClient.setAjaxController(new NicelyResynchronizingAjaxController());
            webClient.getCookieManager().setCookiesEnabled(true);

            final HtmlPage page = webClient.getPage(url + "/index.xhtml");

            final HtmlDivision knownDIV = (HtmlDivision) page.getElementById("mydiv");
            assertNotNull(knownDIV);
            assertEquals("This text is verified from tests", knownDIV.getTextContent());

            // assertEquals(10, datatable.getByXPath("//tr[contains(@role,'row') and contains(@class,'ui-datatable-selectable')]").size());
        }
    }

}
