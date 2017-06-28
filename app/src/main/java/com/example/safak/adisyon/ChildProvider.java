package com.example.safak.adisyon;

class ChildProvider {

    private int foto;
    private String ad;
    private int fiyat;

    public ChildProvider(int foto, String ad, int fiyat){
        this.setFoto(foto);
        this.setAd(ad);
        this.setFiyat(fiyat);
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

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }
}
