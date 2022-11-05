package com.example.weblab2.tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTagHandler extends TagSupport{

    public int doStartTag(){
        MessageFinder messageFinder = new MessageFinder();
        JspWriter out = pageContext.getOut();
        try {
            messageFinder.findMessage().forEach(
                    message -> {
                        try {
                            out.print("<h3>" + message.getSenderName() + "</h3>"
                                        + "<h5>" + message.getSendDateTime() + "</h5>"
                                        + "<p>" + message.getMessageText() + "</p>"
                                        + "<hr/>");
                        } catch (IOException ignore) {
                        }
                    }
            );
        } catch (IOException ignore) {
        }

        return SKIP_BODY;
    }
}