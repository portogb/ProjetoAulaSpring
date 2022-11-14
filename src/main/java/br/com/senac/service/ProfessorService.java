package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Professor;
import br.com.senac.repository.ProfessorRepository;

@Service
public class ProfessorService {
    
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> buscarTodosProfessores(){
        return professorRepository.findAll();
    }

    public Professor salvar(Professor professor) {
		return professorRepository.save(professor);
	}
    
    public Professor buscarPorId(Integer id) throws ObjectNotFoundException{
		Optional<Professor> professor = professorRepository.findById(id);
		return professor.orElseThrow(() -> new ObjectNotFoundException(1L, "Professor nao encontrado"));
	}
	
	public void deletar(Integer id) {
		professorRepository.deleteById(id);
	}

	public Professor salvarAlteracao(Professor professorAlterado){
		Professor professor = buscarPorId(professorAlterado.getId());
		professor.setNome(professorAlterado.getNome());
		return salvar(professor);
	}

	public Professor buscaPorNome(String nome){
		return professorRepository.findByNome(nome);
	}

	public List<Professor> buscaProfessorComLivro(){
		List<Professor> list = professorRepository.findBook();
		return list;
	}
}
