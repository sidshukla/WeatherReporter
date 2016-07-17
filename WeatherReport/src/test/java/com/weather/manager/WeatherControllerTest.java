package com.weather.manager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringApplicationConfiguration(classes = Application.class)
public class WeatherControllerTest {
    
    @Autowired
    private WeatherController weatherControler;
    
    private MockMvc mockMvc;    
    

    @Before
    public void setup(){
    }

    @Test
    public void getTodaysWeatherTest() {
    	//TODO Yet to be implemented

    }

    @Test
    public void weatherFormTest() {
    	//TODO Yet to be implemented
    }

}
