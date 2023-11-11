package TELAS;


import javax.swing.JFrame;

import javax.swing.text.MaskFormatter;

public class GerenciamentoPedido extends JFrame {
	public static MaskFormatter Mascara(String Mascara){
		MaskFormatter F_Mascara = new MaskFormatter();
		try{
			F_Mascara.setMask(Mascara);
			F_Mascara.setPlaceholderCharacter(' ');
		}
		catch (Exception excecao) {
		excecao.printStackTrace();
		}
		return F_Mascara;
 	}
}