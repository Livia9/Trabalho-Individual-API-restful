package livia.TrabalhoIndividual.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

@Override
protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
HttpHeaders headers, HttpStatusCode status, WebRequest request) {
	
	List<String> erros = new ArrayList<>();
	for (FieldError err: ex.getBindingResult().getFieldErrors()) {
		erros.add(err.getField() + ": " + err.getDefaultMessage());
	}
	
ErroResposta erroResposta = new ErroResposta(status.value(),
"Campos inválidos. Por favor, insira-os novamente!", LocalDateTime.now(), erros);

return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
}
@ExceptionHandler(FuncionarioNaoEncontrado.class)
public ResponseEntity<ErroResposta> NaoEncontrado(FuncionarioNaoEncontrado ex) {
    ErroResposta erro = new ErroResposta(
        404, "O funcionario informado não existe. Tente novamente",
        LocalDateTime.now(),
        List.of(ex.getMessage())
    );
    return ResponseEntity.status(404).body(erro);
}}