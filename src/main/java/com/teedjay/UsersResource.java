package com.teedjay;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    @GET
    public List<Users> getAllUsers() {
        return Users.listAll();
    }

    @POST
    @Transactional
    public Users createUser(Users users) {
        if (users.id != null) throw new BadRequestException("ID is autogenerated, make sure to not pass any value when creating entities.");
        users.persist();
        return users;
    }

}
