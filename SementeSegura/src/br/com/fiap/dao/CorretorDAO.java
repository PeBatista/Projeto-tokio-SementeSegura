package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.model.Corretor;

public class CorretorDAO {
	
	private Connection conexao;

	public CorretorDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public void insert(Corretor corretor) throws SQLException {
		
		String sql = "insert into t_corretor (nm_corretor, tp_pessoa_corretor, nr_cpf_corretor, cd_susep_corretor, ds_email_corretor, nr_tel_corretor, vl_salario_corretor) values (?,?,?,?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setString(1, corretor.getNmCorretor());
		stmt.setString(2, corretor.getTpPessoaCorretor());
		stmt.setString(3, corretor.getNrCpfCorretor());
		stmt.setInt(4, corretor.getCdSusepCorretor());
		stmt.setString(5, corretor.getDsEmailCorretor());
		stmt.setString(6, corretor.getNrTelCorretor());
		stmt.setDouble(7, corretor.getVlSalarioCorretor());

		stmt.execute();

		stmt.close();
		
	}
	
	public List<Corretor> select() throws SQLException {
		List<Corretor> corretores = new ArrayList<Corretor>();
		String sql = "select * from t_corretor";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Corretor corretor = new Corretor();
			corretor.setCdCorretor(rs.getInt("cd_corretor"));
			corretor.setNmCorretor(rs.getString("nm_corretor"));
			corretor.setTpPessoaCorretor(rs.getString("TP_PESSOA_CORRETOR"));
			corretor.setNrCpfCorretor(rs.getString("NR_CPF_CORRETOR"));
			corretor.setCdSusepCorretor(rs.getInt("CD_SUSEP_CORRETOR"));
			corretor.setDsEmailCorretor(rs.getString("DS_EMAIL_CORRETOR"));
			corretor.setNrTelCorretor(rs.getString("NR_TEL_CORRETOR"));
			corretor.setVlSalarioCorretor(rs.getDouble("vl_salario_corretor"));
			
			corretores.add(corretor);
		}

		rs.close();
		stmt.close();
		return corretores;
	}
	
	public List<Corretor> selectSalarioMaior(double salario) throws SQLException {
		
		List<Corretor> corretores = new ArrayList<Corretor>();
		String sql = "select cd_corretor, nm_corretor, NR_CPF_CORRETOR, VL_SALARIO_CORRETOR from t_corretor where VL_SALARIO_CORRETOR >= ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setDouble(1, salario);
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Corretor corretor = new Corretor();
			corretor.setCdCorretor(rs.getInt("cd_corretor"));
			corretor.setNmCorretor(rs.getString("nm_corretor"));
			corretor.setVlSalarioCorretor(rs.getDouble("vl_salario_corretor"));
			corretor.setNrCpfCorretor(rs.getString("NR_CPF_CORRETOR"));
			
			corretores.add(corretor);
		}

		rs.close();
		stmt.close();
		return corretores;
	}
	
	public List<Corretor> selectSalarioMenor(double salario) throws SQLException {
		
		List<Corretor> corretores = new ArrayList<Corretor>();
		String sql = "select cd_corretor, nm_corretor, NR_CPF_CORRETOR, VL_SALARIO_CORRETOR from t_corretor where VL_SALARIO_CORRETOR <= ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setDouble(1, salario);
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Corretor corretor = new Corretor();
			corretor.setCdCorretor(rs.getInt("cd_corretor"));
			corretor.setNmCorretor(rs.getString("nm_corretor"));
			corretor.setVlSalarioCorretor(rs.getDouble("vl_salario_corretor"));
			corretor.setNrCpfCorretor(rs.getString("NR_CPF_CORRETOR"));
			
			corretores.add(corretor);
		}

		rs.close();
		stmt.close();
		return corretores;
	}
	
	public void update(Corretor corretor, int cd) throws SQLException {
		String sql = "update t_corretor set nm_corretor=?, tp_pessoa_corretor=?, nr_cpf_corretor=?, cd_susep_corretor=?, ds_email_corretor=?, nr_tel_corretor=?, vl_salario_corretor=? where cd_corretor=?";

		PreparedStatement stmt = conexao.prepareStatement(sql);

		stmt.setString(1, corretor.getNmCorretor());
		stmt.setString(2, corretor.getTpPessoaCorretor());
		stmt.setString(3, corretor.getNrCpfCorretor());
		stmt.setInt(4, corretor.getCdSusepCorretor());
		stmt.setString(5, corretor.getDsEmailCorretor());
		stmt.setString(6, corretor.getNrTelCorretor());
		stmt.setDouble(7, corretor.getVlSalarioCorretor());
		stmt.setInt(8, cd);

		stmt.execute();

		stmt.close();

	}
	
	public void excluir(int cd) {
		try {
			PreparedStatement stmt = conexao.prepareStatement("DELETE FROM t_corretor WHERE cd_corretor = ?");
			stmt.setInt(1, cd);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
