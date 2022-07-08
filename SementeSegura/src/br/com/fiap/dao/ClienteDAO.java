package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.model.Cliente;

public class ClienteDAO {

	private Connection conexao;

	public ClienteDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public void insert(Cliente cliente) throws SQLException {

		String sql = "insert into t_cliente (nm_cliente, nr_cpf_cliente, dt_nasc_cliente, ds_nacionali_cliente, nr_rg_cliente, sg_genero_cliente, ds_profi_cliente, ds_est_civ_cliente, vl_renda_cliente)\r\n"
				+ "values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);

		stmt.setString(1, cliente.getNmCliente());
		stmt.setString(2, cliente.getNrCpfCliente());
		stmt.setDate(3, cliente.getDtNascCliente());
		stmt.setString(4, cliente.getDsNacionaliCliente());
		stmt.setString(5, cliente.getNrRgCliente());
		stmt.setString(6, String.valueOf(cliente.getSgGeneroCliente()));
		stmt.setString(7, cliente.getDsProfiCliente());
		stmt.setString(8, cliente.getDsEstCivCliente());
		stmt.setDouble(9, cliente.getVlRendaCliente());

		stmt.execute();

		stmt.close();

	}

	public List<Cliente> select() throws SQLException {

		List<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "Select * from t_cliente";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Cliente cliente = new Cliente(rs.getString("nm_cliente"),
					rs.getString("nr_cpf_cliente"), rs.getDate("dt_nasc_cliente"), rs.getString("ds_nacionali_cliente"),
					rs.getString("nr_rg_cliente"), rs.getString("sg_genero_cliente").charAt(0),
					rs.getString("ds_profi_cliente"), rs.getString("ds_est_civ_cliente"),
					rs.getDouble("vl_renda_cliente"));

			cliente.setCdCliente(rs.getInt("cd_cliente"));
			clientes.add(cliente);

		}

