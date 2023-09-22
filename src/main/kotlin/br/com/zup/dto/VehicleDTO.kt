package br.com.zup.dto

import br.com.zup.entities.Vehicle
import br.com.zup.services.validation.VehicleValidData
import com.fasterxml.jackson.annotation.JsonInclude
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Null

@JsonInclude(JsonInclude.Include.NON_NULL)
@VehicleValidData
data class VehicleDTO (
    @NotBlank
    var brand: String,
    @NotBlank
    var model: String,
    @NotBlank
    var yearAndFuel: String,
    var rotKey: Int,
    var isRotation: Boolean = false,
    var price: String
) {
    companion object {
        fun fromEntity(entity: Vehicle): VehicleDTO {
            return VehicleDTO(
                brand = entity.brand,
                model = entity.model,
                yearAndFuel = entity.yearAndFuel,
                rotKey = 0,
                isRotation = false,
                price = "",
            )
        }
    }
}
