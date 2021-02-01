package br.com.mstech.escola.infraestrutura.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.mstech.escola.dominio.aluno.Aluno;
import br.com.mstech.escola.dominio.aluno.CPF;
import br.com.mstech.escola.dominio.aluno.RepositorioDeAluno;
import br.com.mstech.escola.dominio.aluno.Telefone;

public class RepositorioDeAlunoJDBC implements RepositorioDeAluno {

    private final Connection connection;

    public RepositorioDeAlunoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {        
        try {
            String sql = "INSERT INTO ALUNO VALUES(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.setString(1, aluno.getNome());
            ps.setString(1, aluno.getEmail());
            ps.execute();

            sql = "INSERT INTO TELEFONE VALUES(?, ?)";
            ps = connection.prepareStatement(sql);
            for (Telefone telefone : aluno.getTelefones()) {
                ps.setString(1, telefone.getDdd());
                ps.setString(2, telefone.getNumero());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        // TODO Auto-generated method stub
        return null;
    }


    
}