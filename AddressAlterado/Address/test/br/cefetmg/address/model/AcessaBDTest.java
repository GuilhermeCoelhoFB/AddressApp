/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.address.model;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author caked
 */
public class AcessaBDTest {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public AcessaBDTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getConnection method, of class AcessaBD.
     */
    @Test
    public void testGetConnection() throws Exception {
        System.out.println("getConnection");
        AcessaBD instance = new AcessaBD();
        Connection expResult = null;
        Connection result = instance.getConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class AcessaBD.
     */
    @Test
    public void testInsert() throws Exception {
        Boolean flag = false;
        String pNome = "Geraldo";
        String uNome = "Flores";
        String ruaNum = "Rua tritimba 10";
        Integer cep = 789654;
        String cidade = "PinTown";
        LocalDate nasc = LocalDate.parse("02/02/2012",formatter);
        Person p =  new Person(pNome, uNome, ruaNum, cep, cidade, nasc);
        AcessaBD acesso = new AcessaBD();
        List<Person> lista = acesso.listAll();
        acesso.insert(p);
        for (Person l : lista) {
            if (pNome.equals(l.getFirstName()) && uNome.equals(l.getLastName()) 
                && ruaNum.equals(l.getStreet()) && cep.equals(l.getPostalCode()) 
                && cidade.equals(l.getCity()) && nasc.equals(l.getBirthday())) {
                flag = true;
                Long idtemp = l.getId();
                acesso.delete(idtemp);
            }
        }
        assertTrue(flag);
        fail("Insert failed.");
    }

    /**
     * Test of update method, of class AcessaBD.
     */
    @Test
    public void testUpdate() throws Exception {
        Boolean flag = false;
        String pNome = "Geraldo";
        String uNome = "Flores";
        String ruaNum = "Rua tritimba 10";
        Integer cep = 789654;
        String cidade = "PinTown";
        LocalDate nasc = LocalDate.parse("02/02/2012",formatter);
        Person p =  new Person(pNome, uNome, ruaNum, cep, cidade, nasc);
        AcessaBD acesso = new AcessaBD();
        Long idtemp = p.getId();
        List<Person> lista = acesso.listAll();
        acesso.update(p);
        for (Person l : lista) {
            if (idtemp.equals(l.getId()) && pNome.equals(l.getFirstName()) && uNome.equals(l.getLastName()) 
                && ruaNum.equals(l.getStreet()) && cep.equals(l.getPostalCode()) 
                && cidade.equals(l.getCity()) && nasc.equals(l.getBirthday())) {
                flag = true;
            }
        }
        assertTrue(flag);
        fail("Update failed.");
    }

    /**
     * Test of delete method, of class AcessaBD.
     */
    @Test
    public void testDelete() throws Exception {
        AcessaBD acesso = new AcessaBD();
        List<Person> lista = acesso.listAll();
        boolean flag = false;
        System.out.println("deletar"); 
        String pNome = "Geraldo";
        String uNome = "Flores";
        String ruaNum = "Rua tritimba 10";
        Integer cep = 789654;
        String cidade = "PinTown";
        LocalDate nasc = LocalDate.parse("02/02/2012",formatter);
        Person p =  new Person(pNome, uNome, ruaNum, cep, cidade, nasc);
        Long id = p.getId();
        for (Person l : lista) {
            flag = id.equals(l.getId());
        }
        assertTrue(flag);
        fail("Test Failed");
    }

    /**
     * Test of getPersonById method, of class AcessaBD.
     */
    @Test
    public void testGetPersonById() throws Exception {
        AcessaBD acesso = new AcessaBD();
        List<Person> lista =  acesso.listAll();
        Person pf = lista.get(1);
        Person ptemp = acesso.getPersonById(pf.getId());
        assertEquals(pf.getId(), ptemp.getId());
    }

    /**
     * Test of listAll method, of class AcessaBD.
     */
    @Test
    public void testListAll() throws Exception {
        AcessaBD acesso = new AcessaBD();
        List<Person> lista =  acesso.listAll();
        System.out.println("listar");
        lista = acesso.listAll();
        List<Person> expResult = lista;
        List<Person> result = acesso.listAll();
        assertEquals(expResult, result);
        fail("Test failed.");
    }
    
}
