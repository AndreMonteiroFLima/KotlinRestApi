package br.com.zup.services.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [VehicleValidatorData::class])
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class VehicleValidData(
    val message: String = "Validation error",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
