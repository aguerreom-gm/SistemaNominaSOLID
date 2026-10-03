package servicio;

public class CalculadoraDeducciones {

    private static final double PORCENTAJE_DEDUCCION = 0.04;

    public double calcularDeducciones(double salarioBruto) {

        if (salarioBruto < 0) {
            throw new IllegalArgumentException(
                    "El salario bruto no puede ser negativo."
            );
        }

        return salarioBruto * PORCENTAJE_DEDUCCION;
    }

    public double calcularSalarioNeto(double salarioBruto) {

        double deducciones = calcularDeducciones(salarioBruto);
        double salarioNeto = salarioBruto - deducciones;

        if (salarioNeto < 0) {
            throw new IllegalArgumentException(
                    "El salario neto no puede ser negativo."
            );
        }

        return salarioNeto;
    }
}
