package net.lihui.app.plugin.thoughtworkscodereviewtools.ui;

import net.lihui.app.plugin.thoughtworkscodereviewtools.idea.store.TrelloBoardMember;
import net.lihui.app.plugin.thoughtworkscodereviewtools.idea.store.TrelloBoardMemberState;
import net.lihui.app.plugin.thoughtworkscodereviewtools.ui.dto.OwnerCheckboxDTO;

import javax.swing.*;
import java.util.List;

import static net.lihui.app.plugin.thoughtworkscodereviewtools.mapper.MemberMapper.MEMBER_MAPPER;

public class CodeReviewFeedbackPanel {
    private JPanel mainPanel;
    private JLabel ownerSelectionLabel;
    private JPanel ownerSelectionPanel;
    private JScrollPane ownerCheckboxScrollPanel;
    private JTable ownerListTable;
    private JPanel refreshOwnerListButtonPanel;
    private JButton refreshOwnerListButton;
    private JLabel feedbackLabel;
    private JTextField feedbackTextField;

    public CodeReviewFeedbackPanel() {
        List<TrelloBoardMember> trelloBoardMembers = TrelloBoardMemberState.getInstance().getState().getTrelloBoardMembers();
        OwnerCheckboxTableModel tableModel = new OwnerCheckboxTableModel(MEMBER_MAPPER.toDtoList(trelloBoardMembers));

        ownerListTable.setModel(tableModel);
        ownerListTable.setDefaultRenderer(OwnerCheckboxDTO.class, new TableCheckboxCellRenderer());
        ownerListTable.setDefaultEditor(OwnerCheckboxDTO.class, new TableCheckboxCellEditor());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public String getFeedback() {
        return feedbackTextField.getText();
    }
}