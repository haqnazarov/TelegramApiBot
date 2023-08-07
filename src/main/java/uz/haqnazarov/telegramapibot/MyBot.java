package uz.haqnazarov.telegramapibot;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.haqnazarov.telegramapibot.TelegramBotsApi.response.Message;
import uz.haqnazarov.telegramapibot.TelegramBotsApi.services.TelegramBot.TelegramWebhookBot;

@Service
public class MyBot implements TelegramWebhookBot {
    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = update.getMessage().getChatId();
        SendMessage sendMessage = SendMessage.builder()
                .chatId(chatId)
                .text("salom")
                .build();
        execute.send(sendMessage);
        SendPhoto sendPhoto = SendPhoto.builder()
                .chatId(chatId)
                .photo(new InputFile("files/img.png"))
                .build();
        Message send = execute.send(sendPhoto);
        System.out.println(send);
    }
}
