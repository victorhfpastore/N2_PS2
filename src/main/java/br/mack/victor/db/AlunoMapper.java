package br.mack.victor.db;

import br.mack.victor.api.Aluno;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoMapper implements RowMapper<Aluno> {

    @Override
    public Aluno map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Aluno(
                rs.getInt("tia"),
                rs.getString("nome"),
                rs.getDate("auladia"),
                rs.getBoolean("presenca")
        );
    }
}
