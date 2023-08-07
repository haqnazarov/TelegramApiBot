package uz.haqnazarov.telegramapibot.TelegramBotsApi.config;

public interface BotConfig {
    /**
     * Your domain must be HTTPS Example: https://haqnazarov.uz
     */
    String DOMAIN = "";
    /**
     * Your Telegram bot private api token
     */
    String API_TOKEN = "";

    String API_TELEGRAM = "https://api.telegram.org/bot" + API_TOKEN;

}
