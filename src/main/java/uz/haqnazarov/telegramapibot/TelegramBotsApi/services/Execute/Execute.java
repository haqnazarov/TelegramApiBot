package uz.haqnazarov.telegramapibot.TelegramBotsApi.services.Execute;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import uz.haqnazarov.telegramapibot.TelegramBotsApi.response.Message;

public interface Execute {
    Message send(SendMessage sendMessage);

    Message send(SendPhoto sendPhoto);
}
