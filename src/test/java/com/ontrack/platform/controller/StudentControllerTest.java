package com.ontrack.platform.controller;

import com.ontrack.platform.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void testCreateStudent() throws Exception {
        // Create a new Student object to send in the request
        String newStudentJson = "{"
                + "\"firstName\": \"John\","
                + "\"lastName\": \"Doe\","
                + "\"email\": \"john.doe@example.com\""
                + "}";

        // Perform a POST request to create a new student
        mockMvc.perform(MockMvcRequestBuilders.post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newStudentJson))
                // Validate that the response status is 201 (CREATED)
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testGetAllStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/students"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    @Test
    public void testGetStudentById() throws Exception {
        Long studentId = 1L;

    
        mockMvc.perform(MockMvcRequestBuilders.get("/students/{id}", studentId))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
