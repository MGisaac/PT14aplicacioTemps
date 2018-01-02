package com.isaac.pt14_maldonadoisaac.model;

/**
 * Created by Isaac on 02/01/2018.
 */

public class Bloc {
    private String hora;
    private String temperatura;
    private boolean fredcalor;

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public boolean isFredcalor() {
        return fredcalor;
    }

    public void setFredcalor(boolean fredcalor) {
        this.fredcalor = fredcalor;
    }
}
