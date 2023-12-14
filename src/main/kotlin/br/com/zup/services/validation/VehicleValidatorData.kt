package br.com.zup.services.validation

import br.com.zup.controllers.exceptions.FieldMessage
import br.com.zup.dto.VehicleDTO
import br.com.zup.services.FeignService
import br.com.zup.services.feign.FIPEClient
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDate


class VehicleValidatorData(val feignService: FeignService) : ConstraintValidator<VehicleValidData, VehicleDTO> {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun isValid(dto: VehicleDTO, context: ConstraintValidatorContext): Boolean {
        val fuel = dto.yearAndFuel.substring(5).toInt()
        if(fuel < 0 || fuel > 3) {
            context.disableDefaultConstraintViolation()
            context.buildConstraintViolationWithTemplate("Fuel type must be between 0 and 3")
                .addPropertyNode("yearAndFuel")
                .addConstraintViolation()
            return false
        }
        feignService.getInformations(dto)
        
        return true
    }
}
