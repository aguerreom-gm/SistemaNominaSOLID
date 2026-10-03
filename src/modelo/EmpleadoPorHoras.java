package modelo;

public class EmpleadoPorHoras extends Empleado {

    private double horasTrabajadas;
    private double tarifaHora;

    public EmpleadoPorHoras(
            String nombre,
            double horasTrabajadas,
            double tarifaHora) {

        super(nombre, 0);

        if (horasTrabajadas < 0) {
            throw new IllegalArgumentException(
                    "Las horas trabajadas no pueden ser negativas."
            );
        }

        if (tarifaHora < 0) {
            throw new IllegalArgumentException(
                    "La tarifa por hora no puede ser negativa."
            );
        }

        this.horasTrabajadas = horasTrabajadas;
        this.tarifaHora = tarifaHora;
    }

    @Override
    public double calcularSalarioBruto() {

        if (horasTrabajadas <= 40) {
            return horasTrabajadas * tarifaHora;
        }

        double horasNormales = 40;
        double horasExtras = horasTrabajadas - 40;

        return (horasNormales * tarifaHora)
                + (horasExtras * tarifaHora * 1.5);
    }

    @Override
    public String getTipoEmpleado() {
        return "Empleado por Horas";
    }
}
