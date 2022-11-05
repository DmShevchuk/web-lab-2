package com.example.weblab2.tags;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MessageFinder {
    private static final int BASE_INDEX = 0;
    private static final int INDEX_OF_PARAGRAPH_WITH_MESSAGE = 1;

    public List<Message> findMessage() throws IOException {
        String blogUrl = "https://se.ifmo.ru";
        Document doc = Jsoup.connect(blogUrl).get();
        Elements allMessages = getAllMessages(doc);
        List<Message> messageList = new ArrayList<>();
        for (Element message: allMessages){
            Message msg = new Message();
            msg.setSenderName(getSenderName(message));
            msg.setSendDateTime(getSendDateTime(message));
            msg.setMessageText(getMessageText(message));
            messageList.add(msg);
        }
        return messageList;
    }


    /**
     * Получить все сообщения из ВК на se.ifmo.ru
     * */
    private Elements getAllMessages(Document document){
        return document.select(".vk-messages")
                .get(BASE_INDEX)
                .select("tbody")
                .get(BASE_INDEX)
                .select("tr");
    }

    /**
     * Получить из сообщения имя отправителя
     * */
    private String getSenderName(Element message){
        return message.select("p")
                .get(BASE_INDEX)
                .select("a")
                .get(BASE_INDEX)
                .text();
    }

    /**
     * Получить из сообщения имя отправителя
     * */
    private String getSendDateTime(Element message){
        return message.select("p")
                .get(BASE_INDEX)
                .select("font")
                .get(BASE_INDEX)
                .text();
    }

    /**
     * Получить из сообщения имя отправителя
     * */
    private String getMessageText(Element message){
        return message.select("p")
                .get(INDEX_OF_PARAGRAPH_WITH_MESSAGE)
                .text();
    }
}
