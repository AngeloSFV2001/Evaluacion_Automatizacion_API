package com.nttdata.glue;

import com.nttdata.steps.World;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class WorlStepDef {
    @Steps
    World world;   // world = new World();

    @When("ejecuto servicio Word")
    public void ejecutoServicioWord() {
       world.consultarWorld();
    }

    @Then("valido el codigo de respuesta {int}")
    public void validoElCodigoDeRespuesta(int status) {
       world.validacionCodigoRespuesta(status);
    }

    @And("valido el contenido")
    public void validoElContenido() {
        Assert.assertEquals("World", SerenityRest.lastResponse().body().path("name").toString());
        ;
    }
}
