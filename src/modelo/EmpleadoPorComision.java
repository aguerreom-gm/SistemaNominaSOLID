package modelo;

public class EmpleadoPorComision extends Empleado {

    private double porcentajeComision;
    private double ventas;

    public EmpleadoPorComision(
            String nombre,
            double salarioBase,
            double porcentajeComision,
            double ventas) {

        super(nombre, salarioBase);

        if (porcentajeComision < 0) {
            throw new IllegalArgumentException(
                    "El porcentaje de comisión no puede ser negativo."
            );
        }

        if (ventas < 0) {
            throw new IllegalArgumentException(
                    "Las ventas no pueden ser negativas."
            );
        }

        this.porcentajeComision = porcentajeComision;
        this.ventas = ventas;
    }

    @Override
    public double calcularSalarioBruto() {

        double salario = getSalarioBase();

        salario += ventas * (porcentajeComision / 100);

        if (ventas > 20_000_000) {
            salario += ventas * 0.03;
        }

        return salario;
    }

    @Override
    public String getTipoEmpleado() {
        return "Empleado por Comisión";
    }
}
