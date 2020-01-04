package ru.kozhukhovskii.components;

import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

/**
 * TODO: comment
 *
 * @author vempari 01.01.2020   18:16
 */
public class Future implements PlaceInfo {
    private String place = "Future";
    @Override
    public String getPlace() {
        return place;
    }

    @Override
    public String doAction(ArrayList<KeyboardRow> keyboard, KeyboardRow leftRow, KeyboardRow rightRow, String text) {
        switch (text) {
            case "1546" : return "Очухавшись от тряски ты оглянулась и увидела вокруг очень красивую пустыню. Но вокруг не было ничего. " +
                    "Подняв голову ты увидела луну, необычайно близко, но что-то в ней было не так, а именно огромная дыра размером с половину самой луны." +
                    "Маленький приборчик зазвонил - нажав на кнопку на экране появился Лео. " +
                    "-Привет, я смотрю ты добралась до конца! Поздравляю, теперь ты готова к финальным вопросам!" +
                    "Давай с простого, что объединяет цитаты встреченные тебе. Назови это одним словом";
            case "Неизбежность":
            case "неизбежность":
                return "Верно, давай еще немного - как звали того, кто победил существо похожее на меня.";
            case "Эдип" :
                return "Молодец какая, все верно! Выставка скульптора Натана Савайи называется" +
                        " \"По кирпичику\". Можно сказать, что на создание уникального стиля " +
                        "Натана повлияли родители, подарив трехлетнему сыну... Что?";
            case "лего" :
            case "Лего" :
                return "Верно! Я думаю ты готова к подарку) Покажи это сообщение моему создателю :**";
            default: return "Боюсь не правильно, попробуй еще раз)";
    }
}
}
