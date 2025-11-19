package cadastro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNomeClt;
	private JTextField tfCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				CadastroCliente frame = new CadastroCliente();
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Cadastro cad = new Cadastro();
//				if () {
//					
//				}
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroCliente() {
		setTitle("Cadastro dos clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setBounds(50, 38, 46, 14);
		contentPane.add(lbNome);
		
		JLabel lbCPF = new JLabel("CPF:");
		lbCPF.setBounds(50, 75, 46, 14);
		contentPane.add(lbCPF);
		
		tfNomeClt = new JTextField();
		tfNomeClt.setBounds(125, 35, 180, 20);
		contentPane.add(tfNomeClt);
		tfNomeClt.setColumns(10);
		
		
		
		tfCPF = new JTextField();
		tfCPF.setBounds(125, 72, 180, 20);
		contentPane.add(tfCPF);
		tfCPF.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tfNomeClt.getText().trim().isEmpty() || tfCPF.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Você precisa preenxer todos os campus");
				} else {
					JOptionPane.showMessageDialog(null, "Você está cadastrado!");
				}
				
				
			}
		});
		btnNewButton.setBounds(48, 131, 112, 23);
		contentPane.add(btnNewButton);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEntrarCliente ent = new TelaEntrarCliente();
				
				ent.setVisible(true);
			}
		});
		btnEntrar.setBounds(193, 131, 112, 23);
		contentPane.add(btnEntrar);
	}

}
