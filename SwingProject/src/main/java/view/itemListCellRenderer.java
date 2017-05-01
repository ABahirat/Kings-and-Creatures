package view;
import javax.swing.*;
import java.awt.Component;

import model.item;

/**
 * Created by vindi on 4/29/2017.
 */
public class itemListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        if (value instanceof item) {
            value = ((item)value).getName();
        }

        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.

    }

}