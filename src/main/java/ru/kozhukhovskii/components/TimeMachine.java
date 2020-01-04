package ru.kozhukhovskii.components;

import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

import static ru.kozhukhovskii.Bot.placeNow;

/**
 * TODO: comment
 *
 * @author vempari 01.01.2020   18:53
 */
public class TimeMachine implements PlaceInfo {
    private String place = "TimeMachine";
    @Override
    public String getPlace() {
        return place;
    }

    @Override
    public String doAction(ArrayList<KeyboardRow> keyboard, KeyboardRow leftRow, KeyboardRow rightRow, String text) {
        switch (text){
            case "Вперед и с песней!":
                return "Ты открываешь глаза и видишь перед собой огромную шарообразную штуку. Осмотрев её вокруг ты понимаешь, что это какой-то механизм" +
                        "заглянув внутрь ты видишь что-то наподобие ручи и колеса с временем." +
                        " Внимательно осмотрев округу ты не можешь найти ничего интересного. Забравшись внутрь устройства ты решаешь нажать что-то на дисплее с цифрами";
            case "1546":
                leftRow.clear();
                rightRow.clear();
                placeNow = "Future";
                return "Вдруг что-то зажужжало и заверещало, вокруг тебя вздернулись молнии вжух-вжух-петух.";
            default:
                leftRow.clear();
                rightRow.clear();
                placeNow = "Ancient";
                return "что-то пошло не так, вижимо фифры не правтльные..";

        }
    }
}
