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

public class CadastroFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfSetor;
	private JTextField tfCod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionario frame = new CadastroFuncionario();
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
	public CadastroFuncionario() {
		setTitle("Cadastro dos Funcionarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbNome = new JLabel("Nome completo:");
		lbNome.setBounds(52, 37, 120, 14);
		contentPane.add(lbNome);
		
		JLabel lbCod = new JLabel("Código de verificação:");
		lbCod.setBounds(52, 111, 142, 14);
		contentPane.add(lbCod);
		
		JLabel lbSetor = new JLabel("Setor:");
		lbSetor.setBounds(52, 75, 46, 14);
		contentPane.add(lbSetor);
		
		tfNome = new JTextField();
		tfNome.setBounds(182, 34, 195, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfSetor = new JTextField();
		tfSetor.setBounds(182, 72, 195, 20);
		contentPane.add(tfSetor);
		tfSetor.setColumns(10);
		
		tfCod = new JTextField();
		tfCod.setBounds(182, 108, 195, 20);
		contentPane.add(tfCod);
		tfCod.setColumns(10);
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (tfNome.getText().trim().isEmpty() || tfSetor.getText().trim().isEmpty() || tfCod.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Você precisa preenxer todos os campus");
				} else {
					JOptionPane.showMessageDialog(null, "Você está cadastrado, clique no botão entrar");
				}
				
			}
		});
		btCadastrar.setBounds(62, 167, 120, 23);
		contentPane.add(btCadastrar);
		
		JButton btEntrar = new JButton("Entrar");
		btEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEntrarFuncionario ent = new TelaEntrarFuncionario();
				
				if (tfNome.getText().trim().isEmpty() || tfSetor.getText().trim().isEmpty() || tfCod.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Você precisa preenxer todos os campus");
				} else {
					ent.setVisible(true);
				}
				
			}
		});
		btEntrar.setBounds(230, 167, 120, 23);
		contentPane.add(btEntrar);
	}
}
