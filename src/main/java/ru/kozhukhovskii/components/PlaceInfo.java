package ru.kozhukhovskii.components;

import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

/**
 * TODO: comment
 *
 * @author vempari 01.01.2020   18:37
 */
public interface PlaceInfo {
    public String getPlace();
    public String doAction(ArrayList<KeyboardRow> keyboard, KeyboardRow leftRow, KeyboardRow rightRow, String text);
}
