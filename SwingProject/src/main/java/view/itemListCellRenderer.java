package view;
import javax.swing.*;
import java.awt.Component;
import model.character.*;

/**
 * Created by vindi on 4/29/2017.
 */
public class itemListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        if (value instanceof Item) {
            value = ((Item)value).getName();
        }

        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.

    }

}