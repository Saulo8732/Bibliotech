package br.com.bibliotech.view;

import java.awt.Color;
import javax.swing.JPanel;

public class TelaUtils {
    public static Color corClara = new java.awt.Color(50, 181, 120);
    public static Color corEscura = new java.awt.Color(38, 169, 108);
    
    public static void setBotaoClaro(JPanel jpanel){
        jpanel.setBackground(corClara);
    }
    
    public static void setBotaoEscuro(JPanel jpanel){
        jpanel.setBackground(corEscura);
    }
    
    /*
    adicionando nova linha a tabela
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.addRow(new Object[]{"1", "as", "as", "as"});
    */
    
}
