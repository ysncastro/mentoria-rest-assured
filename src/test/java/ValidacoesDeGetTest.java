import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;

class ValidacoesDeGetTest {

    @Test
    @DisplayName("Deveria verificar se a lista está trazendo 3 users")
    void deveriaVerificarSeAListaEstaTrazendo3Users() {
        given()
                .baseUri("https://restapi.wcaquino.me")
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("$", Matchers.hasSize(3));
    }


    @Test
    @DisplayName("Deveria verificar se as idades estão vindo na ordem correta")
    void deveriaVerificarSeAsIdadesEstaoVindoCorretamente() {
        given()
                .baseUri("https://restapi.wcaquino.me")
                .when()
                .get("/users")
                .then()
                .statusCode(200)
//                .body("age", Matchers.contains(25,30,20));
                .body("age", Matchers.contains(30,25,20)); //usando o contains
    }

    @Test
    @DisplayName("Deveria verificar se as idades estão vindo com os valores corretos, em qualquer ordem")
    void deveriaVerificarSeAsIdadesEstaoVindoCorretamenteEmQualquerOrdem() {
        given()
                .baseUri("https://restapi.wcaquino.me")
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("age", Matchers.hasItems(25,20,30));
    }

    @Test
    @DisplayName("Deveria verificar se os dados da Maria estão corretos")
    void deveriaVerificarSeOsDadosDaMariaEstaoCorretos() {
        given()
                .baseUri("https://restapi.wcaquino.me")
                .when()
                .get("/users/2")
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(2))
                .body("name", Matchers.equalTo("Maria Joaquina"))
                .body("endereco.rua", Matchers.equalTo("Rua dos bobos"))
                .body("endereco.numero", Matchers.equalTo(0))
                .body("age", Matchers.equalTo(25))
                .body("salary", Matchers.equalTo(2500))
                .body("salary", Matchers.isA(Integer.class))
                .body("salary", Matchers.greaterThanOrEqualTo(2500))
                .body("salary", Matchers.greaterThan(2499))
                .body("salary", Matchers.lessThan(5000));
    }



}
