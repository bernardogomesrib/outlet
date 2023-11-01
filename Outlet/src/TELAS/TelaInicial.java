package TELAS;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLayeredPane;
import javax.swing.BoxLayout;

import DATABASE.Conexao;
import TELAS.PAINEIS.ConsultaCliente;
import TELAS.PAINEIS.PanelCliente;
import TELAS.PAINEIS.PanelGerenciamentoProduto;
import DAO.ClienteComEnderecoDAO;
import DAO.ClienteDAO;
import DAO.EnderecoDAO;
import DAO.ItempedidoDAO;
import DAO.ProdutoDao;
import DAO.VendaDAO;


public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PainelInicial;
    private JLayeredPane layeredPane = new JLayeredPane();
    PanelCliente panelCliente = new PanelCliente(layeredPane);
	ConsultaCliente consultaCliente = new ConsultaCliente(layeredPane);
	PanelGerenciamentoProduto panelGerenciamentoProduto = new PanelGerenciamentoProduto(layeredPane);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
					Conexao con = new Conexao();
					ClienteDAO.start(con.getConexao());
					EnderecoDAO.start(con.getConexao());
					ClienteComEnderecoDAO.start(con.getConexao());
					ProdutoDao.start(con.getConexao());
					ItempedidoDAO.start(con.getConexao());
					VendaDAO.start(con.getConexao());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1080, 720);
		PainelInicial = new JPanel();
		PainelInicial.setBackground(new Color(255, 255, 255));
		PainelInicial.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PainelInicial);
		PainelInicial.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(170, 170, 170));
		menuBar.setBounds(0, 0, 152, 686);
		PainelInicial.add(menuBar);
		// Defina o layout do JMenuBar como BoxLayout na orientação Y (vertical)
        menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.Y_AXIS));
        
		JMenu mn_Cliente = new JMenu("Cliente");
		menuBar.add(mn_Cliente);
		
		JMenuItem mntm_ClienteGerenciamento = new JMenuItem("Gerenciamento");
		mntm_ClienteGerenciamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                limparpainel();                
				panelCliente.praFrente();

			}
		});
		mn_Cliente.add(mntm_ClienteGerenciamento);
		
		JMenuItem mntm_ClienteConsulta = new JMenuItem("Consulta");
		mntm_ClienteConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparpainel();
				consultaCliente.praFrente();
			}
		});
		mn_Cliente.add(mntm_ClienteConsulta);
		
		JMenu mn_Produto = new JMenu("Produto");
		menuBar.add(mn_Produto);
		
		JMenuItem mntm_ProdutoGerenciamento = new JMenuItem("Gerenciamento");
		mntm_ProdutoGerenciamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparpainel();
				panelGerenciamentoProduto.praFrente();
			}
		});
		mn_Produto.add(mntm_ProdutoGerenciamento);
		
		JMenuItem mntm_ProdutoConsulta = new JMenuItem("Consulta");
		mntm_ProdutoConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_Produto.add(mntm_ProdutoConsulta);
		
		JMenu mn_Estoque = new JMenu("Estoque");
		menuBar.add(mn_Estoque);
		
		JMenu mn_Pedido = new JMenu("Pedido");
		menuBar.add(mn_Pedido);
		
		JMenuItem mntm_PedidoGerenciamento = new JMenuItem("Gerenciamento");
		mntm_PedidoGerenciamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_Pedido.add(mntm_PedidoGerenciamento);
		
		JMenuItem mntm_PedidoConsulta = new JMenuItem("Consulta");
		mntm_PedidoConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_Pedido.add(mntm_PedidoConsulta);
		
		JMenu mn_Venda = new JMenu("Venda");
		menuBar.add(mn_Venda);
		
		JMenuItem mntm_VendaGerenciamento = new JMenuItem("Gerenciamento");
		mntm_VendaGerenciamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_Venda.add(mntm_VendaGerenciamento);
		
		JMenuItem mntm_VendaConsulta = new JMenuItem("Consulta");
		mntm_VendaConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_Venda.add(mntm_VendaConsulta);
		
		JMenu mn_Financeiro = new JMenu("Financeiro");
		menuBar.add(mn_Financeiro);
		
		JMenuItem mntm_ContasPagar = new JMenuItem("Contas a Pagar");
		mntm_ContasPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_Financeiro.add(mntm_ContasPagar);
		
		JMenuItem mntm_ContasReceber = new JMenuItem("Contas a Receber");
		mntm_ContasReceber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_Financeiro.add(mntm_ContasReceber);
		
		JMenu mn_EntradaMercadorias = new JMenu("Entrada de \nMercadoria");
		mn_EntradaMercadorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mn_EntradaMercadorias);
		
		JMenu mn_Relatorios = new JMenu("Relatórios");
		menuBar.add(mn_Relatorios);
		
		JMenu mn_Nada1 = new JMenu(" ");
		menuBar.add(mn_Nada1);
		JMenu mn_Nada2 = new JMenu(" ");
		menuBar.add(mn_Nada2);
		JMenu mn_Nada3 = new JMenu(" ");
		menuBar.add(mn_Nada3);
		JMenu mn_Nada4 = new JMenu(" ");
		menuBar.add(mn_Nada4);
		JMenu mn_Nada5 = new JMenu(" ");
		menuBar.add(mn_Nada5);
		JMenu mn_Nada6 = new JMenu(" ");
		menuBar.add(mn_Nada6);
		JMenu mn_Nada7 = new JMenu(" ");
		menuBar.add(mn_Nada7);
		JMenu mn_Nada8 = new JMenu(" ");
		menuBar.add(mn_Nada8);
		JMenu mn_Nada9 = new JMenu(" ");
		menuBar.add(mn_Nada9);
		JMenu mn_Nada10 = new JMenu(" ");
		menuBar.add(mn_Nada10);
		
		JMenu mn_Sair = new JMenu("Sair");
		mn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mn_Sair);
		
		layeredPane.setBackground(new Color(32, 215, 0));
		layeredPane.setBounds(164, 0, 910, 686);
		PainelInicial.add(layeredPane);
	}

    /**
     * 
     */

    
	
	public void limparpainel() {
		
        layeredPane.removeAll();
        layeredPane.repaint();
        layeredPane.revalidate();
    }
}