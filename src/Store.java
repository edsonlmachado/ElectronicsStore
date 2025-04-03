import javax.swing.*;
import java.awt.GridBagLayout;
import java.util.ArrayList;

/**
  Projeto Aplicativo da Disciplica de Fundamentos da Programação Orientada a Objetos (POO)
  @author Edson Luiz Machado
  @version 1.00
  @since Release 1
 **/

public class Store {
    static String descTipoSelecionado = "";

    private static ArrayList<Electronic> listaEletronicos;

    public Store() {
        this.listaEletronicos = new ArrayList<Electronic>();
    }

    public static void main(String[] args) {
        Store store = new Store();
        store.menuElectronicsStore();
    }

    public String leCampoObjetoFilho(String nomeCampo) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("\n\ndescrição do " + nomeCampo + ":");
        panel.add(label);
        JTextField field = new JTextField(20);
        panel.add(field);
        String[] options = new String[]{"Continuar"};

        String.valueOf(JOptionPane.showOptionDialog(null, panel, "Entrada de " + descTipoSelecionado,
                JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0])).toString();

        return field.getText();
    }

    public void setCampoOjetoPaiComuns(Electronic electronic) {
        electronic.setTipo(descTipoSelecionado);
        electronic.setNome(leCampoObjetoFilho("Produto"));
        electronic.setMarca(leCampoObjetoFilho("Marca"));
        String anoModelo = leCampoObjetoFilho("Ano de Fabricação");
        electronic.setTela(leCampoObjetoFilho("Tamanho da Tela"));
        electronic.setModelo(this.retornarAno(anoModelo));
    }

    public Smartwatch leSmartwatch() {
        Smartwatch smartwatch = new Smartwatch();
        setCampoOjetoPaiComuns(smartwatch);
        smartwatch.setCores(leCampoObjetoFilho("Cores"));
        return smartwatch;
    }

    public Smartphone leSmartphone() {
        Smartphone smartphone = new Smartphone();
        setCampoOjetoPaiComuns(smartphone);
        smartphone.setEspecificacoesTecnicas(leCampoObjetoFilho("Especificações Técnicas"));
        return smartphone;
    }

    public Computer leComputer() {
        Computer computer = new Computer();
        setCampoOjetoPaiComuns(computer);
        computer.setPerifericos(leCampoObjetoFilho("Periféricos"));
        return computer;
    }

    public Notebook leNotebook() {
        Notebook notebook = new Notebook();
        setCampoOjetoPaiComuns(notebook);
        notebook.setAcessorios(leCampoObjetoFilho("Acessórios"));
        return notebook;
    }

    private boolean verificarInteiro(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int retornarInteiro(String entrada) {
        JTextField field = null;
        while (!this.verificarInteiro(entrada)) {

            JPanel panel = new JPanel();
            JLabel label = new JLabel("Entre com a opção de " + descTipoSelecionado + "(Ex. 1,2,3...): ");
            panel.add(label);
            field = new JTextField(20);
            panel.add(field);
            String[] options = new String[]{"Continuar"};

            String.valueOf(JOptionPane.showOptionDialog(null, panel, "Atenção! A opção de " + descTipoSelecionado + " selecionado ( " + entrada + " ) Não é válida, verifique! ",
                    JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0])).toString();
            entrada = field.getText();;
        }
        return Integer.parseInt(entrada);
    }

    private boolean verificarAno(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int retornarAno(String entrada) {

        JTextField field = null;
        while (!this.verificarAno(entrada)) {

            JPanel panel = new JPanel();
            JLabel label = new JLabel("Entre com o ano de fabricação (Ex. 2022,2014,2018...): ");
            panel.add(label);
            field = new JTextField(20);
            panel.add(field);
            String[] options = new String[]{"Continuar"};
            String.valueOf(JOptionPane.showOptionDialog(null, panel, "Cadastro de " + descTipoSelecionado + " Atenção! O ano de fabricação ( " + entrada + " ) Não é válido, verifique! ",
                    JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0])).toString();
            entrada = field.getText();
        }
        return Integer.parseInt(entrada);
    }

    private static boolean validarListaVazia(String mensagem) {
        if (listaEletronicos.isEmpty()) {
            JOptionPane.showMessageDialog(null, mensagem);
            return true;
        }
        return false;
    }
    public void menuElectronicsStore() {
        int selecionadoMenu, selecionadoTipo;
        String menu = "";
        String entrada;
        listaEletronicos = Utils.recuperaEletronico();

        do {
            menu = "Bem vindo à Electronics Store\n\n" +
                    "Menu Principal: \n" +
                    "_________________________________________\n" +
                    "1. Incluir dados\n" +
                    "2. Exibir dados\n" +
                    "3. Limpar dados\n\n" +

                    "Banco de Dados:\n" +
                    "_________________________________________\n" +
                    "4. Gravar (Salvar os dados) \n" +
                    "5. Importar (Recuperar dados Salvos)\n\n" +

                    "_________________________________________\n" +
                    "9. Sair do Sistema\n" +
                    "0. Sobre\n\n" +

                    "dicas úteis! \n    Use a tecla tab para navegar entre os itens da tela. " +
                    " \n    Após selecionar um item ou após digitar um valor, \n    tecle ENTER para ir para o proximo passo. ";

            entrada = JOptionPane.showInputDialog(menu + "\n\n");
            descTipoSelecionado = "Menu";
            selecionadoMenu = this.retornarInteiro(entrada);

            switch (selecionadoMenu) {
                case 1:
                    descTipoSelecionado = "Tipo";
                    Object[] tiposEletronicos = { "Smartphone","Smartwatch","Computer","Notebook" };
                    JPanel panel = new JPanel(new GridBagLayout());
                    JComboBox comboBoxType = new JComboBox(tiposEletronicos);
                    comboBoxType.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, comboBoxType, "Selecione um Tipo de Eletrônico",
                            JOptionPane.INFORMATION_MESSAGE);
                    panel.add(comboBoxType);
                    entrada = String.valueOf(comboBoxType.getSelectedIndex());
                    descTipoSelecionado = String.valueOf(comboBoxType.getSelectedItem());

                    if (entrada != "") {
                        selecionadoTipo = this.retornarInteiro(entrada) + 1;
                        Electronic electronic = null;

                        switch (selecionadoTipo) {
                            case 1:
                                electronic = leSmartphone();
                                break;
                            case 2:
                                electronic = leSmartwatch();
                                break;
                            case 3:
                                electronic = leComputer();
                                break;
                            case 4:
                                electronic = leNotebook();
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Tipo de Eletrônico selecionado é inválido. \n\nO processo de cadastro de " + descTipoSelecionado + " foi cancelado.");
                        }

                        if(electronic!=null){
                            JOptionPane.showMessageDialog(null, descTipoSelecionado +" incluído com sucesso: \n\n "+ electronic.imprimirLista());
                            listaEletronicos.add(electronic);
                        }

                    }else if (entrada != ""){
                        JOptionPane.showMessageDialog(null, "Não foi informado um Tipo de Eletrônico selecionado válido. \n\nO processo de cadastro de " + descTipoSelecionado + " foi cancelado.");
                    }

                    break;
                case 2:
                    if (validarListaVazia("Não existe produtos cadatrados, verifique!")) break;
                    StringBuilder dados = new StringBuilder();

                    for (Electronic eletronico : listaEletronicos) {
                        dados.append(eletronico.imprimirLista() + "\n");
                        dados.append("...\n");
                    }
                    JOptionPane.showMessageDialog(null, dados.toString());
                    break;
                case 3:
                    if (validarListaVazia("Não existe produtos cadatrados, verifique!")) break;
                    listaEletronicos.clear();
                    JOptionPane.showMessageDialog(null, "Banco de dados eliminado com sucesso!");
                    break;
                case 4:
                    if (validarListaVazia("Não existe produtos cadatrados, verifique!")) break;
                    Utils.salvaEletronico(listaEletronicos);
                    JOptionPane.showMessageDialog(null, "Dados Gravados com sucesso!");
                    break;
                case 5:
                    listaEletronicos = Utils.recuperaEletronico();
                    if (validarListaVazia("Sem dados para mostrar.")) break;
                    JOptionPane.showMessageDialog(null, "Banco de Dados Recuperado com sucesso!");
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Electronics Store \n\nFim da execução do sistema. ");
                    break;
                case 0:
                    String about = "About Electronics Store\n\n" +
                            "Electronics Store 2022 (Beta Edition)  \n" +

                            "Build #1.00, built on November 20, 2022\n\n\n" +
                            "Runtime version:1.00-08:27 amd64 \n" +
                            "VM: OpenJDK 64-bit Server VM by JetBrains Build #IC-222.4345.14, October 5,2022\n\n" +

                            "Powered by Student Edson Luiz Machado RA:1112022208857\n" +
                            "Institution PUCPR - Pontifícia Universidade Católica do Paraná\n" +
                            "Course Superior de Tecnologia em Gestão da Tecnologia da Informação\n" +
                            "Subject Raciocínio Computacional\n" +
                            "Activity ATIVIDADE SOMATIVA 2\n\n" +
                            "Teacher Author: \n" +
                            "   Cristina Verçosa Perez Barrios de Souza \n" +
                            "   Vinícius Godoy de Mendonça\n\n" +
                            "Copyright © 2022 Edson Luiz Machado " ;

                    JOptionPane.showMessageDialog(null, about);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção de Menu selecionado é inválido. Verifique.");
            }
        }
        while (selecionadoMenu != 9);

    }
}

