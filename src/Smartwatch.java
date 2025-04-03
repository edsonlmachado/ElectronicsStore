public class Smartwatch extends Electronic {

	private static final long serialVersionUID = 1L;

	private String cores;

	@Override
	public String imprimirLista() {
		return super.imprimirLista() + "\n" +
				"Cores: " + cores;
	}

	public Smartwatch(){
	}

	public Smartwatch(String tipo, String nome, String marca, int modelo, String tela) {
		super(tipo, nome, marca, modelo, tela);
	}

	public Smartwatch(String tipo,String nome, String marca, int modelo, String tela, String cores) {
		super(tipo, nome, marca, modelo, tela);
		this.cores = cores;
	}

	public String getCores() { return cores; }
	public void setCores(String cores) {this.cores = cores;	}
}