package br.mack.victor.resources;

import br.mack.victor.api.Aluno;
import br.mack.victor.db.AlunoDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("alunos")
@Produces(MediaType.APPLICATION_JSON)
public class AlunoResource {

    AlunoDao alunoDao;

    public AlunoResource(AlunoDao alunoDao) {
        this.alunoDao = alunoDao;
    }

    @GET
    public Response getAlunos() {
        List<Aluno> allAlunos = alunoDao.getAllAlunos();
        return Response.ok(allAlunos).build();
    }

    @POST
    public Response createAluno(Aluno Aluno) {
        if (Aluno == null) {
            throw new BadRequestException("Aluno data missing");
        }
        int tia = alunoDao.insert(Aluno);
        Aluno = alunoDao.findByTia(tia);

        if (Aluno == null) {
            throw new WebApplicationException("Problem creating Aluno");
        }

        return Response.ok(Aluno).build();
    }

    @GET
    @Path("/{tia}")
    public Response getAluno(@PathParam("tia") int tia) {
        Aluno Aluno = alunoDao.findByTia(tia);

        if (Aluno == null)
            throw new WebApplicationException("Aluno does not exist", Response.Status.NOT_FOUND);

        return Response.ok(Aluno).build();
    }
}
