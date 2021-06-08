package calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class JFramel extends JFrame {

	/*
	 * As fotos que estão na pasta foram para teste, elas deram certo, só que estão
	 * muito grandes para serem colocadas na calculadora
	 */
	private JPanel contentPane;
	private JTextField tfResultado;
	private JTextField tfNumero;
	private final ButtonGroup bgNumeros = new ButtonGroup();
	private final ButtonGroup bgOperacoes = new ButtonGroup();
	private JCheckBox chckbxMultiplicacao;
	private JCheckBox chckbxDivisao;
	private JCheckBox chckbxAdicao;
	private JCheckBox chckbxSubtracao;
	double resultado = 0;
	double valorSelecionar = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramel frame = new JFramel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFramel() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFramel.class.getResource("/logoGoverno.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/* PANEL PARA DIGITAR O VALOR */
		JPanel panelDigiteOValor = new JPanel();
		panelDigiteOValor.setBorder(new LineBorder(Color.BLUE));
		panelDigiteOValor.setForeground(Color.WHITE);
		panelDigiteOValor.setBounds(32, 32, 362, 97);
		contentPane.add(panelDigiteOValor);
		panelDigiteOValor.setLayout(null);

		JLabel lblDigiteUmValor = new JLabel("Digite um valor:");
		lblDigiteUmValor.setBounds(30, 44, 140, 14);
		panelDigiteOValor.add(lblDigiteUmValor);

		tfNumero = new JTextField();
		tfNumero.setHorizontalAlignment(SwingConstants.CENTER);
		tfNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfNumero.setBounds(209, 28, 122, 43);
		tfNumero.setColumns(10);
		panelDigiteOValor.add(tfNumero);

		/* PANEL SELECIONE A OPERAÇÃO COM CHECK BOX */
		JPanel panelSelecioneOperacao = new JPanel();
		panelSelecioneOperacao.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255)),
				"Selecione uma opera\u00E7\u00E3o:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSelecioneOperacao.setBounds(32, 140, 362, 122);
		contentPane.add(panelSelecioneOperacao);
		panelSelecioneOperacao.setLayout(null);

		// JCheckBox chckbxAdicao = new JCheckBox("Adi\u00E7\u00E3o");
		chckbxAdicao = new JCheckBox("Adi\u00E7\u00E3o");
		bgOperacoes.add(chckbxAdicao);
		chckbxAdicao.setBounds(30, 28, 97, 23);
		panelSelecioneOperacao.add(chckbxAdicao);

		chckbxSubtracao = new JCheckBox("Subtra\u00E7\u00E3o");
		bgOperacoes.add(chckbxSubtracao);
		chckbxSubtracao.setBounds(30, 72, 97, 23);
		panelSelecioneOperacao.add(chckbxSubtracao);

		chckbxMultiplicacao = new JCheckBox("Multiplica\u00E7\u00E3o");
		bgOperacoes.add(chckbxMultiplicacao);
		chckbxMultiplicacao.setBounds(200, 28, 117, 23);
		panelSelecioneOperacao.add(chckbxMultiplicacao);

		chckbxDivisao = new JCheckBox("Divis\u00E3o");
		bgOperacoes.add(chckbxDivisao);
		chckbxDivisao.setBounds(200, 72, 97, 23);
		panelSelecioneOperacao.add(chckbxDivisao);

		/* PANEL SELECIONAR O NÚMERO RADIO BUTTON */

		JPanel panelSelecioneNumero = new JPanel();
		panelSelecioneNumero.setForeground(Color.BLACK);
		panelSelecioneNumero.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255)),
				"Selecione um n\u00FAmero:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSelecioneNumero.setBounds(32, 273, 362, 138);
		contentPane.add(panelSelecioneNumero);
		panelSelecioneNumero.setLayout(null);

		/* CRIAÇÃO DOS RADIOS BUTTONS DE 1 A 9 */
		JRadioButton rdbtn1 = new JRadioButton("1");
		rdbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcular(1);
			}
		});
		bgNumeros.add(rdbtn1);
		rdbtn1.setBounds(19, 27, 56, 23);
		panelSelecioneNumero.add(rdbtn1);

		JRadioButton rdbtn2 = new JRadioButton("2");
		rdbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular(2);
			}
		});
		bgNumeros.add(rdbtn2);
		rdbtn2.setBounds(19, 53, 93, 23);
		panelSelecioneNumero.add(rdbtn2);

		JRadioButton rdbtn3 = new JRadioButton("3");
		rdbtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular(3);
			}
		});
		bgNumeros.add(rdbtn3);
		rdbtn3.setBounds(19, 79, 93, 23);
		panelSelecioneNumero.add(rdbtn3);

		JRadioButton rdbtn4 = new JRadioButton("4");
		rdbtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular(4);
			}
		});
		bgNumeros.add(rdbtn4);
		rdbtn4.setBounds(135, 27, 93, 23);
		panelSelecioneNumero.add(rdbtn4);

		JRadioButton rdbtn5 = new JRadioButton("5");
		rdbtn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular(5);
			}
		});
		bgNumeros.add(rdbtn5);
		rdbtn5.setBounds(135, 53, 93, 23);
		panelSelecioneNumero.add(rdbtn5);

		JRadioButton rdbtn6 = new JRadioButton("6");
		rdbtn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular(6);
			}
		});
		bgNumeros.add(rdbtn6);
		rdbtn6.setBounds(135, 79, 93, 23);
		panelSelecioneNumero.add(rdbtn6);

		JRadioButton rdbtn7 = new JRadioButton("7");
		rdbtn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular(7);
			}
		});
		bgNumeros.add(rdbtn7);
		rdbtn7.setBounds(263, 27, 93, 23);
		panelSelecioneNumero.add(rdbtn7);

		JRadioButton rdbtn8 = new JRadioButton("8");
		rdbtn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular(8);
			}
		});
		bgNumeros.add(rdbtn8);
		rdbtn8.setBounds(263, 53, 93, 23);
		panelSelecioneNumero.add(rdbtn8);

		JRadioButton rdbtn9 = new JRadioButton("9");
		rdbtn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular(9);
			}
		});
		bgNumeros.add(rdbtn9);
		rdbtn9.setBounds(263, 79, 93, 23);
		panelSelecioneNumero.add(rdbtn9);

		/* PANEL RESULTADO */
		JPanel panelResultado = new JPanel();
		panelResultado.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255)), "Resultado:",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelResultado.setBounds(32, 431, 362, 97);
		contentPane.add(panelResultado);
		panelResultado.setLayout(null);

		/* BOTÃO PARA APAGAR */
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfResultado.setText(null);
				tfNumero.setText(null);
				tfResultado.setText(null);
				bgNumeros.clearSelection();
				bgOperacoes.clearSelection();
				tfNumero.requestFocus();
				tfNumero.setEditable(true);
			}
		});
		btnApagar.setBounds(239, 21, 89, 23);
		panelResultado.add(btnApagar);

		/* BOTÃO PARA ENCERRAR */
		JButton btnEncerrar = new JButton("Encerrar");
		btnEncerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEncerrar.setBounds(239, 55, 89, 23);
		panelResultado.add(btnEncerrar);

		/* BOTÃO PARA RESULTADO */
		tfResultado = new JTextField();
		tfResultado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfResultado.setHorizontalAlignment(SwingConstants.CENTER);
		tfResultado.setEditable(false);
		tfResultado.setBounds(50, 21, 111, 57);
		panelResultado.add(tfResultado);
		tfResultado.setColumns(10);

	}

	/* FIM DO PANEL RESULTADO */

	public void calcular(double valorSelecionar) {
		double numero = Double.parseDouble(tfNumero.getText());
		if (chckbxMultiplicacao.isSelected()) {
			resultado = numero * valorSelecionar;
			exibir();
		} else if (chckbxDivisao.isSelected()) {
			resultado = numero / valorSelecionar;
			exibir();
		} else if (chckbxAdicao.isSelected()) {
			resultado = numero + valorSelecionar;
			exibir();
		} else if (chckbxSubtracao.isSelected()) {
			resultado = numero - valorSelecionar;
			exibir();
		} else {
			limpar();
		}
	}

	public void exibir() {
		tfResultado.setText(String.valueOf(resultado));
	}

	public void limpar() {
		tfNumero.setText(null);
		tfNumero.requestFocus();
		tfNumero.setEditable(true);
		tfResultado.setText(null);
		bgNumeros.clearSelection();
		bgOperacoes.clearSelection();

	}
}
