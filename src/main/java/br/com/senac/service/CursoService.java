package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Curso;
import br.com.senac.repository.CursoRepository;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> buscarTodosCursos(){
        return cursoRepository.findAll();
    }

    public Curso buscarPorId(Integer id){
        Optional <Curso> curso = cursoRepository.findById(id);
        return curso.orElseThrow(() -> new ObjectNotFoundException(1L, "Curso nao encontrado"));
    }

    public Curso salvar(Curso curso){
        return cursoRepository.save(curso);
    }

    public void deletar(Integer id) {
		cursoRepository.deleteById(id);
	}

	public Curso salvarAlteracao(Curso cursoAlterado){
		Curso curso = buscarPorId(cursoAlterado.getId());
		curso.setNome(cursoAlterado.getNome());
		return salvar(curso);
	}
}
