/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.paucasesnovescifp.swdws.serveis;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author alumne
 */
@Path("upload")
public class UploadWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UploadWS
     */
    public UploadWS() {
    }

    /**
     *
     * @param uploadedInputStream
     * @return
     */
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response get(String contingut) {
        System.out.println(contingut);
        return null;
    }

}
