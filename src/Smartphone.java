public class Smartphone extends Electronic {

	private static final long serialVersionUID = 1L;

	private String especificacoesTecnicas;

	@Override
	public String imprimirLista() {
		return super.imprimirLista() + "\n" +
				"Especificações Técnicas: " + especificacoesTecnicas;
	}

	public Smartphone(){
	}

	public Smartphone(String tipo,String nome, String marca, int modelo, String tela) {
		super(tipo, nome, marca, modelo, tela);
	}

	public Smartphone(String tipo, String nome, String marca, int modelo, String tela, String campoSmartWatch) {
		super(tipo, nome, marca, modelo, tela);
		this.especificacoesTecnicas = campoSmartWatch;
	}

	public String getEspecificacoesTecnicas() {
		return especificacoesTecnicas;
	}

	public void setEspecificacoesTecnicas(String especificacoesTecnicas) {this.especificacoesTecnicas = especificacoesTecnicas;	}
}