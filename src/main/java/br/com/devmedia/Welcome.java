package br.com.devmedia;

import javax.enterprise.inject.Model;

@Model
public class Welcome {
    public String welcomeFromJSF() {
        return "Bem vindo ao JSF!! Ou você prefere hello world?";
    }
}