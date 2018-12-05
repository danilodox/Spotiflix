package musicas;

/**
 *
 * @author Danilo
 * https://github.com/danilodox/Spotiflix
 */

public class Musica {
    private int cod;
    private String nomeCantor;
    private String nomeMusica;
    private int ano;
    
    public int getCod() {
        return cod;
    }

    public String getNomeCantor() {
        return nomeCantor;
    }

    public void setNomeCantor(String nomeCantor) {
        this.nomeCantor = nomeCantor;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
}
