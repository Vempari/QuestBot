package ru.kozhukhovskii;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import ru.kozhukhovskii.components.*;

import java.util.ArrayList;

public class Bot extends TelegramLongPollingBot {
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    Ancient ancient = new Ancient();
    CeaserHome ceaserHome = new CeaserHome();
    Future future = new Future();
    KingArthurCastle kingArthurCastle = new KingArthurCastle();
    MidleAges midleAges = new MidleAges();
    Nokolai1 nokolai1 = new Nokolai1();
    Pushkin pushkin = new Pushkin();
    TimeMachine timeMachine = new TimeMachine();
    public static String placeNow = "Leo";



    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi botapi = new TelegramBotsApi();
        try {
            botapi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    private String getMessage(String text, Message message) {
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow leftRow = new  KeyboardRow();
        KeyboardRow rightRow = new KeyboardRow();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        leftRow.add("Открыть дверь номер 1");
        rightRow.add("Открыть дверь номер 2");
        keyboard.add(leftRow);
        keyboard.add(rightRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        if (text.equals("Открыть дверь номер 1")) {
            placeNow = midleAges.getPlace();
        }
        else if (text.equals("Открыть дверь номер 2")) {
            placeNow = ancient.getPlace();
        }

        if (placeNow.equals(midleAges.getPlace())) {
            leftRow.clear();
            rightRow.clear();
            return midleAges.doAction(keyboard, leftRow, rightRow, text);
        }
        else if (placeNow.equals(ancient.getPlace())) {
            leftRow.clear();
            rightRow.clear();
            return ancient.doAction(keyboard, leftRow, rightRow, text);
        }
        else if (placeNow.equals(future.getPlace())) {
            leftRow.clear();
            rightRow.clear();
            return future.doAction(keyboard, leftRow, rightRow, text);
        }
        else if (placeNow.equals(kingArthurCastle.getPlace())) {
            leftRow.clear();
            rightRow.clear();
            return kingArthurCastle.doAction(keyboard, leftRow, rightRow, text);
        }
        else if (placeNow.equals(nokolai1.getPlace())) {
            leftRow.clear();
            rightRow.clear();
            return nokolai1.doAction(keyboard, leftRow, rightRow, text);
        }
        else if (placeNow.equals(pushkin.getPlace())) {
            leftRow.clear();
            rightRow.clear();
            return pushkin.doAction(keyboard, leftRow, rightRow, text);
        }
        else if (placeNow.equals(ceaserHome.getPlace())) {
            leftRow.clear();
            rightRow.clear();
            return ceaserHome.doAction(keyboard, leftRow, rightRow, text);
        }
        else if (placeNow.equals(timeMachine.getPlace())) {
            leftRow.clear();
            rightRow.clear();
            return timeMachine.doAction(keyboard, leftRow, rightRow, text);
        }

        return "Не пытайся хитрить:3";
    }
    @Override
    public void onUpdateReceived(Update e) {
        e.getUpdateId();
        SendMessage sendMessage = new SendMessage().setChatId(e.getMessage().getChatId());
        long chat_id = e.getMessage().getChatId();
        String text = e.getMessage().getText();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        if (text.equals("/start")) {
            try {
                sendMessage.setText(
                        "Привет, меня зовут Лев, я буду твоим проводником. " +
                                "Для того чтоб получить ответ на главный вопрос, " +
                                "надо будет пройти по всем комнатам и решить все загадки." +
                                " Пойдем за мной. Перед тобой 2 двери, каждая из которых ведет в свой мир. " +
                                "Но будь осторожна и внимательно смотри на все подсказки."
                );
                execute(sendMessage);
            } catch (TelegramApiException ex) {
                ex.printStackTrace();
            }
        } else{
            try {
                sendMessage.setText(getMessage(text, e.getMessage()));
                execute(sendMessage);
            } catch (TelegramApiException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "USER";
    }
    @Override
    public String getBotToken() {
        return "944204743:AAENKPp5lcBYJxwozvPHKNgGK1d36Ir2muE";
        //Токен бота
    }
}
