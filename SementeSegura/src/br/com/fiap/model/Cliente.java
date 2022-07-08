package br.com.fiap.model;

import java.sql.Date;

public class Cliente {

	private int cdCliente;
	private String nmCliente, nrCpfCliente, dsNacionaliCliente, nrRgCliente, dsProfiCliente, dsEstCivCliente;
	private double vlRendaCliente;
	private char sgGeneroCliente;
	private Date dtNascCliente;
	
	public Cliente(String nmCliente, String nrCpfCliente, Date dtNascCliente, String dsNacionaliCliente,
			String nrRgCliente, char sgGeneroCliente, String dsProfiCliente, String dsEstCivCliente,
			double vlRendaCliente) {
		this.nmCliente = nmCliente;
		this.nrCpfCliente = nrCpfCliente;
		this.dtNascCliente = dtNascCliente;
		this.dsNacionaliCliente = dsNacionaliCliente;
		this.nrRgCliente = nrRgCliente;
		this.sgGeneroCliente = sgGeneroCliente;
		this.dsProfiCliente = dsProfiCliente;
		this.dsEstCivCliente = dsEstCivCliente;
		this.vlRendaCliente = vlRendaCliente;
	}
	
	public int getCdCliente() {
		return cdCliente;
	}
	public void setCdCliente(int cdCliente) {
		this.cdCliente = cdCliente;
	}
	public String getNmCliente() {
		return nmCliente;
	}
	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}
	public String getNrCpfCliente() {
		return nrCpfCliente;
	}
	public void setNrCpfCliente(String nrCpfCliente) {
		this.nrCpfCliente = nrCpfCliente;
	}
	public String getDsNacionaliCliente() {
		return dsNacionaliCliente;
	}
	public void setDsNacionaliCliente(String dsNacionaliCliente) {
		this.dsNacionaliCliente = dsNacionaliCliente;
	}
	public String getNrRgCliente() {
		return nrRgCliente;
	}
	public void setNrRgCliente(String nrRgCliente) {
		this.nrRgCliente = nrRgCliente;
	}
	public String getDsProfiCliente() {
		return dsProfiCliente;
	}
	public void setDsProfiCliente(String dsProfiCliente) {
		this.dsProfiCliente = dsProfiCliente;
	}
	public String getDsEstCivCliente() {
		return dsEstCivCliente;
	}
	public void setDsEstCivCliente(String dsEstCivCliente) {
		this.dsEstCivCliente = dsEstCivCliente;
	}
	public double getVlRendaCliente() {
		return vlRendaCliente;
	}
	public void setVlRendaCliente(double vlRendaCliente) {
		this.vlRendaCliente = vlRendaCliente;
	}
	public char getSgGeneroCliente() {
		return sgGeneroCliente;
	}
	public void setSgGeneroCliente(char sgGeneroCliente) {
		this.sgGeneroCliente = sgGeneroCliente;
	}
	public Date getDtNascCliente() {
		return dtNascCliente;
	}
	public void setDtNascCliente(Date dtNascCliente) {
		this.dtNascCliente = dtNascCliente;
	}
	
	
}
