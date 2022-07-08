package br.com.fiap.model;

public class SaudeCliente {

	private int cdSaudeClinte;
	private String nmAsseguradoSaude, dsEspRadCliente, dsDoencaCliente;
	private char sgVicioCliente;
	private int cdCliente;
	
	public SaudeCliente(String nmAsseguradoSaude, String dsEspRadCliente, String dsDoencaCliente, char sgVicioCliente,
			int cdCliente) {
		this.nmAsseguradoSaude = nmAsseguradoSaude;
		this.dsEspRadCliente = dsEspRadCliente;
		this.dsDoencaCliente = dsDoencaCliente;
		this.sgVicioCliente = sgVicioCliente;
		this.cdCliente = cdCliente;
	}
	
	public int getCdSaudeClinte() {
		return cdSaudeClinte;
	}
	public void setCdSaudeClinte(int cdSaudeClinte) {
		this.cdSaudeClinte = cdSaudeClinte;
	}
	public String getNmAsseguradoSaude() {
		return nmAsseguradoSaude;
	}
	public void setNmAsseguradoSaude(String nmAsseguradoSaude) {
		this.nmAsseguradoSaude = nmAsseguradoSaude;
	}
	public String getDsEspRadCliente() {
		return dsEspRadCliente;
	}
	public void setDsEspRadCliente(String dsEspRadCliente) {
		this.dsEspRadCliente = dsEspRadCliente;
	}
	public String getDsDoencaCliente() {
		return dsDoencaCliente;
	}
	public void setDsDoencaCliente(String dsDoencaCliente) {
		this.dsDoencaCliente = dsDoencaCliente;
	}
	public char getSgVicioCliente() {
		return sgVicioCliente;
	}
	public void setSgVicioCliente(char sgVicioCliente) {
		this.sgVicioCliente = sgVicioCliente;
	}
	public int getCdCliente() {
		return cdCliente;
	}
	public void setCdCliente(int cdCliente) {
		this.cdCliente = cdCliente;
	}
	
	
	
}
