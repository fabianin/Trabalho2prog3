/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fabiano
 */
public class AlunoTest {
    
    public AlunoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addTurma method, of class Aluno.
     */
    @Test
    public void testAddTurma() {
        System.out.println("addTurma");
        Turma t = null;
        Aluno instance = new Aluno();
        instance.addTurma(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatricula method, of class Aluno.
     */
    @Test
    public void testGetMatricula() {
        System.out.println("getMatricula");
        Aluno instance = new Aluno();
        long expResult = 0L;
        long result = instance.getMatricula();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTurmas method, of class Aluno.
     */
    @Test
    public void testGetTurmas() {
        System.out.println("getTurmas");
        Aluno instance = new Aluno();
        List<Turma> expResult = null;
        List<Turma> result = instance.getTurmas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Aluno.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Aluno instance = new Aluno();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Aluno.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Aluno instance = new Aluno();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Aluno.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Aluno instance = new Aluno();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTurmas method, of class Aluno.
     */
    @Test
    public void testSetTurmas() {
        System.out.println("setTurmas");
        List<Turma> turmasNew = null;
        Aluno instance = new Aluno();
        instance.setTurmas(turmasNew);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
