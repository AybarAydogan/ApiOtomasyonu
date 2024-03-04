package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C4_Put_ResponseBilgileriAssertion {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki Json formatindaki body ile
        bir PUT request gonderdigimizde
        {
        "title": "Aybar",
        "body": "Merhaba",
        "userId": 25,
        "id": 15
        }
        donen Response'un,
        status code'unun 200,
        ve content type'inin application/json; charset=utf-8, ve Server isimli Header'in degerinin cloudflare,
        ve status Line'in HTTP/1.1 200 OK olduğunu assert ediniz.
     */

     /*
        API Testlerinde genelde işlemler 4 aşamada gerçekleşir

        1- Endpoint belirlenerek hazırlanır
        2- Gerekli ise Expected Data hazrılanır
        3- Actual Data kaydedilir
        4- Assertion işlemi yapılır
     */


    @Test
    public void put01() {

        // 1- Endpoint belirlenerek hazırlanır
        String url = " https://jsonplaceholder.typicode.com/posts/15";

        JSONObject reqBody = new JSONObject();

        reqBody.put("Title", "Aybar");
        reqBody.put("body", "Merhaba");
        reqBody.put("userId", 25);
        reqBody.put("id", 15);

        // 2- Gerekli ise Expected Data hazırılanır

        // 3- Actual Data kaydedilir
        Response response = given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);


        // 4- Assertion işlemi yapılır

        response.then().assertThat().statusCode(200)
                .header("Server", "cloudflare")
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK");


        response.prettyPrint();
        System.out.println(response.getHeaders());


    }


}
