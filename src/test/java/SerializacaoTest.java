import Classes.Post;
import Classes.User;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

class SerializacaoTest {

    @Test
    @DisplayName("Deveria criar um POST passando uma String")
    void deveriaCriarUmPostPassandoUmaString() {
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .body("{\"title\": \"Classes.Post de Teste\", \"body\": \"Descricao post de teste\", \"userId\": 3}")
                .when()
                .post("/posts")
                .then()
                .statusCode(201);
    }


    @Test
    @DisplayName("Deveria criar um POST passando um Objeto")
    void deveriaCriarUmPostPassandoUmObjeto() {
        Post post = new Post("Classes.Post com objeto", "Descrição post com objeto", 5);

        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .body(post)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);
    }


    @Test
    @DisplayName("Deveria deserializar após criar um USUARIO passando um Objeto")
    void deveriaDeserializarAposCriarUmUsuarioPassandoUmObjeto() {
        User user = new User("Usuario", 5);

        User userInserido = given()
                .body(user)
                .contentType(ContentType.JSON)
                .when()
                .post("https://restapi.wcaquino.me/users")
                .then()
                .statusCode(201)
                .extract().body().as(User.class);

        Assertions.assertEquals(userInserido.name, user.name);

    }


    @Test
    @DisplayName("Deveria criar um POST passando um Map")
    void deveriaCriarUmPostPassandoUmMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("title", "Classes.Post com map");
        params.put("body", "Descrição post com map");
        params.put("userId", 4);

        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .body(params)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);
    }






}
