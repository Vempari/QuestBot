package ru.kozhukhovskii.components;

import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

import static ru.kozhukhovskii.Bot.placeNow;
import static ru.kozhukhovskii.components.MidleAges.merlinSpell;

/**
 * TODO: comment
 *
 * @author vempari 01.01.2020   18:14
 */
public class KingArthurCastle implements PlaceInfo {
    public static int marlinCounter = 0;
    private String place = "KingArthurCastle";
    @Override
    public String getPlace() {
        return place;
    }

    @Override
    public String doAction(ArrayList<KeyboardRow> keyboard, KeyboardRow leftRow, KeyboardRow rightRow, String text) {
        switch (text) {
            case "Мы знакомы?":
                leftRow.clear();
                rightRow.clear();
                if (marlinCounter++ == 0) {
                    leftRow.add("Что?");
                }
                rightRow.add("Спросить у старика, что делать дальше.");
                return "Конечно знакомы! Пойми солнышко, Мы склоняемся перед неизбежным. " +
                        "Но не как пшеница, а как гречиха! Когда налетает буря, ветер приминает спелую пшеницу, " +
                        "потому что она сухая и не клонится. У спелой же гречихи в стебле есть сок, и она клонится. " +
                        "А как ветер уймется, она снова подымается, такая же прямая и сильная, как прежде.";
            case "Спросить у старика, что делать дальше.":
                leftRow.clear();
                rightRow.clear();
                return "А дальше отгадай пару загадок и я пущу тебя дальше:" +
                        "– Она красная?\n" +
                        "– Нет, черная.\n" +
                        "– А почему она сейчас белая?\n" +
                        "– Потому, что еще зеленая.\n" +
                        "О чем речь?";
            case "Черная смородина":
            case "черная смородина":
                leftRow.clear();
                rightRow.clear();
                return "Верно, Какое слово начинается с трех букв «Г» и заканчивается тремя буквами «Я»?";
            case "Тригонометрия":
            case "тригонометрия":
                leftRow.clear();
                rightRow.clear();
                leftRow.add("Уменьшится");
                rightRow.add("Увеличится");
                leftRow.add("никак");
                return "Верно, Допустим, вы летите из Москвы во Владивосток, " +
                        "а затем обратно, при полном безветрии. " +
                        "Затем вы совершаете точно такой же перелёт, но на этот раз на протяжении" +
                        " всего перелёта дует постоянный западный ветер: в одну сторону попутный, " +
                        "в обратную — лобовой. Как изменится суммарное время перелёта туда-обратно?";
            case "Мэрлин, мы уже друг другу как родные стали":
            case "никак":
                leftRow.clear();
                rightRow.clear();
                if (marlinCounter >= 3){
                    leftRow.add("Вперед и с песней!");
                    placeNow = "TimeMachine";
                    return "Молодец, теперь ты можешь идти дальше.";
                }
                rightRow.add("Вернуться в поле");
                placeNow = "MidleAges";
                merlinSpell = true;
                return "Отлично, ты решила все загадки, давай посмотрим, что же ты будешь делать дальше." +
                        "О, я знаю! Я дам тебе одно заклинание - оно поможет тебе в будующем!";
            case "Что?" :
                leftRow.clear();
                rightRow.clear();
                leftRow.add("Открыть глаза");
                placeNow = "Ancient";
                return "Cj dhtvtytv ns dct gjqvtim";
            case "Открыть дверь.":
                leftRow.clear();
                rightRow.clear();
                leftRow.add("Мы знакомы?");
                if (marlinCounter >= 3) {
                    rightRow.add("Мэрлин, мы уже друг другу как родные стали!");
                }
                return "Ты заходишь в замок и сразу с порога тебя встречает огромная картина на которой изображен рыцарь, достающий из камня меч." +
                        "Только ты задумалась, как сзади тебя окликивают и ты поворачиваешься. Перед тобой стоит высокий седовлассый мужчина в синем одеянии и смешной шляпе." +
                        "-Здравствуй дорогая моя, давно не виделись. Как твои путешествия?";
            default:
                return "мимо, попробуй еще раз";

        }
    }
}
