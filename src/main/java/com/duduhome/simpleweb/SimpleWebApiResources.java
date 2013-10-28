package com.duduhome.simpleweb;

import com.duduhome.simpleweb.data.Note;
import com.duduhome.simpleweb.data.NoteDao;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class SimpleWebApiResources {

    private NoteDao _noteDao;

    @Inject
    public SimpleWebApiResources(NoteDao noteDao){
        _noteDao = noteDao;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static private class NoteList{
        @JsonProperty("noteList")
        private List<Note> _noteList;

        public NoteList(List<Note> noteList){
            _noteList = noteList;
        }

        private List<Note> getNoteList() {
            return _noteList;
        }
    }
    @GET
    @Path("GetAllNotes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Note> getcAllNotes(@QueryParam("orderby")String orderBy) throws Exception {
        Iterable<Note> result = _noteDao.getAllNotes(orderBy);
        return Lists.newArrayList(result);
    }

    @POST
    @Path("PutNote")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putNote(Note note) throws Exception {
        try {
            System.out.println(note);
            _noteDao.putNote(note);
            return Response.ok().build();
        }
        catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
