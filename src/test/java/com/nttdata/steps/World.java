package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

public class World {

    private String URL_BASE = "http://api.football-data.org/v4/";

    public void consultarWorld(){

        SerenityRest.given()
                .baseUri(URL_BASE)
                .log()
                .all()
                .when()
                .get("areas/2267")
                .then()
                .log()
                .all()
                ;
    }

    public void validacionCodigoRespuesta(int codigo){
        Assert.assertEquals(codigo, SerenityRest.lastResponse().statusCode());
    }
}
