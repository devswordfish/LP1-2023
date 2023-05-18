public class Main {
    public static void main(String[] args) {
        GastoLazer gl = new GastoLazer("Dormir", 100, true);
        System.out.println(gl.getValor());

        gl.mudarValor(10);
        System.out.println(gl.getValor());

        GastoFixo gf = new GastoFixo("Estudar", 0);
        gf.mudarValor(100);

        System.out.println(gf.getValor());
    }
}
