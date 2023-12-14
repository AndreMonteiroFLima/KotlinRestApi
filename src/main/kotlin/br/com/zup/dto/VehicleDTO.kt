package br.com.zup.dto

import br.com.zup.entities.Vehicle
import br.com.zup.services.validation.VehicleValidData
import com.fasterxml.jackson.annotation.JsonInclude
import jakarta.validation.constraints.NotBlank
import org.slf4j.LoggerFactory
import java.time.DayOfWeek

@JsonInclude(JsonInclude.Include.NON_NULL)
@VehicleValidData
data class VehicleDTO (
    @field:NotBlank
    var brand: String,
    @field:NotBlank
    var model: String,
    @NotBlank
    var yearAndFuel: String,
    var rotKey: Int?,
    var isRotation: Boolean? = false,
    var price: String?
) {

    companion object {
        fun fromEntity(entity: Vehicle): VehicleDTO {
            return VehicleDTO(
                brand = entity.brand,
                model = entity.model,
                yearAndFuel = entity.yearAndFuel,
                rotKey = setRotKey(entity.yearAndFuel.substring(3,4).toInt()),
                isRotation = false,
                price = "",
            )
        }

        private fun setRotKey(rotKey: Int): Int{
            return when(rotKey){
                0, 1 -> DayOfWeek.MONDAY.value
                2, 3 -> DayOfWeek.TUESDAY.value
                4, 5 -> DayOfWeek.WEDNESDAY.value
                6, 7 -> DayOfWeek.THURSDAY.value
                8, 9 -> DayOfWeek.FRIDAY.value
                else -> 0
            }
        }
    }
}