		rs.close();
		stmt.close();
		return clientes;

	}

	public Cliente selectByCd(int cd) throws SQLException {

		Cliente cliente = null;
		String sql = "Select * from t_cliente where cd_cliente=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		stmt.setInt(1, cd);
		ResultSet rs = stmt.executeQuery();

		
		if (rs.next()) {
			cliente = new Cliente(rs.getString("nm_cliente"), rs.getString("nr_cpf_cliente"),
					rs.getDate("dt_nasc_cliente"), rs.getString("ds_nacionali_cliente"), rs.getString("nr_rg_cliente"),
					rs.getString("sg_genero_cliente").charAt(0), rs.getString("ds_profi_cliente"),
					rs.getString("ds_est_civ_cliente"), rs.getDouble("vl_renda_cliente"));

			cliente.setCdCliente(rs.getInt("cd_cliente"));
			
			System.out.println(rs.getString("nm_cliente") + "\t" + rs.getString("nr_cpf_cliente") + "\t"
					+ sdf.format(rs.getDate("dt_nasc_cliente")) + "\t" + rs.getString("ds_nacionali_cliente") + "\t"
					+ rs.getString("nr_rg_cliente") + "\t" + rs.getString("sg_genero_cliente").charAt(0) + "\t"
					+ rs.getString("ds_profi_cliente") + "\t" + rs.getString("ds_est_civ_cliente") + "\t"
					+ rs.getDouble("vl_renda_cliente")); 

		} else {
			System.out.println("Nao foi encontrado nenhum cliente com esse codigo.");
		}
		
		rs.close();
		stmt.close();
		return cliente;

	}

	public Cliente selectByName(String name) throws SQLException {

		Cliente cliente = null;
		String sql = "Select * from t_cliente where nm_cliente=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		stmt.setString(1, name);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			cliente = new Cliente(rs.getString("nm_cliente"), rs.getString("nr_cpf_cliente"),
					rs.getDate("dt_nasc_cliente"), rs.getString("ds_nacionali_cliente"), rs.getString("nr_rg_cliente"),
					rs.getString("sg_genero_cliente").charAt(0), rs.getString("ds_profi_cliente"),
					rs.getString("ds_est_civ_cliente"), rs.getDouble("vl_renda_cliente"));

			System.out.println(rs.getString("nm_cliente") + "\t" + rs.getString("nr_cpf_cliente") + "\t"
					+ sdf.format(rs.getDate("dt_nasc_cliente")) + "\t" + rs.getString("ds_nacionali_cliente") + "\t"
					+ rs.getString("nr_rg_cliente") + "\t" + rs.getString("sg_genero_cliente").charAt(0) + "\t"
					+ rs.getString("ds_profi_cliente") + "\t" + rs.getString("ds_est_civ_cliente") + "\t"
					+ rs.getDouble("vl_renda_cliente"));

		} else {
			System.out.println("Nao foi encontrado nenhum cliente com esse nome.");
		}

		rs.close();
		stmt.close();
		return cliente;

	}

	public Cliente selectByCpf(String cpf) throws SQLException {

		Cliente cliente = null;
		String sql = "Select * from t_cliente where nr_cpf_cliente=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		stmt.setString(1, cpf);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			cliente = new Cliente(rs.getString("nm_cliente"), rs.getString("nr_cpf_cliente"),
					rs.getDate("dt_nasc_cliente"), rs.getString("ds_nacionali_cliente"), rs.getString("nr_rg_cliente"),
					rs.getString("sg_genero_cliente").charAt(0), rs.getString("ds_profi_cliente"),
					rs.getString("ds_est_civ_cliente"), rs.getDouble("vl_renda_cliente"));

			System.out.println(rs.getString("nm_cliente") + "\t" + rs.getString("nr_cpf_cliente") + "\t"
					+ sdf.format(rs.getDate("dt_nasc_cliente")) + "\t" + rs.getString("ds_nacionali_cliente") + "\t"
					+ rs.getString("nr_rg_cliente") + "\t" + rs.getString("sg_genero_cliente").charAt(0) + "\t"
					+ rs.getString("ds_profi_cliente") + "\t" + rs.getString("ds_est_civ_cliente") + "\t"
					+ rs.getDouble("vl_renda_cliente"));

		} else {
			System.out.println("Nao foi encontrado nenhum cliente com esse CPF.");
		}

		rs.close();
		stmt.close();
		return cliente;

	}

	public Cliente selectByRg(String rg) throws SQLException {

		Cliente cliente = null;
		String sql = "Select * from t_cliente where nr_rg_cliente=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		stmt.setString(1, rg);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			cliente = new Cliente(rs.getString("nm_cliente"), rs.getString("nr_cpf_cliente"),
					rs.getDate("dt_nasc_cliente"), rs.getString("ds_nacionali_cliente"), rs.getString("nr_rg_cliente"),
					rs.getString("sg_genero_cliente").charAt(0), rs.getString("ds_profi_cliente"),
					rs.getString("ds_est_civ_cliente"), rs.getDouble("vl_renda_cliente"));

			System.out.println(rs.getString("nm_cliente") + "\t" + rs.getString("nr_cpf_cliente") + "\t"
					+ sdf.format(rs.getDate("dt_nasc_cliente")) + "\t" + rs.getString("ds_nacionali_cliente") + "\t"
					+ rs.getString("nr_rg_cliente") + "\t" + rs.getString("sg_genero_cliente").charAt(0) + "\t"
					+ rs.getString("ds_profi_cliente") + "\t" + rs.getString("ds_est_civ_cliente") + "\t"
					+ rs.getDouble("vl_renda_cliente"));

		} else {
			System.out.println("Nao foi encontrado nenhum cliente com esse RG.");
		}

		rs.close();
		stmt.close();
		return cliente;

	}

	public int clienteCD(String cpf) throws SQLException {
		
		int cd = 0;
		Cliente cliente = null;
		String sql = "Select * from t_cliente where nr_cpf_cliente=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, cpf);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			cliente = new Cliente(rs.getString("nm_cliente"), rs.getString("nr_cpf_cliente"),
					rs.getDate("dt_nasc_cliente"), rs.getString("ds_nacionali_cliente"), rs.getString("nr_rg_cliente"),
					rs.getString("sg_genero_cliente").charAt(0), rs.getString("ds_profi_cliente"),
					rs.getString("ds_est_civ_cliente"), rs.getDouble("vl_renda_cliente"));

			cliente.setCdCliente(rs.getInt("cd_cliente"));
			cd = cliente.getCdCliente();
			
		}

		rs.close();
		stmt.close();

		return cd;
	}

	public void update(Cliente cliente, int cd) throws SQLException {

		String sql = "update t_cliente set nm_cliente=?, nr_cpf_cliente=?, dt_nasc_cliente=?, ds_nacionali_cliente=?,"
				+ " nr_rg_cliente=?, sg_genero_cliente=?, ds_profi_cliente=?, ds_est_civ_cliente=?,"
				+ "vl_renda_cliente=? where cd_cliente=?";

		PreparedStatement stmt = conexao.prepareStatement(sql);

		stmt.setString(1, cliente.getNmCliente());
		stmt.setString(2, cliente.getNrCpfCliente());
		stmt.setDate(3, cliente.getDtNascCliente());
		stmt.setString(4, cliente.getDsNacionaliCliente());
		stmt.setString(5, cliente.getNrRgCliente());
		stmt.setString(6, String.valueOf(cliente.getSgGeneroCliente()));
		stmt.setString(7, cliente.getDsProfiCliente());
		stmt.setString(8, cliente.getDsEstCivCliente());
		stmt.setDouble(9, cliente.getVlRendaCliente());
		stmt.setInt(10, cd);

		stmt.execute();

		stmt.close();

	}

	public void excluir(int cd) {
		try {
			PreparedStatement stmt = conexao.prepareStatement("DELETE FROM t_cliente WHERE cd_cliente = ?");
			stmt.setInt(1, cd);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
