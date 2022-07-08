package br.com.fiap.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.fiap.dao.ContratoDAO;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Contrato;

public class ContratoController {

	private ContratoDAO contratoDAO;

	public ContratoController() {
		Connection connection = new ConnectionFactory().conectar();
		this.contratoDAO = new ContratoDAO(connection);
	}

	public void insert(Contrato contrato) throws SQLException {
		this.contratoDAO.insert(contrato);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		switch (contrato.getCdSeguroVida()) {
		case 1: {
			System.out.println(contrato.getDsAssCliente() + " iniciou um contrato de " + "seguro 'Homem' ");
			System.out.println("com o corretor(a) " + contrato.getDsAssCorretor() + " no dia "
					+ sdf.format(contrato.getDtInicioContrato()) + ".");
			break;
		}
		case 2: {
			System.out.println(contrato.getDsAssCliente() + " iniciou um contrato de " + "seguro 'Mulher' ");
			System.out.println("com o corretor(a) " + contrato.getDsAssCorretor() + " no dia "
					+ sdf.format(contrato.getDtInicioContrato()) + ".");
			break;
		}
		case 3: {
			System.out.println(contrato.getDsAssCliente() + " iniciou um contrato de " + "seguro 'Senior' ");
			System.out.println("com o corretor(a) " + contrato.getDsAssCorretor() + " no dia "
					+ sdf.format(contrato.getDtInicioContrato()) + ".");
			break;
		}
		case 4: {
			System.out.println(contrato.getDsAssCliente() + " iniciou um contrato de " + "seguro 'Familia' ");
			System.out.println("com o corretor(a) " + contrato.getDsAssCorretor() + " no dia "
					+ sdf.format(contrato.getDtInicioContrato()) + ".");
			break;
		}
		}	
	}

	public void select() throws SQLException {
		List<Contrato> contratos = this.contratoDAO.select();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		for (Contrato contrato : contratos) {
			switch (contrato.getCdSeguroVida()) {
			case 1: {
				System.out.println("Numero do contrato: " + contrato.getCdContrato() + "\t| Nome do cliente: "
						+ contrato.getDsAssCliente() + "\t| Nome do corretor: " + contrato.getDsAssCorretor()
						+ "\t| Data inicial: " + sdf.format(contrato.getDtInicioContrato()) + "\t| Seguro: Homem"
						+ "\t| Codigo do cliente: " + contrato.getCdCliente() + "\t| Codigo do corretor: "
						+ contrato.getCdCorretor());
				break;
			}
			case 2: {
				System.out.println("Numero do contrato: " + contrato.getCdContrato() + "\t| Nome do cliente: "
						+ contrato.getDsAssCliente() + "\t| Nome do corretor: " + contrato.getDsAssCorretor()
						+ "\t| Data inicial: " + sdf.format(contrato.getDtInicioContrato()) + "\t| Seguro: Mulher"
						+ "\t| Codigo do cliente: " + contrato.getCdCliente() + "\t| Codigo do corretor: "
						+ contrato.getCdCorretor());
				break;
			}
			case 3: {
				System.out.println("Numero do contrato: " + contrato.getCdContrato() + "\t| Nome do cliente: "
						+ contrato.getDsAssCliente() + "\t| Nome do corretor: " + contrato.getDsAssCorretor()
						+ "\t| Data inicial: " + sdf.format(contrato.getDtInicioContrato()) + "\t| Seguro: Senior"
						+ "\t| Codigo do cliente: " + contrato.getCdCliente() + "\t| Codigo do corretor: "
						+ contrato.getCdCorretor());
				break;
			}
			case 4: {
				System.out.println("Numero do contrato: " + contrato.getCdContrato() + "\t| Nome do cliente: "
						+ contrato.getDsAssCliente() + "\t| Nome do corretor: " + contrato.getDsAssCorretor()
						+ "\t| Data inicial: " + sdf.format(contrato.getDtInicioContrato()) + "\t| Seguro: Familia"
						+ "\t| Codigo do cliente: " + contrato.getCdCliente() + "\t| Codigo do corretor: "
						+ contrato.getCdCorretor());
				break;
			}

			}
		}
	}

	public void selectByCd(int cd) throws SQLException {
		this.contratoDAO.selectByCd(cd);
	}

	public void listarPorNomeCorretor(String nmCorretor) {
		List<Contrato> contratos = this.contratoDAO.listarPorCorretorNome(nmCorretor);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		for(Contrato contrato:contratos) {
			System.out.println("Codigo contrato: " + contrato.getCdContrato() + "\t| Corretor(a): " + contrato.getDsAssCorretor() + "\t| Cliente: " + contrato.getDsAssCliente() + "\t| Data do contrato: " + sdf.format(contrato.getDtInicioContrato()));
		} 
		
		if(contratos.size() == 0) {
			System.out.println("Esse corretor ainda nao tem contratos.");
		}
		
	}
	
	public void listarPorCdCorretor(int cd) {
		List<Contrato> contratos = this.contratoDAO.listarPorCorretorCd(cd);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		for(Contrato contrato:contratos) {
			System.out.println("Codigo contrato: " + contrato.getCdContrato() + "\t| Corretor(a): " + contrato.getDsAssCorretor() + "\t| Cliente: " + contrato.getDsAssCliente() + "\t| Data do contrato: " + sdf.format(contrato.getDtInicioContrato()));
		}
		
		if(contratos.size() == 0) {
			System.out.println("Esse corretor ainda nao tem contratos.");
		}
		
	}
	
	public void listarTpSeguro() {
		List<Contrato> contratos = this.contratoDAO.listarContratoAssegurados();
		
		System.out.println("Contratos totais: " + contratos.size());
		
	}
	
	public void update(Contrato contrato, int cd) throws SQLException {
		this.contratoDAO.update(contrato, cd);
		System.out.println("Update realizado.");
	}
	
	public void delete(int cd) {
		this.contratoDAO.excluir(cd);
		System.out.println("Contrato deletado.");
	}
}
