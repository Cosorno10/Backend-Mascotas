package shared.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

/**
 * Métodos de validación para las excepciones
 */
public class ValidationMethods<Entity> {
	/**
	 * Valida si falta algún dato del modelo
	 * @param result Objeto que tiene los errores del modelo
	 * */
	public void validateHasErrors(BindingResult result) throws InvalidDataException {
		if (result.hasErrors())
			throw new InvalidDataException(result);
	}

	/**
	 * Valida si el dato que se va a reteronar es nulo
	 * Si es nulo devuelve un 404 - NotFound
	 * @param model Modelo que se evaluará para saber si es nulo
	 * */
	public ResponseEntity<Entity> validateNull(Entity model) {
		return model == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(model);
	}
}
