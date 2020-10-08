package com.howmanydays.howmanydays;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class HowManyDaysBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            sendMsg(message, "i work");
        }
    }

    private void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage(message.getChatId(), text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "TestFisherBot";
    }

    public String getBotToken() {
        return "1262183052:AAEhfzxPhiH9QzXMl090D1jTeBymHWRm4Q8";
    }
}
