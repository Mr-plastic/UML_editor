import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;



public class Classicbutton extends JToggleButton {
	protected Icon img;
	protected String path = "./img/";
	protected int id;
	void set_Bounds() {};
	int get_id() {return this.id;};
};

class SelectButton extends Classicbutton{
	Icon img = new ImageIcon(path+"mouse_cursor.png");
	SelectButton(){
		this.setIcon(img);
		this.setBounds(0, 0, 80, 80);
		this.id = 0;
	}

};
class AssocButton extends Classicbutton{
	Icon img = new ImageIcon(path+"right_arrow.png");
	AssocButton(){
		this.setIcon(img);
		this.setBounds(0, 80, 80, 80);
		this.id = 1;
	}
};
class GeneralButton extends Classicbutton{
	Icon img = new ImageIcon(path+"general.png");
	GeneralButton(){
		this.setIcon(img);
		this.setBounds(0, 160, 80, 80);
		this.id = 2;
	}

};
class CompositButton extends Classicbutton{
	Icon img = new ImageIcon(path+"curved_arrow.png");
	CompositButton(){
		this.setIcon(img);
		this.setBounds(0, 240, 80, 80);
		this.id = 3;
	}

};
class ClassButton extends Classicbutton{
	Icon img = new ImageIcon(path+"class.png");
	ClassButton(){
		this.setIcon(img);
		this.setBounds(0, 320, 80, 80);
		this.id = 4;
	}

};
class UseCaseButton extends Classicbutton{
	Icon img = new ImageIcon(path+"case.png");
	UseCaseButton(){
		this.setIcon(img);
		this.setBounds(0, 400, 80, 80);
		this.id = 5;
	}

};



