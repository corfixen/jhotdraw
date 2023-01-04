/**
 * @(#)PaletteFontChooserPreviewPanel.java
 *
 * <p>Copyright (c) 1996-2010 The authors and contributors of JHotDraw. You may not use, copy or
 * modify this file, except in compliance with the accompanying license terms.
 */
package org.jhotdraw.gui.plaf.palette;

import java.awt.*;
import javax.swing.plaf.LabelUI;

/**
 * PaletteFontChooserPreviewPanel.
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public class PaletteFontChooserPreviewPanel extends javax.swing.JPanel {

  private static final long serialVersionUID = 1L;

  /** Creates new form PaletteFontChooserPreviewPanel */
  public PaletteFontChooserPreviewPanel() {
    initComponents();
    previewLabel.setUI((LabelUI) PaletteLabelUI.createUI(previewLabel));
    previewLabel.setBackground(Color.WHITE);
    previewLabel.setForeground(Color.BLACK);
    previewLabel.setOpaque(true);
    setPreferredSize(new Dimension(100, 50));
    setMinimumSize(new Dimension(100, 50));
  }

  public void setSelectedFont(Font newValue) {
    if (newValue == null) {
      previewLabel.setText(
          (String) PaletteLookAndFeel.getInstance().get("FontChooser.nothingSelected"));
      previewLabel.setFont(getFont());
    } else {
      previewLabel.setText(beautifyName(newValue.getFontName()));
      previewLabel.setFont(newValue.deriveFont(24f));
    }
  }

  private String beautifyName(String name) {
    // 'Beautify' the name
    StringBuilder buf = new StringBuilder();
    char prev = name.charAt(0);
    buf.append(prev);
    for (int i = 1; i < name.length(); i++) {
      char ch = name.charAt(i);
      if (prev != ' ' && prev != '-' && Character.isUpperCase(ch) && !Character.isUpperCase(prev)
          || Character.isDigit(ch) && !Character.isDigit(prev)) {
        buf.append(' ');
      }
      buf.append(ch);
      prev = ch;
    }
    name = buf.toString();
    return name;
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    previewLabel = new javax.swing.JLabel();
    setLayout(new java.awt.BorderLayout());
    previewLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    add(previewLabel, java.awt.BorderLayout.CENTER);
  } // </editor-fold>//GEN-END:initComponents
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel previewLabel;
  // End of variables declaration//GEN-END:variables
}
