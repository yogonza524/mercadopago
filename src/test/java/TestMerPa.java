/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.core.controllers.PreferenceController;
import com.core.enums.CurrencyId;
import com.core.exceptions.NoCredentialException;
import com.core.exceptions.Request400Exception;
import com.core.exceptions.Request404Exception;
import com.core.exceptions.UninitializedException;
import com.core.preference.Item;
import com.core.preference_request.FailResponse;
import com.core.preference_request.FailResponseBody;
import com.core.preference_request.Response;
import com.core.preference_request.SuccessPreferenceResponse;
import com.core.preference.Preference;
import com.core.util.MercadoPagoConnector;
import com.google.gson.Gson;
import com.mercadopago.MP;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Gonza
 */
public class TestMerPa {
    
    public TestMerPa() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws NoCredentialException, Request400Exception {
        String CLIENT_ID = "1631038983052315";
        String CLIENT_SECRET = "eWAdRD94ABgzoxuQDlvhRWEbNvXQkMxT";
        MercadoPagoConnector.init(CLIENT_ID, CLIENT_SECRET);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     @Ignore
     public void first() throws Exception {
         String CLIENT_ID = "1631038983052315";
         String CLIENT_SECRET = "eWAdRD94ABgzoxuQDlvhRWEbNvXQkMxT";
         MercadoPagoConnector.init(CLIENT_ID, CLIENT_SECRET);
         assertNotNull(MercadoPagoConnector.getInstance());
         MP m = MercadoPagoConnector.getInstance();
         assertNotNull(m);
         assertNotNull(m.getPreference("139929232-0c1e3aaa-ea1d-49b9-809e-a8da2d001369"));
         JSONObject o = m.getPreference("139929232-0c1e3aaa-ea1d-49b9-809e-a8da2d001369");
         System.out.println(m.getPreference("139929232-0c1e3aaa-ea1d-49b9-809e-a8da2d001369"));
         Gson g = new Gson();
         if (o.getInt("status") == 404) {
            FailResponse r = g.fromJson(o.toString(), FailResponse.class);
            assertNotNull(r);
            System.out.println("Status: " + r.getStatus());
            assertNotNull(r.getResponse());
            System.out.println("Error: " + r.getResponse().getError());
            System.out.println("Message: " + r.getResponse().getMessage());
            System.out.println("Response body status: " + r.getResponse().getStatus());
            System.out.println("Causes: " + r.getResponse().getCauses());
         }
         if (o.getInt("status") == 200) {
             SuccessPreferenceResponse r = g.fromJson(o.toString(), SuccessPreferenceResponse.class);
             assertNotNull(r);
             System.out.println("Auto Return value: " + r.getAuto_return());
             System.out.println("Additional Info value: " + r.getAdditional_info());
             assertNotNull(r.getResponse());
             System.out.println("Response:");
             Preference resp = r.getResponse();
             for(Field f : resp.getClass().getDeclaredFields()){
                 f.setAccessible(true);
                 System.out.println(f.getName() + ": " + f.get(resp));
             }
         }
     }
     
     @Test
     @Ignore
     public void second() throws NoCredentialException, Request400Exception{
         String CLIENT_ID = "1631038983052315";
         String CLIENT_SECRET = "eWAdRD94ABgzoxuQDlvhRWEbNvXQkMxT";
         MercadoPagoConnector.init(CLIENT_ID, CLIENT_SECRET);
         PreferenceController pc = new PreferenceController();
        try {
            Preference p = pc.byId("139929232-5ce6eb07-7933-4af8-aa61-89a50ec7a79f");
            System.out.println("Init point: " + p.getInit_point());
            System.out.println("Currency Id: " + p.getItems().get(0).getCurrency_id());
            System.out.println("Shipments mode: " + p.getShipments().getMode());
            System.out.println("Operation type: " + p.getOperation_type());
            System.out.println("Item: " + p.getItems().get(0).getId());
        } catch (JSONException ex) {
            Logger.getLogger(TestMerPa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Request404Exception ex) {
            Logger.getLogger(TestMerPa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TestMerPa.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     @Test
     @Ignore
     public void connectionTest() throws NoCredentialException, UninitializedException, Exception{
         String CLIENT_ID = "1631038983052315";
         String CLIENT_SECRET = "eWAdRD94ABgzoxuQDlvhRWEbNvXQkMxT";
         MercadoPagoConnector.init(CLIENT_ID, CLIENT_SECRET);
     }
     
     @Test
     @Ignore
     public void createPreferenceTest() throws NoCredentialException, UninitializedException, Exception{
        PreferenceController pc = new PreferenceController();
        Item i = new Item();
        i.setTitle("Esta es una prueba");
        i.setUnit_price(25.4f);
        i.setCurrency_id(CurrencyId.ARS);
        i.setDescription("Esta es la primera prueba con el controlador");
        i.setQuantity(12);
        i.setPicture_url("http://cdn.oporto.net/guias/oporto/fotos/mercado-do-bolhao.jpg");
        List<Item> list = new ArrayList<>();
        list.add(i);
        Preference p = null;
         try {
            p = pc.addPreference(list);
         } catch (Request400Exception e) {
             System.out.println("Error: " + e.getResponse400().getResponse().getError());
             System.out.println("Message: " + e.getResponse400().getResponse().getMessage());
         }
        assertNotNull(p);
        System.out.println("ID: " + p.getId());
        System.out.println("Init point: " + p.getInit_point());
     }
     
     @Test
     @Ignore
     public void updatePreferenceTest() throws Exception{
         PreferenceController pc = new PreferenceController();
        Item i = new Item();
        i.setTitle("Esta es una prueba");
        i.setUnit_price(25.4f);
        i.setCurrency_id(CurrencyId.ARS);
        i.setDescription("Esta es la primera prueba con el controlador");
        i.setQuantity(12);
        i.setPicture_url("http://cdn.oporto.net/guias/oporto/fotos/mercado-do-bolhao.jpg");
        List<Item> list = new ArrayList<>();
        list.add(i);
        Preference p = null;
         try {
            p = pc.updatePreference("139929232-22f21a64-c978-4509-b86b-a8fed894e3c7",list);
         } catch (Request400Exception e) {
             System.out.println("Error: " + e.getResponse400().getResponse().getError());
             System.out.println("Message: " + e.getResponse400().getResponse().getMessage());
         }
        assertNotNull(p);
        System.out.println("ID: " + p.getId());
        System.out.println("Init point: " + p.getInit_point());
     }
     
     @Test 
     @Ignore
     public void listPaymentsTest() throws Exception{
         // Sets the filters you want
        Map<String, Object> filters = new HashMap<String, Object> ();
           filters.put("site_id", "MLA"); // Argentina: MLA; Brasil: MLB; Mexico: MLM; Venezuela: MLV; Colombia: MCO
           filters.put("external_reference", "Bill001");

        // Search payment data according to filters
        JSONObject searchResult = MercadoPagoConnector.getInstance().searchPayment (filters);
        JSONArray results = searchResult.getJSONObject("response").getJSONArray("results");

        for (int i = 0; i < results.length(); i++) {
            System.out.println(results.getJSONObject(i).getJSONObject("collection").getString("id"));
            System.out.println(results.getJSONObject(i).getJSONObject("collection").getString("external_reference"));
            System.out.println(results.getJSONObject(i).getJSONObject("collection").getString("status"));
        }
     }
     
     @Test
     public void getPaymentTest() throws UninitializedException, Exception{
         String id = "1272671219";
         JSONObject payment_info = MercadoPagoConnector.getInstance().getPayment(id);
         System.out.println(payment_info);
        // Show payment information
        if (Integer.parseInt (payment_info.get("status").toString()) == 200) {
            System.out.print(payment_info.get("response"));
        }
     }
}
