package com.example.techolution.accountservice.unittests.controller;

import com.example.techolution.accountservice.controller.AccountController;
import com.example.techolution.accountservice.payload.AccountDto;
import com.example.techolution.accountservice.service.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AcountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    public void testCreateAccount() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(35656546767L);
        accountDto.setAccountName("Divyansh");
        accountDto.setDob("23-09-98");
        accountDto.setAge(25);
        accountDto.setEmail("test@gmail.com");
        accountDto.setGender("male");
        accountDto.setTelephone("995510928");

        String inputInJson = this.mapToJson(accountDto);

        String URI = "/api/accounts";

        Mockito.when(accountService.createAccount(Mockito.any(AccountDto.class))).thenReturn(accountDto);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();

        assert(outputInJson).equals(inputInJson);
        assertEquals(HttpStatus.CREATED.value(),response.getStatus());

    }

    @Test
    public void testUpdateAccount() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(35656546767L);
        accountDto.setAccountName("Divyansh");
        accountDto.setDob("23-09-98");
        accountDto.setAge(25);
        accountDto.setEmail("test@gmail.com");
        accountDto.setGender("male");
        accountDto.setTelephone("995510928");

        String inputInJson = this.mapToJson(accountDto);

        String URI = "/api/accounts/35656546767";

        Mockito.when(accountService.updateAccount(Mockito.any(AccountDto.class), Mockito.anyLong())).thenReturn(accountDto);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();

        assert(outputInJson).equals(inputInJson);
        assertEquals(HttpStatus.CREATED.value(),response.getStatus());

    }


    @Test
    public void testgetAllAccounts() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(35656546767L);
        accountDto.setAccountName("Divyansh");
        accountDto.setDob("23-09-98");
        accountDto.setAge(25);
        accountDto.setEmail("test@gmail.com");
        accountDto.setGender("male");
        accountDto.setTelephone("995510928");

        List<AccountDto> accountDtoList = new ArrayList<>();
        accountDtoList.add(accountDto);
        String URI = "/api/accounts";

        Mockito.when(accountService.getAllAccounts(Mockito.anyInt(),Mockito.anyInt())).thenReturn(accountDtoList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);


        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String expectedJson = this.mapToJson(accountDtoList);
        String outputInJson = response.getContentAsString();

        assert(outputInJson).equals(expectedJson);


    }

    @Test
    public void testSearchAccounts() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(35656546767L);
        accountDto.setAccountName("Divyansh");
        accountDto.setDob("23-09-98");
        accountDto.setAge(25);
        accountDto.setEmail("test@gmail.com");
        accountDto.setGender("male");
        accountDto.setTelephone("995510928");

        List<AccountDto> accountDtoList = new ArrayList<>();
        accountDtoList.add(accountDto);
        String URI = "/api/accounts/search?query=Divyansh";

        Mockito.when(accountService.searchAccounts(Mockito.anyString())).thenReturn(accountDtoList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);


        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String expectedJson = this.mapToJson(accountDtoList);
        String outputInJson = response.getContentAsString();

        assert(outputInJson).equals(expectedJson);


    }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }



}
