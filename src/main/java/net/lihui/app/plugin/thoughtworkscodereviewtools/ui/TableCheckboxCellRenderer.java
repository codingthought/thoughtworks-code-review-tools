package net.lihui.app.plugin.thoughtworkscodereviewtools.ui;

import net.lihui.app.plugin.thoughtworkscodereviewtools.ui.dto.OwnerCheckboxDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class TableCheckboxCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (table.getValueAt(row, column) == null) {
            return new JLabel();
        }
        OwnerCheckboxDTO ownerCheckboxDTO = (OwnerCheckboxDTO) value;
        return new JCheckBox(ownerCheckboxDTO.getFullName(), ownerCheckboxDTO.isSelected());
    }
}
