package com.one.web.service;

import com.one.boot.web.WebApplication;
import com.one.boot.web.service.TestService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Author jonn
 * @Date: 2021/7/14
 * @Description:
 */
@DisplayName("测试Domain一些方法")
@SpringBootTest(classes = {WebApplication.class})
public class DomainTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Autowired
    private TestService testService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    @DisplayName("测试查询个别字段")
    public void testSearchSurvey() {
        List<Map<String, Object>> res1 = testService.selectMaps(null, "id", "name");
        System.out.println(res1);
    }


    @Test
    public void createDomain() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/test/createDomain"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.log())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is(1)));
    }


}
