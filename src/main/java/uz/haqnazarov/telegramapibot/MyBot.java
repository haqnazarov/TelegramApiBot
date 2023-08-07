package uz.haqnazarov.telegramapibot;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.haqnazarov.telegramapibot.TelegramBotsApi.services.TelegramBot.TelegramWebhookBot;

@Service
public class MyBot implements TelegramWebhookBot {
    @Override
    public void onUpdateReceived(Update update) {
//        your telegram bot source code
    }
}
