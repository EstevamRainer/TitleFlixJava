package br.com.alura.titleflix.methods.errorverifyer.errors;

public abstract class Fail {
    protected Fail next;
    public Fail(Fail next) {
        this.next = next;
    }
    public final String applySolution(String error){
        if (willApplySolution(error)){
            return solution(error);
        }
        return next.applySolution(error);
    }
    protected abstract String solution(String error);
    protected abstract boolean willApplySolution(String error);
}
// O objetivo dessa classe é verificar se houve algum erro em alguma pesquisa da API
