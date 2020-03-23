/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author essip
 */
public class KassapaateTest {
    
    Kassapaate paate;
    Maksukortti kortti;
    
    public KassapaateTest() {
    }
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
    
    @Test
    public void rahaOikein() {
        assertEquals(paate.kassassaRahaa(), 100000);
    }
    @Test
    public void myydytOikein() {
        assertEquals(paate.maukkaitaLounaitaMyyty()+paate.edullisiaLounaitaMyyty(), 0);
    }
    @Test
    public void kateisostoEdulliset() {
        int vaihtoraha = paate.syoEdullisesti(300);
        assertEquals(paate.kassassaRahaa(), 100240);
        assertEquals(vaihtoraha, 60);
        assertEquals(paate.edullisiaLounaitaMyyty(), 1);
    }
    @Test 
    public void kateisEdullisetEiTarpeeksi() {
        int vaihtoraha = paate.syoEdullisesti(200);
        assertEquals(paate.kassassaRahaa(), 100000);
        assertEquals(vaihtoraha, 200);
        assertEquals(paate.edullisiaLounaitaMyyty(), 0);
    }
       @Test
    public void kateisostoMaukkaat() {
        int vaihtoraha = paate.syoMaukkaasti(500);
        assertEquals(paate.kassassaRahaa(), 100400);
        assertEquals(vaihtoraha, 100);
        assertEquals(paate.maukkaitaLounaitaMyyty(), 1);
    }
    @Test 
    public void kateisMaukkaatEiTarpeeksi() {
        int vaihtoraha = paate.syoMaukkaasti(300);
        assertEquals(paate.kassassaRahaa(), 100000);
        assertEquals(vaihtoraha, 300);
        assertEquals(paate.maukkaitaLounaitaMyyty(), 0);
    }
       @Test
    public void korttiostoEdulliset() {
        boolean osto = paate.syoEdullisesti(kortti);
        assertEquals(kortti.saldo(), 760);
        assertEquals(osto, true);
        assertEquals(paate.edullisiaLounaitaMyyty(), 1);
    }
    @Test 
    public void korttiEdullisetEiTarpeeksi() {
        Maksukortti kortti2 = new Maksukortti(100);
        boolean osto = paate.syoEdullisesti(kortti2);
        assertEquals(kortti.saldo(), 1000);
        assertEquals(osto, false);
        assertEquals(paate.edullisiaLounaitaMyyty(), 0);
    }
           @Test
    public void korttiostoMaukkaat() {
        boolean osto = paate.syoMaukkaasti(kortti);
        assertEquals(kortti.saldo(), 600);
        assertEquals(osto, true);
        assertEquals(paate.maukkaitaLounaitaMyyty(), 1);
    }
    @Test 
    public void korttiMaukkaatEiTarpeeksi() {
        Maksukortti kortti2 = new Maksukortti(100);
        boolean osto = paate.syoMaukkaasti(kortti2);
        assertEquals(kortti.saldo(), 1000);
        assertEquals(osto, false);
        assertEquals(paate.maukkaitaLounaitaMyyty(), 0);
    }
    @Test
    public void kortinLataus() {
        paate.lataaRahaaKortille(kortti, 500);
        assertEquals(kortti.saldo(), 1500);
        assertEquals(paate.kassassaRahaa(), 100500);
    }
    @Test
    public void kortinLatausNega() {
        paate.lataaRahaaKortille(kortti, -500);
        assertEquals(kortti.saldo(), 1000);
        assertEquals(paate.kassassaRahaa(), 100000);
    }

}
