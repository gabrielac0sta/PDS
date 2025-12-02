package cadastro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cadastro() {
		
		setTitle("Tela geral");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 255, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbCategoria = new JLabel("Escolha sua categoria:");
		lbCategoria.setBounds(47, 48, 138, 14);
		contentPane.add(lbCategoria);
		
		JRadioButton rbFun = new JRadioButton("Funcionario");
		rbFun.setBounds(47, 80, 109, 23);
		contentPane.add(rbFun);
		
		JRadioButton rbCliente = new JRadioButton("Cliente");
		rbCliente.setBounds(47, 114, 109, 23);
		contentPane.add(rbCliente);
		
		ButtonGroup categoria = new ButtonGroup();
		categoria.add(rbCliente);
		categoria.add(rbFun);
		
		JButton btEntrar = new JButton("Entrar");
		btEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroFuncionario fun = new CadastroFuncionario();
				CadastroCliente cliente = new CadastroCliente();
				
				if (rbFun.isSelected()) {
					fun.setVisible(true);
					
				} else if (rbCliente.isSelected()){
					cliente.setVisible(true);
					
				} else {
					JOptionPane.showConfirmDialog(null, "Selecione um campo vaziu");
				}
			}
		});
		btEntrar.setBounds(76, 185, 89, 23);
		contentPane.add(btEntrar);
		
		setLocationRelativeTo(null);
	}
}
