package view;

import java.awt.Color;
import javax.swing.JButton;

public class ConfigButton extends JButton{

	private static final long serialVersionUID = 1L;

	public ConfigButton(String texto, Color color, Color colorTxt) {
		setText(texto);
		setBackground(color);
		setFocusable(false);
		setForeground(colorTxt);
		setBorder(null);
		setForeground(Color.BLACK);
	}
}