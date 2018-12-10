import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class AplicacaoExercicio04 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNumUsuarios;

	ControleRepositorioUsuarios usuarios;
	private JTextField textFieldNomeUsuario;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacaoExercicio04 frame = new AplicacaoExercicio04();
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
	public AplicacaoExercicio04() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumUsuarios = new JLabel("N\u00FAmero de usu\u00E1rios");
		lblNumUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumUsuarios.setBounds(10, 0, 184, 36);
		contentPane.add(lblNumUsuarios);
		
		textFieldNumUsuarios = new JTextField();
		textFieldNumUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumUsuarios.setBounds(10, 34, 65, 20);
		contentPane.add(textFieldNumUsuarios);
		textFieldNumUsuarios.setColumns(10);
		
		JPanel panelControle = new JPanel();
		panelControle.setVisible(false);
		panelControle.setBounds(10, 65, 180, 185);
		contentPane.add(panelControle);
		panelControle.setLayout(null);
		
		JPanel panelSaida = new JPanel();
		panelSaida.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panelSaida.setVisible(false);
		panelSaida.setBounds(204, 11, 220, 239);
		contentPane.add(panelSaida);
		
		JButton btnConfirma = new JButton("Confirma");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNumUsuarios.getText().length() > 0) {
					int tamanho = Integer.parseInt(textFieldNumUsuarios.getText());
					if(tamanho > 0 ) {	//falta criar o controle de instancia
						usuarios = new ControleRepositorioUsuarios(tamanho);
						panelControle.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "O número de usuários tem que ser maior que zero!");
					}					
				}
			}
		});
		btnConfirma.setBounds(85, 33, 105, 23);
		contentPane.add(btnConfirma);
		
		JPanel panelPermissoes = new JPanel();
		panelPermissoes.setBounds(5, 55, 170, 60);
		panelControle.add(panelPermissoes);
		panelPermissoes.setLayout(null);
		
		JLabel lblAdministrador = new JLabel("Permiss\u00F5es:");
		lblAdministrador.setBounds(10, 5, 92, 14);
		panelPermissoes.add(lblAdministrador);
		
		JLabel lblLogar = new JLabel("- Logar");
		lblLogar.setBounds(35, 20, 46, 14);
		panelPermissoes.add(lblLogar);
		
		JLabel lblManterCadastro = new JLabel("- Manter Cadastro");
		lblManterCadastro.setBounds(35, 35, 125, 14);
		panelPermissoes.add(lblManterCadastro);
		
		JLabel lblConsultarCadastro = new JLabel("- Consultar cadastro");
		lblConsultarCadastro.setVisible(false);
		lblConsultarCadastro.setBounds(35, 35, 135, 14);
		panelPermissoes.add(lblConsultarCadastro);
		panelSaida.setLayout(null);
		
		JComboBox comboBoxPerfil = new JComboBox();
		comboBoxPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomePerfil = (String)comboBoxPerfil.getSelectedItem();
				if(nomePerfil.equals("Administrador")) {
					lblConsultarCadastro.setVisible(false);
					lblManterCadastro.setVisible(true);
				} else {			//Consultor
					lblManterCadastro.setVisible(false);
					lblConsultarCadastro.setVisible(true);
				}
			}
		});
		
		comboBoxPerfil.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Consultor"}));
		comboBoxPerfil.setBounds(40, 6, 135, 22);
		panelControle.add(comboBoxPerfil);
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setHorizontalAlignment(SwingConstants.LEFT);
		lblPerfil.setBounds(5, 10, 35, 14);
		panelControle.add(lblPerfil);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setBounds(5, 35, 35, 14);
		panelControle.add(lblNome);
		
		textFieldNomeUsuario = new JTextField();
		textFieldNomeUsuario.setBounds(40, 31, 135, 20);
		panelControle.add(textFieldNomeUsuario);
		textFieldNomeUsuario.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 11));
		btnCadastrar.setForeground(Color.RED);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeUsuario = textFieldNomeUsuario.getText();
				if(nomeUsuario.length() > 0) {
					String nomePerfil = (String)comboBoxPerfil.getSelectedItem();
					
					Perfil perfil = new Perfil();
					perfil.setDescricao(nomePerfil);
					
					Permissao[] permissoes = new Permissao[2];
					permissoes[0] = new Permissao();
					permissoes[1] = new Permissao();
					
					permissoes[0].setId("0");
					permissoes[0].setNome("Logar");
					permissoes[0].setObservacao("Habilita o login do sistema");
					if(nomePerfil.equals("Administrador")) {
						permissoes[1].setId("1");
						permissoes[1].setNome("Manter cadastro");
						permissoes[1].setObservacao("Habilita a inserção e alteração dos dados");						
					} else {			//Consultor
						permissoes[1].setId("2");
						permissoes[1].setNome("Consultar cadastro");
						permissoes[1].setObservacao("Habilita apenas a consulta dos dados do cadastro");												
					}
					perfil.setPermissoes(permissoes);
					
					Usuario usuario = new Usuario(perfil, nomeUsuario);
					try {
						usuarios.inserir(usuario);
						JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
					} catch (UsuarioJaCadastradoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMensagem());
					} catch (LimiteUsuarioExcedidoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMensagem());
					}
						
				} else {
					JOptionPane.showMessageDialog(null, "O campo Nome não pode ser vazio!");
				}
			}
		});
		btnCadastrar.setBounds(5, 135, 170, 23);
		panelControle.add(btnCadastrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 220, 239);
		panelSaida.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeUsuario = textFieldNomeUsuario.getText();
				
				Usuario usuarioLocal = new Usuario();
				try {
					usuarioLocal = usuarios.buscar(nomeUsuario);
				} catch (UsuarioNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMensagem());
				}
				
				if(usuarioLocal != null) {
					panelSaida.setVisible(true);
					textArea.setText(usuarioLocal.toString());
				}
			}
		});
		btnBuscar.setBounds(5, 160, 80, 23);
		panelControle.add(btnBuscar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSaida.setVisible(true);
				textArea.setText(usuarios.toString());
			}
		});
		btnListar.setBounds(95, 160, 80, 23);
		panelControle.add(btnListar);
		
	}
}
