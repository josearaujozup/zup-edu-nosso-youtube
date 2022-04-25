package br.com.zup.edu.nossoyoutube.video;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class VideoController {
	
	private final VideoRepository repository;

	public VideoController(VideoRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	@PatchMapping("/videos/{idVideo}/visualizacoes")
	public ResponseEntity<?> atualizarVisualizacoes(@PathVariable Long idVideo){
		
		Video video = repository.findById(idVideo).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"video não encontrado"));
		
		video.aumentarVisualizacao();
		
		repository.save(video);
		
		return ResponseEntity.noContent().build();
	}
	
	
	@Transactional
	@PatchMapping("/videos/{idVideo}/gostei")
	public ResponseEntity<?> atualizarGostei(@PathVariable Long idVideo){
		
		Video video = repository.findById(idVideo).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"video não encontrado"));
		
		video.aumentarGostei();
		
		repository.save(video);
		
		return ResponseEntity.noContent().build();
	}
}
