package ru.kozhukhovskii.components;

import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

import static ru.kozhukhovskii.Bot.placeNow;
import static ru.kozhukhovskii.components.Ancient.ancientWord;

/**
 * TODO: comment
 *
 * @author vempari 01.01.2020   18:11
 */
public class MidleAges implements PlaceInfo {
    private String place = "MidleAges";
    public static boolean merlinSpell = false;

    @Override
    public String getPlace() {
        return place;
    }



    @Override
    public String doAction(ArrayList<KeyboardRow> keyboard, KeyboardRow leftRow, KeyboardRow rightRow, String text) {
        switch (text) {
            case "Осмотреться вокруг.":
                leftRow.clear();
                rightRow.clear();
                leftRow.add("Пойти к зданиям.");
                rightRow.add("Пойти к замку");
                return "Ты оглядываешься вокруг и вдалеке видишь огромный замок," +
                        " отличная возможность познакомиться с его обитателями!";
            case "Пойти к замку":
                leftRow.clear();
                rightRow.clear();
                if (ancientWord) rightRow.add("АБЕРОЙ");
                leftRow.add("Пойти к зданиям.");
                return "Около замка тебя встречает охрана." +
                        "-Вход запрещен! Говори пароль!";
            case "АБЕРОЙ":
                leftRow.clear();
                rightRow.clear();
                leftRow.add("Открыть дверь.");
                placeNow = "KingArthurCastle";
                return "Прошу, можете войти внутрь!";
            case "Пойти к зданиям.":
                leftRow.clear();
                rightRow.clear();
                leftRow.add("Сказать, что ты пришелец с другой планеты");
                rightRow.add("Сказать, что ты из службы судебных приставов, и пришла их всех арестовать");
                leftRow.add("Cказать, что ты тут случайно оказалась");
                rightRow.add("Сказать, что тебе нужна их одежда и мотоцикл");
                if (merlinSpell) {
                    leftRow.add("Произнести заклинания которое подарил Мерлин.");
                }

                leftRow.add("Убежать");
                return "Ты подходишь к зданиям и видишь застывших в изумлении людей, " +
                        "они одеты в какие-то лохмотья и очень напуганны. К тебе подходит один из крестьян и спрашивает:" +
                        "- Кто ты?";
            case "Произнести заклинания которое подарил Мерлин.":
                leftRow.clear();
                rightRow.clear();
                leftRow.add("Пойти к замку");
                return "Крестьяне внезапно встали как вкопанные, а ты смогла прошмыгнуть внутрь. " +
                        "Внутри здания ничего не было, только обованная бумажка с надписью: " +
                        "'То, что мы называем злом, является всего лишь неизбежностью в нашем бесконечном развитии.'";
            case "Сказать, что ты пришелец с другой планеты":
            case "Сказать, что ты из службы судебных приставов, и пришла их всех арестовать":
            case "Cказать, что ты тут случайно оказалась":
            case "Сказать, что тебе нужна их одежда и мотоцикл":
                leftRow.clear();
                rightRow.clear();
                leftRow.add("Открыть дверь.");
                placeNow = "Ancient";
                return "-Что она сказала?" +
                        "-Не знаю, видимо она ведьма! ВЕДЬМА!" +
                        "Толпа кинулась на тебя с вилами и факелами, у тебя не остается другово выбора как бежать." +
                        "Ты долго бежала вдаль пока не увидела дверь, похожую на ту, что ты видела в башне Льва." +
                        " Скорее открывай её - если не хочешь быть сожжённой заживо!";
            default:
                leftRow.add("Пойти к зданиям.");
                rightRow.add("Осмотреться вокруг.");
                return "Ты открываешь глаза и твоему взору предстоют огромные луга усеяные пшеницей, " +
                        "бескрайнее небо и пару зданий из дерева и соломы недалеко от тебя. Что будешь делать дальше?";

        }
    }

}
