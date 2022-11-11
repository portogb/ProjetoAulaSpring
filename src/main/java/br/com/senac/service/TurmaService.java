package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Turma;
import br.com.senac.repository.TurmaRepository;

@Service
public class TurmaService {
    
    @Autowired
    private TurmaRepository turmaRepository;

    public List<Turma> buscarTodasTurmas(){
        return turmaRepository.findAll();
    }

    public Turma buscarPorId(Integer id){
        Optional<Turma> turma = turmaRepository.findById(id);
        return turma.orElseThrow(() -> new ObjectNotFoundException(1L, "Turma nao encontrada"));
    }

    public Turma salvar(Turma turma){
        return turmaRepository.save(turma);
    }

    public void deletar(Integer id){
        turmaRepository.deleteById(id);
    }

    public Turma salvarAlteracao(Turma turmaAlterada){
        Turma turma = buscarPorId(turmaAlterada.getId());
        turma.setNome(turmaAlterada.getNome());
        return salvar(turma);
    }

    public Turma buscarListaAlunosTurma(Integer id){
        Optional<Turma> turma = turmaRepository.findById(id);
        return turma.orElseThrow(() -> new ObjectNotFoundException(id, "Turma nao encontrada"));
    }

    public Turma findTurmaByIdTurma(Integer id){
        Turma turma = turmaRepository.findTurmaByIdTurma(id);
        return turma;
    }
}
