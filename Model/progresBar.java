package Model;


public class progresBar {


    private float value_porcent;

    public progresBar() {
        value_porcent = 0;
    }

    public float getValue_porcent() {
        return value_porcent;
    }

    public void setValue_porcent(int value_porcent) {
        this.value_porcent = value_porcent;
    }

    public void setValue(float por_add, int por_subtotal) {

        value_porcent = value_porcent + (por_add * por_subtotal) / 100;
        System.out.println("value " + value_porcent);
    }

    public static void main(String[] args) {
        progresBar b = new progresBar();
        float total_reg = 23;
        for (int i = 0; i < total_reg; i++) {

            b.setValue((1 / total_reg) * 100f, 10);

        }
        for (int i = 0; i <= total_reg; i++) {

            b.setValue((1 / total_reg) * 100f, 90);

        }

    }
}

