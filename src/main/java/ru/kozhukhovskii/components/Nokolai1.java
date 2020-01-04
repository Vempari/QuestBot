package ru.kozhukhovskii.components;

import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

/**
 * TODO: comment
 *
 * @author vempari 01.01.2020   18:16
 */
public class Nokolai1 implements PlaceInfo {
    @Override
    public String getPlace() {
        return null;
    }

    @Override
    public String doAction(ArrayList<KeyboardRow> keyboard, KeyboardRow leftRow, KeyboardRow rightRow, String text) {
        return null;
    }
}
