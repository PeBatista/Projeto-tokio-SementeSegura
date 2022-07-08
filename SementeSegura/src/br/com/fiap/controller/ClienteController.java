package br.com.fiap.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Cliente;


public class ClienteController {
	
	private ClienteDAO clienteDAO;
	
	public ClienteController() {
		Connection connection = new ConnectionFactory().conectar();
		this.clienteDAO = new ClienteDAO(connection);
	}
	
	public void insert(Cliente cliente) throws SQLException {
		this.clienteDAO.insert(cliente);
		System.out.println("Cliente " + cliente.getNmCliente() + " cadastrado(a).");
	}

	public int cdPorCPF(String cpf) throws SQLException {
		return this.clienteDAO.clienteCD(cpf);
	}
	
	public void select() throws SQLException {
		List<Cliente> clientes = clienteDAO.select();
		
		for(Cliente cliente:clientes) {
			System.out.println("Código: " + cliente.getCdCliente() + "\t| Nome: " + cliente.getNmCliente() + "\t| CPF: " + cliente.getNrCpfCliente());
		}
		if (clientes.size() == 0)  {
			System.out.println("Nenhum cliente foi encontrado.");
		}
		
	}
	
	public void selectByCd(int cd) throws SQLException {
		this.clienteDAO.selectByCd(cd);	
	}
	
	public void selectByCpf(String cpf) throws SQLException {
		this.clienteDAO.selectByCpf(cpf);
	}
	
	public void selectByRg(String rg) throws SQLException {
		this.clienteDAO.selectByRg(rg);
	}
	
	public void selectByName(String name) throws SQLException {
		this.clienteDAO.selectByName(name);
	}

	public void update(Cliente cliente, int cd) throws SQLException {
		this.clienteDAO.update(cliente, cd);
		System.out.println("Update realizado.");
		
	}

	public void delete(int cd) {
		this.clienteDAO.excluir(cd);
		System.out.println("Cliente deletado.");
	}
	
}
