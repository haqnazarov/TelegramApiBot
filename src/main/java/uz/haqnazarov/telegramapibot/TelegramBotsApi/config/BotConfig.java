package uz.haqnazarov.telegramapibot.TelegramBotsApi.config;

public interface BotConfig {
    /**
     * Your domain must be HTTPS Example: https://haqnazarov.uz
     */
    String DOMAIN = "https://d78d-84-54-71-15.ngrok-free.app";
    /**
     * Your Telegram bot private api token
     */
    String API_TOKEN = "6252673201:AAGvRiGdqyY0xjv4p_HObNkOTwRBNV9m8UI";

    String API_TELEGRAM = "https://api.telegram.org/bot" + API_TOKEN;

}
