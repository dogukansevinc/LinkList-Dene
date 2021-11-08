package com.company;

public class Main {

    public static void main(String[] args) {
	BizimLL list = new BizimLL();
    list.basaEkle(2);
    list.basaEkle(7);
    list.basaEkle(4);
    list.listeyiYazdir();
    list.sonaEkle(1);
    list.sonaEkle(2);
    list.sonaEkle(3);
    list.listeyiYazdir();

    list.indexeEkle(-1,0);
    list.listeyiYazdir();

    list.indexeEkle(-4,33);
    list.listeyiYazdir();

    list.indexeEkle(0,2);
    list.listeyiYazdir();

    list.bastanSil();
    list.listeyiYazdir();

    list.sondanSil();
    list.listeyiYazdir();

    list.indexSil(0);
    list.listeyiYazdir();

    list.indexSil(3);
    list.listeyiYazdir();

    list.sonaEkle(6);
    list.listeyiYazdir();

    list.sonaEkle(6);
    list.listeyiYazdir();

    list.verilenDegElSil(7);
    list.listeyiYazdir();

    list.verilenDegerinHepsiniSil(2);
    list.listeyiYazdir();

    }
}
