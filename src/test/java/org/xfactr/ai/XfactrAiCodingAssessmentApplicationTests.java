package org.xfactr.ai;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.xfactr.ai.controller.ServiceRequestController;
import org.xfactr.ai.entity.ServiceRequest;
import org.xfactr.ai.service.ServiceRequestService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ServiceRequestController.class)
class XfactrAiCodingAssessmentApplicationTests {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceRequestService service;

    @Test
    public void testGetAllRequests() throws Exception {
        mockMvc.perform(get("/api/servicerequest"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateRequest() throws Exception {
        ServiceRequest request = new ServiceRequest();
       

        Mockito.when(service.create(Mockito.any(ServiceRequest.class))).thenReturn(request);

        mockMvc.perform(post("/api/servicerequest")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ /* JSON representation of ServiceRequest */ }"))
                .andExpect(status().isCreated());
    }
}