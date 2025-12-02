package cadastro;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TelaEntrarFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfProduto;
	private JTextField tfCodigo;
	private JTable table;
	private JTable tabela;
	
	DefaultTableModel tab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEntrarFuncionario frame = new TelaEntrarFuncionario();
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
	public TelaEntrarFuncionario() {
		setTitle("Tela do Funcionario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfProduto = new JTextField();
		tfProduto.setBounds(142, 11, 250, 20);
		contentPane.add(tfProduto);
		tfProduto.setColumns(10);
		
		JLabel lbProduto = new JLabel("Produto:");
		lbProduto.setBounds(23, 14, 109, 14);
		contentPane.add(lbProduto);
		
		JLabel lbCodigo = new JLabel("Código do produto:");
		lbCodigo.setBounds(23, 45, 109, 14);
		contentPane.add(lbCodigo);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(142, 42, 250, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 430, 200);
		contentPane.add(scrollPane);
		
		tabela = new JTable();
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (tabela.getSelectedRow() != -1) {
					tfProduto.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
					tfCodigo.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um produto");
				}
			}
		});
		
		tabela.setModel(new DefaultTableModel(
				new Object[][] {}, 
				new String[] {"Nome", "Código do produto"} 
			) {
				private static final long serialVersionUID = 1L;
				boolean[] columnEditables = new boolean[] { false, false, false, false };
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		
		scrollPane.setViewportView(tabela);
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tab = (DefaultTableModel) tabela.getModel();
				
				Object [] campusTabela = {tfProduto.getText(), tfCodigo.getText()}; 
				
				tab.addRow(campusTabela);
				
				tfProduto.setText("");
				tfCodigo.setText("");
				
				tfProduto.requestFocus();
			}
		});
		btCadastrar.setBounds(43, 100, 110, 23);
		contentPane.add(btCadastrar);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabela.getSelectedRow() != -1) {
					DefaultTableModel tab = (DefaultTableModel) tabela.getModel();
					
					tab.removeRow(tabela.getSelectedRow());
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um produto");
				}
				
				tfProduto.setText("");
				tfCodigo.setText("");
				
				tfProduto.requestFocus();
				
			}
		});
		btExcluir.setBounds(290, 100, 110, 23);
		contentPane.add(btExcluir);
		
		setLocationRelativeTo(null);
	}

}
