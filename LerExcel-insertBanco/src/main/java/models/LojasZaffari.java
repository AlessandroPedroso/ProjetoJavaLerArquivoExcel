package models;

public class LojasZaffari {

	private Long idlojas;
	private String lojasNumero;
	private String nomeLocal;
	private String endereco;

	public Long getIdlojas() {
		return idlojas;
	}

	public void setIdlojas(Long idlojas) {
		this.idlojas = idlojas;
	}

	public String getLojasNumero() {
		return lojasNumero;
	}

	public void setLojasNumero(String lojasNumero) {
		this.lojasNumero = lojasNumero;
	}

	public String getNomeLocal() {
		return nomeLocal;
	}

	public void setNomeLocal(String nomeLocal) {
		this.nomeLocal = nomeLocal;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "LojasZaffari [idlojas=" + idlojas + ", lojasNumero=" + lojasNumero + ", nomeLocal=" + nomeLocal
				+ ", endereco=" + endereco + "]";
	}
	
	

}
