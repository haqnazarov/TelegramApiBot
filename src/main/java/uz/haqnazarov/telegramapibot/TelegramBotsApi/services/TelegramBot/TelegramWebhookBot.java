package uz.haqnazarov.telegramapibot.TelegramBotsApi.services.TelegramBot;

import org.telegram.telegrambots.meta.api.objects.Update;
import uz.haqnazarov.telegramapibot.TelegramBotsApi.services.Execute.Execute;
import uz.haqnazarov.telegramapibot.TelegramBotsApi.services.Execute.ExecuteImpl;

public interface TelegramWebhookBot {
    Execute execute = new ExecuteImpl();
    void onUpdateReceived(Update update);
}
