package com.company;

public class BizimLL {

    Eleman bas;
    Eleman son;

    public BizimLL(){
        bas = null;
        son = null;
    }

    public void basaEkle(int sayi){

        Eleman yeniEleman = new Eleman(sayi);

        if(doluMu()){
            //liste dolu
            yeniEleman.siradaki = bas;
            bas = yeniEleman;
        }else{
            //liste boş
            bas = yeniEleman;
            son = yeniEleman;

        }
    }

    public void sonaEkle(int sayi){
        Eleman yeniEleman = new Eleman(sayi);
        if (doluMu()){
            son.siradaki = yeniEleman;
            son = yeniEleman;
        }else {
            bas = yeniEleman;
            son = yeniEleman;
        }
    }

    public void indexeEkle(int sayi,int index){
        Eleman yeniEleman = new Eleman(sayi);
        if(doluMu()){
            if (index == 0){
                yeniEleman.siradaki = bas;
                bas = yeniEleman;
            }
            else {
                Eleman isaretci1= null;
                Eleman isaretci2= bas;
                int mevcutIndex = 0;

                while (isaretci2 != null && mevcutIndex<index){
                    isaretci1 = isaretci2;
                    isaretci2 = isaretci2.siradaki;
                    mevcutIndex++;
                }
                if (isaretci2 == null){
                    //lisenin sonuna ekle
                    son.siradaki = yeniEleman;
                    son = yeniEleman;
                }else {
                    //ortadaki bi yere ekliyoruz
                    yeniEleman.siradaki = isaretci2;
                    isaretci1.siradaki = yeniEleman;
                }
            }

        }else {
            bas = yeniEleman;
            son= yeniEleman;
        }
    }

    public void bastanSil(){
        if (doluMu()){
            if (bas == son){
                //listede tek eleman var
                bas = null;
                son = null;
            }else {
                Eleman yeniBas = bas.siradaki;
                bas.siradaki = null;
                bas = yeniBas;
            }
        }
    }

    public void sondanSil(){
        if (doluMu()){
            if (bas == son){
                bas= null;
                son= null;
            }
            else {
                Eleman isaretci = bas;
                while (isaretci.siradaki != son){
                   isaretci = isaretci.siradaki;
                }
                isaretci.siradaki = null;
                son = isaretci;
            }
        }
    }

    public void indexSil(int index){
        if (doluMu() && index >= 0){
            if (bas == son){
                bas = null;
                son = null;
            }else {
                if (index == 0){
                    //bastakini sil
                    Eleman yeniBas = bas.siradaki;
                    bas.siradaki = null;
                    bas = yeniBas;
                }else {
                    Eleman isaretci1 = null;
                    Eleman isaretci2 = bas;
                    int mevcutIndex = 0;
                    while (isaretci2 != null && mevcutIndex<index){
                        isaretci1 = isaretci2;
                        isaretci2 = isaretci2.siradaki;
                        mevcutIndex++;
                    }
                    if (isaretci2 != null){
                        if(isaretci2 == son){
                            //sondan silme
                            son = isaretci1;
                            isaretci1.siradaki = null;
                        }else {
                            //ortadan silme
                            Eleman isaretci3 = isaretci2.siradaki;
                            isaretci2.siradaki = null;
                            isaretci1.siradaki = isaretci3;
                        }
                    }
                }
            }

        }
    }

    public void verilenDegElSil(int sayi){
        if(doluMu()){
            if (bas == son){
                if (bas.sayi == sayi){
                    bas= null;
                    son = null;
                }
            }
            else {
                if (bas.sayi == sayi){
                    Eleman yeniBas = bas.siradaki;
                    bas.siradaki = null;
                    bas = yeniBas;
                }
                else {
                    Eleman isaretci1 = null;
                    Eleman isaretci2 = bas;
                    while (isaretci2 != null && isaretci2.sayi != sayi){
                        isaretci1 = isaretci2;
                        isaretci2 = isaretci2.siradaki;
                    }
                    if (isaretci2 != null){
                        if (isaretci2 == son){
                            son = isaretci1;
                            isaretci1.siradaki = null;
                        }
                        else {
                            Eleman isaretci3 = isaretci2.siradaki;
                            isaretci2.siradaki = null;
                            isaretci1.siradaki = isaretci3;
                        }
                    }
                }
            }
        }
    }

    public void verilenDegerinHepsiniSil(int sayi){
        if(doluMu()){
            if (bas == son){
                if (bas.sayi == sayi){
                    bas= null;
                    son = null;
                }
            }
            else {
                Eleman isaretci1 = null;
                Eleman isaretci2 = bas;
                while (isaretci2 != null ){
                    if (isaretci2.sayi == sayi){
                        if (bas == isaretci2){
                            bas = isaretci2.siradaki;
                            isaretci2.siradaki = null;
                            isaretci2 = bas;
                        }else{
                            if (isaretci2 == son){
                                son = isaretci1;
                                isaretci1.siradaki = null;
                                isaretci2 = null;

                            }else {
                                //ortadan sil
                                Eleman isaretci3 = isaretci2.siradaki;
                                isaretci2.siradaki = null;
                                isaretci1.siradaki = isaretci3;
                                isaretci2 = isaretci3;
                            }
                        }
                    }
                    else {
                        //elamanı silmiyorsak işaretçileri güncelle
                        isaretci1 = isaretci2;
                        isaretci2 = isaretci2.siradaki;
                    }
                }
            }
        }
    }



    public void listeyiYazdir(){
        Eleman isaretci = bas;
        int elemanSayisi =0;
        while (isaretci != null){
            System.out.print(isaretci.sayi + " ");
            isaretci = isaretci.siradaki;
            elemanSayisi++;
        }
        System.out.println();
        System.out.println("Eleman Sayısı = "+elemanSayisi);
        System.out.println();
    }



    public boolean doluMu(){
        if (bas != null){
            return true;
        }else {
            return false;
        }
    }


}
