package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    @Test 
    public void saldoAlussaOikein() {
        assertEquals(kortti.saldo(), 10);
    }
    @Test
    public void lataaOikein() {
        kortti.lataaRahaa(3);
        assertEquals(kortti.saldo(), 13);
    }
    @Test
    public void vaheneeOikein() {
        boolean otto = kortti.otaRahaa(3);
        assertEquals(kortti.saldo(), 7);
        assertEquals(otto, true);
    }
    @Test
    public void eiMuutuJosEiRahaa() {
        boolean otto = kortti.otaRahaa(13);
        assertEquals(kortti.saldo(), 10);
        assertEquals(otto, otto);
    }
}
