package br.com.alura.titleflix.methods.errorverifyer.errors;

public class NoSolution extends Fail {
    public NoSolution() {
        super(null);
    }

    @Override
    protected String solution(String error) {
        return error;
    }

    @Override
    protected boolean willApplySolution(String error) {
        return true;
    }
}
//Caso não seja encontrado nenhum problema com a informação aqui analizada da API, é retornado a informação sem qualquer modificação
