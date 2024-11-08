package org.example.controller;

import org.example.dto.AgendamentoDto;
import org.example.exceptions.NotSavedException;
import org.example.exceptions.UnsupportedServiceOperationException;
import org.example.model.oficina.Agendamentos;
import org.example.service.agendamento.AgendamentoService;
import org.example.service.agendamento.AgendamentoServiceFactory;
import org.example.exceptions.NotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.Map;

@Path("/agendamento")
public class AgendamentoController {
    private final AgendamentoService agendamentoService = AgendamentoServiceFactory.create();

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(AgendamentoDto input) throws UnsupportedServiceOperationException {
        if (input.id() == null) {
            try {
                Agendamentos agendamentos = (Agendamentos) this.agendamentoService.create(new Agendamentos(null, input.dataAgendamento(),input.horaDoAgendamento(), input.descricaoServico(), input.idOficina(), input.idPessoa()));
                return Response
                        .status(Response.Status.CREATED)
                        .entity(agendamentos)
                        .build();
            } catch (SQLException | NotSavedException e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(Map.of("mensagem", "erro inesperado ao tentar inserir agendamento: " + e)).build();
            }

        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(
                            Map.of(
                                    "mensagem",
                                    "esse método só permite a criação de novos agendamentos"))
                    .build();
        }
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.status(Response.Status.OK)
                .entity(this.agendamentoService.findAll()).build();
    }

    @GET
    @Path("/pessoa/{idPessoa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByIdPessoa(@PathParam("idPessoa") Long id) {
        try {
            return Response.status(Response.Status.OK)
                    .entity(this.agendamentoService.findByIdPessoa(id)).build();
        } catch (org.example.exceptions.NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/oficina/{idOficina}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByIdOficina(@PathParam("idOficina") Long id) {
        try {
            return Response.status(Response.Status.OK)
                    .entity(this.agendamentoService.findByIdOficina(id)).build();
        } catch (org.example.exceptions.NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, AgendamentoDto input){
        try {
            Agendamentos updated = (Agendamentos) this.agendamentoService.update(new Agendamentos(id, input.dataAgendamento(),input.horaDoAgendamento(), input.descricaoServico(), input.idOficina(), input.idPessoa()));
            return Response.status(Response.Status.OK).entity(updated).build();
        } catch (org.example.exceptions.NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (SQLException s) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Map.of("mensagem","erro inesperado ao tentar atualizar agendamento" + s)).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id")Long id){
        try {
            this.agendamentoService.deleteById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (SQLException s) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Map.of("mensagem", "erro inesperado ao tentar deletar agendamento")).build();
        }

    }
}
