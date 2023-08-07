package uz.haqnazarov.telegramapibot.TelegramBotsApi.services.Execute;

import lombok.SneakyThrows;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import uz.haqnazarov.telegramapibot.TelegramBotsApi.config.BotConfig;
import uz.haqnazarov.telegramapibot.TelegramBotsApi.response.Message;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ExecuteImpl implements Execute {

    /**
     * SendMessage Method
     */
    @Override
    public Message send(SendMessage sendMessage) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(BotConfig.API_TELEGRAM + "/sendMessage", sendMessage, Message.class);
    }

    @SneakyThrows
    @Override
    public Message send(SendPhoto sendPhoto) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        Path path = Paths.get(sendPhoto.getPhoto().getAttachName());
        byte[] photoBytes = Files.readAllBytes(path);
        ByteArrayResource photo = new ByteArrayResource(photoBytes) {
            @Override
            public String getFilename() {
                return path.getFileName().toString();
            }
        };
        body.add("chat_id", sendPhoto.getChatId());
        body.add("photo", photo);
        body.add("message_thread_id", sendPhoto.getMessageThreadId());
        body.add("caption", sendPhoto.getCaption());
        body.add("parse_mode", sendPhoto.getParseMode());
        body.add("caption_entities", sendPhoto.getCaptionEntities());
        body.add("has_spoiler", sendPhoto.getHasSpoiler());
        body.add("disable_notification", sendPhoto.getDisableNotification());
        body.add("protect_content", sendPhoto.getProtectContent());
        body.add("reply_to_message_id", sendPhoto.getReplyToMessageId());
        body.add("allow_sending_without_reply", sendPhoto.getAllowSendingWithoutReply());
        body.add("reply_markup", sendPhoto.getReplyMarkup());
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body, headers);
        ResponseEntity<Message> responseEntity = restTemplate.postForEntity(BotConfig.API_TELEGRAM + "/sendPhoto", request, Message.class);
        return responseEntity.getBody();
    }
}
