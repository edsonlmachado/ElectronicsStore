public class Notebook extends Electronic {

	private static final long serialVersionUID = 1L;

	private String acessorios;

	@Override
	public String imprimirLista() {
		return super.imprimirLista() + "\n" +
				"Acessórios: " + acessorios;
	}

	public Notebook(){
	}

	public Notebook(String tipo, String nome, int modelo, String marca, String tela) {
		super(tipo, nome, marca, modelo, tela);
	}

	public Notebook(String tipo, String nome, String marca, int modelo, String tela, String acessorios) {
		super(tipo, nome, marca, modelo, tela);
		this.acessorios = acessorios;
	}

	public String getAcessorios() {	return acessorios;}

	public void setAcessorios(String acessorios) {
		this.acessorios = acessorios;
	}
}
