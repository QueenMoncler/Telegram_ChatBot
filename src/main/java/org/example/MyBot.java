package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        // геттер имени бота
        return null;
    }

    @Override
    public String getBotToken() {
        // геттер токена бота
        return null;
    }



    @Override
    public void onUpdateReceived(Update update) {
        // Проверяем появление нового сообщения в чате, и если это текст
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();            // Создаем переменную равную тексту присланного сообщения
            String chat_id = update.getMessage().getChatId().toString();// Создаем переменную равную ид чата присланного сообщения


            SendMessage message = new SendMessage(); // Создаем обект-сообщение
            message.setChatId(chat_id);              // Передаем чат ид
            message.setText(message_text);           // Передаем эхо сообщение

            try {
                System.out.println(update.getMessage().getChatId().toString());
                execute(message);                   // Отправляем обект-сообщение пользователю
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }


}
