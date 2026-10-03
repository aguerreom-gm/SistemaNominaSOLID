package pruebas;

import modelo.Empleado;
import modelo.EmpleadoAsalariado;
import modelo.EmpleadoPorHoras;
import modelo.EmpleadoPorComision;
import modelo.EmpleadoTemporal;
import servicio.CalculadoraNomina;

public class PruebasNomina {

    public static void main(String[] args) {

        CalculadoraNomina calculadora =
                new CalculadoraNomina();

        probarAsalariado(calculadora);
        probarEmpleadoPorHoras(calculadora);
        probarEmpleadoPorComision(calculadora);
        probarEmpleadoTemporal(calculadora);
        probarDeducciones(calculadora);
        probarHorasNegativas();
        probarVentasNegativas();

        System.out.println("\nTodas las pruebas finalizaron.");
    }

    private static void probarAsalariado(
            CalculadoraNomina calculadora) {

        Empleado empleado =
                new EmpleadoAsalariado(
                        "Prueba Asalariado",
                        3_000_000,
                        6
                );

        double resultado =
                calculadora.calcularSalarioBruto(empleado);

        assert resultado == 3_300_000 :
                "Error en prueba asalariado";

        System.out.println(
                "OK - Prueba empleado asalariado"
        );
    }

    private static void probarEmpleadoPorHoras(
            CalculadoraNomina calculadora) {

        Empleado empleado;
        empleado = new EmpleadoPorHoras(
                "Prueba Horas",
                45,
                30_000
        );

        double resultado;
        resultado = calculadora.calcularSalarioBruto(empleado);

        assert resultado == 1_425_000 :
                "Error en prueba empleado por horas";

        System.out.println(
                "OK - Prueba empleado por horas"
        );
    }

    private static void probarEmpleadoPorComision(
            CalculadoraNomina calculadora) {

        Empleado empleado =
                new EmpleadoPorComision(
                        "Prueba Comisión",
                        2_500_000,
                        5,
                        25_000_000
                );

        double resultado =
                calculadora.calcularSalarioBruto(empleado);

        assert resultado == 4_500_000 :
                "Error en prueba comisión";

        System.out.println(
                "OK - Prueba empleado por comisión"
        );
    }

    private static void probarEmpleadoTemporal(
            CalculadoraNomina calculadora) {

        Empleado empleado =
                new EmpleadoTemporal(
                        "Prueba Temporal",
                        2_000_000,
                        6
                );

        double resultado =
                calculadora.calcularSalarioBruto(empleado);

        assert resultado == 2_000_000 :
                "Error en prueba temporal";

        System.out.println(
                "OK - Prueba empleado temporal"
        );
    }

    private static void probarDeducciones(
            CalculadoraNomina calculadora) {

        Empleado empleado =
                new EmpleadoAsalariado(
                        "Prueba Deducciones",
                        3_000_000,
                        1
                );

        double resultado =
                calculadora.calcularDeducciones(empleado);

        assert resultado == 120_000 :
                "Error en prueba de deducciones";

        System.out.println(
                "OK - Prueba deducciones"
        );
    }

    private static void probarHorasNegativas() {

        try {

            EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras(
                    "Error",
                    -5,
                    30_000
            );

            System.out.println(
                    "ERROR - Se permitieron horas negativas"
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "OK - Validación de horas negativas"
            );
        }
    }

    private static void probarVentasNegativas() {

        try {

            EmpleadoPorComision empleadoPorComision = new EmpleadoPorComision(
                    "Error",
                    2_000_000,
                    5,
                    -100
            );

            System.out.println(
                    "ERROR - Se permitieron ventas negativas"
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "OK - Validación de ventas negativas"
            );
        }
    }
}