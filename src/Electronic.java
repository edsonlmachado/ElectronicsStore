import java.io.Serializable;

public class Electronic implements Serializable {

	private static final long serialVersionUID = 1L;
	private   String tipo;
	private   String nome;
	private   String marca;
	private   int modelo;
	private   String tela;

	public Electronic(String tipo,String nome, String marca, int modelo, String tela) {
		this.tipo = nome;
		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		this.tela = tela;
	}

	public Electronic(){

	}
	public String imprimirLista() {
		String retorno = "";
		retorno += "Tipo: " + this.tipo + "\n";
		retorno += "Produto: " + this.getNome() + "\n";
		retorno += "Marca: " + this.getMarca() + "\n";
		retorno += "Ano de Fabricação: " + this.getModelo() + "\n";
		retorno += "Tamanho da Tela: " + this.getTela();
		return retorno;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNome() {

		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getModelo() {

		return modelo;
	}
	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTela() {
		return tela;
	}
	public void setTela(String tela) {
		this.tela = tela;
	}
}
