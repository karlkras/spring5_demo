package com.jrp.demo.web;

import com.jrp.demo.domain.Product;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/{userid}")
    public String displayUser(@PathVariable int userid) {
        return String.format("User ID: %d", userid);
    }

    @RequestMapping("/{userid}/invoices")
    public String displayUserInvoices(@PathVariable int userid,
             @RequestParam(value="date", required=false) Date dateOrNull) {
        return String.format("invoice found for user: %d %s",
                userid, dateOrNull == null ? "" :
                String.format("on the date %s", dateOrNull));

    }

    @RequestMapping("/{userid}/items")
    public String displayStringJson(@PathVariable int userid) {
        JSONArray mainData = new JSONArray();
        JSONObject jo = new JSONObject();
        JSONArray jsItems = new JSONArray(Arrays.asList("foobar", "foobar2"));
        jo.put("items", jsItems);
        jo.put("userid", userid);

        mainData.put(jo);

        return mainData.toString();
    }

    @RequestMapping("/{userid}/products")
    public List<Product> displayProductsJson(@PathVariable int userid) {
        return Arrays.asList(new Product(123, "product one", 12.24),
                new Product(124, "product two", 22.33),
                new Product(125, "product three", 74.22)
        );
    }


}
