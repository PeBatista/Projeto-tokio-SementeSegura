package br.com.fiap.model;

import java.util.ArrayList;
import java.util.List;

public class Corretor {

	private int cdCorretor;
	private String nmCorretor, tpPessoaCorretor, nrCpfCorretor;
	private int cdSusepCorretor;
	private String dsEmailCorretor, nrTelCorretor;
	private double vlSalarioCorretor;
	private List<Contrato> contratos = new ArrayList<Contrato>();
	
	public Corretor() {
	}
	
	public List<Contrato> getContrato() {
		return contratos;
	}

	public void AdicionarContrato(Contrato contrato) {
		contratos.add(contrato);
	}
	
	public int getCdCorretor() {
		return cdCorretor;
	}
	public void setCdCorretor(int cdCorretor) {
		this.cdCorretor = cdCorretor;
	}
	public String getNmCorretor() {
		return nmCorretor;
	}
	public void setNmCorretor(String nmCorretor) {
		this.nmCorretor = nmCorretor;
	}
	public String getTpPessoaCorretor() {
		return tpPessoaCorretor;
	}
	public void setTpPessoaCorretor(String tpPessoaCorretor) {
		this.tpPessoaCorretor = tpPessoaCorretor;
	}
	public String getNrCpfCorretor() {
		return nrCpfCorretor;
	}
	public void setNrCpfCorretor(String nrCpfCorretor) {
		this.nrCpfCorretor = nrCpfCorretor;
	}
	public int getCdSusepCorretor() {
		return cdSusepCorretor;
	}
	public void setCdSusepCorretor(int cdSusepCorretor) {
		this.cdSusepCorretor = cdSusepCorretor;
	}
	public String getDsEmailCorretor() {
		return dsEmailCorretor;
	}
	public void setDsEmailCorretor(String dsEmailCorretor) {
		this.dsEmailCorretor = dsEmailCorretor;
	}
	public String getNrTelCorretor() {
		return nrTelCorretor;
	}
	public void setNrTelCorretor(String nrTelCorretor) {
		this.nrTelCorretor = nrTelCorretor;
	}
	public double getVlSalarioCorretor() {
		return vlSalarioCorretor;
	}
	public void setVlSalarioCorretor(double vlSalarioCorretor) {
		this.vlSalarioCorretor = vlSalarioCorretor;
	}
	
	
	
}
