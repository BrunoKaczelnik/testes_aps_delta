package br.pro.hashi.ensino.desagil.aps.model;

import java.awt.*;

//especifica um modelo para luzes indicadoras
//simulador "pluga" as portas lógicas nessas luzes para visualizar a saída
public class Light implements Receiver {
    private Color color; //atributo que define a cor
    private Emitter emitter;//
    private Color color_off;

    public Light(int r1, int g1, int b1,int r2, int g2, int b2) {
        color = new Color(r1, g1, b1);
        color_off = new Color(r2, g2, b2);
        emitter = null;
    }

    //ele ja me retorna qual a cor de saida
    public Color getColor() {
        if (emitter != null && emitter.read()) { //se emitter for diferente de null e emitter.read()=True eu retorno a cor definida
            return color; // indica saida = 1
        }
        else {
            return color_off; // se emitter=null ou emitter.read()=False eu retorno a cor preta -->indica saida = 0
        }}

    //metodo usado para mudar a cor
    public void setColor(Color color) {
        if (emitter.read()){this.color = color;}
        else {this.color_off = color;}
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        if (inputIndex != 0) {
            throw new IndexOutOfBoundsException(inputIndex);
        }
        this.emitter = emitter;
    }
    //como Switch esta diretamente relacionado com a saida, se eu receber um valor de inputIndex != 0 eu devo lançar uma exceção
    //se for = 0 eu apenas atribuo o emitter recebido como parametro ao meu atributo emitter definido em Light

    public boolean isOn(){
        return emitter.read();
    }
}
