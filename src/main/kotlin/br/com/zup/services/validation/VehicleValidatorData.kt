package br.com.zup.services.validation

import br.com.zup.controllers.exceptions.FieldMessage
import br.com.zup.dto.VehicleDTO
import br.com.zup.services.feign.FIPEClient
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class VehicleValidatorData() : ConstraintValidator<VehicleValidData, VehicleDTO> {

    override fun isValid(dto: VehicleDTO, context: ConstraintValidatorContext): Boolean {
        return true
    }
}
