package br.mack.victor.db;

import br.mack.victor.api.Aluno;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterRowMapper(AlunoMapper.class)
public interface AlunoDao {

    @SqlUpdate("insert into aluno (tia, nome, auladia, presenca) values (:tia, :nome, :auladia, :presenca)")
    @GetGeneratedKeys
    int insert(@BindBean Aluno aluno);

    @SqlQuery("select * from aluno")
    List<Aluno> getAllAlunos();

    @SqlQuery("select * from aluno where tia = :tia")
    Aluno findByTia(@Bind("tia") int tia);
}
