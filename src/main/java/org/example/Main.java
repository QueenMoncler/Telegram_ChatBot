package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


public class Main {
    public static void main(String[] args) {
        String botName = "ChatBotGamer_bot";
        String botToken = "6120623714:AAExsw4wmpbeVpj2QCA7adFAWV1b8yxWaBs";
        TelegramBotsApi telegramBotsApi = null;
        try {
            telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new EchoJavaTelegramBot(botName, botToken));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}