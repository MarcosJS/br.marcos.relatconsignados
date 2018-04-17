package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class HighlightLineTextPane extends JTextPane {
	  public HighlightLineTextPane() {
	    setOpaque(false);
	  }
	  public HighlightLineTextPane(StyledDocument d) {
			super(d);
		    setOpaque(false);
	  }
	  @Override
	  protected void paintComponent(Graphics g) {
	    g.setColor(getBackground());
	    g.fillRect(0, 0, getWidth(), getHeight());
	    try {
	      Rectangle rect = modelToView(getCaretPosition());
	      if (rect != null) {
	        g.setColor(new Color(230,230,255));
	        g.fillRect(0, rect.y, getWidth(), rect.height);
	      }
	    } catch (BadLocationException e) {
	      System.out.println(e);
	    }
	    super.paintComponent(g);
	  }

	  @Override
	  public void repaint(long tm, int x, int y, int width, int height) {
	    super.repaint(tm, 0, 0, getWidth(), getHeight());
	  }
	}
