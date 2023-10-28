package br.com.zup.services.validation

import br.com.zup.controllers.exceptions.FieldMessage
import br.com.zup.dto.VehicleDTO
import br.com.zup.services.feign.FIPEClient
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import org.slf4j.LoggerFactory


class VehicleValidatorData() : ConstraintValidator<VehicleValidData, VehicleDTO> {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun isValid(dto: VehicleDTO, context: ConstraintValidatorContext): Boolean {
        log.info("Vehicle validation mock OK")
        return true
    }
}
