/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.address.controller;

import br.cefetmg.address.model.Person;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author caked
 */
public class PersonHandlerTest {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public PersonHandlerTest() {
    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }

    /**
     * Test of verificaPessoa method, of class PersonHandler.
     */
    @Test
    public void testVerificaPessoa() {
        PersonHandler p = new PersonHandler();
        List<Person> lista;
        lista = p.listar();
        lista.forEach(l -> {
            assertEquals(true, p.verificaPessoa(l.getId()));
        });
        fail("Test failed.");
    }

    /**
     * Test of inserir method, of class PersonHandler.
     */
    @Test
    public void testInserir() {
        List<Person> lista;
        boolean flag = false;
        System.out.println("inserir");
        String pNome = "Pedro";
        String uNome = "Felipe";
        String ruaNum = "Rua Doribenes 690";
        Integer cep = 123456;
        String cidade = "FrobaTown";
        LocalDate nasc = LocalDate.parse("01/01/2001",formatter);
        PersonHandler instance = new PersonHandler();
        instance.inserir(pNome, uNome, ruaNum, cep, cidade, nasc);
        lista = instance.listar();
        for (Person l : lista) {
            if (pNome.equals(l.getFirstName()) && uNome.equals(l.getLastName()) 
                && ruaNum.equals(l.getStreet()) && cep.equals(l.getPostalCode()) 
                && cidade.equals(l.getCity()) && nasc.equals(l.getBirthday())) {
                flag = true;
                Long idtemp = l.getId();
                instance.deletar(idtemp);
            }
        }   
        assertTrue(flag);
        fail("Test Failed");
        
    }

    /**
     * Test of atualizar method, of class PersonHandler.
     */
    @Test
    public void testAtualizar() {
        List<Person> lista;
        boolean flag = false;
        System.out.println("atualizar");
        Long id = Long.parseLong("12");
        String pNome = "Pedro";
        String uNome = "Felipe";
        String ruaNum = "Rua Doribenes 690";
        Integer cep = 123456;
        String cidade = "FrobaTown";
        LocalDate nasc = LocalDate.parse("01/01/2001",formatter);
        PersonHandler instance = new PersonHandler();
        instance.atualizar(id,pNome, uNome, ruaNum, cep, cidade, nasc);
        lista = instance.listar();
        for (Person l : lista) {
            if (id.equals(l.getId()) && pNome.equals(l.getFirstName()) && uNome.equals(l.getLastName()) 
                && ruaNum.equals(l.getStreet()) && cep.equals(l.getPostalCode()) 
                && cidade.equals(l.getCity()) && nasc.equals(l.getBirthday())) {
                flag = true;
            }
        }
        assertTrue(flag);
        fail("Test Failed");
    }

    /**
     * Test of deletar method, of class PersonHandler.
     */
    @Test
    public void testDeletar() {
        List<Person> lista;
        boolean flag = false;
        System.out.println("deletar");
        Long id = Long.parseLong("12");
        /*
        String pNome = "Pedro";
        String uNome = "Felipe";
        String ruaNum = "Rua Doribenes 690";
        Integer cep = 123456;
        String cidade = "FrobaTown";
        LocalDate nasc = LocalDate.parse("01/01/2001",formatter);
        */
        PersonHandler instance = new PersonHandler();
        instance.deletar(id);
        lista = instance.listar();
        for (Person l : lista) {
            flag = id.equals(l.getId());
        }
        assertFalse(flag);
        fail("Test Failed");
    }

    /**
     * Test of encontrar method, of class PersonHandler.
     */
    @Test
    public void testEncontrar() {
        List<Person> lista;
        boolean flag = false;
        System.out.println("encontrar");
        Long id = Long.parseLong("12");
        PersonHandler instance = new PersonHandler();
        instance.encontrar(id);
        lista = instance.listar();
        for (Person l : lista) {
            if (flag == false) {
                flag = id.equals(l.getId());          
            }
        }
        assertTrue(flag);
        fail("Test Failed");
    }

    /**
     * Test of listar method, of class PersonHandler.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        List<Person> lista;
        PersonHandler instance = new PersonHandler();
        lista = instance.listar();
        List<Person> expResult = lista;
        List<Person> result = instance.listar();
        assertEquals(expResult, result);
        fail("Test failed.");
    }   
}
