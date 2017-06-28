package com.example.safak.adisyon;

public class ParentProvider {

    private int foto;
    private String ad;
    private double fiyat;

    public ParentProvider(int foto, String ad){
        this.setFoto(foto);
        this.setAd(ad);
    }

    public ParentProvider(int foto, String ad, double fiyat){
        this.foto = foto;
        this.ad = ad;
        this.fiyat = fiyat;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

}
