package com.teedjay;

import org.junit.jupiter.api.Test;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XmlPrettyPrintTest {

    String xmlData = "<xml>\n" +
        "\n" +
        "\n" +
        "\n" +
        "\n" +
        "\n" +
        "<abc>hsjdks</abc>\t\t\t\t<def>djfdfjkdf</def>\n" +
        "\n" +
        "\n" +
        "\n" +
        "\n" +
        "\n" +
        "\n" +
        "</xml>";

    @Test
    public void prettyPrint() throws Exception {

        // enable pretty printing with indentation and no xml declaration on top
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        Source xmlInput = new StreamSource(new StringReader(xmlData));
        StreamResult xmlOutput = new StreamResult(new StringWriter());
        transformer.transform(xmlInput, xmlOutput);
        String formattedXml = xmlOutput.getWriter().toString();

        // and remove empty lines
        String emptyLinesRemoved = formattedXml.replaceAll("(?m)^[ \t]*\r?\n", "");
        String strippedForTabsAndNewLine = emptyLinesRemoved.replaceAll("[\n\t]", "");

        assertEquals("<xml><abc>hsjdks</abc><def>djfdfjkdf</def></xml>", strippedForTabsAndNewLine);

    }

}
