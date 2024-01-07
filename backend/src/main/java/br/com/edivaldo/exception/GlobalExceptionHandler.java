package br.com.edivaldo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler({StudentNotFoundException.class})
//    public ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException exception) {
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(exception.getMessage());
//    }
	@ExceptionHandler({ RestException.class })
	public ResponseEntity<Object> handle1(RestException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseApp(400, exception.getMessage()));
	}

	@ExceptionHandler({ RuntimeException.class })
	public ResponseEntity<Object> handle2(RuntimeException exception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseApp(500, "Erro interno, tente mais tarde."));
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handle3(Exception exception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseApp(500, "Erro interno, tente mais tarde."));
	}
	
	private AppError responseApp(int codigo, String msg){
		return new AppError(codigo, msg);
	}
}
