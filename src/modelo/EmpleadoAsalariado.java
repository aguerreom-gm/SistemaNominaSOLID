package modelo;

public class EmpleadoAsalariado extends Empleado {

    private int añosEmpresa;

    public EmpleadoAsalariado(
            String nombre,
            double salarioBase,
            int añosEmpresa) {

        super(nombre, salarioBase);

        if (añosEmpresa < 0) {
            throw new IllegalArgumentException(
                    "Los años en la empresa no pueden ser negativos."
            );
        }

        this.añosEmpresa = añosEmpresa;
    }

    @Override
    public double calcularSalarioBruto() {

        double salario = getSalarioBase();

        if (añosEmpresa > 5) {
            salario += salario * 0.10;
        }

        return salario;
    }

    @Override
    public String getTipoEmpleado() {
        return "Empleado Asalariado";
    }

    public int getAñosEmpresa() {
        return añosEmpresa;
    }
}
