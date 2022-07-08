package br.com.fiap.model;

public class ContatoCliente {

	private int cdContatoCliente;
	private String dsEmilCliente;
	private int nrCelCliente;
	private String nrTelCliente, nmRuaCliente;
	private int nrMoradiaCliente;
	private String nrCepCliente, dsComplementoClinte, nmBairroCliente, nmCidadeCliente, nmEstadoCliente;
	private int cdCliente;
	
	public ContatoCliente(String dsEmilCliente, int nrCelCliente, String nrTelCliente,
			String nmRuaCliente, int nrMoradiaCliente, String nrCepCliente, String dsComplementoClinte,
			String nmBairroCliente, String nmCidadeCliente, String nmEstadoCliente, int cdCliente) {
		this.dsEmilCliente = dsEmilCliente;
		this.nrCelCliente = nrCelCliente;
		this.nrTelCliente = nrTelCliente;
		this.nmRuaCliente = nmRuaCliente;
		this.nrMoradiaCliente = nrMoradiaCliente;
		this.nrCepCliente = nrCepCliente;
		this.dsComplementoClinte = dsComplementoClinte;
		this.nmBairroCliente = nmBairroCliente;
		this.nmCidadeCliente = nmCidadeCliente;
		this.nmEstadoCliente = nmEstadoCliente;
		this.cdCliente = cdCliente;
	}
	
	public int getCdContatoCliente() {
		return cdContatoCliente;
	}
	public void setCdContatoCliente(int cdContatoCliente) {
		this.cdContatoCliente = cdContatoCliente;
	}
	public String getDsEmilCliente() {
		return dsEmilCliente;
	}
	public void setDsEmilCliente(String dsEmilCliente) {
		this.dsEmilCliente = dsEmilCliente;
	}
	public int getNrCelCliente() {
		return nrCelCliente;
	}
	public void setNrCelCliente(int nrCelCliente) {
		this.nrCelCliente = nrCelCliente;
	}
	public String getNrTelCliente() {
		return nrTelCliente;
	}
	public void setNrTelCliente(String nrTelCliente) {
		this.nrTelCliente = nrTelCliente;
	}
	public String getNmRuaCliente() {
		return nmRuaCliente;
	}
	public void setNmRuaCliente(String nmRuaCliente) {
		this.nmRuaCliente = nmRuaCliente;
	}
	public int getNrMoradiaCliente() {
		return nrMoradiaCliente;
	}
	public void setNrMoradiaCliente(int nrMoradiaCliente) {
		this.nrMoradiaCliente = nrMoradiaCliente;
	}
	public String getNrCepCliente() {
		return nrCepCliente;
	}
	public void setNrCepCliente(String nrCepCliente) {
		this.nrCepCliente = nrCepCliente;
	}
	public String getDsComplementoClinte() {
		return dsComplementoClinte;
	}
	public void setDsComplementoClinte(String dsComplementoClinte) {
		this.dsComplementoClinte = dsComplementoClinte;
	}
	public String getNmBairroCliente() {
		return nmBairroCliente;
	}
	public void setNmBairroCliente(String nmBairroCliente) {
		this.nmBairroCliente = nmBairroCliente;
	}
	public String getNmCidadeCliente() {
		return nmCidadeCliente;
	}
	public void setNmCidadeCliente(String nmCidadeCliente) {
		this.nmCidadeCliente = nmCidadeCliente;
	}
	public String getNmEstadoCliente() {
		return nmEstadoCliente;
	}
	public void setNmEstadoCliente(String nmEstadoCliente) {
		this.nmEstadoCliente = nmEstadoCliente;
	}
	public int getCdCliente() {
		return cdCliente;
	}
	public void setCdCliente(int cdCliente) {
		this.cdCliente = cdCliente;
	}
	
	
	
}
