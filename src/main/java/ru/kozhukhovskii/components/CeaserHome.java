package ru.kozhukhovskii.components;

import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

import static ru.kozhukhovskii.Bot.placeNow;

/**
 * TODO: comment
 *
 * @author vempari 01.01.2020   18:15
 */
public class CeaserHome implements PlaceInfo {
    private String place = "CeaserHome";
    @Override
    public String getPlace() {
        return place;
    }

    @Override
    public String doAction(ArrayList<KeyboardRow> keyboard, KeyboardRow leftRow, KeyboardRow rightRow, String text) {
        switch (text) {
            case "Спросить о том где ты.":
                leftRow.clear();
                rightRow.clear();
                leftRow.add("Сказать правду");
                rightRow.add("Соврать");
                return "Ты в моих покоях, я хотел спросить откуда ты тут взялась? На тебе необычные наряды, кто ты?";
            case "Сказать правду":
                leftRow.clear();
                rightRow.clear();
                leftRow.add("Осмотреть огромную железную дверь");
                rightRow.add("Осмотреть бумаги лежащие на столе");
                return "Хммм... я даже не уверен, надо было ли мне знать это все. Ладно, надеюсь эти три остолопа смогут дерать язык за зубами," +
                        "да Брут? Ладно, я так понимаю тебе нужно найти какое-то знание, на самом деле у меня есть кое-что интересно. Я не совсем понимаю, что это, но может ты поймешь." +
                        "Тут написано - Неизбежность смерти отчасти смягчается тем, что мы не знаем, когда она настигнет нас" +
                        " в этой неопределенности есть нечто от бесконечности и того, что мы называем вечностью." +
                        "Может быть это как-то поможет. Вообщем чувствуй себя как дома.";
            case "Осмотреть бумаги лежащие на столе":
                return "Увы, но тут ничего интересного.";
            case "Осмотреть огромную железную дверь":
                leftRow.clear();
                rightRow.clear();
                rightRow.add("Открыть дверь");
                placeNow = "MidleAge";
                return "На двери нарисованны разные истории в одной из них ты разглядываешь цифры 1546";
            case "Соврать" :
                leftRow.clear();
                rightRow.clear();
                leftRow.add("Выбежать в дверь.");
                placeNow = "Ancient";
                return "Хммм... Ты не выглядишь как принцесса - лягушка, ты уверена, что это правда? Ладно, даже ответа не надо - стража - выкеньте её отсюда.";

            default:
                leftRow.clear();
                rightRow.clear();
                leftRow.add("Спросить о том где ты.");
                return "Ты приходишь в себя на очень неудобной кровате. Рядо с тобой стоят трое мужчин в белых одеждах" +
                        " и о чем-то усиленно спорят. Обрывками ты понимаешь, что они считают тебя как-то связанной с богами и очень важной фигурой." +
                        "Вдруг дверь в конце комнаты распахивается и оттуда входит статный мужчина средних лет." +
                        "Все вокруг прислоняют руку к груди и что-то выкрикивают. Мужчина их успокаивает и наклонившись к тебе говорит:" +
                        "-Я вижу ты уже проснулась, надеюсь ты сможешь сейчас погвоорить?";
        }
    }
}
