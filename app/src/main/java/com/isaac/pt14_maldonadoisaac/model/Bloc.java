package com.isaac.pt14_maldonadoisaac.model;

/**
 * Created by Isaac on 02/01/2018.
 */

public class Bloc {
    private String hora;
    private String temperatura;
    // true es frio, false calor.
    public boolean fredcalor;


    public Bloc(){

    }
    public Bloc(String hora, String temperatura){
        this.hora = hora;
        this.temperatura = temperatura;
        double temp = Double.parseDouble(temperatura);
        if(temp <14){
            fredcalor = true;
        }else{
            fredcalor = false;
        }
    }

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
