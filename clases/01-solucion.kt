package ar.edu.unsam.algo2.seguros

class CobroSiniestroSpec : DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    describe("Tests Cobro Siniestro") {
        describe("Dado un cliente normal") {
            val cliente = ClienteNormal()
            it("si no es moroso puede cobrar siniestro y no debe registrar la consulta del libre deuda") {
                cliente.puedeCobrarSiniestro() shouldBe true
            }
            it("si tiene deuda no puede cobrar siniestro y debe registrar la consulta del libre deuda") {
                cliente.generarDeuda(10)
                cliente.puedeCobrarSiniestro() shouldBe false
            }
        }
        describe("Dada una flota con muchos autos") {
            // Arrange
            val flotaConMuchosAutos = crearFlota(6)
            it("si tiene mucha deuda no puede cobrar siniestro") {
                // Act
                flotaConMuchosAutos.generarDeuda(10001)
                // Assert
                flotaConMuchosAutos.puedeCobrarSiniestro() shouldBe false
            }
            it("si no tiene poca deuda puede cobrar siniestro") {
                // Act
                flotaConMuchosAutos.generarDeuda(10000)
                // Assert
                flotaConMuchosAutos.puedeCobrarSiniestro() shouldBe true
            }
        }
        describe("Dada una flota con pocos autos") {
            val flotaConMuchosAutos = Flota()
            flotaConMuchosAutos.autos = 5
            it("si tiene mucha deuda no puede cobrar siniestro") {
                flotaConMuchosAutos.generarDeuda(5001)
                flotaConMuchosAutos.puedeCobrarSiniestro() shouldBe false
            }
            it("si no tiene poca deuda puede cobrar siniestro") {
                flotaConMuchosAutos.generarDeuda(5000)
                flotaConMuchosAutos.puedeCobrarSiniestro() shouldBe true
            }
        }
    }
})

fun crearFlota(cantidadAutos: Int) =
    Flota().apply {
        autos = cantidadAutos
    }

// El cliente
abstract class Cliente {
    protected var deuda: Int = 0

    abstract fun puedeCobrarSiniestro(): Boolean

    fun esMoroso() = deuda > 0

    fun generarDeuda(monto: Int) {
        this.deuda = this.deuda + monto
    }
}

val MAXIMO_FLOTA_MUCHOS_AUTOS = 10000
val MAXIMO_FLOTA_POCOS_AUTOS = 5000
val LIMITE_MUCHOS_AUTOS = 5

class Flota : Cliente() {
    var autos: Int = 0

    override fun puedeCobrarSiniestro() =
        this.deuda <= maximoPermitido()

    fun maximoPermitido() =
        if (autos <= LIMITE_MUCHOS_AUTOS) MAXIMO_FLOTA_POCOS_AUTOS else MAXIMO_FLOTA_MUCHOS_AUTOS

}

class ClienteNormal : Cliente() {
    var diasDeConsulta: MutableList<LocalDate> = mutableListOf()

    override fun puedeCobrarSiniestro() = !esMoroso()
}