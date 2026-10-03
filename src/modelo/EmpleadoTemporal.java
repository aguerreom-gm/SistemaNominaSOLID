package modelo;

public class EmpleadoTemporal extends Empleado {

    private int mesesContrato;

    public EmpleadoTemporal(
            String nombre,
            double salarioBase,
            int mesesContrato) {

        super(nombre, salarioBase);

        if (mesesContrato <= 0) {
            throw new IllegalArgumentException(
                    "La duración del contrato debe ser mayor que cero."
            );
        }

        this.mesesContrato = mesesContrato;
    }

    @Override
    public double calcularSalarioBruto() {
        return getSalarioBase();
    }

    @Override
    public String getTipoEmpleado() {
        return "Empleado Temporal";
    }

    public int getMesesContrato() {
        return mesesContrato;
    }
}
