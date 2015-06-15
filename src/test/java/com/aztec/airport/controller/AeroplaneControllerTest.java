package com.aztec.airport.controller;

import com.aztec.airport.application.Application;
import com.aztec.airport.application.ApplicationConfig;
import com.aztec.airport.dto.AeroplaneDto;
import com.aztec.airport.dto.AirportDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Controller test.
 *
 * @author robertgolder
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes={Application.class})
public class AeroplaneControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testList() throws Exception {

        ResultActions result = mockMvc.perform(get("/aeroplane/list/222abc")
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(view().name("aeroplane-list"))
                .andExpect(model().attributeExists("aeroplanes"));

        List<AeroplaneDto> aeroplanes = (List<AeroplaneDto>)result.andReturn().getModelAndView().getModelMap().get("aeroplanes");
        assertThat(aeroplanes.size(), is(2));
    }

    @Test
    public void testRetrieve() throws Exception {

        ResultActions result = mockMvc.perform(get("/aeroplane/IJ12 ABC")
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(view().name("aeroplane-view"))
                .andExpect(model().attributeExists("aeroplane"));

        AeroplaneDto aeroplane = (AeroplaneDto)result.andReturn().getModelAndView().getModelMap().get("aeroplane");
        assertThat(aeroplane, notNullValue());
        assertThat(aeroplane.getName(), is("Aeroplane5"));
    }
}
