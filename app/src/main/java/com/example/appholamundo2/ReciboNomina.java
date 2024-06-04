package com.example.appholamundo2;

public class ReciboNomina {
    private int numRecibo;
    private String nombre;
    private float horasTrabNormal;
    private float horasTrabExtras;
    private int puesto;
    private float impuestoPorc = 0.16f;

    private static final float PAGO_BASE = 200;
    private static final float PAGO_AUXILIAR = PAGO_BASE * 1.2f;
    private static final float PAGO_ALBANIL = PAGO_BASE * 1.5f;
    private static final float PAGO_ING_OBRA = PAGO_BASE * 2.0f;

    public ReciboNomina() { }

    public int getNumRecibo() {
        return numRecibo;
    }

    public void setNumRecibo(int numRecibo) {
        this.numRecibo = numRecibo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getHorasTrabNormal() {
        return horasTrabNormal;
    }

    public void setHorasTrabNormal(float horasTrabNormal) {
        this.horasTrabNormal = horasTrabNormal;
    }

    public float getHorasTrabExtras() {
        return horasTrabExtras;
    }

    public void setHorasTrabExtras(float horasTrabExtras) {
        this.horasTrabExtras = horasTrabExtras;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public float calcularSubtotal() {
        float pagoPorHora;
        switch (puesto) {
            case 1:
                pagoPorHora = PAGO_AUXILIAR;
                break;
            case 2:
                pagoPorHora = PAGO_ALBANIL;
                break;
            case 3:
                pagoPorHora = PAGO_ING_OBRA;
                break;
            default:
                pagoPorHora = 0;
                break;
        }
        return (pagoPorHora * horasTrabNormal) + (horasTrabExtras * pagoPorHora * 2);
    }

    public float calcularImpuesto() {
        return calcularSubtotal() * impuestoPorc;
    }

    public float calcularTotal() {
        return calcularSubtotal() - calcularImpuesto();
    }
}
