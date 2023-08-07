package uz.haqnazarov.telegramapibot.TelegramBotsApi.response;

import lombok.Data;

@Data
public class Message {
    private Boolean ok;
    private Result result = new Result();
}
