public class Computer extends Electronic {

	private static final long serialVersionUID = 1L;

	private String perifericos;

	@Override
	public String imprimirLista() {
		return super.imprimirLista() + "\n" +
				"Periféricos: " + perifericos;
	}

	public Computer(){
	}

	public Computer(String tipo, String nome, String marca, int modelo, String tela) {
		super(tipo, nome, marca, modelo, tela);
	}

	public Computer(String tipo, String nome, String marca, int modelo, String tela, String perifericos) {
		super(tipo, nome, marca, modelo, tela);
		this.perifericos = perifericos;
	}

	public String getPerifericos() {
		return perifericos;
	}

	public void setPerifericos(String perifericos) {
		this.perifericos = perifericos;
	}
}
