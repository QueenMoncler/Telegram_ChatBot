package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Random;

public class GuessNumber extends TelegramLongPollingBot {
    final String botName;
    final String botToken;


    public GuessNumber(String botName, String botToken) {
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

    public static int gameNumber = newRandNumber();


    @Override
    public void onUpdateReceived(Update update) {
        String vin = "Ты угадал!\n Давай следующее число, если не зассал";
        String lose = "Не угадал";

        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();            // Создаем переменную равную тексту присланного сообщения
            String chat_id = update.getMessage().getChatId().toString();    // Создаем переменную равную ид чата присланного сообщения

            SendMessage message = new SendMessage(); // Создаем обект-сообщение
            message.setChatId(chat_id);
            System.out.println(gameNumber);

            if (Integer.parseInt(message_text) == gameNumber) {
                message.setText(vin);
                gameNumber = newRandNumber();
            } else {
                message.setText(lose);

            }
            try {
                execute(message); // Отправляем обект-сообщение пользователю
                //System.out.println(update.getMessage().getChatId().toString());
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }
    }

    public static int newRandNumber() {
        Random random = new Random();
        return random.nextInt(10 - 0 + 1) + 0;
    }
}

