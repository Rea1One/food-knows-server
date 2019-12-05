package com.foodknows.server.food;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void postHistory() throws Exception {
        RequestBuilder request = null;

        // 测试/food的post
        request = post("/food")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"openId\":\"aaa\",\"reqParam\":{\"name\":\"test2\",\"calories\":150,\"weight\":2,\"time\":1574307193000}}");
        mockMvc.perform(request)
                .andExpect(status().isOk());
    }

    @Test
    public void getRatio() throws Exception {
        RequestBuilder request = null;

        // 测试/food/ratio的get
        request = get("/food/ratio")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"openId\":\"aaa\",\"reqParam\":{\"time\":1574226411000}}");
        mockMvc.perform(request)
                .andExpect(status().isOk());
    }

    @Test
    public void getDaily() throws Exception {
        RequestBuilder request = null;

        // 测试/food/ratio的get
        request = get("/food/daily")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"openId\":\"aaa\",\"reqParam\":{\"startTime\":1574226411000,\"endTime\":1574307193000}}");
        mockMvc.perform(request)
                .andExpect(status().isOk());
    }
}