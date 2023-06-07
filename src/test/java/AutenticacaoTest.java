import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class AutenticacaoTest {


    //Basic Auth

    @Test
    void naoDeveAcessarSemSenha() {
        given()
                .baseUri("https://restapi.wcaquino.me")
                .when()
                .get("/basicauth")
                .then()
                .statusCode(401);
    }

    @Test
    void deveAcessarComSucesso1() {
        given()
                .baseUri("https://admin:senha@restapi.wcaquino.me")
                .when()
                .get("/basicauth")
                .then()
                .statusCode(200)
                .body("status", is("logado"));
    }

    @Test
    void deveAcessarComSucesso2() {
        given()
                .auth().basic("admin", "senha")
                .baseUri("https://restapi.wcaquino.me")
                .when()
                .get("/basicauth")
                .then()
                .statusCode(200)
                .body("status", is("logado"));
    }



    //JWT - JSON Web Token

    @Test
    void deveFazerRequisicaoComTokenJWT() {
        String token = given()
                .body("{\"email\": \"wagner@aquino\", \"senha\": \"123456\"}")
                .contentType(ContentType.JSON)
                .when()
                .post("https://barrigarest.wcaquino.me/signin")
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("token");

        given()
                .header("Authorization", "JWT " + token)
                .when()
                .get("https://barrigarest.wcaquino.me/contas")
                .then()
                .statusCode(200)
//                .body("$", hasSize(23)) //não é bom porque essa massa de dados pode aumentar
//                .body("$", hasSize(greaterThanOrEqualTo(23)))
                .log().all();

    }


}
