package br.com.fiap.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.fiap.dao.ContatoClienteDAO;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.ContatoCliente;

public class ContatoClienteController {
	
	private ContatoClienteDAO contatoClienteDAO;

	public ContatoClienteController() {
		Connection connection = new ConnectionFactory().conectar();
		this.contatoClienteDAO = new ContatoClienteDAO(connection);
	}
	
	public void insert(ContatoCliente contato) throws SQLException {
		this.contatoClienteDAO.insert(contato);
		System.out.println("Contato adicionado.");
	}
	
	public void select() throws SQLException {
		List<ContatoCliente> contatos = this.contatoClienteDAO.select();
		
		for(ContatoCliente contato:contatos) {
			System.out.println("Codigo: " + contato.getCdContatoCliente() + "\t| Numero celular: " + contato.getNrCelCliente() + "\t| Email: " + contato.getDsEmilCliente() + "\t| Cidade: " + contato.getNmCidadeCliente()  + "\t| CEP: " + contato.getNrCepCliente() + "\t| Codigo cliente: " + contato.getCdCliente());
		}
	}
	
	public void update(ContatoCliente contato, int cd) throws SQLException {
		this.contatoClienteDAO.update(contato, cd);
		System.out.println("Update realizado.");
	}
	
	public void selectByCdCliente(int cd) throws SQLException {
		this.contatoClienteDAO.selectByCd(cd);
	}
	
	public void delete(int cd) {
		this.contatoClienteDAO.excluir(cd);
		System.out.println("Coluna excluida.");
	}

}
