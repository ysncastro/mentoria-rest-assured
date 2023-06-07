import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

class ValidacoesDeCrudTest {

    @Test
    @DisplayName("Deveria buscar os POSTS e validar o retorno")
    void deveriaBuscarPostsEValidarRetorno() {
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("$", Matchers.hasSize(100))
                .body("userId", Matchers.hasItems(2,1,3,5,4,6,8,7,9,10));
//                .body("userId", Matchers.contains(2,1,3,5,4,6,8,7,9,10));
    }

    @Test
    @DisplayName("Deveria criar um POST e validar o retorno")
    void deveriaCriarUmPostEValidarORetorno() {
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .body("{\"title\": \"Classes.Post de Teste\", \"body\": \"Descricao post de teste\", \"userId\": 3}")
                .when()
                .post("/posts")
                .then()
                .statusCode(201);
    }

    @Test
    @DisplayName("Deveria alterar um POST e validar o retorno")
    void deveriaAlterarUmPostEValidarORetorno() {
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .body("{\"id\": 1,\"title\": \"Classes.Post de Teste\", \"body\": \"Descricao post de teste\", \"userId\": 3}")
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Deveria deletar um POST e validar o retorno")
    void deveriaDeletarUmPostEValidarORetorno() {
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .delete("/posts/1")
                .then()
                .statusCode(200);
    }

}
