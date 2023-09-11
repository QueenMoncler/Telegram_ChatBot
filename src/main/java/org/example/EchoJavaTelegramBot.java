package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.SQLOutput;

public class EchoJavaTelegramBot extends TelegramLongPollingBot {
    final String botName;
    final String botToken;


    public EchoJavaTelegramBot(String botName, String botToken) {
        this.botName = botName;
        this.botToken = botToken;
    }

    @Override
    public String getBotUsername() {
        // геттер имени бота
        return this.botName;
    }

    @Override
    public String getBotToken() {
        // геттер токена бота
        return this.botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Проверяем появление нового сообщения в чате, и если это текст
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();            // Создаем переменную равную тексту присланного сообщения
            String chat_id = update.getMessage().getChatId().toString();    // Создаем переменную равную ид чата присланного сообщения

            SendMessage message = new SendMessage(); // Создаем обект-сообщение
            message.setChatId(chat_id);              // Передаем чат ид
            message.setText(message_text);           // Передаем эхо сообщение

            try {
                execute(message); // Отправляем обект-сообщение пользователю
                //System.out.println(message_text);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}

