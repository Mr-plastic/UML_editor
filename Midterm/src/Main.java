import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToggleButton;


public class Main {

	private JFrame frame;
	public static Canvas can;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
		     		e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
//-------------------- frame---------------------------------------------------------------
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
//-------------------- Canvas---------------------------------------------------------------
		can = new Canvas();
		frame.add(can);
//---------------------Button---------------------------------------------------------------------
		JToggleButton[] button_group = new Classicbutton[6];
		button_group[0] = new SelectButton();
		button_group[1] = new AssocButton();
		button_group[2] = new GeneralButton();
		button_group[3] = new CompositButton();
		button_group[4] = new ClassButton();
		button_group[5] = new UseCaseButton();
		ButtonGroup buttongruop = new ButtonGroup();
		for(int i = 0 ; i < 6 ;i++) {
			buttongruop.add(button_group[i]);
			frame.getContentPane().add(button_group[i]);
		}
		button_group[0].addActionListener( (ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				can.setState(((Classicbutton) button_group[0]).get_id());
			}
		});
		button_group[1].addActionListener( (ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setState(((Classicbutton) button_group[1]).get_id());
			}
		});	
		button_group[2].addActionListener( (ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setState(((Classicbutton) button_group[2]).get_id());
			}
		});	
		button_group[3].addActionListener( (ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setState(((Classicbutton) button_group[3]).get_id());
			}
		});	
		button_group[4].addActionListener( (ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setState(((Classicbutton) button_group[4]).get_id());
			}
		});	
		button_group[5].addActionListener( (ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setState(((Classicbutton) button_group[5]).get_id());
			}
		});	
//----------------------Menu-------------------------------------------------------------------------------		
		JMenu menu = new Menu(can,frame,"File","Edit");
	}
}
