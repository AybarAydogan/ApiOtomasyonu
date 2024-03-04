package tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class C3_JsonObjesiOlusturma {

    // Asagidaki JSON Objesini olusturup konsolda yazdirin.
    // {
    // "title":"Ahmet",
    // "body":"Merhaba",
    // "userId":1
    // }


    @Test
    public void jsonData() {

        JSONObject jsonData = new JSONObject();

        jsonData.put("Title","Aybar");
        jsonData.put("body","Merhaba");
        jsonData.put("userId",15);

        System.out.printf("ilk oluşturulan JSON DATA :" + jsonData);

    }



      /*
Asagidaki JSON Objesini olusturup konsolda yazdirin.

{
"firstname":"Jim",
 "additionalneeds":"Breakfast",
 "bookingdates":{
                "checkin":"2018-01-01",
                "checkout":"2019-01-01"
                },
"totalprice":111,
"depositpaid":true,
 "lastname":"Brown"
}
 */

    @Test
    public void innerJsonData(){

        JSONObject innerjson = new JSONObject();
        innerjson.put("checkin","2018-01-01");
        innerjson.put( "checkout","2019-01-01");


        JSONObject outerJson = new JSONObject();

        outerJson.put("firstname","Jim");
        outerJson.put("additionalneeds","Breakfast");
        outerJson.put("bookingdates",innerjson);
        outerJson.put("totalprice",111);
        outerJson.put("depositpaid",true);
        outerJson.put("lastname","Brown");


        System.out.println(outerJson);


    }
}