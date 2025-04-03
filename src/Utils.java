import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Utils {
    public static final String NOME_ARQUIVO = "ElectronicsStore.dados";
    @SuppressWarnings("finally")
    public static ArrayList<Electronic> recuperaEletronico (){
        ArrayList<Electronic> eletronicoTemp = new ArrayList<Electronic>();

        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream
                    (new FileInputStream(NOME_ARQUIVO));
            Object obj = null;
            while ((obj = inputStream.readObject()) != null) {
                if (obj instanceof Electronic) {
                    eletronicoTemp.add((Electronic) obj);
                }
            }
        } catch (EOFException ex) {
            System.out.println("Recuperação dos dados do arquivo "+ NOME_ARQUIVO + " concluída com sucesso.");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"O Banco de Dados ainda não foi criado! \n\nInclua um novo produto e salve os dados. \nNa proxima vez que você abrir o sistema, os dados serão recuperados automáticamente.");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
            return eletronicoTemp;
        }
    }

    public static void salvaEletronico (ArrayList<Electronic> eletronico){
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream
                    (new FileOutputStream(NOME_ARQUIVO));
            for (int i=0; i < eletronico.size(); i++)
                outputStream.writeObject(eletronico.get(i));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Impossível criar arquivo de Banco de Dados !");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
