package com.example.appholamundo2;

public class ItemData {

    //Atributos
    private String textCategoria;
    private String textDescripcion;
    private int imageId;


    //Constructores
    public ItemData (){
        this.textCategoria = "";
        this.textDescripcion = "";
        this.imageId = 0;
    }

    public ItemData(String textCategoria, String textDescripcion, int imageId) {
        this.textCategoria = textCategoria;
        this.textDescripcion = textDescripcion;
        this.imageId = imageId;
    }

    public ItemData(ItemData item) {
        this.textCategoria = item.textCategoria;
        this.textDescripcion = item.textDescripcion;
        this.imageId = item.imageId;
    }

    public String getTextCategoria() {
        return textCategoria;
    }

    public void setTextCategoria(String textCategoria) {
        this.textCategoria = textCategoria;
    }

    public String getTextDescripcion() {
        return textDescripcion;
    }

    public void setTextDescripcion(String textDescripcion) {
        this.textDescripcion = textDescripcion;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}


